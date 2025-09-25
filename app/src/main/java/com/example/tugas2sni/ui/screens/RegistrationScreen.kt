package com.example.tugas2sni.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2sni.User

@Composable
fun RegistrationScreen(onSaveClick: (User) -> Unit) {
	var firstName by remember { mutableStateOf("") }
	var lastName by remember { mutableStateOf("") }
	var username by remember { mutableStateOf("") }
	var email by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var phoneNumber by remember { mutableStateOf("") }
	var birthDate by remember { mutableStateOf("") }
	var address by remember { mutableStateOf("") }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp)
			.verticalScroll(rememberScrollState()), // Mengizinkan scrolling jika konten melebihi layar
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		// Judul Halaman
		Text(
			text = "Daftar Akun Baru",
			style = MaterialTheme.typography.headlineLarge,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(8.dp))

		// Input data utama
		OutlinedTextField(
			value = firstName,
			onValueChange = { firstName = it },
			label = { Text("Nama Depan") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = lastName,
			onValueChange = { lastName = it },
			label = { Text("Nama Belakang") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = username,
			onValueChange = { username = it },
			label = { Text("Username") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = email,
			onValueChange = { email = it },
			label = { Text("Email") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = password,
			onValueChange = { password = it },
			label = { Text("Password") },
			visualTransformation = PasswordVisualTransformation(),
			modifier = Modifier.fillMaxWidth()
		)

		// 3 input identitas tambahan
		Divider(modifier = Modifier.padding(vertical = 8.dp))
		Text(text = "Informasi Tambahan", style = MaterialTheme.typography.titleMedium)
		OutlinedTextField(
			value = phoneNumber,
			onValueChange = { phoneNumber = it },
			label = { Text("Nomor Telepon") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = birthDate,
			onValueChange = { birthDate = it },
			label = { Text("Tanggal Lahir") },
			modifier = Modifier.fillMaxWidth()
		)
		OutlinedTextField(
			value = address,
			onValueChange = { address = it },
			label = { Text("Alamat") },
			modifier = Modifier.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(8.dp))

		// Tombol Simpan
		Button(
			onClick = {
				val newUser = User(
					firstName = firstName,
					lastName = lastName,
					username = username,
					email = email,
					phoneNumber = phoneNumber,
					birthDate = birthDate,
					address = address
				)
				onSaveClick(newUser)
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp)
		) {
			Text("Simpan")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
	RegistrationScreen(onSaveClick = {})
}
