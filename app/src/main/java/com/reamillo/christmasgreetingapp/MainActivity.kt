package com.reamillo.christmasgreetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reamillo.christmasgreetingapp.ui.theme.ChristmasGreetingAppTheme

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
        DedicationMessage { showDedication = false }
    }
}

@Composable
fun ChristmasMessage(onNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFF0B6623)) // Christmas green background
    ) {
        Text(
            text = "Merry Christmas!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.christmas_image),
            contentDescription = "Christmas Image",
            modifier = Modifier
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "To: Ceanne Kolinne G. Arenas",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "From: Bryan Luise F. Reamillo",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onNext,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text("Open Dedication Message")
        }
    }
}

@Composable
fun DedicationMessage(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFB22222)) // Christmas red background
    ) {
        Text(
            text = "Dedication Message",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Merry Christmas Ceanne!",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "I hope you have a wonderful Christmas and a Happy New Year!",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text("Back to Christmas Message")
        }
    }
}

@Preview
@Composable
fun PreviewGreetingApp() {
    GreetingApp()
}
