package DBConn;

import java.sql.*;
import java.util.ArrayList;

public class DBConnOnConcole {
    static Connection con = null;
    static String myTableName = "bookTable_201958142";

    public static void main(String[] args) {
        con = makeConnection();     //1단계 : db 연결
        dropTable(myTableName);
        createTable(myTableName);       //2단계 : db 안에 내 Table 생성
//        String title = "Java Prog";
//        String publisher = "Hanshin";
//        String year = "2022";
//        int price = 30000;
        //3단계 : db 테이블에 레코 입력(insert)
        insertDataIntoTable(con, myTableName, "Java Prog", "Hanshin", "2021", 20000);
        insertDataIntoTable(con, myTableName, "자바_최무성", "최무성출판사", "2022", 20000);

        insertDataIntoTable2(con, myTableName, "파이썬", "Hanshin", "2021", 10000);
        insertDataIntoTable2(con, myTableName, "자바_홍길동", "홍길동출판사", "2020", 10000);
        insertDataIntoTable2(con, myTableName, "자바_이순신", "이순신출판사", "2022", 20000);
        // 4단계 : db Table에 저장된 레코드 내용 읽어옴(select)
        ArrayList<String> list = getDataFromTable(con, myTableName);
        // 5단계 : 읽어온 내용을 콘솔에 출
        PrintList(list);
    }

    static void PrintList(ArrayList<String> list) {
        for(String value : list) {
            System.out.println(value);
        }
    }

    static ArrayList<String> getDataFromTable(Connection con, String myTableName) {
        String selectDataSQL = "SELECT * FROM " + myTableName + "; ";
        ArrayList<String> resultList = new ArrayList<String>();

        try {
            PreparedStatement pstmt = con.prepareStatement(selectDataSQL);
            ResultSet result = pstmt.executeQuery(selectDataSQL);

            while(result.next()) {
//				System.out.println("제목: " + result.getString("title"));
//				System.out.println("출판사: " + result.getString("publisher"));
//				System.out.println("출판연도: " + result.getString("year"));
//				System.out.println("금액: " + result.getString("price"));
                resultList.add("제목: " + result.getString("title") + "\t" +
                                "출판사: "  + result.getString("publisher") + "\t" +
                                "연도: " + result.getString("year") + "\t" +
                                "금액: " + result.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static void insertDataIntoTable(Connection con, String myTableName, String title, String publisher, String year, int price) {
            String insertDataSQL = "INSERT INTO " + myTableName +
                                    " (title, publisher, year, price) " +
                                    "VALUES " + " ('" + title + "', '" + publisher +"', '" + year + "', " + price + ");" ;

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);
            pstmt.executeUpdate();
            System.out.println("Insert Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Data Error!!!");
        }
    }

    static void insertDataIntoTable2(Connection con, String myTableName, String title, String publisher, String year, int price) {
        String insertDataSQL = "INSERT INTO " + myTableName +
                                " (title, publisher, year, price) VALUES(?,?,?,?);";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            pstmt.setString(1, title);
            pstmt.setString(2, publisher);
            pstmt.setString(3, year);
            pstmt.setInt(4, price);

            pstmt.executeUpdate();
            System.out.println("Insert Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Data Error!!!");
        }
    }

    public static void insertDataIntoTable3(Connection con, String myTableName, String title, String publisher, String year,
                                            int price) {
        // TODO Auto-generated method stub

        String insertDataSQL = "INSERT INTO " + myTableName + " (title, publisher, year, price) VALUES(?,?,?,?);";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            pstmt.setString(1, title);
            pstmt.setString(2, publisher);
            pstmt.setString(3, year);
            pstmt.setInt(4, price);

            pstmt.executeUpdate();
            System.out.println("Insert Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Data Error!!!");
        }
    }

    static void deleteDataFromTable(Connection con, String myTableName, String book_id) {
        String deleteDataSQL = "DELETE FROM " + myTableName + " WHERE book_id = ? ;";

        try {
            PreparedStatement pstmt = con.prepareStatement(deleteDataSQL);
            pstmt.setString(1, book_id);
            pstmt.executeUpdate();
            System.out.println("GUI : Delete Data OK!!!");
        } catch (SQLException e) {
            System.out.println("GUI : Delete Data Error!!!");
        }
    }

    // 내림차순으로 정렬 = 풩션으로 만들면 값이 반영이 되지 않기 때문에 BookDBGUI 에서 result로 바로 반영한다
//    static void sortingDataFromTable(Connection con, String myTableName, String field) {
//        String sortingDataSQL = "SELECT  * FROM " + myTableName + " ORDER BY ? DESC ;";
//
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sortingDataSQL);
//            pstmt.setString(1, field);
//            pstmt.execute();
//            System.out.println("GUI : Sorting Data OK!!!");
//        } catch (SQLException e) {
//            System.out.println("GUI : Sorting Data Error!!!");
//        }
//    }

    static void createTable(String myTableName) {
        String createTableSQL = "CREATE TABLE if not exists " + myTableName + " (" +
                                "book_id INT NOT NULL auto_increment," +
                                "title VARCHAR(30)," +
                                "publisher VARCHAR(20)," +
                                "year VARCHAR(5)," +
                                "price INT," +
                                "PRIMARY Key(book_id) ) default charset=utf8;";

        try {
            PreparedStatement pstmt = con.prepareStatement(createTableSQL);
            System.out.println("Create Table SQL OK!!!");
            pstmt.execute();
            System.out.println("Create Table " + myTableName +" OK!!!");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Create Table SQL Error!!!");
        }
    }

    static void dropTable(String myTableName) {
        String dropTableSQL = "DROP TABLE if exists " + myTableName + ";";

        PreparedStatement pstmt;

        try {
            pstmt = con.prepareStatement(dropTableSQL);
            System.out.println("Drop Table SQL OK!!!");
            pstmt.execute();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Drop Table SQL Error!!!");
        }
    }

    public static Connection makeConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String hostName = "sql6.freemysqlhosting.net";
        String databaseName = "sql6440389";  // 수정
        String utf8Connection = "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul";

        String url = "jdbc:mysql://"+hostName+":3306/"+databaseName + utf8Connection;
        String userName = "sql6440389";   // 수정
        String password = "NCxKw5xvyv";   // 수정

        // B반 : databaseName : sql6440389
        // B반 : UserName : sql6440389
        // B반 : Password : NCxKw5xvyv

        try {
            Class.forName(driver);
            System.out.println("JDBC Driver Loading OK!!!");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("MySQL Connection OK!!!");
            return con;
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("JDBC Driver Loading Error!!!");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("MySQL Connection Error!!!");
        }
        return null;
    }
}
