package com.example.mobilahptedarikcisecim;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

public class Search {


    public Menu SearchItem(Menu menu, MenuInflater inflater, final ArrayAdapter<String> adapter ){
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchview=(SearchView)item.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
              adapter.getFilter().filter(s);
                return false;
            }
        });

        return menu;
    }
}
