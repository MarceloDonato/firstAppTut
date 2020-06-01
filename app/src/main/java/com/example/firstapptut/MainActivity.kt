package com.example.firstapptut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationy = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()

                val translationDistance =
                    (initialTextViewTranslationy + progress + resources.getDimension(R.dimen.text_anim_step) + -1)

                textView_progress.animate().translationY(translationDistance)
                if (!fromUser)

                textView_progress.animate().setDuration(500).rotationBy(360f)
                    .translationY(initialTextViewTranslationy)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        button_reset.setOnClickListener {
            seekBar.progress = 0

        }

    }
}