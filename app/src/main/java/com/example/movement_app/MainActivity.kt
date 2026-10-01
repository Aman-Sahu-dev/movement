package com.example.movement_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {

    var firstName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var attendance by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Main content
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {

            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = {
                    Text("First Name")
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            TextField(
                value = age,
                onValueChange = { age = it },
                label = {
                    Text("Age")
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            TextField(
                value = attendance,
                onValueChange = { attendance = it },
                label = {
                    Text("Overall Attendance")
                }
            )
        }

        // Bottom navigation
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .height(60.dp)
                .fillMaxWidth(0.9f)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(30.dp)
                ),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Home")
            Text("Stats")
            Text("Records")
            Text("Settings")
        }
    }
}
