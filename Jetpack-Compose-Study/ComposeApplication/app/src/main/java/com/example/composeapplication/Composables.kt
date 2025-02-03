package com.example.composeapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .clickable(onClick = {
            })
            .padding(all = 24.dp) // Order matters! Padding no longer clickable if before
            .height(240.dp)
            .width(200.dp),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.SemiBold
    )

    // Modifiers apply outer towards inner

//    style = TextStyle(
//        color = Color.Blue,
//        fontWeight = FontWeight.Bold,
//        fontSize = 18.sp

    //.padding(start = 24.dp, top = 24.dp)
    //.size(width = 80.dp, height = 80.dp)
    //.width(80.dp)
    //.fillMaxSize()
    //.fillMaxHeight()
    //.fillMaxWidth(0.5f)
}

@Composable
fun GreetingButton() {
    Button(onClick = {
        // Do something
    }) {
        GreetingText(name = "button")
        GreetingText(name = " remaining button")
    }
}
