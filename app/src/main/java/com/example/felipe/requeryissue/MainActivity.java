package com.example.felipe.requeryissue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.felipe.requeryissue.entities.User;

import io.requery.Persistable;
import io.requery.rx.SingleEntityStore;
import io.requery.sql.EntityDataStore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Just count how many users I have in database. Using the same
        //patter shown on Android Sample.
        SingleEntityStore<Persistable> dataStore = ((RequeryIssueApplication)getApplication()).getData();
        Toast.makeText(this, dataStore.count(User.class).get().value().toString(), Toast.LENGTH_LONG);
    }
}