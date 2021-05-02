package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {

    TextView txtNama, txtTelpon;
    String id, nm, tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        txtNama = findViewById(R.id.txtNama);
        txtTelpon = findViewById(R.id.txtNomorTelepon);

        id = getIntent().getStringExtra("ID");
        nm = getIntent().getStringExtra("Nama");
        tlp = getIntent().getStringExtra("Telpon");

        txtNama.setText(nm);
        txtTelpon.setText(tlp);
    }
}