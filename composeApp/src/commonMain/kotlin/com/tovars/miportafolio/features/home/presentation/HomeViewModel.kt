package com.tovars.miportafolio.features.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tovars.miportafolio.data.repository.PortfolioRepository
import com.tovars.miportafolio.domain.model.Language

class HomeViewModel(
    private val repository: PortfolioRepository
) {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        loadData()
    }

    fun toggleLanguage() {
        val newLanguage = if (_state.value.language == Language.ES) Language.EN else Language.ES
        _state.value = _state.value.copy(language = newLanguage)
        loadData()
    }

    private fun loadData() {
        _state.value = _state.value.copy(isLoading = true)
        val data = repository.getAboutMe(_state.value.language)
        _state.value = _state.value.copy(
            aboutMe = data,
            isLoading = false
        )
    }
}
