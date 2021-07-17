package com.example.flixpartonedebug.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    private int movieId;
    private String title;
    private String overview;
    private String posterPath;
    private double rating;
    private static final String TAG = "Movie";
    private static final String posterPathStatic = "https://image.tmdb.org/t/p/w342%s";

    // Empty constructor for Parceler library
    public Movie() {}

    // basic constructor
    public Movie(JSONObject jsonObject) throws JSONException {
        setTitle(jsonObject.getString("title"));
        setOverview(jsonObject.getString("overview"));
        setPosterPath(jsonObject.getString("poster_path"));
        setRating(jsonObject.getDouble("vote_average"));
        setMovieId(jsonObject.getInt("id"));
    }


    // So we can take TMDB JsonArrays and return them as List<movie> objects
    static public List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Movie> ReturnMovies = new ArrayList<>();

        // call the movie constructor for all movies in our jsonArray
        for (int i = 0; i < jsonArray.length(); i++) {
            ReturnMovies.add(new Movie(jsonArray.getJSONObject(i)));
            Log.d(TAG, String.format(posterPathStatic, ReturnMovies.get(i).posterPath));
        }

        return ReturnMovies;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return String.format(posterPathStatic, posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
