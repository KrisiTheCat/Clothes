package bg.smg;

public class Apartment implements Comparable{
    private String city;
    private int rooms;
    private int area;
    private int price;
    private String phone;

    public Apartment() {
        this.city = "";
        this.rooms = 0;
        this.area = 0;
        this.price = 0;
        this.phone = "";
    }
    public Apartment(String city, int rooms, int area, int price, String phone) {
        this.city = city;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object o) {
        if(price == ((Apartment)o).getPrice())
            return area - ((Apartment)o).getArea();
        return price - ((Apartment)o).getPrice();
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "city='" + city + '\'' +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", phone='" + phone + '\'' +
                '}';
    }
}