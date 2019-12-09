package com.nuedevlop.submission1aplikasimoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] dataJudul,dataTanggal,dataKet,dataBudged,dataDurasi;
    TypedArray dataPoster;
    MovieAdapter adapter;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.mainListMovie);
        listView.setAdapter(adapter);

        prepare();

        addItem();




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int poster = movies.get(position).getPoster();
                String judul = movies.get(position).getJudul();
                String budget = movies.get(position).getBudget();
                String tanggal = movies.get(position).getTanggal();
                String keterangan = movies.get(position).getKeterangan();
                String durasi = movies.get(position).getDurasi();

                Intent intent = new Intent(MainActivity.this , DetailActivity.class);
                intent.putExtra("poster" , poster);
                intent.putExtra("judul" , judul);
                intent.putExtra("budget" , budget);
                intent.putExtra("tanggal" , tanggal);
                intent.putExtra("keterangan" , keterangan);
                intent.putExtra("durasi" , durasi);

                startActivity(intent);

            }
        });

    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0 ; i<dataJudul.length;i++){

            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setBudget(dataBudged[i]);
            movie.setTanggal(dataTanggal[i]);
            movie.setDurasi(dataDurasi[i]);
            movie.setJudul(dataJudul[i]);
            movie.setKeterangan(dataKet[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.judul);
        dataTanggal = getResources().getStringArray(R.array.tanggal);
        dataKet = getResources().getStringArray(R.array.keterangan);
        dataBudged = getResources().getStringArray(R.array.budget);
        dataDurasi = getResources().getStringArray(R.array.durasi);
        dataPoster = getResources().obtainTypedArray(R.array.poster);

    }
}
