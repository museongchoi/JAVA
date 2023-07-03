package JavaLec_0613_test1;

import java.awt.*;

public class FinalExA1 {
    public static void main(String[] args) {
        Point p = new Point(6.0, 10.0);
        Circle cir = new Circle(2.5, 3.0, 1.5);
        Cylinder cyl = new Cylinder(2.0, 3.0, 4.5, 6.5);

        System.out.print("점: ");
        p.printPoint();

        cir.printCircle();
        System.out.print("원의 면적 = ");
        System.out.println(cir.getArea());

        cyl.printCylinder();
        System.out.print("원기둥의 부피 = ");
        System.out.println(cyl.calculateVolume());
        System.out.print("원기둥의 표면적 = ");
        System.out.println(cyl.calculateSurfaceArea());
    }
}
