package ru.ibaevzz.vibehack.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.terrakok.cicerone.Router
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import javax.inject.Inject
import kotlin.getValue

class TasksFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: TasksViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (context?.applicationContext as App).appComponent.inject(this)

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    val type by viewModel.typeFlow.collectAsStateWithLifecycle()
                    val tasks by viewModel.tasksFlow.collectAsStateWithLifecycle()
                    TasksScreen(
                        isWard = type == UserType.Ward,
                        "Магомед Шариев",
                        tasks
                    )
                }
            }
        }
    }

}