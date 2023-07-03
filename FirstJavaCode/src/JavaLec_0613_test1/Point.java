package JavaLec_0613_test1;

public class Point {
    private double x_coordinate;
    private double y_coordinate;

    public Point() {
    }

    public Point(double xval, double yval) {
        x_coordinate = xval;
        y_coordinate = yval;
    }

    public double getX() {
        return x_coordinate;
    }

    public double getY() {
        return y_coordinate;
    }

    public void setX(double xval) {
        x_coordinate = xval;
    }

    public void setY(double yval) {
        y_coordinate = yval;
    }

    public void printPoint() {
        System.out.println("좌표 = [" + x_coordinate + ", " + y_coordinate + "]");
    }
}
