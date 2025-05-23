package com.example.my_app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestAge() {
    var name by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "THỰC HÀNH 01", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                result = ""
            },
            label = { Text("Họ và tên") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = ageInput,
            onValueChange = {
                ageInput = it
                result = ""
            },
            label = { Text("Tuổi") },
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val age = ageInput.toIntOrNull()
                if (age == null || name.isBlank()) {
                    result = "Vui lòng nhập đầy đủ họ tên và tuổi hợp lệ"
                    isError = true
                } else {
                    isError = false
                    result = "$name là " + when {
                        age > 65 -> "Người già"
                        age in 7..65 -> "Người lớn"
                        age in 2..6 -> "Trẻ em"
                        else -> "Em bé"
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF000080)) // màu xanh đậm
        ) {
            Text("Kiểm tra", color = Color.White)
        }

        if (result.isNotEmpty()) {
            Text(
                text = result,
                color = if (isError) Color.Red else Color(0xFF006400), // xanh lá đậm
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}
