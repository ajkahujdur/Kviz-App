package com.example.user.kvizzastave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView slikeZastava;
    private Button dugme1;
    private Button dugme2;
    private Button dugme3;
    private Button detalji;
    private Button sljedece;

    private int trenutniIndex = 0;

    private final Random rand = new Random();
    private final Random rand1 =new Random();
    private static final String EXTRA="com.example.user.kvizzastave";
    private int rndInt;

    Pitanje[] nizPitanja = new Pitanje[]{
            new Pitanje(R.drawable.at, "Austrija",R.string.detalji_austrija),
            new Pitanje(R.drawable.ba, "Bosna i Hercegovina",R.string.detalji_bosna),
            new Pitanje(R.drawable.be, "Belgija",R.string.detalji_belgija),
            new Pitanje(R.drawable.it, "Italija",R.string.detalji_italija),
            new Pitanje(R.drawable.de,"Njemačka",R.string.detalji_njemacka),
            new Pitanje(R.drawable.dk,"Danska",R.string.detalji_danska),
            new Pitanje(R.drawable.fi,"Finska",R.string.detalji_finska),
            new Pitanje(R.drawable.pt,"Portugal",R.string.detalji_portugal),
            new Pitanje(R.drawable.se,"Švedska",R.string.detalji_svedska),
            new Pitanje(R.drawable.tr,"Turska",R.string.detalji_turska),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dugme1 = (Button) findViewById(R.id.dugme1);
        dugme2 = (Button) findViewById(R.id.dugme2);
        dugme3 = (Button) findViewById(R.id.dugme3);
        sljedece = (Button) findViewById(R.id.sljedece);
        detalji = (Button) findViewById(R.id.detalji);
        slikeZastava = (ImageView) findViewById(R.id.zastava);

        detalji.setVisibility(View.GONE);

        final int[] indeksi=new int[nizPitanja.length];
        for (int i = 0; i < nizPitanja.length; i++) {
            indeksi[i] = i;
        }
        shuffleArray(indeksi);

        sljedece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateImage(indeksi);
            }
        });

        dugme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriOdgovor(dugme1);
            }
        });

        dugme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriOdgovor(dugme2);
            }
        });

        dugme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                provjeriOdgovor(dugme3);
            }
        });

        detalji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("EXTRA",rndInt);
                startActivity(i);
            }
        });

        updateImage(indeksi);
    }

    int vratiRBrojZaPostOdgovora(){
        return rand1.nextInt(3);
    }

    void updateImage(int[] indeksi) {
        int broj=vratiRBrojZaPostOdgovora();;
        rndInt=indeksi[trenutniIndex % nizPitanja.length];
        detalji.setVisibility(View.GONE);
        trenutniIndex++;

        if(broj==0){
            dugme1.setText(nizPitanja[rndInt].getTacan_odgovor());
            slikeZastava.setImageResource(nizPitanja[rndInt].getIndex());
            int pomocna = rand.nextInt(nizPitanja.length);
            while (pomocna == rndInt) {
                pomocna = rand.nextInt(nizPitanja.length);
            }
            dugme2.setText(nizPitanja[pomocna].getTacan_odgovor());

            int pomocna1 = rand.nextInt(nizPitanja.length);
            while (pomocna1 == rndInt|| pomocna == pomocna1) {
                pomocna1 = rand.nextInt(nizPitanja.length);
            }
            dugme3.setText(nizPitanja[pomocna1].getTacan_odgovor());
        }
        else if(broj==1){
            dugme2.setText(nizPitanja[rndInt].getTacan_odgovor());
            slikeZastava.setImageResource(nizPitanja[rndInt].getIndex());
            int pomocna = rand.nextInt(nizPitanja.length);
            while (pomocna == rndInt) {
                pomocna = rand.nextInt(nizPitanja.length);
            }
            dugme1.setText(nizPitanja[pomocna].getTacan_odgovor());

            int pomocna1 = rand.nextInt(nizPitanja.length);
            while (pomocna1 == rndInt || pomocna == pomocna1) {
                pomocna1 = rand.nextInt(nizPitanja.length);
            }
            dugme3.setText(nizPitanja[pomocna1].getTacan_odgovor());
        }
        else if(broj==2){
            dugme3.setText(nizPitanja[rndInt].getTacan_odgovor());
            slikeZastava.setImageResource(nizPitanja[rndInt].getIndex());
            int pomocna = rand.nextInt(nizPitanja.length);
            while (pomocna == rndInt) {
                pomocna = rand.nextInt(nizPitanja.length);
            }
            dugme2.setText(nizPitanja[pomocna].getTacan_odgovor());

            int pomocna1 = rand.nextInt(nizPitanja.length);
            while (pomocna1 == rndInt || pomocna == pomocna1) {
                pomocna1 = rand.nextInt(nizPitanja.length);
            }
            dugme1.setText(nizPitanja[pomocna1].getTacan_odgovor());
        }
    }

    void provjeriOdgovor(Button b1) {
        String s2 = new String(nizPitanja[rndInt].getTacan_odgovor());
        String s1 = new String(b1.getText().toString());
        if (s1.equals(s2)) {
            Toast.makeText(this, "Tačno", Toast.LENGTH_SHORT).show();
            detalji.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Netačno", Toast.LENGTH_SHORT).show();
        }
    }

    void shuffleArray(int[] ar){
        for (int i=ar.length-1;i>0;i--){
            int index=rand.nextInt(i+1);
            int a=ar[index];
            ar[index]=ar[i];
            ar[i]=a;
        }
    }



}
