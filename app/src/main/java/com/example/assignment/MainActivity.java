package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    private SurfaceView msurfaceview;
    private SurfaceHolder msurfaceHolder;
    Canvas canvas;
    private BouncingBall t = new BouncingBall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msurfaceview = findViewById(R.id.surfaceview);
        msurfaceHolder = msurfaceview.getHolder();
        msurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                t.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
    private class BouncingBall extends Thread{
        public boolean isBouncing = true;
//        public int X = msurfaceview.getWidth()/2;
//        public int Y = msurfaceview.getHeight()/2;
//        public int lastX = msurfaceview.getWidth();
//        public int lastY = msurfaceview.getHeight();


        @Override
        public void run(){
            final int lastX = msurfaceview.getHeight();
            final int Y = msurfaceview.getHeight()/2;
            final int R = lastX/15;
            for (int X = msurfaceview.getWidth()/2;X<lastX-2*R;X+=1){
                if ((canvas = msurfaceHolder.lockCanvas()) == null) {
                    // can happen when the app is paused.
                    continue;}
            canvas.drawColor(Color.WHITE);


            Paint p = new Paint();
            p.setStrokeWidth(5);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);

            canvas.drawCircle(X,Y,R,p);
            msurfaceHolder.unlockCanvasAndPost(canvas);

            }
        }
    }


}
