package com.example.myapplication.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class StatItem(val label: String, val value: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
data class MenuItem(val title: String, val subtitle: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val color: Color)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoDashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Dashboard", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Notifications, contentDescription = "알림")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            ProfileHeaderCard()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "오늘의 활동",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            val stats = listOf(
                StatItem("커밋", "12", Icons.Filled.Refresh),
                StatItem("리뷰", "3", Icons.Filled.Favorite),
                StatItem("완료", "5", Icons.Filled.CheckCircle),
            )

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(stats) { stat ->
                    StatCard(stat)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "바로가기",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            val menuItems = listOf(
                MenuItem("프로젝트", "진행 중인 작업 보기", Icons.Filled.Home, Color(0xFF6C63FF)),
                MenuItem("팀원", "멤버 관리", Icons.Filled.Person, Color(0xFFFF6584)),
                MenuItem("설정", "환경 설정", Icons.Filled.Settings, Color(0xFF43C6AC)),
            )

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                menuItems.forEach { item ->
                    MenuRow(item)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("새 항목 추가", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ProfileHeaderCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF6C63FF), Color(0xFF43C6AC))
                    )
                )
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.25f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "박선혁",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Android Developer",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}

@Composable
fun StatCard(stat: StatItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.size(width = 100.dp, height = 90.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(stat.icon, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(6.dp))
            Text(stat.value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(stat.label, fontSize = 11.sp, color = Color.Gray)
        }
    }
}

@Composable
fun MenuRow(item: MenuItem) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(item.color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(item.icon, contentDescription = null, tint = item.color)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                Text(item.subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            Icon(Icons.Filled.ArrowForward, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoDashboardScreenPreview() {
    MaterialTheme {
        DemoDashboardScreen()
    }
}