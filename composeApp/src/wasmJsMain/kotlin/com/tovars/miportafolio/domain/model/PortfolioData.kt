package com.tovars.miportafolio.domain.model

import androidx.compose.ui.graphics.Color

enum class Language {
    ES, EN
}

data class Specialty(
    val title: String,
    val description: String,
    val color: Color
)

data class Project(
    val title: String,
    val description: String,
    val highlights: List<String> = emptyList(),
    val tags: List<String>,
    val isLive: Boolean,
    val url: String = ""
)

data class Experience(
    val role: String,
    val company: String,
    val period: String,
    val location: String,
    val description: String = "",
    val highlights: List<String> = emptyList(),
    val technologies: List<String> = emptyList(),
    val companyUrl: String = "",
    val playStoreUrls: List<Pair<String, String>> = emptyList()
)

data class Education(
    val degree: String,
    val institution: String,
    val period: String
)

data class AboutMe(
    val name: String,
    val role: String,
    val subtitle: String,
    val description: String,
    val specialties: List<Specialty>,
    val projects: List<Project>,
    val experience: List<Experience>,
    val education: List<Education>
)
