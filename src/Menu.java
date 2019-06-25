public class Menu {
    String name;
    int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return ""+name+" 가격 : "+price+"\n";
    }
}