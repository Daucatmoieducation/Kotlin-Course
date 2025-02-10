package com.example.yourcard

import android.os.Bundle
import android.util.Printer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourcard.ui.theme.YourCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YourCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CardApp(modifier: Modifier = Modifier){
    Column (
//        modifier = modifier.fillMaxSize(),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CardInformation(
            "Mèo vàng nhà chăm",
            "Ngoài ỉa bậy tôi còn biết đi chơi gái",
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
        ContactInformation(
            "123-1213-123",
            "@meodaccaudenhat",
            "Vangyelow"
        )
    }
}
@Composable
fun CardInformation(name: String, title: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable._73616489_609065071771548_4126248286964162493_n)
    Column(
        modifier = modifier.width(350.dp),
//            .fillMaxSize()
//            .padding(10.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.Center,

    ){
        Image(
            painter = image,
            null,
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp)
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text= name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
@Composable
fun ContactInformation(phone: String, email: String, fb: String, modifier: Modifier = Modifier ){
    val phoneIcon = painterResource(R.drawable.call)
    val fbIcon = painterResource(R.drawable._0464408)
    val emailIcon = painterResource(R.drawable.mess)
    Column(
        modifier = modifier
            .padding(10.dp),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Information(
            iconLink = phoneIcon,
            link = phone,
        )
        Information(
            iconLink = emailIcon,
            link = email,
//            modifier = modifier.padding(5.dp)
        )
        Information(
            iconLink = fbIcon,
            link = fb,
//            modifier = modifier.padding(5.dp)
        )
    }
}
@Composable
fun Information(iconLink: Painter, link: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(60.dp)
            .width(350.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = iconLink,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = link,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 10.dp)
                .width(180.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val phoneIcon = painterResource(R.drawable.call)
    YourCardTheme {
        CardApp()
    }
}