package ru.ibaevzz.vibehack.ui.root

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.ibaevzz.vibehack.App
import ru.ibaevzz.vibehack.R
import ru.ibaevzz.vibehack.Screens
import ru.ibaevzz.vibehack.domain.model.UserType
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import javax.inject.Inject

class RootActivity: AppCompatActivity() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: RootViewModel by viewModels { viewModelFactory }

    private val navigator = AppNavigator(this, R.id.fragment_container)

    override fun onResume() {
        super.onResume()
        (application as App).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        lifecycleScope.launch {
            val screen = when (viewModel.userTypeFlow.first()) {
                UserType.Curator, UserType.Volunteer -> Screens.WardsFragment()
                UserType.Ward -> Screens.TasksFragment()
                null -> Screens.Registration()
            }
            router.newRootScreen(screen)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}