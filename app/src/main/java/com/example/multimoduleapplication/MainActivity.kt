package com.example.multimoduleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.Route
import com.example.multimoduleapplication.navigate.navigate
import com.example.multimoduleapplication.ui.theme.MultiModuleApplicationTheme
import com.example.onboarding_presentation.welcome.WelcomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleApplicationTheme {
                // A surface container using the 'background' color from the theme
              val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.WELCOME){
                    composable(Route.ACTIVITY){

                    }
                    composable(Route.WELCOME){
                     WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE){

                    }
                    composable(Route.GOAL){

                    }
                    composable(Route.GENDER){

                    }
                    composable(Route.HEIGHT){

                    }
                    composable(Route.NUTRIENT_GOAL){

                    }
                    composable(Route.SEARCH){

                    }
                    composable(Route.TRACKER_OVERVIEW){

                    }

                    composable(Route.WEIGHT){

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MultiModuleApplicationTheme {
        Greeting("Android")
    }
}