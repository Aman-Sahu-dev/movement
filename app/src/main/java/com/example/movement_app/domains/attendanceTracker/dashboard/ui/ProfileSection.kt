package com.example.movement_app.domains.attendanceTracker.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movement_app.domains.attendanceTracker.dashboard.data.ProfileData
import com.example.movement_app.domains.attendanceTracker.dashboard.ui.components.profileDetailsBlock
import com.example.movement_app.domains.attendanceTracker.dashboard.ui.components.profileHeader
import com.example.movement_app.domains.attendanceTracker.dashboard.ui.components.profilePhotoFrame

@Composable
fun profileSection(
    profile: ProfileData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 24.dp)
    ) {
        profileHeader(
            title = "Profile"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            profileDetailsBlock(
                name = profile.name,
                age = profile.age,
                overallAttendancePercent = profile.overallAttendancePercent,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            )

            profilePhotoFrame(
                name = profile.name,
                avatarUrl = profile.avatarUrl
            )
        }
    }
}
