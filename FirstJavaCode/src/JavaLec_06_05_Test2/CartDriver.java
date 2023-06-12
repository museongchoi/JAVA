package JavaLec_06_05_Test2;

import java.util.Scanner;

public class CartDriver {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String flag = "예";
        String itemName;
        int itemPrice;
        int itemQuantity;
        ShoppingCart scart = new ShoppingCart();

        while (flag.equals("예"))
        {
            System.out.print("구매하는 상품의 이름을 입력하세요: ");
            itemName = scan.next();
            System.out.print("구매하는 상품의 가격을 입력하세요: ");
            itemPrice = scan.nextInt();
            System.out.print("구매하는 상품의 수량을 입력하세요: ");
            itemQuantity = scan.nextInt();

            scart.addToCart(itemName, itemPrice, itemQuantity);
            
            // tostring 으로 재정의
            System.out.println(scart);


            if(scart.cnt != scart.capacity) {
                System.out.print("쇼핑을 계속 하시겠습니까(예 혹은 아니요): ");
                flag = scan.next();
            }
            else {
                flag = "아니요";
            }
        }

        System.out.println("\n결제하세요");
        System.out.println("총 결제액: " + scart.getTotalPrice());
    }
}
