package ScoreDB;

import java.sql.*;
import java.util.ArrayList;

public class ScoreDBConn {

    static Connection con = null;
    static String myTableName = "scoreTable_201958142";
    //static String myMenuTableName = "menuTable_201958142";

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
                resultList.add("학번: " + result.getString("std_id") + "\t" +
                        "학부: "  + result.getString("dept") + "\t" +
                        "이름: " + result.getString("name") + "\t" +
                        "국어: " + result.getInt("kor") + "\t" +
                        "영어: " + result.getInt("eng") + "\t" +
                        "수학: " + result.getInt("math") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    static void insertDataIntoTable2(Connection con, String myTableName, String std_id, String dept, String name, int kor, int eng, int math) {
        String insertDataSQL = "INSERT INTO " + myTableName +
                " (std_id, dept, name, kor, eng, math) VALUES(?,?,?,?,?,?);";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            pstmt.setString(1, std_id);
            pstmt.setString(2, dept);
            pstmt.setString(3, name);
            pstmt.setInt(4, kor);
            pstmt.setInt(5, eng);
            pstmt.setInt(6, math);

            pstmt.executeUpdate();
            System.out.println("Insert Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Data Error!!!");
        }
    }

    static void insertMenuIntoTable2(Connection con, String myMenuTableName, String menu, int price) {
        String insertDataSQL = "INSERT INTO " + myMenuTableName +
                " (menu, price) VALUES(?,?);";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            pstmt.setString(1, menu);
            pstmt.setInt(2, price);

            pstmt.executeUpdate();
            System.out.println("Insert Menu Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Menu Data Error!!!");
        }
    }

    static void deleteDataFromTable(Connection con, String myTableName, String std_id) {
        String deleteDataSQL = "DELETE FROM " + myTableName + " WHERE std_id = ? ;";

        try {
            PreparedStatement pstmt = con.prepareStatement(deleteDataSQL);
            pstmt.setString(1, std_id);
            pstmt.executeUpdate();
            System.out.println("GUI : Delete Data OK!!!");
        } catch (SQLException e) {
            System.out.println("GUI : Delete Data Error!!!");
        }
    }

    static void dropTable(Connection con, String myTableName) {
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

    static void createTable(Connection con, String myTableName) {
        //NOT NULL auto_increment = std_id int 뒤에 없어도 된다
        String createTableSQL = "CREATE TABLE if not exists " + myTableName + " (" +
                "std_id INT," +
                "dept VARCHAR(15)," +
                "name VARCHAR(15)," +
                "kor INT," +
                "eng INT," +
                "math INT," +
                "UNIQUE INDEX (std_id), " +     // 중복 삽입 방지를 위해..중복 검사용 필드 추가
                "PRIMARY Key(std_id) ) default charset=utf8;";

        try {
            PreparedStatement pstmt = con.prepareStatement(createTableSQL);
            System.out.println("Create Table SQL OK!!!");
            pstmt.execute();
            System.out.println("Create Table " + myTableName + " OK!!!");
        } catch (SQLException e) {
            System.out.println("Create Table SQL Error!!!");
        }
    }

    static void createMenuTable(Connection con, String myMenuTableName) {
        //NOT NULL auto_increment = std_id int 뒤에 없어도 된다
        String createTableSQL = "CREATE TABLE if not exists " + myMenuTableName + " (" +
                "menu VARCHAR(15)," +
                "price INT," +
                "UNIQUE INDEX (menu), " +     // 중복 삽입 방지를 위해..중복 검사용 필드 추가
                "PRIMARY Key(menu) ) default charset=utf8;";

        try {
            PreparedStatement pstmt = con.prepareStatement(createTableSQL);
            System.out.println("Create Menu Table SQL OK!!!");
            pstmt.execute();
            System.out.println("Create Menu Table " + myMenuTableName +" OK!!!");
        } catch (SQLException e) {
            System.out.println("Create Menu Table SQL Error!!!");
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
            Class.forName(driver);  //JDBC connector driver loading?
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
