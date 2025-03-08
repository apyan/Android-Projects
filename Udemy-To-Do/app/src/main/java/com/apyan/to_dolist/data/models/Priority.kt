package com.apyan.to_dolist.data.models

import androidx.compose.ui.graphics.Color
import com.apyan.to_dolist.ui.theme.HighPriorityColor
import com.apyan.to_dolist.ui.theme.LowPriorityColor
import com.apyan.to_dolist.ui.theme.MediumPriorityColor
import com.apyan.to_dolist.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}