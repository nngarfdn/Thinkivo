package org.mob.thinkivo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.mob.thinkivo.kivodesign.components.toggle.KivoThemeToggle
import org.mob.thinkivo.kivodesign.demo.KivoDesignDemo
import org.mob.thinkivo.kivodesign.theme.KivoTheme
import org.mob.thinkivo.kivodesign.theme.ThemeManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    KivoTheme(darkTheme = ThemeManager.isDarkTheme) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "KivoDesign System",
                            style = KivoTheme.typography.H5
                        )
                    },
                    actions = {
                        KivoThemeToggle(
                            isDarkTheme = ThemeManager.isDarkTheme,
                            onThemeChange = { newTheme -> ThemeManager.setTheme(newTheme) },
                            showLabel = false
                        )
                    }
                )
            }
        ) { paddingValues ->
            KivoDesignDemo()
        }
    }
}

