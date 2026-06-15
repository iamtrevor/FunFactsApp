package com.example.funfacts.Routes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfacts.Screens.UserInputScreen
import com.example.funfacts.Screens.WelcomeScreen
import com.example.funfacts.ViewModel.UserInputViewModel


@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){

    var navController = rememberNavController()

    //NavHost is a container for the screens
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
                    UserInputScreen(userInputViewModel, showWelcomeScreen = {
                        println("Coming_inside_showWelcome")
                        println(it.first)
                        println(it.second)
                        navController.navigate(Routes.WELCOME_SCREEN+"/${it.first}/${it.second}")
                    })
        }


        composable(
            route = "${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(Routes.USER_NAME) {
                    type = NavType.StringType
                },
                navArgument(Routes.ANIMAL_SELECTED) {
                    type = NavType.StringType
                }
            )
        ) {

            var userName = it?.arguments?.getString(Routes.USER_NAME)
            var animalSelected = it?.arguments?.getString(Routes.ANIMAL_SELECTED)
            WelcomeScreen(userName, animalSelected)
        }


    }
}





