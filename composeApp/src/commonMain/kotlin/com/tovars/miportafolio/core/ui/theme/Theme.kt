package com.tovars.miportafolio.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ElectricViolet,
    secondary = CyanAccent,
    tertiary = MagentaAccent,
    background = EerieBlack,
    surface = JetBlack,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = PureWhite,
    onSurface = PureWhite
)

@Composable
fun PortafolioTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PortafolioTypography,
        content = content
    )
}
