package com.example.compose.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import androidx.ui.tooling.preview.Preview
import com.example.compose.ui.ComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.get

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                TodoActivityContent(viewModel = get(), lifecycleScope)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeTheme {
        Surface {
            content()
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun TodoActivityContent(viewModel: TodoViewModel, coroutineScope: CoroutineScope) {
    val items: List<TodoItem> by viewModel.todoItems.collectAsState(
        listOf(),
        coroutineScope.coroutineContext
    )
    TodoScreen(
        items = items,
        onAddItem = viewModel::addItem,
        onRemoveItem = viewModel::removeItem
    )
}

@Preview(showBackground = true, name = "MyApp")
@Composable
fun DefaultPreview() {
    MyApp {
        TodoScreen(items = listOf(
            TodoItem("Learn compose"),
            TodoItem("Take the codelab", true),
            TodoItem("Apply state"),
            TodoItem("Build dynamic UI's")
        ),
            onAddItem = {}, onRemoveItem = {})
    }
}