package dev;

public class Bogie {
    private String name;
    private int capacity;
    private String type;
    private String cargo;

    public Bogie(String name, int capacity, String type, String cargo) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.cargo = cargo;
    }

    public Bogie(String name, int capacity) {
        this(name, capacity, name, "Passengers");
    }

    public Bogie(String type, String cargo) {
        this(type + " Bogie", 0, type, cargo);
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats) [" + type + " / " + cargo + "]";
    }
}
