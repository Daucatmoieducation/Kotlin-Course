package com.example.quartercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quartercompose.ui.theme.QuarterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuarterComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StringCompose(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StringCompose(modifier: Modifier = Modifier){
    GreetingCompose(
        text1= "Text composable",
        detail1 = "Displays text and follows the recommended Material Design guidelines.",
        text2 = "Row composable",
        detail2 = "A layout composable that places its children in a horizontal sequence.",
        text3 = "Image composable",
        "Creates a composable that lays out and draws a given Painter class object.",
        "Column composable",
        "A layout composable that places its children in a vertical sequence."
    )
}

@Composable
fun GreetingCompose(
    text1: String,detail1: String,
    text2: String,detail2: String,
    text3: String, detail3: String,
    text4: String, detail4: String,
    modifier: Modifier = Modifier){
    Column (
        modifier = modifier
    ){
        Row(
            modifier = modifier
                .weight(1f)
        ) {
            OneQuarter(
                text = text1,
                detail = detail1,
                modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFEADDFF))
            )
            OneQuarter(
                text = text2,
                detail = detail2,
                modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFB69DF8))
            )
        }
        Row(
            modifier = modifier
                .weight(1f)
        ) {
            OneQuarter(
                text = text3,
                detail = detail3,
                modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFD0BCFF))
            )
            OneQuarter(
                text = text4,
                detail = detail4,
                modifier = modifier
                    .weight(0.5f)
                    .background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun OneQuarter(text: String,detail: String,modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = detail,
            textAlign = TextAlign.Justify,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuarterComposeTheme {
        StringCompose()
    }
}