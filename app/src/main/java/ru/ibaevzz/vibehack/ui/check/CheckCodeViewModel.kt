package ru.ibaevzz.vibehack.ui.check

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.usecase.CheckCodeUseCase
import ru.ibaevzz.vibehack.domain.usecase.GetTypeUseCase
import javax.inject.Inject

class CheckCodeViewModel @Inject constructor(
    private val checkCodeUseCase: CheckCodeUseCase,
    private val isAuthUseCase: GetTypeUseCase,
): ViewModel() {

    private val _isCodeValidFlow = MutableSharedFlow<Boolean>()
    val isCodeValidFlow = _isCodeValidFlow.asSharedFlow()

    private val _errorSharedFlow = MutableSharedFlow<String>()
    val errorSharedFlow = _errorSharedFlow.asSharedFlow()

    fun checkCode(code: String, phone: String) = viewModelScope.launch {
        val result = checkCodeUseCase(code = code, phoneNumber = phone)
        if (result.isSuccess) {
            result.getOrNull()?.let {
                _isCodeValidFlow.emit(it)
            }
        }
        else {
            result.exceptionOrNull()?.message?.let {
                _errorSharedFlow.emit(it)
            }
        }
    }

    suspend fun getType() = isAuthUseCase()

}