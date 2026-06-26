package com.example.myapplication.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileCard2(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFF534AB7))
            )
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .offset(x = 20.dp, y = 58.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFCECBF6)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "김",
                    color = Color(0xFF3C3489),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Text(
            text = "오스카",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 20.dp, top = 44.dp)
        )

        Text(
            text = "I Like You",
            fontSize = 13.sp,
            color = Color(0xFF888780),
            modifier = Modifier.padding(start = 20.dp, top = 2.dp)
        )

        Row(
            modifier = Modifier.padding(start = 20.dp, top = 12.dp)
        ) {
            TagChip2("OZOGI", Color(0xFFEEEDFE), Color(0xFF3C3489))
            Spacer(modifier = Modifier.width(6.dp))
            TagChip2("BABUU", Color(0xFFEEEDFE), Color(0xFF3C3489))
            Spacer(modifier = Modifier.width(6.dp))
            TagChip2("Honney", Color(0xFFEEEDFE), Color(0xFF3C3489))
        }

        Row(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF534AB7))
            ) {
                Text("팔로우", color = Color.White)
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Text("메시지")
            }
        }
    }
}

@Composable
fun TagChip2(label: String, background: Color, textColor: Color) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(label, color = textColor, fontSize = 12.sp)
    }
}