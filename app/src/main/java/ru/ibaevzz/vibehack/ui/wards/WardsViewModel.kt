package ru.ibaevzz.vibehack.ui.wards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.model.Ward
import ru.ibaevzz.vibehack.domain.repo.VolunteersRepository
import javax.inject.Inject

class WardsViewModel @Inject constructor(
    volunteersRepository: VolunteersRepository
): ViewModel() {

    private val _wardsFlow = MutableStateFlow<List<Ward>>(listOf())
    val wardsFlow = _wardsFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = volunteersRepository.getWards()
            val wards = result.getOrNull() ?: return@launch
            _wardsFlow.emit(wards)
        }
    }

}