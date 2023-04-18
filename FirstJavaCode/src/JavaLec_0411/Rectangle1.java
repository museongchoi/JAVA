package JavaLec_0411;

public class Rectangle1 {
    // 사각형 기본 속성
    int width;  // 가로
    int height; // 세로

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return this.getWidth() * this.getHeight();
    }

    public void display() {
        System.out.println("가로 길이 : " + this.width);
        System.out.println("세로 길이 : " + this.height);
        System.out.println("면적 : " + this.getArea());
    }
}
