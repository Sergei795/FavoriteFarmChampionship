package farm.favbet.game.fovorit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;


public class MenuActivity extends AppCompatActivity {

    ImageView btn_play, btn_share, btn_quit,bt_rate,bt_abouter, bt_htpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(ConstraintLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        btn_play = findViewById(R.id.btn_play);
        btn_share = findViewById(R.id.btn_share);
        btn_quit = findViewById(R.id.btn_quit);
        bt_rate = findViewById(R.id.ratilka);
        bt_abouter = findViewById(R.id.aboutilka);
        bt_htpl = findViewById(R.id.howtotopla);

        btn_play.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, MainActivity.class)));
        btn_share.setOnClickListener(v -> {
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT," Share ");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "Play with me --- https://play.google.com/store/apps/details?id=" + getPackageName());
            startActivity(Intent.createChooser(i,"Share this game for?->"));
        });
        btn_quit.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Do you really want to exit application?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", (arg0, arg1) -> finish())
                .create()
                .show());
        bt_rate.setOnClickListener(v->{
            Intent intent1 = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id="
                            + MenuActivity.this.getPackageName()));
            startActivity(intent1);
        });
        bt_abouter.setOnClickListener(v->{
            startActivity(new Intent(this,FarmUsAb.class));
        });
        bt_htpl.setOnClickListener(v->{
            startActivity(new Intent(this,ChampionHTPL.class));
        });
    }
}