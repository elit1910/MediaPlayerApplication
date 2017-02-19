package com.example.mediaplayerapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Matrix;
import android.widget.ImageView;

import static android.R.attr.angle;
import static android.R.attr.pivotX;
import static android.R.attr.pivotY;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.mediaplayerapplication.R.id.Abba;
import static com.example.mediaplayerapplication.R.id.Bach;
import static com.example.mediaplayerapplication.R.id.Beatles;
import static com.example.mediaplayerapplication.R.id.BildF;



public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        //ABBA
        // Find the View that shows the numbers category
        TextView abba = (TextView) findViewById(Abba);

        //Set OnClickListener to the textview
        abba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new intent on click
                Intent abbaIntent = new Intent(MainActivity.this, Abba.class);

                //Start the activity
                startActivity(abbaIntent);

            }
        });

        //BACH
        // Find the View that shows the numbers category
        TextView bach = (TextView) findViewById(Bach);

        //Set OnClickListener to the textview
        bach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new intent on click
                Intent bachIntent = new Intent(MainActivity.this, Bach.class);

                //Start the activity
                startActivity(bachIntent);

            }
        });

        //Beatles
        // Find the View that shows the numbers category
        TextView beatles = (TextView) findViewById(Beatles);

        //Set OnClickListener to the textview
        beatles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new intent on click
                Intent beatlesIntent = new Intent(MainActivity.this, Beatles.class);

                //Start the activity
                startActivity(beatlesIntent);

            }
        });



    };
    }



    //Kolla det senare, asso bild rotationen
    /*ImageView imageView = (ImageView)findViewById(BildF);
    Matrix matrix = new Matrix();
    imageView.setScaleType(ImageView.ScaleType.MATRIX);   //required
    matrix.postRotate((float) angle, pivotX, pivotY);
    imageView.setImageMatrix(matrix);
    */

