package ru.ibaevzz.vibehack.ui.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.domain.usecase.GetTypeUseCase
import javax.inject.Inject

class RootViewModel @Inject constructor(
    getTypeUseCase: GetTypeUseCase
) : ViewModel() {

    private val _userTypeFlow = MutableSharedFlow<UserType?>(replay = 1, extraBufferCapacity = 1)
    val userTypeFlow = _userTypeFlow.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _userTypeFlow.emit(getTypeUseCase())
        }
    }

}