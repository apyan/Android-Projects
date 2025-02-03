package com.example.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.example.mealzapp.model.response.MealResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(mealResponse: MealResponse?) {
//    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
//    val transition = updateTransition(targetState = profilePictureState, label = "")
//    val imageSizeDp by transition.animateDp(
//        targetValueByState = {
//            it.size
//        },
//        label = ""
//    )
//    val color by transition.animateColor(
//        targetValueByState = {
//            it.color
//        },
//        label = ""
//    )
//    val widthSize by transition.animateDp(
//        targetValueByState = {
//            it.borderWidth
//        },
//        label = ""
//    )
    
//    val scrollState = rememberScrollState()
    // Scroll up, value is bigger, down is smaller
//    val offset = min(1f, 1 - (scrollState.value / 600f))
//    val animateSize by animateDpAsState(
//        targetValue = max(100.dp, 200.dp * offset),
//        label = ""
//    )

    val scrollState = rememberLazyListState()
    // Goes by scroll elements, rather than dp
    val offset = min(1f, 1 -
            (scrollState.firstVisibleItemScrollOffset / 600f
                    + scrollState.firstVisibleItemIndex)) // If this is gone, the shrinking element resets,
                                                          // returns big everytime upon new scroll element
    val animateSize by animateDpAsState(
        targetValue = max(100.dp, 140.dp * offset),
        label = ""
    )

    Surface(color = MaterialTheme.colorScheme.background) {
        Column {
            Surface(shadowElevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
//                    width = widthSize,
//                    color = color
                            width = 2.dp,
                            color = Color.Green
                        )
                    ) {
                        AsyncImage(
                            model = mealResponse?.imageUrl,
                            contentDescription = "Image Url",
                            modifier = Modifier
                                .clip(CircleShape)
//                        .size(imageSizeDp)
                                .size(animateSize)
//                                .padding(8.dp)
                        )
                    }
                    Text(
                        text = mealResponse?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
//            Button(
//                modifier = Modifier
//                    .padding(16.dp),
//                onClick = {
//                    profilePictureState  = if(profilePictureState == MealProfilePictureState.Normal)
//                        MealProfilePictureState.Expanded
//                    else
//                        MealProfilePictureState.Normal
//                }) {
//                Text(text = "Change State of Meal Profile Picture")
//            }

//            Column(modifier = Modifier.verticalScroll(scrollState)) {}

            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList) {dummyItem ->
                    Text(text = dummyItem, modifier = Modifier.padding(24.dp))
                }
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}