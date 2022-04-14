package com.example.myapplication
//import com.example.myapplication.


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.tutorial.SampleData
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Message(val author: String, val body: String)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Conversation(messages = SampleData.conversationSample)
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier= Modifier.padding(all=8.dp)) {
        Image(contentDescription ="Profile",
            painter = painterResource (id = R.drawable.image),
            modifier= Modifier
                .size(40.dp)
                .clip(shape = CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape), )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = "${message.author}",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Text(text = "${message.body}",
                style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}
@Preview(name = "Light Mode",
        showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}
