package com.example.tugas2sni.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
	onLoginClick: () -> Unit,
	onForgotPasswordClick: () -> Unit,
	onNavigateToRegistration: () -> Unit // Parameter baru untuk navigasi ke registrasi
) {
	var username by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		// Judul Halaman
		Text(
			text = "Masuk",
			style = MaterialTheme.typography.headlineLarge,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(32.dp))

		// Input Username
		OutlinedTextField(
			value = username,
			onValueChange = { username = it },
			label = { Text("Username") },
			leadingIcon = {
				// TODO: Ikon Username telah ditambahkan
				Icon(Icons.Default.Person, contentDescription = "Username Icon")
			},
			modifier = Modifier.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(16.dp))

		// Input Password (Blind Text)
		OutlinedTextField(
			value = password,
			onValueChange = { password = it },
			label = { Text("Password") },
			visualTransformation = PasswordVisualTransformation(),
			leadingIcon = {
				// TODO: Ikon Password telah ditambahkan
				Icon(Icons.Default.Lock, contentDescription = "Password Icon")
			},
			modifier = Modifier.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(24.dp))

		// Tombol Login
		Button(
			onClick = onLoginClick,
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp)
		) {
			Text("Login")
		}

		Spacer(modifier = Modifier.height(8.dp))

		// Tombol/Link Lupa Password
		TextButton(onClick = onForgotPasswordClick) {
			Text("Lupa Password?")
		}

		Spacer(modifier = Modifier.height(16.dp))

		// Tombol untuk navigasi ke halaman registrasi
		TextButton(onClick = onNavigateToRegistration) { // TODO: Navigasi telah dilayani oleh parameter baru
			Text("Belum punya akun? Daftar di sini")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
	// Preview juga perlu mengoper fungsi kosong untuk parameter baru
	LoginScreen(onLoginClick = {}, onForgotPasswordClick = {}, onNavigateToRegistration = {})
}
