package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.feature_templates.domain.TemplateData

data class UIMemeEditorState(
    val tempTemplate: TemplateData?,
    val isExitConfirmationDialogVisible: Boolean
) {
    fun isEditInProgress(): Boolean = true
    fun showExitConfirmationDialog(): UIMemeEditorState = copy(isExitConfirmationDialogVisible = true)
    fun hideExitConfirmationDialog(): UIMemeEditorState = copy(isExitConfirmationDialogVisible = false)
}
