package com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.info.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.sumpaulo.indriver_jetpack.MainActivity
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultIconButton
import com.sumpaulo.indriver_jetpack.R
import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.profile.ProfileScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.info.ProfileInfoViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileInfoContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ProfileInfoViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    Box(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()
    ){
        Column(modifier = Modifier.padding(bottom = 50.dp)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE7C930), Color(0xFFC9AD1F))
                    )
                ),

               ){
                Text(text="PERFIL",
                    modifier = Modifier.padding(top = 40.dp)
                        .align(Alignment.TopCenter),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            DefaultIconButton(
                modifier = Modifier,
                title = "EDITAR PERFIL",
                icon = Icons.Default.Edit,
                onClick = {
                   if(viewModel.user != null){
                       navController.navigate(ProfileScreen.ProfileUpdate.passUser(viewModel.user!!.toJson()))
                   }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaultIconButton(
                modifier = Modifier,
                title = "SAIR",
                icon = Icons.Default.ExitToApp,
                onClick = {
                    viewModel.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(horizontal = 20.dp, vertical = 100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(115.dp)
                        .clip(CircleShape)
                ){
                    if(!viewModel.user?.image.isNullOrBlank()){
                        AsyncImage(
                            model = viewModel.user?.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }else{
                        Image(
                            painter = painterResource(id = R.drawable.user_image),
                            contentDescription = null
                        )
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text= "${viewModel.user?.name} ${viewModel.user?.lastname}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text= viewModel.user?.email ?: "",
                    fontSize = 16.sp,
                )
                Text(text="${viewModel.user?.phone}",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ProfileInfoContentPreview(){
    ProfileInfoContent(navController = rememberNavController(), paddingValues =  PaddingValues())
}