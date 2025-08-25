package ru.ibaevzz.vibehack.ui.wards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.terrakok.cicerone.Router
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import javax.inject.Inject
import kotlin.getValue

class WardsFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: WardsViewModel by viewModels { viewModelFactory }

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
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        val wards by viewModel.wardsFlow.collectAsStateWithLifecycle()
                        if (wards.isNotEmpty()) {
                            LazyColumn {
                                item {
                                    Spacer(Modifier.systemBarsPadding())
                                    Text(
                                        "${wards.size} человек готовы к вашей поддержке",
                                        style = TextStyle.Default.copy(
                                            fontSize = 20.sp
                                        )
                                    )
                                }
                                items(wards) {
                                    WardCard(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}