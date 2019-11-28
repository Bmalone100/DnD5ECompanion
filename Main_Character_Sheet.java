package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main_Character_Sheet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__character__sheet);

        TextView STR_MOD = (TextView) findViewById(STR_mod_view);
        TextView DEX_MOD = (TextView) findViewById(DEX_mod_view);
        TextView CON_MOD = (TextView) findViewById(CON_mod_view);
        TextView INT_MOD = (TextView) findViewById(INT_mod_view);
        TextView WIS_MOD = (TextView) findViewById(WIS_mod_view);
        TextView CHA_MOD = (TextView) findViewById(CHA_mod_view);

        TextView STR = (TextView) findViewById(STR_view);
        TextView DEX = (TextView) findViewById(DEX_view);
        TextView CON = (TextView) findViewById(CON_view);
        TextView INTEL = (TextView) findViewById(INT_view);
        TextView WIS = (TextView) findViewById(WIS_view);
        TextView CHA = (TextView) findViewById(CHA_view);

        /*
        STR.setText(Player.getStr());
        DEX.setText(Player.getDex());
        CON.setText(Player.getCon());
        INTEL.setText(Player.getInt());
        WIS.setText(Player.getWis());
        CHA.setText(Player.getCha());

        STR_MOD.setText(Player.getStrMod());
        DEX_MOD.setText(Player.getDexMod());
        CON_MOD.setText(Player.getConMod());
        INT_MOD.setText(Player.getIntMod());
        WIS_MOD.setText(Player.getWisMod());
        CHA_MOD.setText(Player.getChaMod());
         */
    }
}
