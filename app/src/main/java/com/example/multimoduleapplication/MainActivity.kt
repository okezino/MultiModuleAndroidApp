package com.example.multimoduleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.Route
import com.example.multimoduleapplication.navigate.navigate
import com.example.multimoduleapplication.ui.theme.MultiModuleApplicationTheme
import com.example.onboarding_presentation.activity.ActivityScreen
import com.example.onboarding_presentation.age.AgeScreen
import com.example.onboarding_presentation.gender.GenderScreen
import com.example.onboarding_presentation.goal.GoalScreen
import com.example.onboarding_presentation.height.HeightScreen
import com.example.onboarding_presentation.weight.WeightScreen
import com.example.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleApplicationTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState

                ) {

                    NavHost(navController = navController, startDestination = Route.WELCOME) {
                        composable(Route.ACTIVITY) {
                            ActivityScreen(onNextClick = navController::navigate)
                        }
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE) {
                            AgeScreen(scaffoldState, onNextClick = navController::navigate)

                        }
                        composable(Route.GOAL) {
                            GoalScreen(onNextClick = navController::navigate)

                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNextClick = navController::navigate)

                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = navController::navigate
                            )

                        }
                        composable(Route.NUTRIENT_GOAL) {

                        }
                        composable(Route.SEARCH) {

                        }
                        composable(Route.TRACKER_OVERVIEW) {

                        }

                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNextClick = navController::navigate
                            )

                        }
                    }

                }

            }
        }
    }
}