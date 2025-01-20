package com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.R
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultButton
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultOutlineTextField
import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.auth.AuthScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(paddingValues: PaddingValues, navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()){

    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.errorMessage) {
        if(viewModel.errorMessage.isNotEmpty()){
            Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_LONG).show()
            viewModel.errorMessage = ""
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE1E032),
                        Color(0xFFD3C122)
                    )
                )
            )
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Login",
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 10.dp)
                    .clickable {
                        navController.navigate(AuthScreen.Login.route)
                    },

                color = Color.White,
                fontSize = 27.sp,

                )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Cadastro",
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 80.dp),

                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(250.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, bottom = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFE3AB12),
                            Color(0xFFFAC831)
                        )
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 25.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null
                    )
                }

                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.name,
                    label = "Nome",
                    icon = Icons.Outlined.Person,
                    onValueChange = { viewModel.onNameInput(it) }
                )

                Spacer(modifier = Modifier.height(10.dp))

                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.lastname,
                    label = "Sobrenome",
                    icon = Icons.Outlined.Person,
                    onValueChange = { viewModel.onLastnameInput(it) }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    onValueChange = { viewModel.onEmailInput(it) },
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.phone,
                    label = "Telefone",
                    icon = Icons.Outlined.Phone,
                    onValueChange = { viewModel.onPhoneInput(it)},
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Senha",
                    icon = Icons.Outlined.Lock,
                    onValueChange = { viewModel.onPasswordInput(it) },
                    keyboardType = KeyboardType.Password,
                    hideText = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlineTextField(
                    modifier = Modifier,
                    value = state.confirmPassword,
                    label = "Confirmar Senha",
                    icon = Icons.Outlined.Lock,
                    onValueChange = { viewModel.onConfirmPasswordInput(it) },
                    keyboardType = KeyboardType.Password,
                    hideText = true
                )

                Spacer(modifier = Modifier.height(30.dp))

                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp, bottom = 20.dp),
                    text = "REGISTRAR-SE",
                    onClick = { viewModel.register() }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                    Text(
                        text = "O",
                        modifier = Modifier.padding(horizontal = 6.dp),
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

                ) {

                    Text(
                        text = "Já tem Conta?",
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Entrar",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        },
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.height(60.dp))
            }

        }
    }
}