package com.example.corecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corecompose.ui.theme.CoreComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CoreComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    //Surface can only have one child
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
//        Row(
//            modifier = Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            HorizontalColoredBar(Color.Red)
//            HorizontalColoredBar(Color.Blue)
//            HorizontalColoredBar(Color.Cyan)
//            HorizontalColoredBar(Color.Magenta)
//            HorizontalColoredBar(Color.Green)
//        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {

                VerticalColoredBar(Color.Red)
                VerticalColoredBar(Color.Blue)
            }

            VerticalColoredBar(Color.Cyan)
            VerticalColoredBar(Color.Magenta)
            VerticalColoredBar(Color.Green)
        }
    }
}

@Composable
fun VerticalColoredBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(50.dp)
            .width(80.dp)
    ) { }
}

@Composable
fun HorizontalColoredBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(80.dp)
            .width(50.dp)
    ) { }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoreComposeTheme {
        MainScreen()
    }
}