package com.example.carifilm;

import java.util.List;

public interface OnGetMoviesCallback {

    void onSuccess(List<Film> movies);

    void onError();
}