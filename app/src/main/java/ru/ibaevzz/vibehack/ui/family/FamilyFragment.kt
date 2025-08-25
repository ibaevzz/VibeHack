package ru.ibaevzz.vibehack.ui.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.Router
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import ru.ibaevzz.vibehack.ui.check.CheckCodeFragment
import javax.inject.Inject
import kotlin.getValue

class FamilyFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: FamilyViewModel by viewModels { viewModelFactory }

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
                    Box(
                        modifier = Modifier.fillMaxSize().background(Color(0x00000000))
                    )
                }
            }
        }
    }

    companion object {
        private const val ARG_CODE = "id"

        fun newInstance(id: Int): FamilyFragment {
            val args = Bundle().apply {
                putInt(ARG_CODE, id)
            }
            return FamilyFragment().apply {
                arguments = args
            }
        }
    }

    private val familyId: Int by lazy {
        requireArguments().getInt(ARG_CODE)
    }

}