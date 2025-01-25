package com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.components

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultIconButton
import com.sumpaulo.indriver_jetpack.R
import com.sumpaulo.indriver_jetpack.presentation.components.DefaultTextField
import com.sumpaulo.indriver_jetpack.presentation.components.DialogCameraOrGallery
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.ProfileUpdateViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileUpdateContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ProfileUpdateViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity
    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()

    val stateDialog = remember { mutableStateOf(false) }

    DialogCameraOrGallery(
        state = stateDialog,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() })

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
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .align(Alignment.TopCenter),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            DefaultIconButton(
                modifier = Modifier,
                title = "ATULIZAR PERFIL",
                icon = Icons.Default.Edit,
                onClick = {
                    viewModel.submit()
                }
            )

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
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
                if(!state.image.isNullOrBlank()){
                    AsyncImage(
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .clickable {
                                stateDialog.value = true
                            },
                        model = state.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                            .clickable {
                                stateDialog.value = true
                            },
                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                DefaultTextField(
                    modifier = Modifier,
                    value = state.name,
                    label = "Nome",
                    icon = Icons.Default.Person,
                    onValueChange = {
                        viewModel.onNameInput(it)
                    }
                )

                DefaultTextField(
                    modifier = Modifier,
                    value = state.lastname,
                    label = "Sobrenome",
                    icon = Icons.Default.Person,
                    onValueChange = {
                        viewModel.onLastnameInput(it)
                    }
                )

                DefaultTextField(
                    modifier = Modifier,
                    value = state.phone,
                    label = "Telefone",
                    icon = Icons.Default.Phone,
                    onValueChange = {
                        viewModel.onPhoneInput(it)
                    }
                )


            }
        }
    }
}
