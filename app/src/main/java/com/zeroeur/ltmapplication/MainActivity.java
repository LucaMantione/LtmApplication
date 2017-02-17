package com.zeroeur.ltmapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luca on 16/02/2017.
 */

public class MainActivity extends Activity  implements View.OnClickListener{

    TextView phoneNumberTv, addressTv, emailTv;
    ArrayList<BusinessCard> businessCards;
    Button callBtn, shareBtn;
    Intent intent;
    String email;
    static LinearLayout layout;

    // recyclerView items
    RecyclerView businessCardsRV;
    LinearLayoutManager layoutManager;
    BusinessCardAdapter adapter;

    //constants
    private static final String ELIS_ADDRESS = "via Sandro Sandri 71";
    private static final String LTM_COURSE = "LTM 11";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.main_layout);
        businessCards = new ArrayList<>();

        businessCardsRV = (RecyclerView) findViewById(R.id.business_cards_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BusinessCardAdapter(this);
        businessCardsRV.setLayoutManager(layoutManager);
        businessCardsRV.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0) {
            int position = data.getIntExtra(BusinessCardAdapter.POSITION_KEY, 0);
            String nome = data.getStringExtra(BusinessCardAdapter.NAME_KEY);
            BusinessCard bc = businessCards.get(position);
            bc.setName(nome);
            adapter.setBusinessCard(bc, position);
        }

    }


    private ArrayList<BusinessCard> getBusinessCards() {
        
        BusinessCard francescoBC = new BusinessCard("Francesco Cipolla", "francescocpll@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard matteoBC = new BusinessCard("Matteo Manfreda", "manfredamatteo44@gmail.com", "348974379", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard micheleBC = new BusinessCard("Michele Foderaro", "michele.foderaro@virgilio.it", "3891379123", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard domenicoBC = new BusinessCard("Domenico Licciardi", "licciardi.domenico98@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard gaetanoBC = new BusinessCard("Gaetano Ciccone", "gaetano.ciccone97@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);

        businessCards.add(francescoBC);
        businessCards.add(matteoBC);
        businessCards.add(micheleBC);
        businessCards.add(domenicoBC);
        businessCards.add(gaetanoBC);

        return businessCards;


    }



    @Override
    protected void onStart() {
        super.onStart();
        adapter.setDataSet(getBusinessCards());

    }

    @Override
    public void onClick(View view) {

    }
}
