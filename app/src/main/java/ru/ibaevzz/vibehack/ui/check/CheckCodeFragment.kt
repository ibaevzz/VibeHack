package ru.ibaevzz.vibehack.ui.check

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
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import ru.ibaevzz.vibehack.ui.login.LoginScreen
import javax.inject.Inject
import kotlin.getValue

class CheckCodeFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CheckCodeViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (context?.applicationContext as App).appComponent.inject(this)

        lifecycleScope.launch {
            viewModel.isCodeValidFlow.collect {
                if (it) TODO()
                else Toast.makeText(context, "Неверный код", Toast.LENGTH_SHORT)
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
                    LoginScreen(true, sendCode = {}, checkCode = {viewModel.checkCode(it, phone)})
                }
            }
        }
    }

    companion object {
        private const val ARG_CODE = "phone"

        fun newInstance(phone: String): CheckCodeFragment {
            val args = Bundle().apply {
                putString(ARG_CODE, phone)
            }
            return CheckCodeFragment().apply {
                arguments = args
            }
        }
    }

    private val phone: String by lazy {
        requireArguments().getString(ARG_CODE) ?: ""
    }


}