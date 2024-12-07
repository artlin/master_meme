package com.plcoding.mastermeme.core.domain.model

import com.plcoding.mastermeme.core.domain.value.CreationDate
import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.core.domain.value.MemeUid

data class MemeData(
    val uid: MemeUid,
    val isFavorite: Boolean = false,
    val creationDate: CreationDate,
    val imageLocation: ImageLocation
)
