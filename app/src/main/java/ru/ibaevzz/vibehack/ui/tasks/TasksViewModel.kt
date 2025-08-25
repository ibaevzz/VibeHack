package ru.ibaevzz.vibehack.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.model.Task
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.domain.repo.VolunteersRepository
import ru.ibaevzz.vibehack.domain.usecase.GetTypeUseCase
import javax.inject.Inject

class TasksViewModel @Inject constructor(
    private val volunteersRepository: VolunteersRepository,
    private val getTypeUseCase: GetTypeUseCase
): ViewModel() {

    private val _typeFlow = MutableStateFlow<UserType?>(null)
    val typeFlow = _typeFlow.asStateFlow()

    private val _tasksFlow = MutableStateFlow<List<Task>>(listOf())
    val tasksFlow = _tasksFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _typeFlow.emit(getTypeUseCase())
        }
        viewModelScope.launch(Dispatchers.IO) {
            val result = volunteersRepository.getTasks().getOrNull() ?: return@launch
            _tasksFlow.emit(result)
        }
    }

}