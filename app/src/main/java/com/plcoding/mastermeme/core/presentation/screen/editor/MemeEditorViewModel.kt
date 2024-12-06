package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.core.presentation.base.BaseViewModel

class MemeEditorViewModel : BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>() {

    override fun onEvent(event: UIMemeEditorEvent) {

    }

    override fun getDefaultState(): UIMemeEditorState {
        return UIMemeEditorState("")
    }
}
