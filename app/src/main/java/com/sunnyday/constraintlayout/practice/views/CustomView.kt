package com.sunnyday.constraintlayout.practice.views

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Create by SunnyDay on 20:23 2021/12/19
 */

class CustomView(
    context: Context,
    attributeSet: AttributeSet
) : View(context,attributeSet){

    companion object{
        const val DEFAULT_VIEW_SIZE = 100
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // view的宽高以及侧来那个模式
        val widthMode = MeasureSpec.getMode(widthMeasureSpec);
        val widthSize = MeasureSpec.getSize(widthMeasureSpec);
        val heightMode = MeasureSpec.getMode(heightMeasureSpec);
        val heightSize = MeasureSpec.getSize(heightMeasureSpec);


        // 用户宽高都设置为 wrap_content时
        // default value
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_VIEW_SIZE, DEFAULT_VIEW_SIZE)
        }else if(widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(DEFAULT_VIEW_SIZE,heightSize)
        }else if(heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,DEFAULT_VIEW_SIZE)
        }else{
            setMeasuredDimension(widthSize,heightSize)
        }

    }
}