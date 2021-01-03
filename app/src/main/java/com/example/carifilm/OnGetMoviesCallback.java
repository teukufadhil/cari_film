package com.example.carifilm;

import java.util.List;

public interface OnGetMoviesCallback {

    void onSuccess(int page, List<Film> movies);

    void onError();
}
