package CMS_201958142_04_25;

public class BookST {
    public String title; // 책 이름
    public String author; // 책 저자
    public int price; // 가격

    public BookST() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BookST(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
