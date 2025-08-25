package ru.ibaevzz.vibehack.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.Screens
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import javax.inject.Inject
import kotlin.getValue

class LoginFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (context?.applicationContext as App).appComponent.inject(this)

        lifecycleScope.launch {
            viewModel.codeSharedFlow.collect {
                context?.applicationContext?.let { context ->
                    (context as App).appComponent.provideNotificationHelper().showNotification(
                        title = "Код",
                        message = it.second,
                    )
                }
                router.navigateTo(Screens.CheckCode(it.first))
            }
        }

        lifecycleScope.launch {
            viewModel.errorSharedFlow.collect { error ->
                context?.let {
                    Toast.makeText(it, error, Toast.LENGTH_SHORT).show()
                }
            }
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    LoginScreen(false, sendCode = {
                        viewModel.sendCode(it)
                    }, checkCode = {})
                }
            }
        }
    }

}