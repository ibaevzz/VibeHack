package ru.ibaevzz.vibehack.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ibaevzz.vibehack.R

@Composable
fun LoginScreen(
    isCheckCode: Boolean,
    sendCode: (String) -> Unit,
    checkCode: (String) -> Unit
) {
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = if (isCheckCode) "Введите код" else "Регистрация",
            fontSize = 30.sp,
            color = colorResource(R.color.reg_title_color),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { newText ->
                phoneNumber = if (isCheckCode) newText else newText.take(10)
            },
            prefix = {
                if (!isCheckCode)
                    Text(
                        "+7",
                        style = TextStyle.Default.copy(fontSize = 15.sp)
                    )
            },
            label = { Text(
                if (isCheckCode) "Код" else "Номер телефона",
                style = TextStyle.Default.copy(fontSize = 15.sp)
            ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 15.sp),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedContainerColor = Color(0xFFF6F7F9),
                unfocusedContainerColor = Color(0xFFF6F7F9),
                focusedLabelColor = Color(0x80303030),
                unfocusedLabelColor = Color(0x80303030),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        )

        Button(
            onClick = {
                if (isCheckCode) checkCode(phoneNumber)
                else if (phoneNumber.length == 10) sendCode("+7$phoneNumber")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0E7F3B)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = if (isCheckCode) "Продолжить" else "Отправить код", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (!isCheckCode) {
            Text(
                text = "Нажимая кнопку «Отправить код», вы даёте согласие на обработку персональных данных",
                fontSize = 15.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}