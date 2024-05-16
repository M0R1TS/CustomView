package ru.devsokovix.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.util.Measure
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.WindowInsets

class CustomView@JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) : View(context, attributeSet) {

    private var strokeWidthAttr = 0f

    init {
        val attributes = context.theme.obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0, 0)

        try {
            strokeWidthAttr = attributes.getFloat(R.styleable.CustomView_stroke_width, 0F)
        } finally {
            attributes.recycle()
        }
    }

    private val strokePaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = strokeWidthAttr
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e("AvatarImageMask", "onAttachedToWindow")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e("AvatarImageMask", "onMeasure")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.e("AvatarImageMask", "onSizeChanged")
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, 0f, width.toFloat(), height.toFloat(), strokePaint)
    }

}