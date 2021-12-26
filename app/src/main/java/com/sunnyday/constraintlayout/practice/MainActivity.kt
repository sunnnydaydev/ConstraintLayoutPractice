package com.sunnyday.constraintlayout.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.test10.*

import java.util.logging.Logger

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ratio)
       // test10()
    }

    /**
     * todo：解决自定义view 时 maxXXX约束失效
     * */
    private fun test10(){
        // 控件初始高
        tv1.post {
            Log.d(TAG, "defaultHeight:${tv1.height}")
        }

        tv1.apply {

            setOnClickListener {
                val params = layoutParams
                params.height += 100
                params.width += 100
                tv1.layoutParams = params

                tv1.post {
                    Log.d(TAG, "currentHeight:${tv1.height}")
                    Log.d(TAG, "currentWidth:${tv1.width}")
                }
            }
        }
    }
}