package com.example.compose.todo

import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.AnimationClockObservable
import androidx.compose.animation.core.DefaultAnimationClock
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.animation.transition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.compose.ui.orange
import com.example.compose.ui.pink
import com.example.compose.ui.purple
import com.example.compose.ui.red_light

@ExperimentalMaterialApi
@Composable
fun TodoCreateOrEdit(
    modifier: Modifier = Modifier,
    todoItem: TodoItem = TodoItem(),
    onComplete: (TodoItem) -> Unit
) {
    val itemState = remember { mutableStateOf(todoItem) }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topLeft = 16.dp, topRight = 16.dp),
        elevation = 24.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, top = 12.dp, end = 12.dp),
                value = todoItem.name,
                onValueChange = { text -> itemState.value = itemState.value.copy(name = text) },
                textStyle = TextStyle(fontSize = 18.sp)
            )
            ColorPicker(
                modifier = Modifier.padding(vertical = 12.dp),
                defColor = todoItem.color,
                colors = listOf(red_light, orange, purple, pink),
                onColorClicked = { itemState.value = itemState.value.copy(color = it) }
            )
            Button(
                modifier = Modifier.padding(bottom = 12.dp),
                onClick = { onComplete(itemState.value) }) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
    defColor: Color,
    colors: List<Color>,
    onColorClicked: (Color) -> Unit
) {
    Row(
        modifier = modifier.height(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        colors.forEach {
            val size = if (it == defColor) 36.dp else 24.dp
            Spacer(
                modifier = Modifier
                    .width(size)
                    .height(size)
                    .background(it, CircleShape)
                    .clickable(onClick = { onColorClicked(it) })
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = false)
@Composable
fun preview() {
    TodoCreateOrEdit(todoItem = TodoItem.createRandomItem(), onComplete = { })
}