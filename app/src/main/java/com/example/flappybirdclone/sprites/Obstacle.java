package com.example.flappybirdclone.sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.flappybirdclone.R;

import java.util.Random;

public class Obstacle implements Sprite {

    private int height, width, separation, xPosition, speed, screenHeight, screenWidth, headHeight, headExtraWidth;
    private Bitmap image;
    private int obstacleMinPosition;

    public Obstacle(Resources resources, int screenHeight, int screenWidth) {
        image = BitmapFactory.decodeResource(resources, R.drawable.pipes);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        width = (int) resources.getDimension(R.dimen.obstacle_width);
        speed = (int) resources.getDimension(R.dimen.obstacle_speed);
        separation = (int) resources.getDimension(R.dimen.obstacle_separation);
        headHeight = (int) resources.getDimension(R.dimen.head_height);
        headExtraWidth = (int) resources.getDimension(R.dimen.head_extra_width);
        obstacleMinPosition = (int) resources.getDimension(R.dimen.obstacle_min_position) ;
        xPosition = 500;

        Random random = new Random(System.currentTimeMillis());
        height = random.nextInt(screenHeight - 2*obstacleMinPosition - separation) + obstacleMinPosition;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bottomPipe = new Rect(xPosition+headExtraWidth, screenHeight-height, xPosition+width+headExtraWidth, screenHeight);
        Rect bottomHead = new Rect(xPosition, screenHeight-height-headHeight, xPosition+width+2*headExtraWidth, screenHeight-height);

        Rect topPipe = new Rect(xPosition+headExtraWidth, 0, xPosition+width+headExtraWidth, screenHeight-height-separation-headHeight);
        Rect topHead = new Rect(xPosition, screenHeight-height-separation-2*headHeight, xPosition+width+2*headExtraWidth, screenHeight-height-separation-headHeight);

        Paint paint = new Paint();
        canvas.drawBitmap(image, null, bottomPipe, paint);
        canvas.drawBitmap(image, null, bottomHead, paint);
        canvas.drawBitmap(image, null, topPipe, paint);
        canvas.drawBitmap(image, null, topHead, paint);

    }

    @Override
    public void update() {

    }
}
