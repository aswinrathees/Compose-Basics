package com.opensource.composebasics.views

import android.os.Bundle
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme
import com.opensource.composebasics.viewmodel.CountViewModel

class ComposeStateHoistingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = viewModel<CountViewModel>()

            ComposeBasicsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Preserves state with configuration changes
                    // var count by rememberSaveable { mutableIntStateOf(0) }
                    StateHoistingButton(viewModel.count) {
                        //count = it + 1
                        viewModel.incrementCount()
                    }
                }
            }
        }
    }
}

// Unidirectional data flow
@Composable
fun StateHoistingButton(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = {
            updateCount(count)
        },
        enabled = true,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.DarkGray, contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text("Count: $count", style = MaterialTheme.typography.headlineSmall)
    }
}