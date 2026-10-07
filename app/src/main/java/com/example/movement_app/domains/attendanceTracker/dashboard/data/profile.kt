package com.example.movement_app.domains.attendanceTracker.dashboard.data

data class ProfileData(
    val name: String,
    val age: Int,
    val overallAttendancePercent: Float,
    val avatarUrl: String? = null
)
