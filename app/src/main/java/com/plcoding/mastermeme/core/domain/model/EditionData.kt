package com.plcoding.mastermeme.core.domain.model

import com.plcoding.mastermeme.core.domain.model.Constants.MAX_FONT_SIZE
import com.plcoding.mastermeme.core.domain.model.Constants.MIN_FONT_SIZE

data class EditionData(private val mFontScale: Float) {

    fun setFontScale(fontSize: Float): EditionData {
        return copy(mFontScale = fontSize)
    }

    fun getFontSize(): Float {
        val fontSize = MIN_FONT_SIZE + (MAX_FONT_SIZE - MIN_FONT_SIZE) * mFontScale
        return fontSize
    }

    fun getFontScale():Float{
        return mFontScale
    }

    companion object {
        fun getDefault(): EditionData {
            return EditionData(mFontScale = .5f)
        }
    }
}

object Constants {
    const val DEFAULT_FONT_SIZE = 20f
    const val MIN_FONT_SIZE = 10f
    const val MAX_FONT_SIZE = 44f
}
