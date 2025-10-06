# DharshanaBookTracker (3 Screens, No Theme)

Minimal Android project with **3 Compose screens** (Library, Book Detail, Add Book) and **no XML theme**.

## Open in Android Studio
1. File → Open… → select this folder (has `settings.gradle.kts`) → Trust.
2. File → Sync Project with Gradle Files.
3. Settings → Build, Execution, Deployment → Gradle → Gradle JDK = 17.
4. Build → Rebuild Project → Run ▶.

Notes:
- Manifest has **no `android:theme`**. Compose `MaterialTheme{}` is only used in code.
- Java/Kotlin targets are **17** to avoid toolchain mismatch.
