package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMoviesList;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.listViewMovies);

        alMoviesList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);

        Movie movie1 = new Movie("The Avengers", "2012", "pg13", "Action | Sci-Fi", date1,"Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movie movie2 = new Movie("Planes", "2013", "pg", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMoviesList.add(movie1);
        alMoviesList.add(movie2);

        caMovies = new CustomAdapter(this, R.layout.movies_item, alMoviesList);

        lvMovies.setAdapter(caMovies);


        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(), MovieDetailActivity.class);
                Movie currentMovie = alMoviesList.get(i);

                intent.putExtra("title", currentMovie.getTitle());
                intent.putExtra("year", currentMovie.getYear());
                intent.putExtra("rated", currentMovie.getRated());
                intent.putExtra("genre", currentMovie.getGenre());
                intent.putExtra("description", currentMovie.getDescription());
                intent.putExtra("date", currentMovie.getDateString());
                intent.putExtra("theatre", currentMovie.getIn_theatre());


                startActivity(intent);
            }
        });


    }
}
