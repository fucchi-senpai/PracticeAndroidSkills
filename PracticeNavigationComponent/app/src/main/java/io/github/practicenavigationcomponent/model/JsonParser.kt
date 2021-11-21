package io.github.practicenavigationcomponent.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

inline fun <reified T> decodeJson(jsonStr: String) = Json.decodeFromString<T>(jsonStr)