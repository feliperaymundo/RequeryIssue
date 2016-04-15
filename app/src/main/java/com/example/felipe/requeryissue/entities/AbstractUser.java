package com.example.felipe.requeryissue.entities;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;

/**
 * Created by felipe on 15/04/2016.
 */
@Entity
public abstract class AbstractUser {
    @Key @Generated
    public int id;
    public String name;
}