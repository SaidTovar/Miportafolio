package com.tovars.miportafolio.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.tovars.miportafolio.core.ui.components.MeshGradientBackground
import com.tovars.miportafolio.core.ui.components.MultimediaWaveform
import com.tovars.miportafolio.core.ui.components.RevealAnimation
import com.tovars.miportafolio.core.ui.theme.SilverGray
import com.tovars.miportafolio.features.home.presentation.HomeViewModel
import com.tovars.miportafolio.features.home.ui.components.*
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import kotlinx.browser.window
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.state
    val scrollState = rememberLazyListState()
    val hazeState = rememberHazeState()
    val coroutineScope = rememberCoroutineScope()
    val currentWidth = LocalWindowInfo.current.containerSize.width

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .hazeSource(state = hazeState)
    ) {
        MeshGradientBackground()

        state.aboutMe?.let { aboutMe ->
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    state = scrollState,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item(key = "Hero") {
                        RevealAnimation { revealModifier ->
                            HeroSection(
                                name = aboutMe.name,
                                role = aboutMe.role,
                                subtitle = aboutMe.subtitle,
                                description = aboutMe.description,
                                currentWidth = currentWidth,
                                language = state.language,
                                onExploreProjectsClick = {
                                    coroutineScope.launch { scrollState.animateScrollToItem(2) }
                                },
                                onContactClick = { /* Handle contact */ },
                                modifier = revealModifier
                            )
                        }
                    }

                    item(key = "Specialties") {
                        ExpertiseSection(
                            specialties = aboutMe.specialties,
                            currentWidth = currentWidth,
                            hazeState = hazeState,
                            language = state.language
                        )
                    }

                    item(key = "Experience") {
                        ExperienceSection(
                            experience = aboutMe.experience,
                            currentWidth = currentWidth,
                            hazeState = hazeState,
                            language = state.language
                        )
                    }

                    item(key = "Projects") {
                        ProjectsSection(
                            projects = aboutMe.projects,
                            currentWidth = currentWidth,
                            hazeState = hazeState,
                            language = state.language
                        )
                    }

                    item(key = "Education") {
                        EducationSection(
                            education = aboutMe.education,
                            currentWidth = currentWidth,
                            hazeState = hazeState,
                            language = state.language
                        )
                    }
                    
                    item(key = "Footer") {
                        Spacer(modifier = Modifier.height(100.dp))
                        Text(
                            "© 2026 ${aboutMe.name} | ${aboutMe.role}",
                            style = MaterialTheme.typography.labelMedium,
                            color = SilverGray,
                            modifier = Modifier.padding(bottom = 60.dp)
                        )
                    }
                }

                if (currentWidth > 1000) {
                    VerticalScrollbar(
                        modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight().padding(end = 4.dp),
                        adapter = rememberScrollbarAdapter(scrollState)
                    )
                }
            }

            NavigationButtons(
                modifier = Modifier
                    .padding(32.dp)
                    .align(if (currentWidth < 800) Alignment.BottomCenter else Alignment.TopCenter),
                hazeState = hazeState,
                currentWidth = currentWidth,
                language = state.language,
                onLanguageToggle = { viewModel.toggleLanguage() },
                onItemClick = { item ->
                    coroutineScope.launch {
                        when (item) {
                            NavigationItem.Home -> scrollState.animateScrollToItem(0)
                            NavigationItem.Habilidades -> scrollState.animateScrollToItem(2)
                            NavigationItem.Proyectos -> scrollState.animateScrollToItem(3)
                            NavigationItem.Contacto -> { /* Handle Contact */ }
                        }
                    }
                }
            )
        }
    }
}
