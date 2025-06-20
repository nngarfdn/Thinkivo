---
description: 
globs: 
alwaysApply: true
---
# KMP Compose Multiplatform Coding Rules

## Table of Contents

- @General Kotlin Principles
- @Project Structure: Feature Modules & Separation of Concerns
- @State Management: Event-State Pattern in Compose
- @Architecture
- @Data & Persistence
- @Testing
- @Documentation & Comments
- @Dependency Injection
- @Platform-Specific Code
- @Error Handling & Logging
- @Accessibility & Internationalization
- @Code Formatting & Linting
- @Versioning & Deprecation
- @Security & Privacy
- @Continuous Integration & Automation
- @Contribution & Onboarding
- @Code Review
- @Performance
- @Release Process
- @Design System
- @API Evolution

---

## General Kotlin Principles

- **Language:** Use English for all code, comments, and documentation.
- **Type Declarations:** Explicitly declare types for all variables, function parameters, and return values.  
  - Avoid `Any` and create specific types as needed.
- **Naming Conventions:**
  - **Classes/Objects:** PascalCase (e.g., `UserProfile`)
  - **Functions/Variables:** camelCase (e.g., `fetchUserData`)
  - **Files/Directories:** PascalCase (e.g., `UserProfile.kt`)
  - **Constants/Env Vars:** UPPERCASE_WITH_UNDERSCORES
  - **Booleans:** Use verbs (e.g., `isLoading`, `hasError`)
  - **No abbreviations** except for standard or well-known cases (`API`, `URL`, `i`, `j`, `err`, `ctx`).
- **Functions:**
  - Short, single-purpose (<20 instructions).
  - Name with a verb and a noun (e.g., `loadUserProfile`).
  - Boolean-returning: `isX`, `hasX`, `canX`.
  - Void-returning: `executeX`, `saveX`.
  - Use early returns and extract utility functions to avoid deep nesting.
  - Use higher-order functions (`map`, `filter`, etc.) and arrow functions for simple logic.
  - Use default parameter values instead of null checks.
  - Use RO-RO (Request Object - Response Object) for multiple parameters/returns.
  - Maintain a single level of abstraction per function.
- **Data:**
  - Use `data class` for data structures.
  - Prefer composite types over primitives.
  - Encapsulate validation within classes.
  - Prefer immutability (`val`).
- **Classes:**
  - Follow SOLID principles.
  - Prefer composition over inheritance.
  - Use interfaces for contracts.
  - Keep classes small (<200 lines, <10 public methods/properties).
- **Exceptions:**
  - Use exceptions for unexpected errors.
  - Catch exceptions only to fix, add context, or escalate; otherwise, use a global handler.

---

## Project Structure: Feature Modules & Separation of Concerns

- Organize your codebase by **feature modules** (feature-first), not by technical layer across the whole app.
- Each feature (e.g., `login`, `profile`, `appointments`) should have its own folder/module using **PascalCase**.
- Inside each feature folder:
  - `data/`: Data sources, repositories, DTOs, platform-specific implementations.
  - `domain/`: Use cases, business logic, models.
  - `presentation/`: Screens, view models, UI state, events, composables.
  - `FeatureModule.kt`: Dependency injection setup for the feature.
- Place shared/core code (e.g., navigation, design system, utilities, DI) in a `core/` directory.
- Platform-specific implementations go in `androidMain` and `iosMain` under the same feature structure.
- Write tests inside each feature's folder in `commonTest`.
- **Boundary Principle:** Shared code should not depend on platform-specific code. Use expect/actual for platform APIs.

### Example Structure

```
composeApp/
  src/
    commonMain/
      kotlin/
        org/
          mob/
            thinkivo/
              features/
                login/
                  data/
                    LoginRepository.kt
                  domain/
                    LoginUseCase.kt
                  presentation/
                    LoginScreen.kt
                    LoginViewModel.kt
                  LoginModule.kt
                profile/
                  data/
                  domain/
                  presentation/
                  ProfileModule.kt
                appointments/
                  data/
                  domain/
                  presentation/
                  AppointmentsModule.kt
              core/
                navigation/
                designsystem/
                utils/
                di/
    androidMain/
      kotlin/
        org/
          mob/
            thinkivo/
              features/
                login/
                  data/
                    AndroidLoginRepository.kt
                profile/
                  data/
                    AndroidProfileRepository.kt
    iosMain/
      kotlin/
        org/
          mob/
            thinkivo/
              features/
                login/
                  data/
                    IosLoginRepository.kt
                profile/
                  data/
                    IosProfileRepository.kt
    commonTest/
      kotlin/
        org/
          mob/
            thinkivo/
              features/
                login/
                  LoginUseCaseTest.kt
                profile/
                  ProfileUseCaseTest.kt
```

