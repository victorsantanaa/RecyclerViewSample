package com.example.recyclerviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvUser;
    TextView tvTpi;
    TextView tvSigla;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvUser  = findViewById(R.id.selectedUser);
        tvTpi = findViewById(R.id.selectedTPI);
        tvSigla = findViewById(R.id.selectedSigla);
        backButton = findViewById(R.id.backbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            UserModel userModel = (UserModel) intent.getSerializableExtra("data" );

            tvUser.setText(userModel.getUserName());
            tvTpi.setText(userModel.getTpi());
            tvSigla.setText(userModel.getSigla());
        }

    }
}