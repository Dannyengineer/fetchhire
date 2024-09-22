
package com.danny.fetchhire

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ItemList(viewModel: ItemViewModel = viewModel()) {
    LazyColumn {
        items(viewModel.items) { item ->
            ItemRow(item)
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    Column(modifier = Modifier.padding(horizontal = 40.dp, vertical = 20.dp).fillMaxWidth()) {

        Text(text = "List ID: ${item.listId}")
        Text(text = "Item ID: ${item.id}")
        Text(text = "Name: ${item.name}")
    }
}

@Preview
@Composable
fun PreviewItemRow() {
    ItemRow(item = Item(1, 1, "Item 1"))
}
