package com.pk.example.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.pk.example.clientui.Profile;

import java.util.ArrayList;

@Entity(tableName = "profiles")
public class ProfileEntity extends Profile {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String _name;
    private ArrayList<String> _appsToBlock;
    private boolean _active;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    @Override
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Override
    public ArrayList<String> getAppsToBlock() {
        return _appsToBlock;
    }

    public void setAppsToBlock(ArrayList<String> appsToBlock) {
        this._appsToBlock = appsToBlock;
    }

    @Override
    public boolean getActive() {return _active;}

    public void setActive(boolean active) { this._active = active;}

    public ProfileEntity(){
    }

    public ProfileEntity(Profile profile){
        this._name = profile.getName();
        this._appsToBlock = profile.getAppsToBlock();
    }

}