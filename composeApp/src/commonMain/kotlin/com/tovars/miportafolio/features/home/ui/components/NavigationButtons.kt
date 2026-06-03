package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConnectWithoutContact
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tovars.miportafolio.domain.model.Language as AppLanguage
import dev.chrisbanes.haze.*

enum class NavigationItem(val icon: ImageVector) {
    Home(icon = Icons.Default.Home),
    Habilidades(icon = Icons.Default.School),
    Proyectos(icon = Icons.Default.Work),
    Contacto(icon = Icons.Default.ConnectWithoutContact);

    fun getDisplayName(language: AppLanguage): String = when (this) {
        Home -> if (language == AppLanguage.ES) "Inicio" else "Home"
        Habilidades -> if (language == AppLanguage.ES) "Ingeniería" else "Expertise"
        Proyectos -> if (language == AppLanguage.ES) "Proyectos" else "Projects"
        Contacto -> if (language == AppLanguage.ES) "Contacto" else "Contact"
    }
}

@Composable
fun NavigationButtons(
    hazeState: HazeState,
    currentWidth: Int,
    language: AppLanguage,
    onLanguageToggle: () -> Unit,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .hazeEffect(
                state = hazeState,
                style = HazeStyle(
                    tint = HazeTint(color = Color.Black.copy(alpha = 0.6f)),
                    blurRadius = 8.dp,
                    noiseFactor = 0.1f
                )
            )
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(100.dp)),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isDesktop = currentWidth > 900

            NavigationItem.values().forEach { item ->
                if (isDesktop) {
                    TextButton(
                        onClick = { onItemClick(item) },
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.White),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            item.getDisplayName(language).uppercase(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        )
                    }
                } else {
                    IconButton(
                        onClick = { onItemClick(item) },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.getDisplayName(language),
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Separator
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(1.dp)
                    .height(24.dp)
                    .background(Color.White.copy(alpha = 0.1f))
            )

            // Language Toggle
            TextButton(
                onClick = onLanguageToggle,
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = "Change Language",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        if (language == AppLanguage.ES) "EN" else "ES",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}
