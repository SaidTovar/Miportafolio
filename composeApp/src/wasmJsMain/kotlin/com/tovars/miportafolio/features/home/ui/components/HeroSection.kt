package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onExploreProjectsClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(100.dp),
                    contentPadding = PaddingValues(horizontal = 40.dp, vertical = 22.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text(
                        if (language == Language.ES) "VER PROYECTOS" else "VIEW PROJECTS", 
                        fontWeight = FontWeight.ExtraBold, 
                        letterSpacing = 1.sp
                    )
                }
                
                TextButton(
                    onClick = onContactClick,
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp)
                ) {
                    Text(
                        if (language == Language.ES) "HABLEMOS" else "LET'S TALK",
                        color = Color.White, 
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}
