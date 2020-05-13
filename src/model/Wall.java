package model;

import model.Entity;
import model.Location;

public class Wall extends Entity {


    public Wall(Location loc, int id) {
        super(loc, id);
    }


    @Override
    public String toString() {
        return "Wall{}";
    }
}