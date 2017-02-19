package com.example.mediaplayerapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by estlander on 16/02/2017.
 */

public class Beatles extends AppCompatActivity {


    public static int oneTimeOnly = 0;
    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaplayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudiomanager;

    private SeekBar seekbar;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    //private TextView info1,info2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);


        final TextView info1 = (TextView) findViewById(R.id.textView2);

        //Define the various buttons
        final Button pause= (Button) findViewById(R.id.button2);
        final Button play= (Button) findViewById(R.id.button3);
        final Button forward= (Button) findViewById(R.id.button4);
        final Button rewind = (Button) findViewById(R.id.button);

        mMediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.beatlessong);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        pause.setEnabled(false);
        seekbar.setClickable(false);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();

                mMediaplayer.start();

                finalTime = mMediaplayer.getDuration();
                startTime = mMediaplayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                info1.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
                );

                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                pause.setEnabled(true);
                play.setEnabled(false);


            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing song",Toast.LENGTH_SHORT).show();
                mMediaplayer.pause();
                pause.setEnabled(false);
                play.setEnabled(true);
            }
        });


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mMediaplayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mMediaplayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaplayer.getCurrentPosition();
            final TextView info2 = (TextView) findViewById(R.id.textView3);
            info2.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };

}
