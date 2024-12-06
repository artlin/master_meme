package com.plcoding.mastermeme.core.presentation.navigation.custom

import SerializableNavType
import com.plcoding.mastermeme.core.presentation.navigation.route.MemeEditorParams
import kotlin.reflect.typeOf

/**
 * Example :
 * val AlarmMetadataNavType = SerializableNavType<AlarmEntity?>(
 *         type = typeOf<AlarmEntity?>(),
 *         isNullableAllowed = true
 *     )
 */
object CustomNavType {

    val MemeEditorNavType = SerializableNavType<MemeEditorParams>(
        type=typeOf<MemeEditorParams>(),
        isNullableAllowed = false
    )

}