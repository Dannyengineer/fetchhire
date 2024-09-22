
package com.danny.fetchhire

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemViewModel : ViewModel() {

    var items = mutableStateListOf<Item>()

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            val fetchedItems = withContext(Dispatchers.IO) {
                RetrofitInstance.api.fetchItems()
            }
            // Filter and sort
            val filteredItems = fetchedItems.filter { !it.name.isNullOrEmpty() }
                .sortedWith(compareBy({ it.listId }, { it.name }))

            items.addAll(filteredItems)
        }
    }
}
