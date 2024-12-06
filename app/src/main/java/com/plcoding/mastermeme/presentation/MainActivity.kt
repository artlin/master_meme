package com.plcoding.mastermeme.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.plcoding.mastermeme.presentation.navigation.graph.RootGraph
import com.plcoding.mastermeme.presentation.ui.theme.MasterMemeTheme
import com.plcoding.mastermeme.presentation.navigation.NavigationController
import com.plcoding.mastermeme.presentation.navigation.NavigationControllerImpl
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterMemeTheme {
                val navController = koinInject<NavigationController>()
                val navHostController = rememberNavController()
                (navController as? NavigationControllerImpl)?.setNavController(
                    navHostController
                )
                RootGraph(navController = navHostController)
            }
        }
    }
}
