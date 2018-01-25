package com.example.user.kvizzastave;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String EXTRA="com.example.user.kvizzastave";
    private TextView detaljiTextView;
    private TextView linkTextView;

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

    String[]  nizLinkova = new String[]{"Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Austrija >Austrija</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Bosna_i_Hercegovina>Bosna i Hercegovina</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Belgija>Belgija</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Italija>Italija</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Njema%C4%8Dka>Njemačka</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Danska>Danska</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Finska>Finska</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Portugal>Portugal</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/%C5%A0vedska>Švedska</a>",
                                        "Detaljnije na sljedećem linku: <a href=https://bs.wikipedia.org/wiki/Turska>Turska</a>"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int trenutniIndex=getIntent().getIntExtra("EXTRA", 0);
        detaljiTextView = (TextView) findViewById(R.id.detalji_text_view);

        detaljiTextView.setText(nizPitanja[trenutniIndex].getDetalji());

        linkTextView = (TextView) findViewById(R.id.link_text_view);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setText(Html.fromHtml(nizLinkova[trenutniIndex]));


    }
}







