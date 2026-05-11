package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
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
import com.tovars.miportafolio.core.ui.theme.SuccessGreen
import com.tovars.miportafolio.domain.model.Language
import com.tovars.miportafolio.domain.model.Project
import dev.chrisbanes.haze.HazeState

import androidx.compose.foundation.clickable
import kotlinx.browser.window

import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ProjectsSection(
    projects: List<Project>,
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
                    text = if (language == Language.ES) "TRABAJOS DESTACADOS" else "FEATURED WORKS",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 3.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (language == Language.ES) "Casos de Estudio" else "Case Studies",
                    style = if (currentWidth > 1000) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Black
                )
            }
            
            Spacer(modifier = Modifier.height(80.dp))
            
            projects.forEachIndexed { index, project ->
                RevealAnimation(delayMillis = index * 200) { itemRevealModifier ->
                    ProjectItem(
                        project = project, 
                        currentWidth = currentWidth, 
                        hazeState = hazeState,
                        modifier = itemRevealModifier
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun ProjectItem(
    project: Project,
    currentWidth: Int,
    hazeState: HazeState,
    modifier: Modifier = Modifier
) {
    val isDesktop = currentWidth > 1000
    
    Box(
        modifier = modifier
            .fillMaxWidth(if (isDesktop) 0.85f else 1f)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.White.copy(0.02f))
            .border(
                BorderStroke(1.dp, Color.White.copy(0.06f)),
                RoundedCornerShape(40.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(if (isDesktop) 60.dp else 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Column(
                modifier = Modifier.weight(1.2f),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (project.isLive) {
                        Surface(
                            color = SuccessGreen.copy(alpha = 0.1f),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, SuccessGreen.copy(0.2f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(SuccessGreen))
                                Text("LIVE", style = MaterialTheme.typography.labelSmall, color = SuccessGreen, fontWeight = FontWeight.Bold)
                            }
                        }
                    } else {
                        Surface(
                            color = Color.White.copy(alpha = 0.05f),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, Color.White.copy(0.1f))
                        ) {
                            Text(
                                "PROTOTYPE", 
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall, 
                                color = SilverGray, 
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Black,
                        letterSpacing = (-1).sp,
                        modifier = if (project.url.isNotEmpty()) {
                            Modifier.clickable { window.open(project.url, "_blank") }
                        } else Modifier
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = SilverGray,
                    modifier = Modifier.fillMaxWidth(),
                    lineHeight = 28.sp,
                    fontSize = 18.sp
                )

                if (project.highlights.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        project.highlights.forEach { highlight ->
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary))
                                Text(
                                    text = highlight,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White.copy(0.7f),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(36.dp))
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.wrapContentWidth()
                ) {
                    project.tags.forEach { tag ->
                        Surface(
                            color = Color.White.copy(alpha = 0.05f),
                            shape = RoundedCornerShape(100.dp),
                            border = BorderStroke(1.dp, Color.White.copy(0.1f))
                        ) {
                            Text(
                                text = tag,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.White.copy(0.8f),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
            
            if (isDesktop) {
                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .aspectRatio(1.2f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    MaterialTheme.colorScheme.primary.copy(0.1f),
                                    MaterialTheme.colorScheme.secondary.copy(0.05f)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (project.imageUrl.isNotEmpty()) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalPlatformContext.current)
                                .data(project.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentDescription = project.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )
                    } else {
                        val projectIcon = when {
                            project.title.contains("Notas") -> Icons.AutoMirrored.Filled.MenuBook
                            project.title.contains("Tools") -> Icons.Default.Terminal
                            project.title.contains("IoT") -> Icons.Default.Sensors
                            project.title.contains("Chat") -> Icons.Default.Forum
                            else -> Icons.Default.Work
                        }
                        Icon(
                            imageVector = projectIcon,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp).graphicsLayer(alpha = 0.15f),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
