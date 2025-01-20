package com.sumpaulo.indriver_jetpack.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Color.Black
){
    Box(
        modifier = modifier
    ){
        Button(
            modifier = Modifier
                .align(Alignment.Center)
                .width(250.dp)
                .height(55.dp),
            onClick =  onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = color
            )
        ) {
            Text(text, fontSize = 18.sp)
        }
    }
}