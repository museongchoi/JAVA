package JavaLec_06_05_Test2;

public class ShoppingCart {
    int itemCount;
    int totalPrice;
    Item[] cart;
    int capacity = 10;

    int cnt = 0;

    // 생성자 두번
    public ShoppingCart() {
        cart = new Item[capacity];
        for(int i = 0; i < cart.length; i++)
        {
            cart[i] = new Item();
        }
    }

    public void addToCart(String itemName, int itemPrice, int itemQuantity) {
        cart[cnt].setName(itemName);
        cart[cnt].setPrice(itemPrice);
        cart[cnt].setQuantity(itemQuantity);

        cnt++;
    }

    public int getTotalPrice() {
        int sum = 0;
        for(int i = 0; i < cnt; i++) {
            sum += cart[i].getPrice() * cart[i].getQuantity();
        }
        return sum;
    }

    public String toString() {
        String msg = "상품\t\t가격\t수량\t총액\n";
        for(int i = 0; i < cnt; i++)
        {
            msg += cart[i].getName() + "\t\t" + cart[i].getPrice() + "\t" + cart[i].getQuantity()
                    + "\t" +cart[i].getPrice()*cart[i].getQuantity() + "\n";
        }
        return "\n장바구니\n\n" + msg + "\n" + "총 구매금액: " + getTotalPrice() + "\n";
    }
}
