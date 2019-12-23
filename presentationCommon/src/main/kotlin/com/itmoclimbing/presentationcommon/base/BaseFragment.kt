package com.itmoclimbing.presentationcommon.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import java.util.LinkedHashSet

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId), OnBackPressable, OnBackPressedListener {

    private var childBackPressedListeners: MutableSet<OnBackPressedListener> = LinkedHashSet()

    override fun onResume() {
        super.onResume()
        getParentOnBackPressable().addOnBackPressedListener(this)

    }

    override fun onPause() {
//        activity?.hideKeyboard()
        getParentOnBackPressable().removeOnBackPressedListener(this)
        super.onPause()
    }

    override fun addOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.add(listener)
    }

    override fun removeOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.remove(listener)
    }

    override fun onBackPressed(): Boolean = when {
        childBackPressedListeners.toList().lastOrNull(OnBackPressedListener::onBackPressed) != null -> true
        else -> performOnBackPressed()
    }

    private fun getParentOnBackPressable(): OnBackPressable = when {
        parentFragment != null -> parentFragment as OnBackPressable
        else -> activity as OnBackPressable
    }

}