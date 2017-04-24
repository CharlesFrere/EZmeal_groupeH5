package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by elthe on 24-04-17.
 */

public class Compte extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);
    }


    public void onBtnClick(View v) {
        if (v.getId() == R.id.bMenu) {
            Intent gh = new Intent(Compte.this, Display.class); //changement d'activity
            startActivity(gh);
        }
    }
}
