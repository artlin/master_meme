package com.plcoding.mastermeme.core.domain.model

import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.core.domain.value.TemplateName

data class TemplateData(val name: TemplateName, val imageLocation: ImageLocation)
