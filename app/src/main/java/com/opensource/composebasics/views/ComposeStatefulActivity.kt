package com.opensource.composebasics.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme

class ComposeStatefulActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeBasicsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    StateButton()
                }
            }
        }
    }
}

// Global state
//var count = mutableIntStateOf(0)

@Composable
fun StateButton() {
    val context = LocalContext.current
    val count = remember { mutableIntStateOf(0) }
    var countBy by remember { mutableIntStateOf(0) }

    Button(
        onClick = {
            count.intValue++
            countBy += 1
            Toast.makeText(context, "Count: ${count.intValue} and CountBy: $countBy", Toast.LENGTH_SHORT).show()
        },
        enabled = true,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.DarkGray, contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text("Count: ${count.intValue} and CountBy: $countBy", style = MaterialTheme.typography.headlineSmall)
    }
}