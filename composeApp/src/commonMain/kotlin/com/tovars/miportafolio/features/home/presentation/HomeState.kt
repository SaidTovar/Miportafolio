package com.tovars.miportafolio.features.home.presentation

import com.tovars.miportafolio.domain.model.AboutMe
import com.tovars.miportafolio.domain.model.Language

data class HomeState(
    val aboutMe: AboutMe? = null,
    val isLoading: Boolean = false,
    val language: Language = Language.ES
)
