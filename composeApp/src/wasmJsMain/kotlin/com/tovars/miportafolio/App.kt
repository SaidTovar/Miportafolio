package com.tovars.miportafolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.tovars.miportafolio.core.ui.theme.PortafolioTheme
import com.tovars.miportafolio.data.repository.PortfolioRepositoryImpl
import com.tovars.miportafolio.features.home.presentation.HomeViewModel
import com.tovars.miportafolio.features.home.ui.HomeScreen

@Composable
fun App() {
    // Dependency Injection (Manual)
    val repository = remember { PortfolioRepositoryImpl() }
    val viewModel = remember { HomeViewModel(repository) }

    PortafolioTheme {
        HomeScreen(viewModel)
    }
}
