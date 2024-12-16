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
                        val fontProgress = event.value
                        updateEditionDataWithFontProgress(fontProgress)
                        updateStyleOfSelectedText(getEditionData())
                    }
                }
            }

            is UIAddTextPanelEvent -> {
                when (event) {
                    UIAddTextPanelEvent.AddTextClicked -> {
                        addNewTextAtRandomPosition()
                    }

                    UIAddTextPanelEvent.RedoButtonClicked -> {}
                    UIAddTextPanelEvent.SaveMemeClicked -> {}
                    UIAddTextPanelEvent.UndoButtonClicked -> {}
                    is UIAddTextPanelEvent.OnTextClicked -> {
                        val textMetaData = event.textEntryMetaData
                        if (isInteractionBlocked(textMetaData)) return
                        updateStyleOfSelectedText(textMetaData.editionData)
                        applyEditionData(textMetaData.editionData)
                        handleTextClicked(textData = textMetaData)
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
                deselectAllTextElements()
                newState = uiState.goToAddTextView()
                cancelEditState()
                resetSelectedTextToOriginal()
                // add cancelation logic, resume previous view
            }

            UIMemeEditorEvent.OnEditConfirmClicked -> {
                saveEditValues(getCurrentEditData())
                cancelEditState()
                newState = uiState.goToAddTextView()
                deselectAllTextElements()
                // add confirmation logic, resume previous view
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
