package org.mob.thinkivo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import org.mob.thinkivo.features.login.presentation.LoginScreen
import org.mob.thinkivo.features.login.presentation.LoginViewModel
import org.mob.thinkivo.kivodesign.theme.KivoTheme
import org.mob.thinkivo.kivodesign.theme.ThemeManager

@Composable
fun App() {
    KivoTheme(darkTheme = ThemeManager.isDarkTheme) {
        val viewModel = remember { LoginViewModel() }
        val state by viewModel.state.collectAsState()
        LoginScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

