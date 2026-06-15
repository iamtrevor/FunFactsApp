package com.example.funfacts.Components

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.funfacts.R
import com.example.funfacts.Utils.Utils


@Composable
fun TopBar(topText : String){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Text(
            text = topText,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}




@Composable
fun TextComponent(textValue: String, textSize: TextUnit, textColor: Color = Color.Black){
    Text(
        text = textValue,
        color = textColor,
        fontSize = textSize
    )
}


@Composable
fun TextFieldComponent(onTextChanged : (name : String) -> Unit){

    var currentValue by remember { mutableStateOf("") }

    var localFocusManager = LocalFocusManager.current


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        }
    )
}



@Composable
fun AnimalCard(image: Int, selected : Boolean, animalSelected : (animalName : String) -> Unit){

    val localFocusManager = LocalFocusManager.current

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(20.dp).size(130.dp).height(200.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){

        Box(

            modifier = Modifier.fillMaxSize()
                .border(
                    shape = RoundedCornerShape(8.dp),
                    width = 3.dp,
                    color = if (selected) Color.Green else Color.Transparent
                )
        ) {

            Image(
                modifier = Modifier.padding(16.dp).wrapContentWidth().wrapContentHeight().height(180.dp)
                    .clickable{
                        localFocusManager.clearFocus()
                        val animalName = if(image == R.drawable.dog) "Dog" else "Cat"
                        animalSelected(animalName)
                    },
                contentScale = ContentScale.Crop,
                painter = painterResource(id = image),
                contentDescription = "Animal Image",

            )
        }
    }
}



@Composable
fun ButtonComponent(navigateToDetailsScreen : () -> Unit){

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {navigateToDetailsScreen()}
    ){
        TextComponent(textValue = "Proceed to Details Screen", textSize = 18.sp, textColor = Color.White)
    }
}




@Composable
fun TextWithShadow(value : String){
    val shadowffSet = Offset(x= 1f, y = 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.getRandomColor(), shadowffSet, 2f)
        )
    )

}


@Composable
fun FactComposable(value: String) {
    Card(
        modifier = Modifier.padding(32.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(
            modifier = Modifier.padding(18.dp,24.dp)
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            TextWithShadow(value = value)

        }

    }
}





