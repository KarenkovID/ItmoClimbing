package com.itmoclimbing.presentation.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import java.util.LinkedHashSet

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId), OnBackPressable {

    private var childBackPressedListeners: MutableSet<OnBackPressedListener> = LinkedHashSet()

    final override fun onBackPressed() {
        val isConsumed = childBackPressedListeners.toList().lastOrNull(OnBackPressedListener::onBackPressed) != null
        if (!isConsumed) {
            performOnBackPressed()
        }
    }

    override fun addOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.add(listener)
    }

    override fun removeOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.remove(listener)
    }

}