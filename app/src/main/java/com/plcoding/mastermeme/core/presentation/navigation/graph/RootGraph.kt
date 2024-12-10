package com.plcoding.mastermeme.core.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.mastermeme.core.presentation.navigation.custom.CustomNavType
import com.plcoding.mastermeme.core.presentation.navigation.route.MemeEditorParams
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute.*
import com.plcoding.mastermeme.core.presentation.screen.editor.MemeEditorViewModel
import com.plcoding.mastermeme.core.presentation.screen.editor.ui.MemeEditorScreen
import com.plcoding.mastermeme.core.presentation.screen.your_memes.YourMemesViewModel
import com.plcoding.mastermeme.core.presentation.screen.your_memes.ui.YourMemesScreen
import org.koin.compose.viewmodel.koinViewModel
import kotlin.reflect.typeOf

@Composable
fun RootGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = YourMemes
    ) {
        composable<YourMemes> {
            val viewModel: YourMemesViewModel = koinViewModel()
            YourMemesScreen(uiState = viewModel.uiState, onEvent = { viewModel.onEvent(it) })
        }

        composable<MemeEditor>(
            typeMap = mapOf(
                typeOf<MemeEditorParams>() to CustomNavType.MemeEditorNavType
            )
        ) {
            val viewModel: MemeEditorViewModel = koinViewModel()
            MemeEditorScreen(
                uiRootState = viewModel.uiState,
                addTextState = viewModel.uiAddTextState,
                onEvent = { viewModel.onEvent(it) })
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
