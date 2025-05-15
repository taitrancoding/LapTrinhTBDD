package com.example.my_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // nền sáng nhẹ
            .padding(16.dp)
    ) {
        // Các icon góc trên
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* TODO: Back action */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            IconButton(onClick = { /* TODO: Edit action */ }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
        }

        // Nội dung chính
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar (thay bằng resource ảnh của bạn)
            Image(
                painter = painterResource(id = R.drawable.avatar), // Thay bằng ảnh avatar trong drawable
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Tên
            Text(
                text = "Trần Phát Tài",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            // Địa chỉ
            Text(
                text = "Hồ Chí Minh City",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}
