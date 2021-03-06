package sample;

public class Product {

    private String name;
    private double price;
    private int duration;

    public Product()
    {
        this.name = "";
        this.price = 0;
        this.duration = 0;

    }

    public Product(String name, double price, int duration)
    {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
