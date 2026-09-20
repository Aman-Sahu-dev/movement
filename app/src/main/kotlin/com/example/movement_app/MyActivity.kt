package com.example.movement_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uniffi.movement_core.getEntries

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MasterTable()
                }
            }
        }
    }
}

@Composable
fun MasterTable() {
    val entries = remember { getEntries() }

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        item {
            Row(Modifier.background(Color.LightGray).padding(4.dp)) {
                Text("Subject", Modifier.width(100.dp), fontWeight = FontWeight.Bold)
                Text("Date", Modifier.width(100.dp), fontWeight = FontWeight.Bold)
                Text("Status", Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            }
        }
        items(entries) { e ->
            Row(
                Modifier
                    .border(0.5.dp, Color.Gray)
                    .padding(4.dp)
            ) {
                Text(e.name, Modifier.width(100.dp))
                Text(e.date, Modifier.width(100.dp))
                Text(
                    if (e.present) "Present" else "Absent",
                    Modifier.width(100.dp),
                    color = if (e.present) Color(0xFF2E7D32) else Color(0xFFC62828)
                )
            }
        }
    }
}