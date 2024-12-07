package com.plcoding.mastermeme.core.domain.factory

import android.net.Uri
import com.plcoding.mastermeme.core.domain.model.MemeData
import com.plcoding.mastermeme.core.domain.value.CreationDate
import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.core.domain.value.MemeUid

class MemeDataFactory {
    fun getFakeMemeData(): MemeData {
        return MemeData(
            uid = MemeUid(""),
            isFavorite = false,
            creationDate = CreationDate(3),
            imageLocation = ImageLocation(Uri.parse(""))
        )
    }
}
