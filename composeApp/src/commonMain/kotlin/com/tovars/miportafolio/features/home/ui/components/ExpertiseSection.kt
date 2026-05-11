package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tovars.miportafolio.core.ui.components.RevealAnimation
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.domain.model.Language
import com.tovars.miportafolio.domain.model.Specialty
import dev.chrisbanes.haze.*

@Composable
fun ExpertiseSection(
    specialties: List<Specialty>,
    currentWidth: Int,
    hazeState: HazeState,
    language: Language,
    modifier: Modifier = Modifier
) {
    RevealAnimation { revealModifier ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .then(revealModifier)
                .padding(vertical = 120.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = if (language == Language.ES) "ESPECIALIDADES" else "EXPERTISE",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 3.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (language == Language.ES) "Ingeniería y Arquitectura" else "Engineering & Architecture",
                    style = if (currentWidth > 1000) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            }
            
            Spacer(modifier = Modifier.height(80.dp))
            
            val maxColumns = if (currentWidth > 1400) 4 else if (currentWidth > 900) 2 else 1
            
            Column(
                modifier = Modifier.fillMaxWidth(if (currentWidth > 1000) 0.9f else 1f),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val chunks = specialties.chunked(maxColumns)
                chunks.forEachIndexed { rowIndex, rowSpecialties ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally)
                    ) {
                        rowSpecialties.forEachIndexed { colIndex, specialty ->
                            RevealAnimation(delayMillis = (rowIndex * 200) + (colIndex * 100)) { itemRevealModifier ->
                                SpecialtyCard(
                                    specialty = specialty,
                                    hazeState = hazeState,
                                    modifier = Modifier
                                        .weight(1f)
                                        .heightIn(min = 280.dp)
                                        .widthIn(max = 400.dp)
                                        .then(itemRevealModifier)
                                )
                            }
                        }
                        if (rowSpecialties.size < maxColumns && maxColumns > 1) {
                            repeat(maxColumns - rowSpecialties.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SpecialtyCard(
    specialty: Specialty,
    hazeState: HazeState,
    modifier: Modifier = Modifier
) {
    val icon = when {
        specialty.title.contains("Android") || specialty.title.contains("KMP") -> Icons.Default.Smartphone
        specialty.title.contains("IA") || specialty.title.contains("AI") || specialty.title.contains("Multimedia") -> Icons.Default.AutoAwesome
        specialty.title.contains("Arquitectura") || specialty.title.contains("Architecture") -> Icons.Default.AccountTree
        specialty.title.contains("Automatización") || specialty.title.contains("Automation") || specialty.title.contains("Web") -> Icons.Default.SettingsSuggest
        else -> Icons.Default.Layers
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White.copy(alpha = 0.02f))
            .border(
                BorderStroke(
                    1.dp, 
                    Brush.verticalGradient(
                        listOf(Color.White.copy(0.12f), Color.Transparent)
                    )
                ),
                RoundedCornerShape(32.dp)
            )
            .hazeEffect(
                state = hazeState,
                style = HazeStyle(
                    tint = HazeTint(color = specialty.color.copy(alpha = 0.05f)), 
                    blurRadius = 30.dp
                )
            )
            .padding(36.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(specialty.color.copy(alpha = 0.15f))
                    .border(BorderStroke(1.dp, specialty.color.copy(0.3f)), RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = specialty.color,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = specialty.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                letterSpacing = (-0.5).sp
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = specialty.description,
                style = MaterialTheme.typography.bodyMedium,
                color = SilverGray,
                lineHeight = 26.sp,
                fontSize = 16.sp
            )
        }
    }
}
