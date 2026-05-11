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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tovars.miportafolio.core.ui.components.RevealAnimation
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.domain.model.Experience
import com.tovars.miportafolio.domain.model.Language
import dev.chrisbanes.haze.*

import androidx.compose.foundation.clickable
import kotlinx.browser.window

@Composable
fun ExperienceSection(
    experience: List<Experience>,
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
                    text = if (language == Language.ES) "TRAYECTORIA" else "TRACK RECORD",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 3.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (language == Language.ES) "Experiencia Profesional" else "Professional Experience",
                    style = if (currentWidth > 1000) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Column(
                modifier = Modifier.fillMaxWidth(if (currentWidth > 1000) 0.85f else 1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                experience.forEachIndexed { index, exp ->
                    RevealAnimation(delayMillis = index * 150) { itemRevealModifier ->
                        ExperienceItem(
                            exp = exp, 
                            hazeState = hazeState, 
                            currentWidth = currentWidth,
                            modifier = itemRevealModifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExperienceItem(
    exp: Experience,
    hazeState: HazeState,
    currentWidth: Int,
    modifier: Modifier = Modifier
) {
    val isDesktop = currentWidth > 800
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White.copy(alpha = 0.01f))
            .border(BorderStroke(1.dp, Color.White.copy(0.05f)), RoundedCornerShape(32.dp))
            .padding(if (isDesktop) 40.dp else 24.dp)
    ) {
        Column {
            if (isDesktop) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                        Surface(
                            modifier = Modifier.size(56.dp),
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(0.2f))
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.BusinessCenter, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(24.dp))
                            }
                        }
                        
                        Column {
                            Text(
                                text = exp.role,
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = (-0.5).sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = exp.company,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                modifier = if (exp.companyUrl.isNotEmpty()) {
                                    Modifier.clickable { window.open(exp.companyUrl, "_blank") }
                                } else Modifier
                            )
                        }
                    }
                    
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = exp.period,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Default.LocationOn, null, tint = SilverGray, modifier = Modifier.size(16.dp))
                            Text(
                                text = exp.location,
                                style = MaterialTheme.typography.bodyMedium,
                                color = SilverGray
                            )
                        }
                    }
                }
            } else {
                Column {
                    Text(
                        text = exp.period,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = exp.role,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = exp.company,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White.copy(alpha = 0.7f),
                        fontWeight = FontWeight.Bold,
                        modifier = if (exp.companyUrl.isNotEmpty()) {
                            Modifier.clickable { window.open(exp.companyUrl, "_blank") }
                        } else Modifier
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Icon(Icons.Default.LocationOn, null, tint = SilverGray, modifier = Modifier.size(14.dp))
                        Text(
                            text = exp.location,
                            style = MaterialTheme.typography.bodySmall,
                            color = SilverGray
                        )
                    }
                }
            }

            if (exp.description.isNotEmpty()) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = exp.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = SilverGray,
                    lineHeight = 26.sp
                )
            }

            if (exp.highlights.isNotEmpty()) {
                Spacer(modifier = Modifier.height(24.dp))
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    exp.highlights.forEach { highlight ->
                        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            Box(modifier = Modifier.padding(top = 8.dp).size(6.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary))
                            
                            val isAppHighlight = exp.playStoreUrls.any { highlight.contains(it.first) }
                            if (isAppHighlight) {
                                val appInfo = exp.playStoreUrls.first { highlight.contains(it.first) }
                                Row(
                                    modifier = Modifier.clickable { window.open(appInfo.second, "_blank") },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text(
                                        text = highlight,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary,
                                        lineHeight = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = Icons.Default.OpenInNew,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            } else {
                                Text(
                                    text = highlight,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White.copy(0.7f),
                                    lineHeight = 22.sp
                                )
                            }
                        }
                    }
                }
            }

            if (exp.technologies.isNotEmpty()) {
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    exp.technologies.forEach { tech ->
                        Surface(
                            color = Color.White.copy(alpha = 0.05f),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.White.copy(0.1f))
                        ) {
                            Text(
                                text = tech,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary.copy(0.8f),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
