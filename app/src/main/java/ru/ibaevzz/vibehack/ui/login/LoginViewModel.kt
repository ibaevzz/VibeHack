package ru.ibaevzz.vibehack.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.usecase.SendCodeUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val sendCodeUseCase: SendCodeUseCase
) : ViewModel() {

    private val _codeSharedFlow = MutableSharedFlow<Pair<String, String>>()
    val codeSharedFlow = _codeSharedFlow.asSharedFlow()

    private val _errorSharedFlow = MutableSharedFlow<String>()
    val errorSharedFlow = _errorSharedFlow.asSharedFlow()

    fun sendCode(phoneNumber: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = sendCodeUseCase.invoke(phoneNumber)
        if (result.isSuccess) {
            result.getOrNull()?.let {
                _codeSharedFlow.emit(phoneNumber to it)
            }
        }
        else {
            result.exceptionOrNull()?.message?.let {
                _errorSharedFlow.emit(it)
            }
        }
    }

}