package com.example.tugas2sni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas2sni.ui.screens.AvatarScreen
import com.example.tugas2sni.ui.screens.LoginScreen
import com.example.tugas2sni.ui.screens.ProfileScreen
import com.example.tugas2sni.ui.screens.RegistrationScreen
import com.example.tugas2sni.ui.theme.TUGAS2SNITheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TUGAS2SNITheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					MyAppNavigation()
				}
			}
		}
	}
}

// Data class untuk menyimpan informasi user
data class User(
	val firstName: String,
	val lastName: String,
	val username: String,
	val email: String,
	val phoneNumber: String,
	val birthDate: String,
	val address: String
)

@Composable
fun MyAppNavigation() {
	val navController = rememberNavController()
	var registeredUser by remember { mutableStateOf<User?>(null) }

	NavHost(navController = navController, startDestination = "login") {
		composable("login") {
			LoginScreen(
				onLoginClick = { navController.navigate("profile") },
				onForgotPasswordClick = { /* TODO: Navigasi ke halaman Lupa Password */ },
				onNavigateToRegistration = { navController.navigate("registration") }
			)
		}
		composable("registration") {
			RegistrationScreen(
				onSaveClick = { user ->
					registeredUser = user
					navController.navigate("profile")
				}
			)
		}
		composable("profile") {
			registeredUser?.let { user ->
				ProfileScreen(
					user = user,
					onLogoutClick = { navController.navigate("login") },
					onNavigateToAvatar = { navController.navigate("avatar") } // Tambahkan navigasi ke AvatarScreen
				)
			}
		}
		// Tambahkan rute untuk halaman Avatar
		composable("avatar") {
			AvatarScreen()
		}
	}
}
