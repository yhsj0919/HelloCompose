package xyz.yhsj.compose.page

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ColumnScope.gravity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import xyz.yhsj.compose.R
import xyz.yhsj.compose.utils.Navigation

@Composable
fun DialogPage() {
    val showDialog = mutableStateOf(false)

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Dialog") },
            elevation = 8.dp,
            navigationIcon = { IconButton(onClick = { Navigation.pop() }) { Icon(asset = Icons.Default.ArrowBack) } }
        )
    }) {

        if (showDialog.value) {
            showDialog { showDialog.value = false }
        }

        ScrollableColumn(
            horizontalGravity = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Button(onClick = {
                showDialog.value = true

            }) {
                Text(text = "Dialog")
            }
        }
    }
}

@Composable
fun showDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        title = { Text(text = "Title", style = typography.h6) },
        text = {
            Text("item.subtitle", modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth())
            Image(
                asset = imageResource(R.drawable.image_1),
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        },
        buttons = {
            TextButton(
                onClick = onDismissRequest,
                modifier = Modifier.padding(8.dp).gravity(Alignment.End)
            ) {
                Text(text = "Ok")
            }
        },
        onDismissRequest = onDismissRequest,
        shape = RoundedCornerShape(16.dp)
    )

}