### Guidelines

- Use **PascalCase** for feature and file names.
- Each feature should be as independent as possible.
- Use interfaces for repositories and inject platform-specific implementations.
- Write tests inside each feature's folder.
- Keep core utilities/design system/navigation in a `core/` directory.

---

## State Management: Event-State Pattern in Compose

- Use **unidirectional data flow** for state management (event-state pattern).
- **Single Source of Truth:** Always keep a single source of truth for UI state in the ViewModel or state holder. Never duplicate or scatter state across multiple places. Composables should only observe state, not own or duplicate it.
- Define a **UI state** data class for each screen or feature, representing all the data needed to render the UI.
- Define a **sealed class** for UI events (user actions, intents) and another for UI effects (one-time actions like navigation, showing a snackbar, etc.).
- Use `State`, `MutableState`, and `StateFlow` to hold and observe UI state in view models and composables.
- The **ViewModel** (or state holder) should:
  - Expose the UI state as an immutable `State` or `StateFlow`.
  - Expose a function to handle events, e.g., `onEvent(event: LoginEvent)`.
  - Emit effects via a separate `SharedFlow` or similar mechanism for one-time actions.
- **Composable functions** should:
  - Collect and observe state from the ViewModel.
  - Send user actions as events to the ViewModel.
  - React to effects (e.g., navigation, showing messages) using side-effect APIs like `LaunchedEffect`.
- Keep state, events, and effects types in the `presentation` layer of each feature.
- Use `remember`, `rememberSaveable`, and Compose state APIs for local UI state only (e.g., text field input), not for business logic or screen state.
- Keep all business logic and state transitions in the ViewModel or state holder, not in composables.
- Use `collectAsState()` or similar APIs to observe state in composables.
- Prefer **stateless composables** that receive all state and event handlers as parameters.

#### Example

```kotlin
// In features/login/presentation/LoginState.kt

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object Submit : LoginEvent()
}

sealed class LoginEffect {
    object NavigateToHome : LoginEffect()
    data class ShowError(val message: String) : LoginEffect()
}
```

---

## Architecture

- **Clean Architecture:**  
  - Separate code into `presentation`, `domain`, and `data` layers within each feature.
  - Use repositories for data access and persistence.
  - Use dependency injection (e.g., Koin, Hilt where supported).
- **State Management:**  
  - Use MVI (Model-View-Intent) or MVVM patterns for state and event management.
  - Use `State`, `MutableState`, and `StateFlow` for UI state.
  - Use sealed classes for UI events and effects.
- **Navigation:**  
  - Use Compose Navigation for multiplatform navigation.
  - Structure navigation logic in a centralized navigator or navigation graph.
- **UI:**
  - Use Jetpack Compose Multiplatform for UI.
  - Use Material 3 components where available.
  - Use `@Composable` functions for UI elements.
  - Keep composables small and focused (<100 lines).
  - Use `remember`, `rememberSaveable`, and `LaunchedEffect` appropriately.
  - Use themes and design systems for consistent styling.
- **Platform-Specific Code:**  
  - Use expect/actual or platform modules for platform-specific implementations.
  - Keep platform-specific code isolated from shared modules.
  - Document platform-specific differences and rationale.

---

## Data & Persistence

- **Repositories:**  
  - Define repository interfaces in each feature's `commonMain`.
  - Implement platform-specific repositories in `androidMain`, `iosMain`, etc.
- **Caching:**  
  - Use in-memory or persistent caching as needed, abstracted via repositories.
- **Data Serialization:**  
  - Use multiplatform-safe serialization libraries (e.g., kotlinx.serialization).
- **Database:**  
  - Use multiplatform database solutions (e.g., SQLDelight) where possible.

---

## Testing

- **Unit Tests:**  
  - Write unit tests for all public functions in `commonTest`.
  - Use clear variable names: `inputX`, `mockX`, `actualX`, `expectedX`.
  - Use test doubles for dependencies.
- **UI Tests:**  
  - Use Compose UI testing for multiplatform UI.
- **Integration Tests:**  
  - Write integration tests for data and API modules.
- **Test Structure:**  
  - Arrange-Act-Assert for unit tests.
  - Given-When-Then for acceptance/integration tests.
- **Test Coverage:**  
  - Aim for >80% coverage on business logic and critical paths.
- **Test Naming:**  
  - Use descriptive names, e.g., `shouldReturnErrorWhenPasswordIsEmpty`.
- **Tooling:**  
  - Use multiplatform test runners and CI integration (e.g., GitHub Actions, TeamCity).

---

## Documentation & Comments

