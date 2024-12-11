package com.samuelconra.recipesapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuelconra.recipesapp.R
import com.samuelconra.recipesapp.dtos.Auth
import com.samuelconra.recipesapp.dtos.SingUp
import com.samuelconra.recipesapp.services.AuthService
import com.samuelconra.recipesapp.ui.theme.RecipesAppTheme
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun SignupScreen(innerPadding: PaddingValues, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val isPasswordValid = password.isNotBlank() && password == confirmPassword
    val scope = rememberCoroutineScope()
    val sharedPref = SharedPref(LocalContext.current)

    // MAIN COLUMN
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(260.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "hans",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(
                    text = "Nombre",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedBorderColor = Color.Gray
            ),
            trailingIcon = {
                Icon(imageVector = User, contentDescription = "Name")
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    text = "Correo Electrónico",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedBorderColor = Color.Gray
            ),
            trailingIcon = {
                Icon(imageVector = Mail, contentDescription = "email")
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "Contraseña",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedBorderColor = Color.Gray
            ),
            trailingIcon = {
                Icon(imageVector = Lock, contentDescription = "email")
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = {
                Text(
                    text = "Confirmar Contraseña",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedBorderColor = Color.Gray
            ),
            trailingIcon = {
                Icon(imageVector = LockClosed, contentDescription = "email")
            }
        )

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = {
                scope.launch(Dispatchers.IO) {
                    val authService = Retrofit
                        .Builder()
                        .baseUrl("https://recipes-api-gyam.onrender.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthService::class.java)

                    val auth = SingUp(email=email, password=password, name=name, username=name)
                    val response = authService.singUp(auth)
                    Log.i("Singup User", response.toString())

                    if (response.body()?.email == email) {
                        withContext(Dispatchers.Main) {
                            sharedPref.saveUserSharedPref(
                                userId = response.body()?.id ?: 0,
                                isLogged = true
                            )

                            navController.navigate(Screens.Home.route){
                                popUpTo(Screens.Home.route){ inclusive = true }
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 30.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            Text(
                text = "Crear Cuenta",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Las Contraseñas no coinciden",
            color = if (!isPasswordValid && (password.isNotBlank() || confirmPassword.isNotBlank())){
                MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.background
            },
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}