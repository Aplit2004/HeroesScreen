package com.example.heroesscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main(
                header = stringResource(R.string.header_text),
                name1 = stringResource(R.string.name1_text),
                name2 = stringResource(R.string.name2_text),
                name3 = stringResource(R.string.name3_text),
                phrase1 = stringResource(R.string.deadpool_text),
                phrase2 = stringResource(R.string.ironman_text),
                phrase3 = stringResource(R.string.spiderman_text)
            )
        }
    }
}

@Composable
fun Main(header: String, name1: String, name2: String, name3: String, phrase1: String, phrase2: String, phrase3: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Firstscreen.route) {
        composable(Routes.Firstscreen.route) { Firstscreen(header, name1, name2, name3, modifier, navController) }
        composable(Routes.Deadpool.route) { Deadpool(name1, phrase1, modifier, navController) }
        composable(Routes.Ironman.route) { Ironman(name2, phrase2, modifier, navController) }
        composable(Routes.Spiderman.route) { Spiderman(name3, phrase3, modifier, navController) }
    }
}

@Composable
fun Firstscreen(header: String, name1: String, name2: String, name3: String, modifier: Modifier, navController: NavController) {
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
                                        onTap = {
                                            navController.navigate(Routes.Deadpool.route)
                                        }
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
                                        onTap = {
                                            navController.navigate(Routes.Ironman.route)
                                        }
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
                                        onTap = {
                                            navController.navigate(Routes.Spiderman.route)
                                        }
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
}

@Composable
fun Deadpool(name1: String, phrase1: String, modifier: Modifier, navController: NavController) {
    val arrow = painterResource(R.drawable.backarrow)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    )
    {
        AsyncImage(
            model = "https://iili.io/JMnAflV.png",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = arrow,
            contentDescription = null,
            modifier = modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.TopStart)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            navController.navigate(Routes.Firstscreen.route)
                        }
                    )
                }
        )
        Text(
            text = name1,
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 150.dp)
        )
        Text(
            text = phrase1,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 75.dp)
        )
    }
}

@Composable
fun Ironman(name2: String, phrase2: String, modifier: Modifier, navController: NavController) {
    val arrow = painterResource(R.drawable.backarrow)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    )
    {
        AsyncImage(
            model = "https://iili.io/JMnuDI2.png",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = arrow,
            contentDescription = null,
            modifier = modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.TopStart)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            navController.navigate(Routes.Firstscreen.route)
                        }
                    )
                }
        )
        Text(
            text = name2,
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 150.dp)
        )
        Text(
            text = phrase2,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 85.dp)
        )
    }
}

@Composable
fun Spiderman(name3: String, phrase3: String, modifier: Modifier, navController: NavController) {
    val arrow = painterResource(R.drawable.backarrow)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    )
    {
        AsyncImage(
            model = "https://iili.io/JMnuyB9.png",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = arrow,
            contentDescription = null,
            modifier = modifier
                .height(50.dp)
                .width(50.dp)
                .align(Alignment.TopStart)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            navController.navigate(Routes.Firstscreen.route)
                        }
                    )
                }
        )
        Text(
            text = name3,
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 150.dp)
        )
        Text(
            text = phrase3,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 25.dp, bottom = 85.dp)
        )
    }
}

sealed class Routes(val route: String) {
    object Firstscreen : Routes("firstscreen")
    object Deadpool : Routes("deadpool")
    object Ironman : Routes("ironman")
    object Spiderman : Routes("spiderman")
}