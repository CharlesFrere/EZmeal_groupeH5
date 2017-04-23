package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by elthe on 22-04-17.
 */

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String adremail = getIntent().getStringExtra("adremail"); //on choppe le username qui vient de l'activité précédente

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(adremail);
    }
}
