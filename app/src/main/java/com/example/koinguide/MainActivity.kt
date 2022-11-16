package com.example.koinguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.koinguide.ui.theme.KoinGuideTheme
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {

//    private val viewModel by viewModel<MainViewModel>()

//    avoid calling data on the presentation layer, but if you really need to, call like this:
//    private val api by inject<MyApi>()

    override val scope: Scope by activityScope()
    private val hello by inject<String>(named("hello"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(hello)
        setContent {
            KoinGuideTheme {
                //In compose we can use viewModel like this:
                val viewModel = getViewModel<MainViewModel>()
                viewModel.doNetworkCall()
            }
        }
    }
}
