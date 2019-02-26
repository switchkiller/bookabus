package com.develop.everest.bookabus;

public class Bus {
    private int id;
    private String Source;
    private String Destination;
    private String Name;
    private String Departure;
    private double price;
    public Bus(int id, String Source, String Destination, String Name, String Departure, Double price) {
        this.id = id;
        this.Source = Source;
        this.Destination = Destination;
        this.Name = Name;
        this.price = price;
        this.Departure = Departure;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public String getName() {
        return Name;
    }

    public String getDeparture() {
        return Departure;
    }

    public double getprice() {
        return price;
    }
}