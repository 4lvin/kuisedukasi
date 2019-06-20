package com.jongjava.alvin.kuisgame;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jongjava.alvin.kuisgame.base.MyApplication;
import com.jongjava.alvin.kuisgame.model.DataItem;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class SoalActivity extends AppCompatActivity {

    ProgressDialog progressdialog;
    ArrayList<DataItem> pertanyaanList;
    TextView soal;
    TextView judul;
    TextView trumus;
    Button a;
    Button b;
    Button c;
    Button d;
    ImageView keluar;
    ImageView image;
    String no = "0";
    String lvl = "";
    int soalLenght;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        soal = findViewById(R.id.soal);
        judul = findViewById(R.id.txt_title);
        trumus = findViewById(R.id.txt_rumus);
        keluar = findViewById(R.id.btn_back);
        image = findViewById(R.id.gambar);
        pertanyaanList = new ArrayList<DataItem>();
        Intent i=getIntent();
        no=i.getStringExtra("no");
        lvl=i.getStringExtra("lvl");
        soalShow();
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void soalShow(){
        Request request = new Request.Builder()
                .url(MyApplication.BASE_URL + "get_pertanyaan")
                .header("Accept", "application/json")
                .build();

        progressdialog = new ProgressDialog(SoalActivity.this);
        progressdialog.setMessage("");
        progressdialog.show();

        MyApplication.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                progressdialog.dismiss();
                SoalActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("tag", e.getMessage());
                        e.printStackTrace();
                        Toast.makeText(SoalActivity.this, "No Internet Accces", Toast.LENGTH_LONG).show();

                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String body = response.body().string();
                SoalActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (response.isSuccessful()) {
                            try {
                                JSONObject res = new JSONObject(body);
                                JSONArray obj = res.getJSONArray("data");
                                for (int i = 0; i < obj.length(); i++) {
                                    JSONObject c = obj.getJSONObject(i);

//                                    String nomer = c.getString("nomer");
                                    String judul = c.getString("judul");
                                    String pertanyaan = c.getString("pertanyaan");
//                                    String idPertanyaan = c.getString("id_pertanyaan");
//                                    String namaSetting = c.getString("nama_setting");
                                    String pilihanA = c.getString("pilihan_a");
                                    String pilihanB = c.getString("pilihan_b");
                                    String pilihanC = c.getString("pilihan_c");
                                    String pilihanD = c.getString("pilihan_d");
                                    String kunciJawaban = c.getString("kunci_jawaban");
                                    String namaLevel = c.getString("nama_level");
                                    String url = c.getString("url");
//                                    String namaJenisBangunan = c.getString("nama_jenis_bangunan");
//                                    String namaJenisRumus = c.getString("nama_jenis_rumus");
                                    String rumus = c.getString("rumus");
                                    String showRumus = c.getString("show_rumus");
//                                    soal.add(new DataItem(pilihanA, pilihanB, pilihanC, pilihanD,namaSetting,namaJenisRumus,
//                                            namaJenisBangunan,kunciJawaban,rumus,idPertanyaan,nomer,namaLevel,judul,pertanyaan));
                                    if(lvl.equals(namaLevel)){
                                        pertanyaanList.add(new DataItem(pilihanA,pilihanC,pilihanB,pilihanD,pertanyaan,kunciJawaban,judul,rumus,namaLevel,showRumus,url));
                                    }
                                }
                                soalLenght = pertanyaanList.size();
                                System.out.println(soalLenght);
                                int numb = Integer.parseInt(no);
                                if( numb >= soalLenght ){
                                    openDialogSelamat();
                                }else{
                                    if(pertanyaanList.get(Integer.parseInt(no)).getShowRumus().equals("1")){
                                        trumus.setText(pertanyaanList.get(Integer.parseInt(no)).getRumus());
                                    }else {
                                        trumus.setVisibility(TextView.VISIBLE);
                                        trumus.setBackgroundResource(android.R.color.transparent);
                                    }
                                    Picasso.with(SoalActivity.this).load(pertanyaanList.get(Integer.parseInt(no)).getUrl()).into(image);
                                    judul.setText(pertanyaanList.get(Integer.parseInt(no)).getJudul());
                                    soal.setText(pertanyaanList.get(Integer.parseInt(no)).getPertanyaan());
                                    a.setText(pertanyaanList.get(Integer.parseInt(no)).getPilihanA());
                                    b.setText(pertanyaanList.get(Integer.parseInt(no)).getPilihanB());
                                    c.setText(pertanyaanList.get(Integer.parseInt(no)).getPilihanC());
                                    d.setText(pertanyaanList.get(Integer.parseInt(no)).getPilihanD());

                                    a.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if(pertanyaanList.get(Integer.parseInt(no)).getPilihanA().equals(pertanyaanList.get(Integer.parseInt(no)).getKunciJawaban())){
                                                openDialog();
                                            } else {
                                                openDialogSalah();
                                            }
                                        }
                                    });
                                    b.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if(pertanyaanList.get(Integer.parseInt(no)).getPilihanB().equals(pertanyaanList.get(Integer.parseInt(no)).getKunciJawaban())){
                                                openDialog();
                                            } else {
                                                openDialogSalah();
                                            }
                                        }
                                    });
                                    c.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if(pertanyaanList.get(Integer.parseInt(no)).getPilihanC().equals(pertanyaanList.get(Integer.parseInt(no)).getKunciJawaban())){
                                                openDialog();
                                            } else {
                                                openDialogSalah();
                                            }
                                        }
                                    });
                                    d.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if(pertanyaanList.get(Integer.parseInt(no)).getPilihanD().equals(pertanyaanList.get(Integer.parseInt(no)).getKunciJawaban())){
                                                openDialog();
                                            } else {
                                                openDialogSalah();
                                            }
                                        }
                                    });

                                }
                                progressdialog.dismiss();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else
                            Log.d("tag", "No succes response: " + response.message());
                    }
                });

            }
        });

    }
//    public String getPertanyaan(int x){
//        ArrayList<DataItem> soal = pertanyaanList(x);
//        return String.valueOf(soal);
//    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Selesaikan soal", Toast.LENGTH_SHORT).show();
    }

    void openDialogSelamat() {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.activity_selamat);
        ImageView close = dialog.findViewById(R.id.btnclose);
        Button menu = dialog.findViewById(R.id.menu);
        TextView tlevel = dialog.findViewById(R.id.txtlevel);
            tlevel.setText(lvl.toUpperCase());
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    void openDialog() {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.activity_benar);
        ImageView close = dialog.findViewById(R.id.btnclose);
        Button menu = dialog.findViewById(R.id.menu);
        Button lanjut = dialog.findViewById(R.id.dialog_ok);
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(SoalActivity.this, MainActivity.class);
              startActivity(intent);
            }
        });
        lanjut.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          int new_no=Integer.parseInt(no)+1;
                                          Intent intent = new Intent(SoalActivity.this, SoalActivity.class);
                                          intent.putExtra("no",String.valueOf(new_no));
                                          intent.putExtra("lvl",String.valueOf(lvl));
                                          startActivity(intent);
                                      }
                                  });
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    void openDialogSalah() {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.activity_salah);
        ImageView close = dialog.findViewById(R.id.btnclosesalah);
        Button menu = dialog.findViewById(R.id.menusalah);
        Button coba = dialog.findViewById(R.id.dialog_ok);
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        coba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
