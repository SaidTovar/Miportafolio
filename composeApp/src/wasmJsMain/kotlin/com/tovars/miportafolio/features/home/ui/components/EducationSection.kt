package com.tovars.miportafolio.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.domain.model.Education
import dev.chrisbanes.haze.*

@Composable
fun EducationSection(
    education: List<Education>,
    currentWidth: Int,
    hazeState: HazeState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FORMACIÓN ACADÉMICA",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.fillMaxWidth(if (currentWidth > 1000) 0.88f else 1f),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            education.forEach { edu ->
                EducationItem(edu = edu, hazeState = hazeState)
            }
        }
    }
}

@Composable
fun EducationItem(
    edu: Education,
    hazeState: HazeState
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White.copy(alpha = 0.03f))
            .border(BorderStroke(1.dp, Color.White.copy(0.08f)), RoundedCornerShape(24.dp))
            .hazeEffect(
                state = hazeState,
                style = HazeStyle(tint = HazeTint(color = Color.White.copy(alpha = 0.02f)), blurRadius = 10.dp)
            )
            .padding(32.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = edu.degree,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = edu.period,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = edu.institution,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White.copy(alpha = 0.7f)
            )
        }
    }
}
