package com.acornova.thenavigator

import androidx.compose.ui.graphics.Color

object Colors {
    var primary = Color(0xFF8B5CF6)          // vibrant violet (car highlight)
    var onPrimary = Color(0xFFF3E8FF)        // light lavender for text/icons on primary
    var onPrimaryContrast = Color(0xFF2A004E) // deep purple for contrast elements

    var primaryVariant = Color(0xFF6D28D9)   // darker purple variant
    var onPrimaryVariant = Color(0xFFFFFFFF) // pure white text on dark purple

    var container = Color(0xFF4B0082)        // indigo container for secondary UI
    var onContainer = Color(0xFFDCCFFF)      // soft lavender text/icons
    var onContainerVariant = Color(0xFFF8F5FF) // very light tone for subtle highlights

    var background = Color(0xFF0E0A1A)       // near-black indigo background
}
