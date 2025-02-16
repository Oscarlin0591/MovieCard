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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    Box(modifier = Modifier) {
        MovieBGPicture(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .scale(1f, .9f)
        )
        MoviePageBody()
    }
}

@Composable
fun MovieBGPicture(modifier: Modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)) {
    Image(
        painterResource(R.drawable.movie),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        alignment = Alignment.TopCenter,
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp)
            .offset(0.dp, -20.dp)
    )
}

@Composable
fun MoviePageBody() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier) {
        MovieHeader()
        MovieInfo("1:45", "English", "7.5", "2k+", 20.dp, modifier = Modifier)
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
            .scale(0.25f)
            .offset(x = -475.dp, y = 80.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )

}

@Composable
fun MovieTitle(title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .offset(120.dp, 290.dp)
    ) {
        Text(
            text = "The Greatest Showman",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)

        }
    }
}

@Composable
fun MovieHeader(modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        MoviePicture()
        MovieTitle("The Greatest Showman")
    }
}

@Composable
fun MovieInfo(
    length: String,
    lang: String,
    rating: String,
    reviews: String,
    padding: Dp,
    modifier: Modifier = Modifier
) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.offset(0.dp, 150.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(padding)
        ) {
            Text(text = "Length", style = MaterialTheme.typography.bodyLarge, modifier = Modifier)
            Text(text = length, style = MaterialTheme.typography.bodyMedium, modifier = Modifier)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(padding)
        ) {
            Text(text = "Lang", style = MaterialTheme.typography.bodyLarge, modifier = Modifier)
            Text(text = lang, style = MaterialTheme.typography.bodyMedium, modifier = Modifier)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(padding)
        ) {
            Text(text = "Rating", style = MaterialTheme.typography.bodyLarge, modifier = Modifier)
            Text(text = rating, style = MaterialTheme.typography.bodyMedium, modifier = Modifier)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(padding)
        ) {
            Text(text = "Reviews", style = MaterialTheme.typography.bodyLarge, modifier = Modifier)
            Text(text = reviews, style = MaterialTheme.typography.bodyMedium, modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard()
}