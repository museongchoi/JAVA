package JavaLec_0613_test1;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double x, double y, double radius, double h) {
        super(x, y, radius);
        height = h;
    }

    public double getHeight() {
        return height;
    }

    public double calculateSurfaceArea() {
        double baseArea = 2 * Math.PI * getRadius() * getRadius();
        double lateralArea = 2 * Math.PI * getRadius() * height;
        return baseArea + lateralArea;
    }

    public double calculateVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }

    public void printCylinder() {
        System.out.println("원의 중심 = [" + getX() + ", " + getY() + "], 반지름 = " + getRadius());
        System.out.println("원기둥의 높이 = " + height);
    }
}
