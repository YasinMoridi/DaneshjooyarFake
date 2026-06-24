package com.yasinmoridi.daneshjooyarFake.data.model

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavigationItem(
    val route:String,
    val name:String,
    val selectedIcon: Painter,
    val unSelectedIcon: Painter,
)
