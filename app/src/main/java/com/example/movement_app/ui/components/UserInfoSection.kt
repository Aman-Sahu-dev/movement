package com.example.movement_app.ui.components

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun userInfoSection(
    name: String,
    age: Int,
    overallAttendance: Float,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(text = name, style = MaterialTheme.typography.titleLarge)
        Text(text = "Age: $age", style = MaterialTheme.typography.bodyMedium)
        Text(
            text = "overall attendance: $overallAttendance",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
