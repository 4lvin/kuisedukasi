package com.jongjava.alvin.kuisgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView easy = findViewById(R.id.txt_easy);
        final TextView medium = findViewById(R.id.txt_medium);
        final TextView hard = findViewById(R.id.txt_hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_no=0;
                String level = "easy";
                Intent intent = new Intent(MainActivity.this, SoalActivity.class);
                intent.putExtra("no",String.valueOf(new_no));
                intent.putExtra("lvl",String.valueOf(level));
                startActivity(intent);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_no=0;
                String level = "medium";
                Intent intent = new Intent(MainActivity.this, SoalActivity.class);
                intent.putExtra("no",String.valueOf(new_no));
                intent.putExtra("lvl",String.valueOf(level));
                startActivity(intent);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int new_no=0;
                String level = "hard";
                Intent intent = new Intent(MainActivity.this, SoalActivity.class);
                intent.putExtra("no",String.valueOf(new_no));
                intent.putExtra("lvl",String.valueOf(level));
                startActivity(intent);
            }
        });
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Anda yakin akan keluar?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Ya",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }
                });

        builder1.setNegativeButton(
                "Tidak",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.show();
    }
}
