package ru.ibaevzz.vibehack.ui.volunteer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.model.Volunteer
import ru.ibaevzz.vibehack.domain.repo.VolunteersRepository
import javax.inject.Inject

class VolunteerViewModel @Inject constructor(
    private val volunteersRepository: VolunteersRepository
): ViewModel() {

    private val _volunteersFlow = MutableStateFlow<List<Volunteer>>(listOf())
    val volunteerFlow = _volunteersFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = volunteersRepository.getVolunteers().getOrNull() ?: return@launch
            _volunteersFlow.emit(result)
        }
    }

}