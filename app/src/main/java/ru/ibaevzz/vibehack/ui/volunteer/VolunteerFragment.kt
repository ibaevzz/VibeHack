package ru.ibaevzz.vibehack.ui.volunteer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.terrakok.cicerone.Router
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.Screens
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import javax.inject.Inject
import kotlin.getValue

class VolunteerFragment: Fragment() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: VolunteerViewModel by viewModels { viewModelFactory }

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
                        val volunteers by viewModel.volunteerFlow.collectAsStateWithLifecycle()
                        if (volunteers.isNotEmpty()) {
                            LazyColumn {
                                item {
                                    Spacer(Modifier.systemBarsPadding())
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceAround
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(Color(0xFFD9D9D9))
                                                .clickable(
                                                    indication = null,
                                                    interactionSource = null
                                                ) {
                                                    router.replaceScreen(Screens.WardsFragment())
                                                }
                                                .padding(horizontal = 9.dp, vertical = 6.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier.align(Alignment.Center),
                                                text = "Подопечный",
                                                color = Color(0xFF333333)
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(Color(0xFF0E7F3B))
                                                .padding(horizontal = 9.dp, vertical = 6.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier.align(Alignment.Center),
                                                text = "Волонтер",
                                                color = Color(0xFFFFFFFF)
                                            )
                                        }
                                    }
                                }
                                items(volunteers) {
                                    VolunteerCard(it) {
                                        //TODO
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}