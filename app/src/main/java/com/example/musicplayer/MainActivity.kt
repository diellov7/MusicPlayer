package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaPlayer = MediaPlayer.create(this,R.raw.music)

        seekbar.progress = 0
        seekbar.max = mediaPlayer.duration
        play_button.setOnClickListener {
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()

                play_button.setImageResource(R.drawable.ic_baseline_pause_24)
            }else {mediaPlayer.pause()
                play_button.setImageResource(R.drawable.ic_baseline_play_arrow_24)

            }
        }
seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
    override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
        if(changed){
            mediaPlayer.seekTo(pos)
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
})

runnable = Runnable {
    seekbar.progress = mediaPlayer.currentPosition
    handler.postDelayed(runnable,1000)

}










    }
}