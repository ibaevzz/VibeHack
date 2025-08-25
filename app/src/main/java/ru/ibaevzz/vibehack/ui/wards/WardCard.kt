package ru.ibaevzz.vibehack.ui.wards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ibaevzz.vibehack.domain.model.Ward

@Preview
@Composable
fun Prev() {
    WardCard(
        Ward(
            id = 0,
            name = "Sultan",
            location = "Moscow",
            phoneNumber = "+79289851280",
            careerGoals = "repojofpojervopgjer4jrogjeijmvg",
            skills = listOf("123444", "eropfoperf", "erkvmeokr", "rofjieoirf"),
            works = listOf(
                "pewofjcjeopr", "3iefjoier"
            )
        ),
        onClick = {}
    )
}

@Composable
fun WardCard(
    ward: Ward,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .clickable(indication = null, interactionSource = null) {
                onClick(ward.id)
            }
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Заголовок
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Аватар
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Имя и город
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = ward.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = ward.location,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                // График работы
                Text(
                    text = "Неполный рабочий день",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Карьерные цели
            Text("Карьерные цели:", fontWeight = FontWeight.SemiBold)
            Text(ward.careerGoals, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(12.dp))

            // Навыки
            Text("Текущие навыки:", fontWeight = FontWeight.SemiBold)
            FlowRow {
                ward.skills.forEach { skill ->
                    SkillChip(skill, Color(0xFF2E7D32))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Желаемая работа
            Text("Ищет работу как:", fontWeight = FontWeight.SemiBold)
            FlowRow {
                ward.works.forEach { work ->
                    SkillChip(work, Color(0xFF0277BD))
                }
            }
        }
    }
}

@Composable
fun SkillChip(text: String, bgColor: Color) {
    Box(
        modifier = Modifier
            .padding(end = 6.dp, top = 6.dp)
            .background(bgColor, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 13.sp, textAlign = TextAlign.Center)
    }
}