package com.example.smartphonetopik7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smartphonetopik7.model.Lis;
import com.google.android.material.textfield.TextInputLayout;

public class FormSmartphone extends AppCompatActivity {
    Button btnSimpan;
    TextInputLayout til_spec, til_hrg, til_md;
    Spinner spnbrand;
    final String[] tipeLis = {Lis.APPLE, Lis.SAMSUNG, Lis.VIVO, Lis.OPPO, Lis.XIOMI};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formsmartphone);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        til_spec = findViewById(R.id.til_spec);
        til_hrg = findViewById(R.id.til_hrg);
        til_md = findViewById(R.id.til_md);
        spnbrand = findViewById(R.id.spn_brand);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipeLis
        );
        spnbrand.setAdapter(adapter);
        spnbrand.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            Lis tr = new Lis();
            tr.setSpesifikasi(til_spec.getEditText().getText().toString());
            tr.setHarga(til_hrg.getEditText().getText().toString());
            tr.setModel(til_md.getEditText().getText().toString());
            tr.setBrand(spnbrand.getSelectedItem().toString());
            SharedPreferences.addLis(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);


        }
    }

    private boolean isDataValid() {
        if (til_spec.getEditText().getText().toString().isEmpty() || til_hrg.getEditText().getText().toString().isEmpty() || til_md.getEditText().getText().toString().isEmpty() || spnbrand.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}