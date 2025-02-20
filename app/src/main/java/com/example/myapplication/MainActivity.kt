package com.example.myapplication

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Topic
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp(modifier:Modifier = Modifier){

}


@Composable
fun Topic(topic:Topic, modifier:Modifier = Modifier){
    Card{
        Row(
        ){
            Box{
                Image(
                    painter = painterResource(R.drawable.tech),
                    contentDescription = stringResource(R.string.film),
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.film),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                )

                Row (verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_gain),
                        contentDescription =  null,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Test(modifier: Modifier = Modifier){
    Topic(Topic(R.string.film,20,R.drawable.film))
}