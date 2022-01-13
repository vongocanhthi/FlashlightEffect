package com.atcoder.moviekotlin.base.textview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.atcoder.moviekotlin.base.BaseTextView

@SuppressLint("AppCompatCustomView")
class OpenSansBoldTextView : TextView {
    constructor(context: Context?) : super(context) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    private fun init(context: Context?) {
        setIncludeFontPadding(false)
//        val typeface = Typeface.createFromAsset(context?.assets, "font/opensans_bold.ttf")
//        setTypeface(typeface)
    }
}