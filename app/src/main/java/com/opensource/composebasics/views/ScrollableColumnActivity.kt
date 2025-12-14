package com.opensource.composebasics.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme

class ScrollableColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeBasicsTheme {
                ScrollableColumn()
            }
        }
    }
}

@Composable
fun ScrollableColumn() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .padding(20.dp)
        .verticalScroll(scrollState)) {
        for (i in 1..100) {
            Text(
                "Item $i",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(8.dp)
            )

            HorizontalDivider(color = Color.Blue, thickness = 3.dp)
        }

    }
}