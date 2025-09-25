package com.example.tugas2sni.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2sni.User


@Composable
fun ProfileScreen(user: User, onLogoutClick: () -> Unit, onNavigateToAvatar: () -> Unit) { // Tambahkan parameter baru
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Judul Halaman
		Text(
			text = "Profil Pengguna",
			style = MaterialTheme.typography.headlineLarge,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(32.dp))

		// Informasi Profil
		Column(
			modifier = Modifier.fillMaxWidth(),
			verticalArrangement = Arrangement.spacedBy(16.dp)
		) {
			InfoRow(label = "Nama Lengkap:", value = "${user.firstName} ${user.lastName}")
			InfoRow(label = "Username:", value = user.username)
			InfoRow(label = "Email:", value = user.email)
			Divider()
			InfoRow(label = "Nomor Telepon:", value = user.phoneNumber)
			InfoRow(label = "Tanggal Lahir:", value = user.birthDate)
			InfoRow(label = "Alamat:", value = user.address)
		}

		Spacer(modifier = Modifier.height(24.dp)) // Kurangi spacer agar ada ruang untuk tombol baru

		// Tambahkan tombol untuk ke halaman Avatar
		Button(
			onClick = onNavigateToAvatar, // Panggil parameter baru
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp)
		) {
			Text("Lihat Avatar")
		}

		Spacer(modifier = Modifier.weight(1f)) // Mendorong tombol ke bagian bawah layar

		// Tombol Logout
		Button(
			onClick = onLogoutClick,
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp),
			colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
		) {
			Text("Logout")
		}
	}
}
@Composable
fun InfoRow(label: String, value: String) {
	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(text = label, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge)
		Text(text = value, style = MaterialTheme.typography.bodyLarge)
	}
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
	val dummyUser = User(
		firstName = "Ahmad",
		lastName = "Satriani",
		username = "ahmadsn",
		email = "ahmad.satriani@gmail.com",
		phoneNumber = "081234567890",
		birthDate = "25 September 2000",
		address = "Jl. Sudirman No. 101, Jakarta"
	)
	ProfileScreen(
		user = dummyUser,
		onLogoutClick = {},
		onNavigateToAvatar = {} // Tambahkan parameter yang hilang di sini
	)
}
