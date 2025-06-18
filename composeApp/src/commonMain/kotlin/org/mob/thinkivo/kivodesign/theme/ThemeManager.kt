package org.mob.thinkivo.kivodesign.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * ThemeManager manages the app's theme state.
 * Provides centralized theme control across the app.
 */
object ThemeManager {
    var isDarkTheme by mutableStateOf(false)
        private set

    /**
     * Toggle between light and dark theme
     */
    fun toggleTheme() {
        isDarkTheme = !isDarkTheme
    }

    /**
     * Set specific theme
     * @param darkTheme true for dark theme, false for light theme
     */
    fun setTheme(darkTheme: Boolean) {
        isDarkTheme = darkTheme
    }

    /**
     * Reset to system theme preference
     */
    fun resetToSystemTheme() {
        // This could be enhanced to read from system preferences
        // For now, defaults to light theme
        isDarkTheme = false
    }
}
