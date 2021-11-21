package dependencies

object Dep {
    object Jetpack {
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val core = "androidx.core:core-ktx:1.6.0"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val junit = "androidx.test.ext:junit:1.1.3"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"

        object Navigation {
            const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
            const val features = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object JUnit {
        const val junit = "junit:junit:4.+"
    }

    object KotlinX {
        const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    }

    object Coil {
        const val coil = "io.coil-kt:coil:1.4.0"
    }
}