package com.nuedevlop.submission1aplikasimoviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }

    MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View itemView = convertView;
       if (itemView==null){
           itemView = LayoutInflater.from(context).inflate(R.layout.list_movie,parent,false);
       }
       ViewHolder viewHolder = new ViewHolder(itemView);
       Movie movie =(Movie) getItem(position);
       viewHolder.bind(movie);
       return itemView;

    }

    private class ViewHolder {
        private TextView txtJudul,txtTanggal,txtKeterangan;
        private ImageView gbrPoster;

        ViewHolder(View view) {
            txtJudul = view.findViewById(R.id.txtListMovieJudul);
            txtTanggal = view.findViewById(R.id.txtListMovieTgl);
            txtKeterangan= view.findViewById(R.id.txtListMovieKet);
            gbrPoster = view.findViewById(R.id.gbrListMoviePriview);
        }

        void bind(Movie movie) {
            gbrPoster.setImageResource(movie.getPoster());
            txtJudul.setText(movie.getJudul());
            txtKeterangan.setText(movie.getKeterangan());
            txtTanggal.setText(movie.getTanggal());
        }
    }

}
