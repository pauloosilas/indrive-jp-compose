package com.sumpaulo.indriver_jetpack.presentation.screens.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.auth.AuthScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.LoginScreen
import com.sumpaulo.indriver_jetpack.ui.theme.IndriverjetpackTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.sumpaulo.indriver_jetpack.R
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultButton
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultOutlineTextField
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController) {


    Scaffold { paddingvalues ->
        RegisterContent(paddingvalues, navController)
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    IndriverjetpackTheme {
        RegisterScreen(navController = rememberNavController())
    }
}