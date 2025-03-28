package com.example.heroesscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heroesscreen.ui.theme.HeroesScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroesScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BackgroundImage(
                        header = "Choose your hero",
                        name1 = "Deadpool",
                        name2 = "Iron Man",
                        name3 = "Spider Man"
                    )
                }
            }
        }
    }
}

@Composable
fun FirstPageContent(header: String, name1: String, name2: String, name3: String, modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.marvel)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = modifier
                .height(100.dp)
                .width(150.dp)
        )
        Text(
            text = header,
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        val listState: LazyListState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            state = listState,
            flingBehavior = rememberSnapFlingBehavior(listState)
        ) {
            item {
                Box(
                    modifier = modifier,
                    contentAlignment = Alignment.BottomStart
                )
                {
                    AsyncImage(
                        model = "https://iili.io/JMnAflV.png",
                        contentDescription = null,
                        modifier = modifier
                            .padding(top = 75.dp)
                            .height(550.dp)
                            .width(350.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = { /*переход на другой экран*/ }
                                )
                            }
                    )
                    Text(
                        text = name1,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 50.dp, bottom = 35.dp)
                    )
                }
            }
            item {
                Box(
                    modifier = modifier,
                    contentAlignment = Alignment.BottomStart
                )
                {
                    AsyncImage(
                        model = "https://iili.io/JMnuDI2.png",
                        contentDescription = null,
                        modifier = modifier
                            .padding(top = 75.dp)
                            .height(550.dp)
                            .width(300.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = { /*переход на другой экран*/ }
                                )
                            }
                    )
                    Text(
                        text = name2,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 50.dp, bottom = 35.dp)
                    )
                }
            }
            item {
                Box(
                    modifier = modifier,
                    contentAlignment = Alignment.BottomStart
                )
                {
                    AsyncImage(
                        model = "https://iili.io/JMnuyB9.png",
                        contentDescription = null,
                        modifier = modifier
                            .padding(top = 75.dp)
                            .height(550.dp)
                            .width(350.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = { /*переход на другой экран*/ }
                                )
                            }
                    )
                    Text(
                        text = name3,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 50.dp, bottom = 35.dp)
                    )
                }
            }
        }

    }
}
@Composable
fun BackgroundImage(header: String, name1: String, name2: String, name3: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.background)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        FirstPageContent(
            header = header,
            name1 = name1,
            name2 = name2,
            name3 = name3,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesPreview() {
    HeroesScreenTheme {
        BackgroundImage(
            header = stringResource(R.string.header_text),
            name1 = stringResource(R.string.name1_text),
            name2 = stringResource(R.string.name2_text),
            name3 = stringResource(R.string.name3_text)
        )
    }
}