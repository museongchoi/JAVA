package JavaLec_0613_test1;

public class Circle extends Point{
    private double radius;

    public Circle() {
    }

    public Circle(double xval, double yval, double red) {
        super(xval, yval);
        radius = red;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void printCircle() {
        System.out.println("원의 중심 = [" + getX() + ", " + getY() + "], 반지름 = " + radius);
    }
}
