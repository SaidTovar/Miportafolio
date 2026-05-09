package com.tovars.miportafolio.core.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.tovars.miportafolio.core.ui.theme.ElectricViolet
import kotlinx.coroutines.delay
import kotlin.math.abs
import kotlin.math.sin

@Composable
fun RevealAnimation(
    delayMillis: Int = 0,
    content: @Composable (Modifier) -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(delayMillis.toLong())
        visible = true
    }

    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    
    val translateY by animateDpAsState(
        targetValue = if (visible) 0.dp else 40.dp,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    content(
        Modifier.graphicsLayer {
            this.alpha = alpha
            this.translationY = translateY.toPx()
        }
    )
}

@Composable
fun MultimediaWaveform(
    modifier: Modifier = Modifier,
    color: Color = ElectricViolet,
    barsCount: Int = 50
) {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * kotlin.math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier.height(120.dp).fillMaxWidth()) {
        val width = size.width
        val height = size.height
        val barWidth = width / (barsCount * 2.5f)
        val centerY = height / 2

        for (i in 0 until barsCount) {
            val x = i * (barWidth * 2.5f) + barWidth
            val normalizedX = i.toFloat() / barsCount
            
            val variation = sin(normalizedX * 12f + phase) * 0.4f + 
                            sin(normalizedX * 7f - phase * 0.7f) * 0.3f +
                            sin(normalizedX * 18f + phase * 1.2f) * 0.15f
            
            val barHeight = (height * 0.15f) + (height * 0.7f * abs(variation))

            drawLine(
                brush = Brush.verticalGradient(
                    colors = listOf(color.copy(alpha = 0.1f), color, color.copy(alpha = 0.1f))
                ),
                start = Offset(x, centerY - barHeight / 2),
                end = Offset(x, centerY + barHeight / 2),
                strokeWidth = barWidth,
                cap = StrokeCap.Round
            )
        }
    }
}
