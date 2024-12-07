package com.plcoding.mastermeme.feature_templates.data

import com.plcoding.mastermeme.feature_templates.domain.TemplateData

interface TemplatesProvider {
    fun getAllTemplates(): List<TemplateData>
}