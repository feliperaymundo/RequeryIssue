package com.example.felipe.requeryissue;

import android.app.Application;

import com.example.felipe.requeryissue.entities.Models;

import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.rx.RxSupport;
import io.requery.rx.SingleEntityStore;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;

/**
 * Created by felipe on 15/04/2016.
 */
public class RequeryIssueApplication extends Application {
    private SingleEntityStore<Persistable> dataStore;

    SingleEntityStore<Persistable> getData() {
        if (dataStore == null) {
            // override onUpgrade to handle migrating to a new version
            DatabaseSource source = new DatabaseSource(this, Models.DEFAULT, 1);
            source.setLoggingEnabled(true);
            Configuration configuration = source.getConfiguration();
            dataStore = RxSupport.toReactiveStore(
                    new EntityDataStore<Persistable>(configuration));
        }
        return dataStore;
    }
}
