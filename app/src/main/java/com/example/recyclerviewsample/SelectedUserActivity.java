package com.example.recyclerviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvUser;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);

        tvUser  = findViewById(R.id.selectedUser);
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
        }

    }
}