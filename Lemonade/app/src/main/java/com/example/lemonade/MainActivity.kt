package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    Column(
        modifier = with(Modifier) { fillMaxSize().windowInsetsPadding(WindowInsets.statusBars) },
        horizontalAlignment = Alignment.CenterHorizontally // ✅ Căn giữa nội dung theo chiều ngang
    ) {
        // Header với nền vàng
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFEB3B)) // Màu vàng
                .padding(16.dp),

            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lemonade",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Nội dung chính
        LemonBackground(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center) // ✅ Căn giữa nội dung
        )
    }
}

@Composable
fun LemonBackground(modifier: Modifier = Modifier){
    var step by remember { mutableStateOf( 1) }
    var randomCount by remember { mutableStateOf( 1) }
    val rd = (2..4).random()
    var stepImage = when(step){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else ->R.drawable.lemon_restart
    }
    var Description = when(step){
        1-> R.string.lemon_select
        2-> R.string.lemon_squeeze
        3-> R.string.lemon_drink
        else -> R.string.lemon_empty_glass
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Button(
            onClick ={
                if(step >3)
                    step=1
                else if (step ==2){
                    if (randomCount == rd)
                        step++
                    else
                        randomCount++
                }
                else {
                    step++
                    randomCount=1
                }
            }
        ) {
            Image(
                painter = painterResource(stepImage),
                null
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Text(
            text = stringResource(Description),
            fontSize = 18.sp
        )
    }
}