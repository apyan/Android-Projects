package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.ui.details.MealDetailsScreen
import com.example.mealzapp.ui.details.MealDetailsViewModel
import com.example.mealzapp.ui.meals.MealsCategoriesScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel tied to the activity
        // will be deleted once activity is gone
        //val viewModel by viewModels<MealCategoryViewModel>()

        setContent {
            MealzAppTheme {
                FoodApp()
            }
        }
    }
}

@Composable
private fun FoodApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen() { navigationMealId ->
                navController.navigate("destination_meals_details/$navigationMealId")
            }
        }
        composable(
            route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(mealResponse = viewModel.mealState.value)
        }
    }
}
