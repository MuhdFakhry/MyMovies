package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 15007803 on 24/7/2018.
 */

public class MovieDetailActivity extends AppCompatActivity {

    ImageView ivRating;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvDate;
    TextView tvTheatre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ivRating = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvDate = findViewById(R.id.textViewDate);
        tvTheatre = findViewById(R.id.textViewTheatre);

        Intent intentReceived = getIntent();

        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String date = intentReceived.getStringExtra("date");
        String theatre = intentReceived.getStringExtra("theatre");
        String rated = intentReceived.getStringExtra("rated");

        tvTitle.setText(title);
        tvYear.setText(year+" - ");
        tvGenre.setText(genre);

        tvDescription.setText("\n"+description+"\n");
        tvDate.setText("Watch on: "+ date);
        tvTheatre.setText("In Theatre: "+theatre+"\n");

        if(rated.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);

        }else if(rated.equalsIgnoreCase("pg")) {
            ivRating.setImageResource(R.drawable.rating_pg);

        }else if(rated.equalsIgnoreCase("pg13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);

        }else if(rated.equalsIgnoreCase("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);

        }else if(rated.equalsIgnoreCase("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);

        }else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }

    }
}
