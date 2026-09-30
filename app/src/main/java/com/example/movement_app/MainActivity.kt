package com.example.movement_app// adjust to your actual package

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uniffi.movement_core.buildMasterRecord
import uniffi.movement_core.MasterError

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BridgeTestScreen()
            }
        }
    }
}

@Composable
fun BridgeTestScreen() {
    val statusText = remember {
        try {
            // Call into Rust
            val record = buildMasterRecord(
                subjectName = "Operating Systems",
                subjectCode = "CS301",
                expectedClasses = 40u,
                frequencyPerWeek = 3u
            )
            "Rust Bridge OK!\nSubject: ${record.subjectName} [${record.subjectCode}]\nClasses: ${record.expectedClasses}, Freq: ${record.frequencyPerWeek}/wk"
        } catch (e: MasterError.MissingName) {
            "Validation Failed: Missing Name"
        } catch (e: Throwable) {
            "Error loading bridge: ${e.message}"
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = statusText,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
