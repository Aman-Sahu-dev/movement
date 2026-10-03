package com.example.movement_app.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movement_app.ui.components.DockItem
import com.example.movement_app.ui.components.FloatingDock
import com.example.movement_app.ui.components.profileHeader
import com.example.movement_app.ui.components.userInfoSection

@Composable
fun homeScreen(
    state: HomeUiState,
    dockItems: List<DockItem>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { profileHeader(title = "Movement", onProfileClick = {}) },
        bottomBar = { FloatingDock(items = dockItems) },
    ) { innerPadding ->
        userInfoSection(
            name = state.name,
            age = state.age,
            overallAttendance = state.overallAttendance,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

fun defaultDockItems() = listOf(
    DockItem("Home", Icons.Default.Home),
    DockItem("Schedule", Icons.Default.DateRange),
    DockItem("Log", Icons.Default.Add),
    DockItem("Settings", Icons.Default.Settings),
)

@Preview(showBackground = true)
@Composable
private fun homeScreenPreview() {
    MaterialTheme {
        homeScreen(
            state = HomeUiState(name = "Immortal", age = 20, overallAttendance = 82.0f),
            dockItems = defaultDockItems(),
        )
    }
}
