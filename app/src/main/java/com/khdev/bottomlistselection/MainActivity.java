package com.khdev.bottomlistselection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String[] arrayRelationship = {"GRANDFATHER", "GRANDMOTHER", "FATHER", "MOTHER", "HUSBAND", "WIFE", "SON", "DAUGHTER", "BROTHER", "SISTER", "N/A"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txt_bt_sheet).setOnClickListener(view -> {
            /*BottomSheetSelection chooseItemBSFragment = BottomSheetSelection.newInstance(arrayRelationship);
            chooseItemBSFragment.setOnMenuSelected(new BottomSheetSelection.OnMenuSelected() {
                @Override
                public void onSelected(int position) {

                    Log.d("item", "select " + arrayRelationship[position]);
                }
            });
            chooseItemBSFragment.show(getSupportFragmentManager(), BottomSheetSelection.TAG);*/
        });

    }
}