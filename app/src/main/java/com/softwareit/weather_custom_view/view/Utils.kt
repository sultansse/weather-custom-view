package com.softwareit.weather_custom_view.view

import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View

inline fun View.setAttrs(
    attrs: AttributeSet?,
    styleable: IntArray,
    crossinline body: (TypedArray) -> Unit
) {
    context.theme.obtainStyledAttributes(attrs, styleable, 0, 0)
        .apply {
            try {
                body(this)
            } finally {
                recycle()
            }
        }
}