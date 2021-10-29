package ar.edu.unlam.marvelmultiplataforma.model

import kotlinx.serialization.Serializable

@Serializable
data class Personaje (
    val name: String,
    val description: String,
    val thumbnailUrl: String
    )

