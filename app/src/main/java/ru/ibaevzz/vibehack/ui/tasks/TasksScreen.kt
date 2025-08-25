package ru.ibaevzz.vibehack.ui.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ibaevzz.vibehack.domain.model.Task

@Composable
fun TasksScreen(
    isWard: Boolean,
    name: String,
    tasks: List<Task>
) {
    val progress = tasks.filter { !it.inProgress }.size
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp).windowInsetsPadding(
            WindowInsets.statusBars
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Задачник",
                style = TextStyle.Default.copy(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            if (!isWard) {
                Box(
                    modifier = Modifier
                        .height(26.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0xFF0E7F3B))
                        .padding(horizontal = 6.dp)
                ) {
                    Text(
                        "Связаться с куратором",
                        modifier = Modifier.align(Alignment.Center),
                        style = TextStyle.Default.copy(
                            color = Color(0xFFFFFFFF),
                            fontSize = 14.sp,
                        )
                    )
                }
            }
        }
        Spacer(Modifier.height(14.dp))
        Text(
            name,
            style = TextStyle.Default.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(28.dp))
        Text(
            "Общий прогресс $progress/${tasks.size}",
            style = TextStyle.Default.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 8.dp).height(10.dp).fillMaxWidth(),
            progress = { (progress.toFloat()/tasks.size) }
        )
        Spacer(Modifier.height(28.dp))
        LazyColumn {
            items(tasks) {
                TaskView(it)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TaskView(task: Task) {
    Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(if (!task.inProgress) 0x180E7F3B else 0xFFD9D9D9))
            .padding(16.dp)
    ) {
        Text(
            task.name,
            style = TextStyle.Default.copy(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "Комментарий волентера:",
            style = TextStyle.Default.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(Modifier.height(8.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFFFFFF))
            .padding(top = 7.dp, start = 10.dp)
        ) {
            Text("Оставить комментарий")
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .align(Alignment.End)
                .height(24.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(Color(0xFF0E7F3B))
                .padding(horizontal = 6.dp)
        ) {
            Text(
                "Отправить",
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle.Default.copy(
                    color = Color(0xFFFFFFFF),
                    fontSize = 14.sp,
                )
            )
        }
    }
}