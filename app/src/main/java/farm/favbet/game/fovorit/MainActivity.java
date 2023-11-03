package farm.favbet.game.fovorit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView t1, t5, coins;
    ImageView back, sp5bg, sp1bg, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;
    Handler h;
    Random r;
    SharedPreferences s;
    boolean run = false;
    int timer = 0;
    int it1, it2, it3, it4, it5, it6, it7, it8, it9, it10, it11, it12, it13, it14, it15;
    int cts;
    int c;
    int[] items;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(ConstraintLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_main);

        items = new int[]{
            R.drawable.clever,
            R.drawable.lemon,
            R.drawable.mellow,
            R.drawable.seven,
            R.drawable.vinograd
        };

        h = new Handler();
        r = new Random();
        s = getSharedPreferences("PREFS", MODE_PRIVATE);
        c = s.getInt("coins", 5000);

        t1 = findViewById(R.id.t1);
        t5 = findViewById(R.id.t5);
        coins = findViewById(R.id.coins);
        back = findViewById(R.id.back);
        sp5bg = findViewById(R.id.sp5bg);
        sp1bg = findViewById(R.id.sp1bg);
        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);
        i4 = findViewById(R.id.i4);
        i5 = findViewById(R.id.i5);
        i6 = findViewById(R.id.i6);
        i7 = findViewById(R.id.i7);
        i8 = findViewById(R.id.i8);
        i9 = findViewById(R.id.i9);
        i10 = findViewById(R.id.i10);
        i11 = findViewById(R.id.i11);
        i12 = findViewById(R.id.i12);
        i13 = findViewById(R.id.i13);
        i14 = findViewById(R.id.i14);
        i15 = findViewById(R.id.i15);

        coins.setText(c + " coins");

        back.setOnClickListener(v -> {
            if(!run){
                finish();
            }
        });
        sp1bg.setOnClickListener(v -> {
            cts = 1;
            if(!run && c >= cts){
                c -= cts;
                coins.setText(c + " coins");
                s.edit().putInt("coins", c).apply();
                run = true;
            }
        });
        sp5bg.setOnClickListener(v -> {
            cts = 5;
            if(!run && c >= cts){
                c -= cts;
                coins.setText(c + " coins");
                s.edit().putInt("coins", c).apply();
                run = true;
            }
        });

        gameLoop();
    }

    private void gameLoop(){
        h.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if(run){
                    timer++;
                    if(timer < 60){
                        it1 = Math.abs(r.nextInt()%5);
                        it2 = Math.abs(r.nextInt()%5);
                        it3 = Math.abs(r.nextInt()%5);
                        i1.setImageResource(items[it1]);
                        i2.setImageResource(items[it2]);
                        i3.setImageResource(items[it3]);
                    }
                    if(timer < 75){
                        it4 = Math.abs(r.nextInt()%5);
                        it5 = Math.abs(r.nextInt()%5);
                        it6 = Math.abs(r.nextInt()%5);
                        i4.setImageResource(items[it4]);
                        i5.setImageResource(items[it5]);
                        i6.setImageResource(items[it6]);
                    }
                    if(timer < 90){
                        it7 = Math.abs(r.nextInt()%5);
                        it8 = Math.abs(r.nextInt()%5);
                        it9 = Math.abs(r.nextInt()%5);
                        i7.setImageResource(items[it7]);
                        i8.setImageResource(items[it8]);
                        i9.setImageResource(items[it9]);
                    }
                    if(timer < 105){
                        it10 = Math.abs(r.nextInt()%5);
                        it11 = Math.abs(r.nextInt()%5);
                        it12 = Math.abs(r.nextInt()%5);
                        i10.setImageResource(items[it10]);
                        i11.setImageResource(items[it11]);
                        i12.setImageResource(items[it12]);
                    }
                    if(timer < 120){
                        it13 = Math.abs(r.nextInt()%5);
                        it14 = Math.abs(r.nextInt()%5);
                        it15 = Math.abs(r.nextInt()%5);
                        i13.setImageResource(items[it13]);
                        i14.setImageResource(items[it14]);
                        i15.setImageResource(items[it15]);
                    }
                    if(timer >= 120){
                        run = false;
                        timer = 0;
                        double k = 0;
                        if((it2 == it5 && it5 == it8 && it8 == it11 && it11 == it14)
                                || (it3 == it6 && it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7 && it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9 && it9 == it11 && it11 == it14)
                                || (it2 == it4 && it4 == it8 && it8 == it12 && it12 == it14)
                                || (it2 == it6 && it6 == it8 && it8 == it10 && it10 == it14)){
                            k = 40;
                        } else if((it2 == it5 && it5 == it8 && it8 == it11)
                                || (it3 == it6 && it6 == it8 && it8 == it10)
                                || (it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12)
                                || (it4 == it8 && it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7 && it7 == it11)
                                || (it5 == it7 && it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9 && it9 == it11)
                                || (it5 == it9 && it9 == it11 && it11 == it14)
                                || (it2 == it4 && it4 == it8 && it8 == it12)
                                || (it4 == it8 && it8 == it12 && it12 == it14)
                                || (it2 == it6 && it6 == it8 && it8 == it10)
                                || (it6 == it8 && it8 == it10 && it10 == it14)){
                            k = 8;
                        } else if((it2 == it5 && it5 == it8)
                                || (it3 == it6 && it6 == it8)
                                || (it6 == it8 && it8 == it10)
                                || (it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8)
                                || (it4 == it8 && it8 == it12)
                                || (it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7)
                                || (it5 == it7 && it7 == it11)
                                || (it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9)
                                || (it5 == it9 && it9 == it11)
                                || (it9 == it11 && it11 == it14)
                                || (it2 == it4 && it4 == it8)
                                || (it8 == it12 && it12 == it14)
                                || (it2 == it6 && it6 == it8)
                                || (it8 == it10 && it10 == it14)){
                            k = 4;
                        }
                        if((it2 == it5 && it5 == it8 && it8 == it11 && it11 == it14)
                                || (it3 == it6 && it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7 && it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9 && it9 == it11 && it11 == it14)){
                            k = 20;
                        } else if((it2 == it5 && it5 == it8 && it8 == it11)
                                || (it3 == it6 && it6 == it8 && it8 == it10)
                                || (it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12)
                                || (it4 == it8 && it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7 && it7 == it11)
                                || (it5 == it7 && it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9 && it9 == it11)
                                || (it5 == it9 && it9 == it11 && it11 == it14)){
                            k = 4;
                        } else if((it2 == it5 && it5 == it8)
                                || (it3 == it6 && it6 == it8)
                                || (it6 == it8 && it8 == it10)
                                || (it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8)
                                || (it4 == it8 && it8 == it12)
                                || (it8 == it12 && it12 == it15)
                                || (it2 == it5 && it5 == it7)
                                || (it5 == it7 && it7 == it11)
                                || (it7 == it11 && it11 == it14)
                                || (it2 == it5 && it5 == it9)
                                || (it5 == it9 && it9 == it11)
                                || (it9 == it11 && it11 == it14)){
                            k = 2;
                        }
                        if((it2 == it5 && it5 == it8 && it8 == it11 && it11 == it14)
                                || (it3 == it6 && it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12 && it12 == it15)){
                            k = 10;
                        } else if((it2 == it5 && it5 == it8 && it8 == it11)
                                || (it3 == it6 && it6 == it8 && it8 == it10)
                                || (it6 == it8 && it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8 && it8 == it12)
                                || (it4 == it8 && it8 == it12 && it12 == it15)){
                            k = 2;
                        } else if((it2 == it5 && it5 == it8)
                                || (it3 == it6 && it6 == it8)
                                || (it6 == it8 && it8 == it10)
                                || (it8 == it10 && it10 == it13)
                                || (it1 == it4 && it4 == it8)
                                || (it4 == it8 && it8 == it12)
                                || (it8 == it12 && it12 == it15)){
                            k = 1;
                        }
                        if(it2 == it5 && it5 == it8 && it8 == it11 && it11 == it14){
                            k = 5;
                        } else if(it2 == it5 && it5 == it8 && it8 == it11){
                            k = 1;
                        } else if(it2 == it5 && it5 == it8){
                            k = (double)1/2;
                        }
                        c += cts * k;
                        coins.setText(c + " coins");
                        s.edit().putInt("coins", c).apply();
                    }
                }
                h.postDelayed(this, 17);
            }
        });
    }
}