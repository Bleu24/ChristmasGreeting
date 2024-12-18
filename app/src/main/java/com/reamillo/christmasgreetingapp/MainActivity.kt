package com.reamillo.christmasgreetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.reamillo.christmasgreetingapp.ui.theme.ChristmasGreetingAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingApp()
        }
    }
}

@Composable
fun GreetingApp() {
    var showDedication by remember { mutableStateOf(false) }
    if (!showDedication) {
        ChristmasMessage { showDedication = true }
    } else {
        DedicationMessage()
    }
}

@Composable
fun ChristmasMessage(onNext: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(
        text = "Merry Christmas!",
        fontSize = 24.sp
    )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.christmas_image),
            contentDescription = "Christmas Image",
            modifier = Modifier.height(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "To: Ceanne Kolinne G. Arenas",
            fontSize = 24.sp
        )
        Text(
            text = "From: Bryan Luise F. Reamillo",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onNext) {
            Text("Open Dedication Message")
        }
    }
}

@Composable
fun DedicationMessage() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Dedication Message",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Merry Christmas Ceanne!",
            fontSize = 24.sp
        )
        Text(
            text = "I hope you have a wonderful Christmas and a Happy New Year!",
            fontSize = 24.sp
        )
    }
}


