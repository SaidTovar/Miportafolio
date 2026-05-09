package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.group
import kotlinx.browser.window
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import com.tovars.miportafolio.core.ui.components.MultimediaWaveform
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.domain.model.Language

@Composable
fun HeroSection(
    name: String,
    role: String,
    subtitle: String,
    description: String,
    currentWidth: Int,
    language: Language,
    onExploreProjectsClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(if (currentWidth > 1000) 850.dp else 700.dp)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Fondo de ondas difuminadas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .blur(60.dp)
                .graphicsLayer(alpha = 0.4f),
            contentAlignment = Alignment.Center
        ) {
            MultimediaWaveform(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
                shape = RoundedCornerShape(100.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                Text(
                    text = if (language == Language.ES) "DISPONIBLE PARA NUEVOS PROYECTOS" else "AVAILABLE FOR NEW PROJECTS",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Text(
                text = (if (language == Language.ES) "HOLA, SOY $name" else "HELLO, I'M $name").uppercase(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                letterSpacing = 5.sp,
                fontWeight = FontWeight.ExtraBold
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = role,
                style = if (currentWidth > 1000) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineSmall,
                color = Color.White.copy(alpha = 0.6f),
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                letterSpacing = (-1).sp
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = subtitle,
                style = if (currentWidth > 1000) MaterialTheme.typography.displayLarge else MaterialTheme.typography.headlineLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(if (currentWidth > 1000) 0.9f else 1f),
                lineHeight = if (currentWidth > 1000) 85.sp else 52.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = (-2).sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = SilverGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(if (currentWidth > 1000) 0.6f else 0.95f),
                lineHeight = 30.sp,
                fontSize = 18.sp
            )
            
            Spacer(modifier = Modifier.height(64.dp))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButton(
                    icon = LinkedInIcon,
                    label = "LinkedIn",
                    color = Color(0xFF0A66C2),
                    onClick = {
                        window.open("https://www.linkedin.com/in/said-tovar-610824143", "_blank")
                    }
                )
                
                SocialButton(
                    icon = GitHubIcon,
                    label = "GitHub",
                    color = Color.White,
                    onClick = {
                        window.open("https://github.com/SaidTovar", "_blank")
                    }
                )
            }
        }
    }
}

private val LinkedInIcon: ImageVector
    get() = ImageVector.Builder(
        name = "LinkedIn",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).group {
        addPath(
            pathData = addPathNodes("M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-11 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.784 1.75 1.764-.783 1.764-1.764 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.396-2.586 7-2.777 7 2.476v6.759z"),
            fill = SolidColor(Color.White)
        )
    }.build()

private val GitHubIcon: ImageVector
    get() = ImageVector.Builder(
        name = "GitHub",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).group {
        addPath(
            pathData = addPathNodes("M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12"),
            fill = SolidColor(Color.White)
        )
    }.build()

@Composable
fun SocialButton(
    icon: ImageVector,
    label: String,
    color: Color,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = Color.White.copy(alpha = 0.05f),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.1f)),
        modifier = Modifier.size(64.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
