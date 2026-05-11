package com.tovars.miportafolio.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.tovars.miportafolio.core.ui.theme.EerieBlack
import com.tovars.miportafolio.core.ui.utils.meshGradient

@Composable
fun MeshGradientBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(EerieBlack)
            .meshGradient(
                points = listOf(
                    listOf(
                        Offset(0.0f, 0.0f) to Color(0xff070310),
                        Offset(.5f, 0f) to Color(0xff121212),
                        Offset(1f, 0f) to Color(0xff0d0917),
                    ),
                    listOf(
                        Offset(0.0f, 0.3f) to Color(0xff0a1023),
                        Offset(.5f, .5f) to Color(0xff121212),
                        Offset(1f, .2f) to Color(0xff000d0e),
                    ),
                    listOf(
                        Offset(0f, 1f) to Color(0xff001204),
                        Offset(.5f, 1f) to Color(0xff121212),
                        Offset(1f, 1f) to Color(0xff1b170b),
                    ),
                ),
                showPoints = false,
            )
    )
}