- Use **KDoc** for all public classes, functions, and properties.
- Write clear, concise comments explaining why (not what) for complex logic.
- Use `TODO:` and `FIXME:` tags for incomplete or problematic code, with a clear explanation and, if possible, a ticket reference.
- Keep documentation up to date with code changes.
- **Architecture Decision Records (ADRs):**  
  - Maintain ADRs in `/docs/adr/` for major decisions.
- **Changelog:**  
  - Maintain a `CHANGELOG.md` at the project root.

---

## Dependency Injection

- Use a DI framework (e.g., Koin, Hilt) or manual DI for testability and modularity.
- Each feature should have its own DI module.
- Register all dependencies in a central DI graph in `core/di/`.
- Prefer constructor injection for testability.

---

## Platform-Specific Code

- Use `expect/actual` for multiplatform abstractions.
- Keep platform-specific code in `androidMain`, `iosMain`, etc.
- Document platform-specific differences and rationale.
- **Shared Code Boundaries:**  
  - Never reference platform-specific APIs in shared code except via expect/actual.

---

## Error Handling & Logging

- Use exceptions for unexpected errors only.
- Catch exceptions to fix, add context, or escalate; otherwise, use a global handler.
- Use a logging library (e.g., Napier) for multiplatform logging.
- Never log sensitive data (passwords, tokens, PII).
- Use sealed classes for error types in domain logic.

---

## Accessibility & Internationalization

- Use accessible components and provide content descriptions for all UI elements.
- Support dynamic font sizes and color contrast.
- Use string resources for all user-facing text.
- Support localization and right-to-left layouts where possible.
- Test accessibility on all supported platforms.

---

## Code Formatting & Linting

- Use `ktlint` or `detekt` for code style enforcement.
- Follow the official Kotlin style guide.
- Run linters and formatters before every commit or PR.
- Enforce consistent formatting in CI.

---

## Versioning & Deprecation

- Use @SemVer for versioning.
- Mark deprecated APIs with `@Deprecated` and provide migration guidance.
- Remove deprecated code after a reasonable period.
- Document all breaking changes in the changelog.

---

## Security & Privacy

- Never store sensitive data in plain text.
- Use secure storage APIs for credentials and tokens.
- Sanitize all user input and validate on both client and server.
- Follow platform security best practices.
- **Secrets Management:**  
  - Never commit secrets to the repository. Use environment variables or secret managers.
- **Dependency Vetting:**  
  - Regularly audit third-party dependencies for vulnerabilities.

---

## Continuous Integration & Automation

- Use CI pipelines (e.g., GitHub Actions, GitLab CI) for build, test, and lint automation.
- Run all tests and linters on every PR.
- Require code review and passing status checks before merging.
- Automate multiplatform builds and artifact publishing.

---

## Contribution & Onboarding

- Provide a `CONTRIBUTING.md` with setup, coding, and PR guidelines.
- Use clear, conventional commit messages (e.g., `feat:`, `fix:`, `refactor:`).
- Document onboarding steps for new contributors in the README.
- **Onboarding Checklist:**  
  - Environment setup
  - Build and run instructions
  - Test execution
  - Coding standards
  - Useful links (docs, ADRs, changelog)

---

## Code Review

- All code must be reviewed by at least one other developer.
- Use PR templates to ensure all requirements are met.
- Reviewers should check for: correctness, readability, test coverage, adherence to guidelines, and documentation.
- Use comments for suggestions and required changes.
- Approve only when all checks pass.

---

## Performance

- Profile performance on all supported platforms.
- Use memory and CPU profilers to detect leaks and bottlenecks.
- Optimize for startup time and UI responsiveness.
- Avoid unnecessary recompositions in Compose.
- Document known performance trade-offs.

---

## Release Process

- Use tagged releases and maintain release notes.
- Automate artifact publishing for all platforms.
- Follow SemVer for versioning.
- Document the release workflow in the README.

---

## Design System

- Extend the design system in `core/designsystem` only via PRs with design review.
- Document all new components and variants.
- Use tokens and themes for consistent styling.
- Avoid hardcoded colors, fonts, or dimensions.

---

## API Evolution

- Evolve public APIs with backward compatibility in mind.
- Use deprecation annotations and migration docs for breaking changes.
- Document API changes in the changelog.
- For multiplatform APIs, ensure consistent behavior across platforms.

---

## Example Function Signature

```kotlin
data class UserProfile(val id: String, val name: String)

interface UserRepository {
    suspend fun fetchUserProfile(userId: String): UserProfile
}

fun isUserLoggedIn(userProfile: UserProfile?): Boolean {
    return userProfile != null
}
```

---

## Example Composable

```kotlin
@Composable
fun UserProfileScreen(
    userProfile: UserProfile,
    onLogout: () -> Unit
) {
    Column {
        Text(text = userProfile.name)
        Button(onClick = onLogout) {
            Text("Logout")
        }
    }
}
```
