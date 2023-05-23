package com.example.lab17java

import android.R
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab17java.ui.theme.Lab17JavaTheme
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab17JavaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    var kilograms by remember { mutableStateOf("") }
    var pounds by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = kilograms,
            onValueChange = { kilograms = it },
            label = { Text("Значение") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = pounds,
            onValueChange = { pounds = it },
            label = { Text("Результат") },
            enabled = false,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (kilograms.isNotEmpty()) {
                    val kg = kilograms.toDouble()
                    val lb = kg * 2.20462
                    pounds = lb.toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Конвертировать в футы")
        }
        Button(
            onClick = {
                if (kilograms.isNotEmpty()) {
                    val kg = kilograms.toDouble()
                    val lb = kg / 2.20462
                    pounds = lb.toString()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Конвертировать в килограммы")
        }
    }
}

fun onCreate() {

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab17JavaTheme {
        Greeting()
    }
}