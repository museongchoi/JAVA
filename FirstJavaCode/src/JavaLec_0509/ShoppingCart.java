package JavaLec_0509;

public class ShoppingCart {
    static int total = 0;  // 총 합... / 아이템에 상관없이 증가 / 클래스 안에서 유니크하게 하나만 있으면 된다.
    static int itemCount;  // 현재 카트에 담은 아이템의 개수...
    static int itemMaxNum; // 카트에 담을수 있는 아이템의 최대 개수...

    // 물건이 배열로 들어감, 담을수 있는 공간이 한정적
    Item[] item;

    // 위 타입들이 static 으로 변경되면 this 가 ShoppingCart로 다 변경 가능, int 로 타입이 변경되면 this로 변경
    public ShoppingCart(int i) {
        // 최개로 카트에 10개가 들어간다 가정
        ShoppingCart.itemMaxNum = i;
        ShoppingCart.itemCount = 0;

        item = new Item[ShoppingCart.itemMaxNum];   // 초기화 됬음
    }

    public void addItem(String name, int price, int quantity) {
        if(ShoppingCart.itemCount < ShoppingCart.itemMaxNum)    // 아이템 카운트가 10개보다 작으면
        {
            item[itemCount] = new Item(name, price, quantity);  // additem을 할때 마다 new
            ShoppingCart.itemCount++;   // 0,1,2에 값을 넣고 카운트가 3이된다.
            total += price * quantity;
        } else {
            System.out.println("카트에 " + name + "아이템 추가 불가!!!");
        }
    }

    public String printItem() {
        String contents = "카트 목록";
        contents += "\n상품명\t\t\t단가\t\t\t수량\n";
        for(int i = 0; i < ShoppingCart.itemCount; i++)
        {
            contents += item[i].getItemInfo();  // 한줄만 리턴
        }
        contents += "\n합계 : " + total + "원\n";

        return contents;
    }
}
