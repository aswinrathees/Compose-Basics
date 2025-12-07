package com.opensource.composebasics.samples

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ButtonAndBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(2.dp, color = Color.Blue)
                        .background(color = Color.Black)
                        .padding(0.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BoxLayout()
                    ButtonDemo()
                    SnackBar()
                }
            }
        }
    }
}

@Composable
fun BoxLayout() {
    Box(
        modifier = Modifier
            .background(color = Color.Blue)
            .size(180.dp, 300.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Cyan)
                .size(125.dp, 100.dp)
                .align(Alignment.TopCenter)

        ) {
            Text("Samples")
        }

        Text(
            text = "Hello World!",
            style = MaterialTheme.typography.headlineSmall,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Gray)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter)
                .padding(5.dp)
        )
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        },
        enabled = true,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.DarkGray, contentColor = Color.White
        ),
        //shape = RoundedCornerShape(10.dp)
        shape = CutCornerShape(20.dp)
    ) {
        Text("Click Me", style = MaterialTheme.typography.headlineSmall)
    }

    TextButton(onClick = {
        Toast.makeText(context, "Text Button Clicked", Toast.LENGTH_SHORT).show()
    }, enabled = true) {
        Text("Click Me")
    }

    OutlinedButton(onClick = {
        Toast.makeText(context, "Outlined Button Clicked", Toast.LENGTH_SHORT).show()
    }, enabled = true) {
        Text("Click Me")
    }

    IconButton(onClick = {
        Toast.makeText(context, "Icon Button Clicked", Toast.LENGTH_SHORT).show()
    }) {
        Icon(
            Icons.Filled.Refresh, contentDescription = "Refresh", tint = Color.Gray
        )
    }
}

@Composable
fun SnackBar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {
        Button(onClick = {
            coroutineScope.launch {
                val snackbarResult =snackbarHostState.showSnackbar(
                    message = "Welcome",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Long
                )

                when(snackbarResult) {
                    SnackbarResult.ActionPerformed -> Toast.makeText(context, "Action Performed", Toast.LENGTH_SHORT).show()
                    SnackbarResult.Dismissed -> Toast.makeText(context, "Dismissed", Toast.LENGTH_SHORT).show()
                }

            }
        }, modifier = Modifier
            .padding(10.dp)) {
            Text("Show Snackbar")
        }
    }
}