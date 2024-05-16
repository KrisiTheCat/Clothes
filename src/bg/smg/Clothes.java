package bg.smg;

public class Clothes implements Comparable<Clothes>{
    private String name;
    private String type;
    private float price;

    public Clothes(String name, String type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\'" + name + '\'' +
                " (" + type + ')' +
                " $" + price;
    }

    @Override
    public int compareTo(Clothes o) {
        return Math.round(price - o.getPrice());
    }
}
