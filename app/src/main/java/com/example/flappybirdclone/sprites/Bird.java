package com.example.flappybirdclone.sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.flappybirdclone.R;

public class Bird implements  Sprite {

    private Bitmap bird_down;
    private Bitmap bird_up;

    private int birdX, birdY, birdWidth, birdHeight;
    private float gravity;
    private float currentFallingSpeed;
    private float flappyBoost;


    public Bird(Resources resources) {
        birdX = (int)resources.getDimension(R.dimen.bird_x);
        birdWidth = (int)resources.getDimension(R.dimen.bird_width);
        birdHeight = (int)resources.getDimension(R.dimen.bird_height);
        gravity = resources.getDimension(R.dimen.gravity);
        flappyBoost = resources.getDimension(R.dimen.flappy_boost);

        Bitmap birdBmp = BitmapFactory.decodeResource(resources, R.drawable.bird_down);
        bird_down = Bitmap.createScaledBitmap(birdBmp, birdWidth, birdHeight, false);
        Bitmap birdBmpUp = BitmapFactory.decodeResource(resources, R.drawable.bird_up);
        bird_up = Bitmap.createScaledBitmap(birdBmpUp, birdWidth, birdHeight, false);
    }

    @Override
    public void draw(Canvas canvas) {
        if(currentFallingSpeed < 0) {
            canvas.drawBitmap(bird_up, birdX, birdY, null);
        } else {
            canvas.drawBitmap(bird_down, birdX, birdY, null);
        }
    }

    @Override
    public void update() {
        birdY += currentFallingSpeed;
        currentFallingSpeed += gravity;
    }

    public void onTouchEvent() {
        currentFallingSpeed = flappyBoost;
    }
}
