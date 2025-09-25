package com.example.tugas2sni.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas2sni.R

@Composable
fun AvatarScreen() {
	// State untuk setiap komponen wajah
	var isBrowEnabled by remember { mutableStateOf(true) }
	var isEyeEnabled by remember { mutableStateOf(true) }
	var isNoseEnabled by remember { mutableStateOf(true) }
	var isMouthEnabled by remember { mutableStateOf(true) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(24.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Judul Halaman
		Text(
			text = "Avatar Anda",
			style = MaterialTheme.typography.headlineLarge,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(32.dp))

		// Tumpukan gambar avatar menggunakan Box
		Box(
			modifier = Modifier
				.size(300.dp)
				.align(Alignment.CenterHorizontally)
		) {
			// Gambar dasar wajah (wajib ditampilkan)
			Image(
				painter = painterResource(id = R.drawable.ic_avatar_base),
				contentDescription = "Avatar Base",
				modifier = Modifier.fillMaxSize()
			)

			// Komponen wajah yang akan tampil/sembunyi berdasarkan state checkbox
			if (isBrowEnabled) {
				Image(
					painter = painterResource(id = R.drawable.ic_avatar_brow),
					contentDescription = "Alis",
					modifier = Modifier.fillMaxSize()
				)
			}
			if (isEyeEnabled) {
				Image(
					painter = painterResource(id = R.drawable.ic_avatar_eye),
					contentDescription = "Mata",
					modifier = Modifier.fillMaxSize()
				)
			}
			if (isNoseEnabled) {
				Image(
					painter = painterResource(id = R.drawable.ic_avatar_nose),
					contentDescription = "Hidung",
					modifier = Modifier.fillMaxSize()
				)
			}
			if (isMouthEnabled) {
				Image(
					painter = painterResource(id = R.drawable.ic_avatar_mouth),
					contentDescription = "Mulut",
					modifier = Modifier.fillMaxSize()
				)
			}
		}

		Spacer(modifier = Modifier.height(32.dp))

		// Checkbox untuk mengaktifkan/menonaktifkan komponen wajah
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceAround
		) {
			CheckboxWithLabel(label = "Alis", checked = isBrowEnabled) { isBrowEnabled = it }
			CheckboxWithLabel(label = "Mata", checked = isEyeEnabled) { isEyeEnabled = it }
			CheckboxWithLabel(label = "Hidung", checked = isNoseEnabled) { isNoseEnabled = it }
			CheckboxWithLabel(label = "Mulut", checked = isMouthEnabled) { isMouthEnabled = it }
		}
	}
}

@Composable
fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		Checkbox(checked = checked, onCheckedChange = onCheckedChange)
		Text(text = label)
	}
}

@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
	AvatarScreen()
}
