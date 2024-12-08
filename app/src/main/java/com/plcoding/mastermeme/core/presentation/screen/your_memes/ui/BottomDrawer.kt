package com.plcoding.mastermeme.core.presentation.screen.your_memes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.your_memes.OnUIEventYourMemes
import com.plcoding.mastermeme.core.presentation.screen.your_memes.UIEventYourMemes
import com.plcoding.mastermeme.core.presentation.ui.text.TextBodyMedium
import com.plcoding.mastermeme.core.presentation.ui.text.TextH3
import com.plcoding.mastermeme.core.presentation.ui.theme.White
import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetState
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetVisibility
import com.plcoding.mastermeme.feature_templates.presentation.ui.TemplateAssetImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomDrawer(bottomSheetState: BottomSheetState, onEvent: OnUIEventYourMemes) {

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    LaunchedEffect(bottomSheetState) {
        when (bottomSheetState.visibility) {
            BottomSheetVisibility.HalfExpanded -> sheetState.partialExpand()
            BottomSheetVisibility.FullyExpanded -> sheetState.expand()
            BottomSheetVisibility.Hidden -> sheetState.hide()
        }
    }

    // React to user gestures on the sheet
    LaunchedEffect(sheetState.currentValue) {
        val newVisibility = when (sheetState.currentValue) {
            SheetValue.Hidden -> BottomSheetVisibility.Hidden
            SheetValue.Expanded -> BottomSheetVisibility.FullyExpanded
            SheetValue.PartiallyExpanded -> BottomSheetVisibility.HalfExpanded
        }
        onEvent(UIEventYourMemes.OnUserChangedSheetState(newVisibility))
    }

    if (bottomSheetState.isVisible()) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            TemplatesList(templateList = bottomSheetState.templateList)
        }
    }
}

@Composable
private fun TemplatesList(templateList: List<TemplateData>) {
    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            TextH3(text = "Choose template", color = White)
            TextBodyMedium(
                text = "Choose template for your next meme masterpiece",
                color = White
            )
        }
        Spacer(Modifier.height(42.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 25.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(
                items = templateList,
                key = { template -> template.name.value } // Assuming each Meme has a unique id
            ) { template ->
                Box(
                    Modifier
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(8.dp))
                ) {
                    TemplateAssetImage(
                        modifier = Modifier.fillMaxSize(),
                        assetPath = template.imageLocation,
                        isThumbnail = true
                    )
                }
            }

        }
    }
}