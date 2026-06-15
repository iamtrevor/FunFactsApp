package com.example.funfacts.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.data.UserInputScreenState
import kotlinx.coroutines.flow.MutableStateFlow

class UserInputViewModel : ViewModel() {

    val uiState = mutableStateOf(UserInputScreenState())

    fun events(event : UserDataUiEvents){
        when(event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }

        }
    }


    fun isValid() : Boolean {
        if(!uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()){
            return true
        } else {
            return false
        }
    }



}