package com.opensource.composebasics

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.opensource.composebasics.views.ButtonAndBoxActivity
import com.opensource.composebasics.views.ComposeStateHoistingActivity
import com.opensource.composebasics.views.ComposeStatefulActivity
import com.opensource.composebasics.views.LazyColumnActivity
import com.opensource.composebasics.views.ScrollableColumnActivity
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = {
                            launchActivity(ButtonAndBoxActivity::class.java)
                        }, modifier = Modifier.fillMaxWidth()) { Text("Box & Button") }

                        Button(onClick = {
                            launchActivity(ScrollableColumnActivity::class.java)
                        }, modifier = Modifier.fillMaxWidth()) { Text("Scrollable Column") }

                        Button(onClick = {
                            launchActivity(LazyColumnActivity::class.java)
                        }, modifier = Modifier.fillMaxWidth()) { Text("Lazy Column") }

                        Button(onClick = {
                            launchActivity(ComposeStatefulActivity::class.java)
                        }, modifier = Modifier.fillMaxWidth()) { Text("Compose State - Stateful") }

                        Button(onClick = {
                            launchActivity(ComposeStateHoistingActivity::class.java)
                        }, modifier = Modifier.fillMaxWidth()) { Text("Compose State - State Hoisting") }
                    }
                }
            }
        }
    }

    private fun <T> launchActivity(clazz: Class<T>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}