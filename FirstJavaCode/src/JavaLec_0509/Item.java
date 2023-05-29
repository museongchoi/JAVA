package JavaLec_0509;

class NewItem extends Item {
    public NewItem(String name, int price, int quantity) {
        super(name, price, quantity);
    }
}
// 상속을 막을 때는 final을 class 앞에 붙임

public class Item {
    String name;
    int price;
    int quantity;   // 개수

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // 각 아이템마다 형식대로 return
    public String getItemInfo() {
        return ("\n"+ this.name + "\t\t\t" + this.price + "\t\t\t" + this.quantity);
    }
}
