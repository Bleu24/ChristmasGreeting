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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
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
            .background(Color(0xFF0B6623)) // Christmas green background
            .padding(25.dp)
    ) {
        Text(
            text = "Happy Holidays!",
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
                .height(600.dp)
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
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB22222), // Christmas red button
                contentColor = Color.White
            ) // Christmas red button
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
            .background(Color(0xFFB22222)) // Christmas red background
            .padding(16.dp)
    ) {
        Text(
            text = "Dedication Message",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.christmas_cat),
            contentDescription = "Christmas Cat",
            modifier = Modifier
                .height(400.dp)
                .align(Alignment.CenterHorizontally)
                .size(800.dp)
        )
        Text(
            text = "Happy Holidays to my dearest Ceanne!",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "I hope you have a wonderful Pasasalamat and a Happy New Year!" +
                    " Anyways, here's a cute cat for you!",
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Justify,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Okay, time for a heartwarming message!!! 💖" +
                    " I've been always grateful for you ever since we met. " +
                    "You've been a great partner and I'm so lucky to have you in my life. " +
                    "After hardships and challenges, we've been through, " +
                    "I'm glad that we're still here for each other. " ,
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Justify,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text =  "No words and sentences can fit here in this screen " +
                    "On how much I appreciate you. " +
                    "The reason why I put this cat because this is the epitome of us and our relationship" +
                    "I hope you like it and I hope you like the message. " ,
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Justify,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text("Back to Cover")
        }
    }
}

@Preview
@Composable
fun PreviewGreetingApp() {
    GreetingApp()
}
