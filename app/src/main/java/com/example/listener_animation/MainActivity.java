package com.example.listener_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {

    TextView tv1;
    Animation escalamiento, transparencia, traslacion, transparencia2;
    Button btn;
    int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.txt1);
        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(this);

        //Animacion de transparencia (Aparicion)
        transparencia = new AlphaAnimation(0,1);
        transparencia.setInterpolator(new LinearInterpolator());
        transparencia.setDuration(2000);
        transparencia.setRepeatMode(Animation.RESTART);
        transparencia.setRepeatCount(10);
        tv1.startAnimation(transparencia);

        //Animacion de transparencia (Aparicion) dos
        transparencia2 = new AlphaAnimation(0,1);
        transparencia2.setInterpolator(new LinearInterpolator());
        transparencia2.setDuration(2000);
        transparencia2.setRepeatMode(Animation.RESTART);
        transparencia2.setRepeatCount(10);

        //Animacion de escalamiento
        int rs = ScaleAnimation.RELATIVE_TO_SELF;
        escalamiento = new ScaleAnimation(1, 2,1, 3, rs, 0.5f, rs, 0.5f);
        escalamiento.setDuration(5000);
        escalamiento.setInterpolator(new LinearInterpolator());
        escalamiento.setFillAfter(true);
        //tv1.startAnimation(escalamiento);

        //Animaciones de traslacion
        int rs2 = TranslateAnimation.RELATIVE_TO_SELF;
        traslacion = new TranslateAnimation(rs2, 0, rs2, 0, rs2, 0, rs2, 0.3f);
        traslacion.setDuration(10000);
        traslacion.setInterpolator(new BounceInterpolator());
        traslacion.setFillAfter(false);
        //tv1.startAnimation(traslacion);

        transparencia.setAnimationListener(this);
        escalamiento.setAnimationListener(this);
        traslacion.setAnimationListener(this);
    }

    ////////////// Funciones de control de animación//////////////
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation==transparencia){
            tv1.setText("BOOM!");
            tv1.startAnimation(escalamiento);
        }
        if(animation==escalamiento){
            tv1.startAnimation(traslacion);
        }
    }

    @Override //Cada que se repita la animación entra a este metodo
    public void onAnimationRepeat(Animation animation) {
        if(animation ==transparencia){
            i--;
            tv1.setText("Contador = " + i);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn1){
            btn.startAnimation(transparencia2);
        }
    }
}