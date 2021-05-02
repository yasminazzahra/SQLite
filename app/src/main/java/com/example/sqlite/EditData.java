package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class EditData extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button simpanBtn;
    String nm, tlp, id;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        tNama = (TextInputEditText)findViewById(R.id.edNama);
        tTelpon = (TextInputEditText)findViewById(R.id.edTelpon);
        simpanBtn = (Button)findViewById(R.id.buttonSave);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nm");
        tlp = getIntent().getStringExtra("tlp");

        setTitle("EditData");
        tNama.setText(nm);
        tTelpon.setText(tlp);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data Belum Lengkap!", Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();
                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("id",id);
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);
                    controller.EditData(qvalues);
                    callHome();
                }
            }
        });

    }
    public void  callHome(){
        Intent intent = new Intent(EditData.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}