package com.github.abel533.drools.firealarm;

public class Sprinkler {
    private Room room;
    private boolean on;

    public Sprinkler(Room room) {
        this.room = room;
    }

    public Sprinkler() {

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
