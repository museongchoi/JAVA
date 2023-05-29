package JavaLec_0509;

public class SSGMain {
    public static void main(String[] args) {

        int maxItem = 10;   // item number...
        ShoppingCart sc = new ShoppingCart(5);

        sc.addItem("스파클 생수", 1000, 5);
        sc.addItem("제로콜라", 1500, 3);
        sc.addItem("우유", 500, 1);
        sc.addItem("사이다", 2000, 4);
        sc.addItem("라면", 1300, 2);
        sc.addItem("커피", 3000, 3);



        String temp = sc.printItem();
        System.out.println(temp);
        // 위 아래 코드 동일
        //System.out.println(sc.printItem());
    }
}
