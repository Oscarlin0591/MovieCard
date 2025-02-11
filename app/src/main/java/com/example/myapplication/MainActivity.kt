package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface {
                    MovieCard()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MovieCard() {
    Box() {
        MovieBGPicture(
            modifier = Modifier.align(Alignment.TopCenter).scale(1f,0.8f)
        )
        MoviePageBody()

    }
}

@Composable
fun MovieBGPicture(modifier: Modifier = Modifier) {
    Image(
        painterResource(R.drawable.movie),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        alignment = Alignment.TopCenter,
        modifier = modifier
            .fillMaxHeight().width(250.dp).offset(0.dp, -107.dp)
    )
}

@Composable
fun MoviePageBody() {
    Column {
        MovieHeader()
        MovieInfo()
    }
}

@Composable
fun MoviePicture(modifier: Modifier = Modifier) {
        Image(
            painterResource(R.drawable.movie),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = modifier
                .scale(0.25F)
                .offset(x = -500.dp, y = 0.dp)
        )
}

@Composable
fun MovieTitle(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "The Greatest Showman",
            textAlign = TextAlign.Center,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Row {
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Icon(imageVector = Icons.Default.Star, contentDescription = null)

        }
    }
}

@Composable
fun MovieHeader(modifier: Modifier = Modifier) {
    Column (){
        MoviePicture()
        MovieTitle()
    }
}

@Composable
fun MovieInfo(modifier: Modifier = Modifier) {
    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier){
        Column(modifier.padding(15.dp)) {
            Text(text = "Length", modifier = Modifier)
            Text(text = "1:45")
        }
        Column(modifier.padding(15.dp)) {
            Text(text = "Lang", modifier = Modifier)
            Text(text = "English")
        }
        Column(modifier.padding(15.dp)) {
            Text(text = "Rating", modifier = Modifier)
            Text(text = "7.5")
        }
        Column(modifier.padding(15.dp)) {
            Text(text = "Reviews", modifier = Modifier)
            Text(text = "2k+")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard()
}