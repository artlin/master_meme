package com.plcoding.mastermeme.feature_editor.presentation

data class TextSizeState(val uiProgress: Float) {

    fun updateProgress(newProgress: Float): TextSizeState {
        return copy(uiProgress = newProgress)
    }

    companion object {
        fun provideDefaultState(): TextSizeState {
            return TextSizeState(.5f)
        }
    }
}