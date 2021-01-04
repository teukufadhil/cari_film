package com.example.carifilm;

public interface OnGetMovieCallback {

    void onSuccess(Film movie);

    void onError();
}
