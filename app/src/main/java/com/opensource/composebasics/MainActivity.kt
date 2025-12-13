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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.opensource.composebasics.samples.ButtonAndBoxActivity
import com.opensource.composebasics.samples.LazyColumnActivity
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxSize()
                            .padding(padding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = {
                            launchActivity(ButtonAndBoxActivity::class.java)
                        }) { Text("Box & Button") }


                        Button(onClick = {
                            launchActivity(LazyColumnActivity::class.java)
                        }) { Text("Scrollable Column") }
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