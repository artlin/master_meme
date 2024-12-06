package com.plcoding.mastermeme.presentation.navigation.graph

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.mastermeme.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.presentation.screen.your_memes.ui.YourMemesScreen
import com.plcoding.mastermeme.presentation.screen.your_memes.YourMemesViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RootGraph(
    navController: NavHostController,
) {

    NavHost(
        modifier = Modifier.padding(10.dp),
        navController = navController,
        startDestination = NavigationRoute.YourMemes
    ) {
        composable<NavigationRoute.YourMemes> {
            val viewModel: YourMemesViewModel = koinViewModel()
            YourMemesScreen(uiState = viewModel.uiState, onEvent = { viewModel.onEvent(it) })
        }
    }
//        composable<NavigationRoute.Alarms> {
//            val viewModel: AlarmListViewModel = koinViewModel()
//            AlarmListScreen(viewModel.uiState.value, onAlarmList = { viewModel.onEvent(it) })
//        }
//        composable<NavigationRoute.EditAlarm>(
//            typeMap = mapOf(
//                typeOf<AlarmEntity?>() to CustomNavType.AlarmMetadataNavType
//            )
//        ) { backStackEntry ->
//            val navParams = backStackEntry.toRoute<NavigationRoute.EditAlarm>()
//            val viewModel: EditAlarmViewModel = koinViewModel {
//                parametersOf(navParams.alarmEntity, backStackEntry.savedStateHandle)
//            }
//            EditAlarmScreen(viewModel.uiState.value, onEditAlarm = { viewModel.onEvent(it) })
//        }
//        composable<NavigationRoute.SelectRingtone>(
//            typeMap = mapOf(
//                typeOf<RingtoneId>() to CustomNavType.RingtoneIdNavType
//            )
//        ) { backStackEntry ->
//            val navParams = backStackEntry.toRoute<NavigationRoute.SelectRingtone>()
//            val viewModel: RingtoneViewModel = koinViewModel {
//                parametersOf(navParams.currentRingtone)
//            }
//            RingtoneListScreen(
//                ringtones = viewModel.uiState.value.ringtones,
//                selectedRingtone = viewModel.uiState.value.selectedRingtone,
//                onRingtoneEvent = { viewModel.onEvent(it) })
//        }
//    }
}
