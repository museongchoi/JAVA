package JavaLec_0411;

public class Rect_3D extends Rectangle1 {
    // int width;  // 가로
    // int height; // 세로 를 상속 받음
    int lenght;
    
    public int getVolum() {
        // super 는 위쪽 상속받은곳을 말함
        return super.getArea() * this.lenght;
    }
}
