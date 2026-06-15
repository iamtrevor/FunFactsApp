package com.example.funfacts.Utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {

    fun getRandomColor() : Color {
        return Color(
             red = Random.nextFloat(),
             green = Random.nextFloat(),
             blue = Random.nextFloat(),
             alpha = 1f
        )
    }
}

