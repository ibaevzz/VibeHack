package ru.ibaevzz.vibehack.ui.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import ru.ibaevzz.vibehack.domain.model.Task

@Composable
fun TasksScreen(
    name: String,
    tasks: List<Task>
) {
    val progress = tasks.filter { !it.inProgress }.size
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Задачник"
            )
            Box(
                modifier = Modifier
                    .height(26.dp)
                    .padding(horizontal = 6.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFF0E7F3B))
            ) {
                Text("Связаться с куратором", modifier = Modifier.align(Alignment.Center))
            }
        }
        Spacer(Modifier.height(14.dp))
        Text(
            name
        )
        Text(
            "Общий прогресс $progress/${tasks.size}",
            modifier = Modifier.padding(top = 30.dp, start = 30.dp)
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 30.dp, start = 30.dp),
            progress = { (progress/tasks.size).toFloat() }
        )
        LazyColumn {
            items(tasks) {
                TaskView(it)
            }
        }
    }
}

@Composable
fun TaskView(task: Task) {
    Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0x180E7F3B))
            .padding(horizontal = 16.dp)
    ) {
        Text(task.name)
        Text("Комментарий волентера")
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (!task.inProgress) Color(0xFFD9D9D9) else Color(0xFFACACAC))
        ) {
            Text("Оставить комментарий")
        }

    }
}