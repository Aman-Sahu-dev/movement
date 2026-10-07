package com.example.movement_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.movement_app.feature.home.homeScreen
import com.example.movement_app.feature.home.HomeUiState
import com.example.movement_app.feature.home.defaultDockItems

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                homeScreen(
                    state = HomeUiState(name = "Immortal", age = 20, overallAttendance = 82.0f),
                    dockItems = defaultDockItems(),
                )
            }
        }
    }
}
