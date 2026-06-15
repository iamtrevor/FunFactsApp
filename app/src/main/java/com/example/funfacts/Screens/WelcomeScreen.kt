package com.example.funfacts.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacts.Components.FactComposable
import com.example.funfacts.Components.TextComponent
import com.example.funfacts.Components.TextWithShadow
import com.example.funfacts.Components.TopBar
import com.example.funfacts.ViewModel.FanFactsViewModel


@Composable
fun WelcomeScreen(userName: String?, animalSelected: String?) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {

            TopBar(topText = "Welcome $userName 😍")

            Spacer(modifier = Modifier.height(30.dp))

            TextComponent(textValue = "Thank you for sharing your data", textSize = 24.sp)

            Spacer(modifier = Modifier.height(60.dp))

            val animalPreference = if (animalSelected == "Dog") "You are a dog 🐶 lover" else "You are a cat 🐱 lover"

            TextWithShadow(value = animalPreference)

            Spacer(modifier = Modifier.height(30.dp))

            val fanFactsViewModel : FanFactsViewModel = viewModel()
            FactComposable(value =
             fanFactsViewModel.getRandomFacts(animalSelected!!))
        }
    }
}


