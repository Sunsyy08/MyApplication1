package com.example.myapplication.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.roundToInt
import kotlin.random.Random


@Composable
fun RandomColorApp(){
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            RandomColorCard2()
        }
    }
}

private fun randomColor(): Color {
    val r = Random.nextInt(0,256)
    val g = Random.nextInt(0,256)
    val b = Random.nextInt(0,256)

    return Color(r,g,b)
}

private fun toRgbString(color: Color): String {
    val r = (color.red * 255).roundToInt()
    val g = (color.green * 255).roundToInt()
    val b = (color.blue * 255).roundToInt()
    return "rgb(r = $r, g = $g, b = $b)"
}

@Composable
private fun RandomColorCard1(){
    var color by remember { mutableStateOf(randomColor()) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable { color = randomColor()},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "탭하면 랜덤 색!",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
private fun RandomColorCard2(){
    var color by remember { mutableStateOf(randomColor()) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = toRgbString(color),
            fontSize = 20.sp,
            color = Color.Black,
            )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color)
                .clickable { color = randomColor()},
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "탭하면 랜덤 색!",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1(){
    MyApplicationTheme {
        RandomColorApp()
    }
}
