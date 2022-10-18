package com.komaldehraj.epoxyandsocket.utils

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

fun <T : View> Activity.findViewLazy(@IdRes id: Int): Lazy<T> = lazy { findViewById(id) }

