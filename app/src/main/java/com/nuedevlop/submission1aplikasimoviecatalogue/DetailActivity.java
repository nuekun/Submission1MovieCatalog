package com.nuedevlop.submission1aplikasimoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    int poster;
    String judul,budget,tanggal,keterangan,durasi;

    TextView txtJudul,txtKeterangan,txtTanggal,txtDurasi,txtBudget;
    ImageView gbrPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        poster = getIntent().getIntExtra("poster", 0);
        judul = getIntent().getStringExtra("judul");
        budget = getIntent().getStringExtra("budget");
        tanggal = getIntent().getStringExtra("tanggal");
        keterangan = getIntent().getStringExtra("keterangan");
        durasi = getIntent().getStringExtra("durasi");

        txtJudul = findViewById(R.id.txtDetailJudul);
        txtKeterangan = findViewById(R.id.txtDetailKeterangan);
        gbrPoster=findViewById(R.id.gbrDetailPoster);
        txtTanggal = findViewById(R.id.txtDetailTanggal);
        txtBudget = findViewById(R.id.txtDetailBudget);
        txtDurasi = findViewById(R.id.txtDetailDurasi);

        txtJudul.setText(judul);
        gbrPoster.setImageResource(poster);
        txtKeterangan.setText(keterangan);
        txtTanggal.setText(tanggal);
        txtDurasi.setText(durasi);
        txtBudget.setText(budget);


    }
}
