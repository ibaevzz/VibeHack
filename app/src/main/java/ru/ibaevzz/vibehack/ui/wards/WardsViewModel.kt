package ru.ibaevzz.vibehack.ui.wards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.domain.model.Ward
import ru.ibaevzz.vibehack.domain.repo.VolunteersRepository
import ru.ibaevzz.vibehack.domain.usecase.GetTypeUseCase
import javax.inject.Inject

class WardsViewModel @Inject constructor(
    volunteersRepository: VolunteersRepository,
    getTypeUseCase: GetTypeUseCase,
): ViewModel() {

    private val _wardsFlow = MutableStateFlow<List<Ward>>(listOf())
    val wardsFlow = _wardsFlow.asStateFlow()

    private val _typeFlow = MutableStateFlow<UserType?>(null)
    val typeFlow = _typeFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _typeFlow.emit(getTypeUseCase())
        }

        viewModelScope.launch(Dispatchers.IO) {
            val result = volunteersRepository.getWards()
            val wards = result.getOrNull() ?: return@launch
            _wardsFlow.emit(wards)
        }
    }

}