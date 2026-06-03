package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tovars.miportafolio.core.ui.components.RevealAnimation
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.domain.model.ContactInfo
import com.tovars.miportafolio.domain.model.Language as AppLanguage
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ContactSection(
    contactInfo: ContactInfo,
    currentWidth: Int,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    var showCopyMessage by remember { mutableStateOf(false) }

    RevealAnimation { revealModifier ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .then(revealModifier)
                .padding(vertical = 100.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (language == AppLanguage.ES) "¿TIENES UN PROYECTO?" else "HAVE A PROJECT?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = if (language == AppLanguage.ES) "Pongámonos en contacto" else "Let's get in touch",
                style = if (currentWidth > 1000) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontWeight = FontWeight.Black
            )
            
            Spacer(modifier = Modifier.height(60.dp))
            
            val isMobile = currentWidth < 600

            if (isMobile) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    ContactButtonsRow(contactInfo, language) {
                        coroutineScope.launch {
                            showCopyMessage = true
                            delay(2000)
                            showCopyMessage = false
                        }
                    }
                }
            } else {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ContactButtonsRow(contactInfo, language) {
                        coroutineScope.launch {
                            showCopyMessage = true
                            delay(2000)
                            showCopyMessage = false
                        }
                    }
                }
            }

            if (showCopyMessage) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = if (language == AppLanguage.ES) "¡Email copiado al portapapeles!" else "Email copied to clipboard!",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun ContactButtonsRow(
    contactInfo: ContactInfo,
    language: AppLanguage,
    onCopyEmail: () -> Unit
) {
    ContactButton(
        icon = Icons.Default.Email,
        label = if (language == AppLanguage.ES) "Enviar Email" else "Send Email",
        onClick = { window.open("mailto:${contactInfo.email}", "_blank") }
    )
    
    ContactButton(
        icon = Icons.Default.ContentCopy,
        label = if (language == AppLanguage.ES) "Copiar Email" else "Copy Email",
        onClick = {
            window.navigator.clipboard.writeText(contactInfo.email)
            onCopyEmail()
        }
    )

    ContactButton(
        icon = Icons.AutoMirrored.Filled.OpenInNew, // Placeholder for LinkedIn
        label = "LinkedIn",
        onClick = { window.open(contactInfo.linkedinUrl, "_blank") }
    )
    
    ContactButton(
        icon = Icons.Default.Code, // Placeholder for GitHub
        label = "GitHub",
        onClick = { window.open(contactInfo.githubUrl, "_blank") }
    )
}

@Composable
fun ContactButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier.size(70.dp),
            shape = CircleShape,
            color = Color.White.copy(alpha = 0.05f),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = SilverGray,
            fontWeight = FontWeight.Medium
        )
    }
}
