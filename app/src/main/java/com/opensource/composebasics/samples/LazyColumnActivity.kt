package com.opensource.composebasics.samples

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.opensource.composebasics.ui.theme.ComposeBasicsTheme

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeBasicsTheme {
                LazyColumnView {
                    Toast.makeText(this@LazyColumnActivity, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


@Composable
fun LazyColumnView(selectedItem: (String) -> Unit) {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        items(100) {
            Text(
                "Item $it", style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        selectedItem("Selected Item: $it")
                    }
            )

            HorizontalDivider(thickness = 3.dp, color = Color.Blue)
        }
    }
}

