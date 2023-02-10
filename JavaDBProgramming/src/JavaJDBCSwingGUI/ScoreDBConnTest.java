package JavaJDBCSwingGUI;

import java.sql.*;
import java.util.ArrayList;

public class ScoreDBConnTest {
    static Connection con = null;
    static String ItemTable = "ItemTable_201958142";

    static void PrintList(ArrayList<String> list) {
        for(String value : list) {
            System.out.println(value);
        }
    }

    static ArrayList<String> getDataFromTable(Connection con, String ItemTable) {
        String selectDataSQL = "SELECT * FROM " + ItemTable + "; ";
        ArrayList<String> resultList = new ArrayList<String>();
        try {
            PreparedStatement pstmt = con.prepareStatement(selectDataSQL);
            ResultSet result = pstmt.executeQuery(selectDataSQL);

            while(result.next()) {
                resultList.add("메뉴: " + result.getString("menu") + "\t" +
                        "가격: "  + result.getInt("price") + "\t" +
                        "바코드: " + result.getString("ea") + "\t" +
                        "번호: "  + result.getInt("numb"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    static void insertDataIntoTable(Connection con, String ItemTable, String menu, int price, String ea, int numb) {
        String insertDataSQL = "INSERT INTO " + ItemTable +
                " (menu, price, ea, numb) VALUES(?,?,?,?);";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataSQL);

            pstmt.setString(1, menu);
            pstmt.setInt(2, price);
            pstmt.setString(3, ea);
            pstmt.setInt(4, numb);

            pstmt.executeUpdate();
            System.out.println("Insert Data OK!!!");
        } catch (SQLException e) {
            System.out.println("Insert Data Error!!!");
        }
    }

    static void deleteDataFromTable(Connection con, String ItemTable, String menu) {
        String deleteDataSQL = "DELETE FROM " + ItemTable + " WHERE menu = ? ;";

        try {
            PreparedStatement pstmt = con.prepareStatement(deleteDataSQL);
            pstmt.setString(1, menu);
            pstmt.executeUpdate();
            System.out.println("GUI : Delete Data OK!!!");
        } catch (SQLException e) {
            System.out.println("GUI : Delete Data Error!!!");
        }
    }

    static void dropTable(Connection con, String ItemTable) {
        String dropTableSQL = "DROP TABLE if exists " + ItemTable + ";";

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

    static void createMenuTable(Connection con, String ItemTable) {
        //NOT NULL auto_increment = std_id int 뒤에 없어도 된다
        String createTableSQL = "CREATE TABLE if not exists " + ItemTable + " (" +
                "menu VARCHAR(15)," +
                "price int," +
                "ea VARCHAR(20)," +
                "numb int," +
                "UNIQUE INDEX (menu), " +     // 중복 삽입 방지를 위해..중복 검사용 필드 추가
                "PRIMARY Key(menu) ) default charset=utf8;";

        try {
            PreparedStatement pstmt = con.prepareStatement(createTableSQL);
            System.out.println("Create Menu Table SQL OK!!!");
            pstmt.execute();
            System.out.println("Create Menu Table " + ItemTable +" OK!!!");
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
