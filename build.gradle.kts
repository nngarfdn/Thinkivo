plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.composeHotReload) apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    ktlint {
        version.set("1.0.1")
        debug.set(false)
        verbose.set(false)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true) // Don't fail build on ktlint issues
        filter {
            exclude("**/build/**")
            exclude("**/generated/**")
            exclude("**/*.generated.kt")
            exclude("**/ActualResourceCollectors.kt")
            exclude("**/ExpectedResourceCollectors.kt")
            exclude("**/Res.kt")
            exclude("**/Drawable*.kt")
        }
    }
}
