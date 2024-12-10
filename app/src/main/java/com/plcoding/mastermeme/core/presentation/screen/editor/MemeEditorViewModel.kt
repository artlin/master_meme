package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.feature_editor.presentation.AddTextController
import org.koin.core.component.KoinComponent

class MemeEditorViewModel(private val addTextController: AddTextController) :
    BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>(), KoinComponent,
    AddTextController by addTextController {


    override fun onEvent(event: UIMemeEditorEvent) {
        when (event) {
            UIMemeEditorEvent.OnBackButtonClicked -> {
                if (uiState.isEditInProgress()) {
                    uiState = uiState.showExitConfirmationDialog()
                } else {
                    goBack()
                }
            }

            UIMemeEditorEvent.OnDialogConfirmCancelClicked -> {
                uiState = uiState.hideExitConfirmationDialog()
            }

            UIMemeEditorEvent.OnDialogConfirmDiscardClicked -> {
                uiState = uiState.hideExitConfirmationDialog()
                goBack()
            }

            is AddTextPanelEvent -> {
                when (event) {
                    AddTextPanelEvent.AddAddTextClicked -> addRandomText()
                    AddTextPanelEvent.RedoButtonClicked -> {}
                    AddTextPanelEvent.SaveMemeClicked -> {}
                    AddTextPanelEvent.UndoButtonClicked -> {}
                }
            }
        }
    }

    override fun getDefaultUIState(): UIMemeEditorState {
        return UIMemeEditorState(
            tempTemplate = null,
            isExitConfirmationDialogVisible = false,
            rootViewState = RootViewState.AddTextView
        )
    }

    override fun handleNavigation() {
        getParams<NavigationRoute.MemeEditor> { navParams ->
            val params = navParams.memeEditorParams
            newState = uiState.copy(tempTemplate = params.template)
        }
    }
}
