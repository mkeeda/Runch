package com.mkeeda.runch.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RunchViewModelFactory<T: ViewModel>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return creator() as T
    }
}
