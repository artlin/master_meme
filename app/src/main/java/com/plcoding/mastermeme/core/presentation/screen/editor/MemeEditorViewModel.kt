package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.feature_editor.presentation.AddTextController
import com.plcoding.mastermeme.feature_editor.presentation.EditTextController
import org.koin.core.component.KoinComponent

class MemeEditorViewModel(
    private val addTextController: AddTextController,
    private val editTextController: EditTextController,
) :
    BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>(), KoinComponent,
    AddTextController by addTextController,
    EditTextController by editTextController {


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

            is UIEditTextPanelEvent -> {
                when (event) {
                    UIEditTextPanelEvent.OnPickerOptionClicked -> pickerOption()
                    UIEditTextPanelEvent.OnSizeOptionClicked -> sizeOption()
                    UIEditTextPanelEvent.OnStyleOptionClicked -> styleOption()
                    is UIEditTextPanelEvent.FonSizeChanged -> {
                        handleSizeChanged(event.value)
                        updateStyleOfSelectedText(getEditedStyleResult())
                    }
                }
            }

            is UIAddTextPanelEvent -> {
                when (event) {
                    UIAddTextPanelEvent.AddTextClicked -> addNewText()
                    UIAddTextPanelEvent.RedoButtonClicked -> {}
                    UIAddTextPanelEvent.SaveMemeClicked -> {}
                    UIAddTextPanelEvent.UndoButtonClicked -> {}
                    is UIAddTextPanelEvent.OnTextClicked -> {
                        handleTextClicked(textData = event.textEntryMetaData)
                        newState = uiState.goToModifyTextView()
                    }

                    is UIAddTextPanelEvent.OnTextDoubleClicked -> handleTextDoubleClicked(textData = event.textEntryMetaData)
                    is UIAddTextPanelEvent.OnDragEnd -> handleDragEnd(
                        event.textEntryMetaData,
                        event.newPosX,
                        event.newPosY
                    )
                }
            }

            UIMemeEditorEvent.OnEditCancelClicked -> {
                deselectAll()
                newState = uiState.goToAddTextView()
                // add cancelation logic, resume previous view
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
