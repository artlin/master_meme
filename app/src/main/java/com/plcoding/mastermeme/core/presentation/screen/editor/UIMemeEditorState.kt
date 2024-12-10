package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.feature_templates.domain.TemplateData

data class UIMemeEditorState(
    val tempTemplate: TemplateData?,
    // move to states system when more than one dialog
    val isExitConfirmationDialogVisible: Boolean,
    val rootViewState: RootViewState,
) {
    fun isEditInProgress(): Boolean = true
    fun showExitConfirmationDialog(): UIMemeEditorState =
        copy(isExitConfirmationDialogVisible = true)

    fun hideExitConfirmationDialog(): UIMemeEditorState =
        copy(isExitConfirmationDialogVisible = false)

    fun goToAddTextView(): UIMemeEditorState = copy(rootViewState = RootViewState.AddTextView)
    fun goToModifyTextView(): UIMemeEditorState = copy(rootViewState = RootViewState.ModifyTextView)
}

sealed interface RootViewState {
    data object AddTextView : RootViewState
    data object ModifyTextView : RootViewState
}
