package com.example.my_app.ui.theme

import EmailValidationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.my_app.ui.screen.ProfileScreen
import com.example.my_app.ui.screen.TestAge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                var currentScreen by remember { mutableStateOf("age") }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(onClick = { currentScreen = "email" }) {
                                Text("Email Form")
                            }
                            Button(onClick = { currentScreen = "profile" }) {
                                Text("Profile")
                            }
                            Button(onClick = { currentScreen = "age" }){
                                Text("Age")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        when (currentScreen) {
                            "email" -> EmailValidationScreen()
                            "profile" -> ProfileScreen()
                            "age" -> TestAge()
                        }
                    }
                }
            }
        }
    }
}
