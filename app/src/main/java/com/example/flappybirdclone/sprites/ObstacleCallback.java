package com.example.flappybirdclone.sprites;

import android.graphics.Rect;

import java.util.ArrayList;

public interface ObstacleCallback {
    public void obstacleOffScreen(Obstacle obstacle);
    public void updatePosition(Obstacle obstacle, ArrayList<Rect> positions);
}
