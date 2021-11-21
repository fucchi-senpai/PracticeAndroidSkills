package io.github.practicenavigationcomponent.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
data class Cats(val cats: ArrayList<Cat>)

@Keep
@Serializable
data class Cat(val name: String, val description: String, val imageUrl: String, val referenceUrl: String) :
    java.io.Serializable