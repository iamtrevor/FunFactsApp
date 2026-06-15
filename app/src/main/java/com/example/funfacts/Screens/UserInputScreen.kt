package com.example.funfacts.Screens

import android.opengl.ETC1.isValid
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.Components.AnimalCard
import com.example.funfacts.Components.ButtonComponent
import com.example.funfacts.Components.TextComponent
import com.example.funfacts.Components.TextFieldComponent
import com.example.funfacts.Components.TopBar
import com.example.funfacts.ViewModel.UserInputViewModel
import com.example.funfacts.data.UserDataUiEvents

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen : (Pair<String, String>) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(modifier = Modifier.fillMaxSize().padding(30.dp)) {
            TopBar(topText = "Hi there! 👋")

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(
                textValue = "What is your name?",
                textSize = 30.sp,
                textColor = Color.Black,

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(
                textValue = "What are your your interest. " +
                        "This app asks basic questions in order to get your interest." +
                        " Please fill in your Name in the field below and select an image that matches with your area of interest",
                textSize = 20.sp,
                textColor = Color.Black
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            TextFieldComponent(onTextChanged = {
                userInputViewModel.events(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.height(25.dp))

            TextComponent(textValue = "What do you Like?", textSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                AnimalCard(image = com.example.funfacts.R.drawable.dog,  animalSelected = {
                    userInputViewModel.events(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")

                AnimalCard(image = com.example.funfacts.R.drawable.cat,  animalSelected = {

                    userInputViewModel.events(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")

            }


            Spacer(modifier = Modifier.weight(1f))


            if(userInputViewModel.isValid()) {
                ButtonComponent(navigateToDetailsScreen = {
                    showWelcomeScreen(
                    Pair(
                        userInputViewModel.uiState.value.nameEntered,
                        userInputViewModel.uiState.value.animalSelected

                    )
                    )
                })

            }

        }
    }
}


