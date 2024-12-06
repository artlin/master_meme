package com.plcoding.mastermeme.presentation.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun RootGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {

//    NavHost(
//        modifier = Modifier.padding(innerPadding).padding(10.dp),
//        navController = navController,
//        startDestination = NavigationRoute.Alarms
//    ) {
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
