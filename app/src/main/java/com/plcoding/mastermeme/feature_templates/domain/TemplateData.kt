package com.plcoding.mastermeme.feature_templates.domain

import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.core.domain.value.TemplateName
import kotlinx.serialization.Serializable

@Serializable
data class TemplateData(val name: TemplateName, val imageLocation: ImageLocation)
