package com.example.carifilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView moviesList;
    private FilmAdapter adapter;

    private MoviesRepository moviesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRepository = MoviesRepository.getInstance();

        moviesList = findViewById(R.id.movies_list);
        moviesList.setLayoutManager(new LinearLayoutManager(this));

        moviesRepository.getMovies(new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Film> movies) {
                adapter = new FilmAdapter(movies);
                moviesList.setAdapter(adapter);
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}