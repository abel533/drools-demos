package com.github.abel533.drools.xls;

public class Ticket {
    private String destination;
    private String cabin;
    private double duration;
    private boolean food;
    private boolean movie;

    public Ticket() {
    }

    public Ticket(String destination) {
        this.destination = destination;
    }

    public Ticket(String destination, String cabin) {
        this.destination = destination;
        this.cabin = cabin;
    }

    public Ticket(String destination, String cabin, double duration) {
        this.destination = destination;
        this.cabin = cabin;
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isMovie() {
        return movie;
    }

    public void setMovie(boolean movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "destination='" + destination + '\'' +
                ", cabin='" + cabin + '\'' +
                ", duration=" + duration +
                ", food=" + food +
                ", movie=" + movie +
                '}';
    }
}
