package com.zeroeur.ltmapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luca on 17/02/2017.
 */

public class BusinessCardActivity extends Activity {

    Intent intent;
    String businessCardName;
    int businessCardPosition;
    TextView businessCardNameTv;
    EditText businessCardNameEt;
    Button businessCardOkBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_card);
        intent = getIntent();
        businessCardNameTv = (TextView) findViewById(R.id.business_card_name_tv);
        businessCardNameEt = (EditText) findViewById(R.id.business_card_name_et);
        businessCardOkBtn = (Button) findViewById(R.id.business_card_ok_btn);
        businessCardName = intent.getStringExtra(BusinessCardAdapter.NAME_KEY);
        businessCardPosition = intent.getIntExtra(BusinessCardAdapter.POSITION_KEY,0);
        businessCardNameTv.setText(businessCardName);
        businessCardNameEt.setText(businessCardName);
        businessCardNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                businessCardNameTv.setText(charSequence);

                if (charSequence.length() >= 18) {
                    Toast.makeText(BusinessCardActivity.this, "Name Too Long", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        businessCardOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(businessCardNameTv.length()!=0){
                    intent.putExtra(BusinessCardAdapter.NAME_KEY,businessCardNameTv.getText().toString());
                    intent.putExtra(BusinessCardAdapter.POSITION_KEY,businessCardPosition);
                    BusinessCardActivity.this.setResult(0,intent);
                    BusinessCardActivity.this.finish();
                }
            }
        });


    }
}
