package io.github.practicenavigationcomponent.utils

import android.content.Context

/**
 * Handle assets files class
 */
object AssetsUtil {
    object JsonFile {
        const val cats = "cats.json"
    }

    fun readFile(context: Context, fileName: String) =
        context.assets.open(fileName).bufferedReader().readText()
}