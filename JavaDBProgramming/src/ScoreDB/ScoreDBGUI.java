package ScoreDB;

import DBConn.DBConnOnConcole;
import com.mysql.cj.xdevapi.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class ScoreDBGUI extends JFrame implements ActionListener, MouseListener {
    private Connection con = null;
    static String myTableName = "scoreTable_201958142";
    static String myMenuTableName = "menuTable_201958142";

    private Vector header = new Vector(); // 반드시 설정 = fieldName 배열이 들어감
    private Vector data = new Vector(); // 반드시 설정 = 데이터들이 들어감
    private DefaultTableModel model;
    private JTable table;
    // model, table 은 아래 또 다시 생성하지 말 것, 다시 생성하게 되면 이름이 같은 새로운 로컬변수가 만들어짐 그것은 값이 없기 때문에 오류가 생김


    // 맨 하단 : 이름 총점 평균 최고점 최저점
    static String[] fieldName = {"학번", "학부", "이름", "국어", "영어", "수학"};
    JPanel southPanel = new JPanel(); // 왼쪽 패널 생성, 안쪽에 두면 로컬 변수가 되므로 전역으로 빼자

    // 왼쪽 하단 패널 제작 sorceDBGUI 맨 아래 쪽에 코드
    JLabel[] label = new JLabel[fieldName.length];  //맨 왼쪽 fieldName 생성
    JTextField[] tf = new JTextField[fieldName.length];
    int[] tfSize = {10,10,7,5,5,5}; // 각 size 설정

    // 버튼 패널 제작
    String[] btnText = {"삽입","삭제","수정","초기화"};
    JButton[] btn = new JButton[btnText.length];
    private PreparedStatement pstmt;
    private ResultSet result;

    // 추가...
    JButton[] menuBtn;

    public ScoreDBGUI() {
        this.setTitle("Score DB");
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        con = ScoreDBConn.makeConnection();

        // dropTable은 나중에는 삭제해야함!!!
//        ScoreDBConn.dropTable(con, myTableName);
//        ScoreDBConn.dropTable(con, myTableName);
        ScoreDBConn.createTable(con, myTableName);
        ScoreDBConn.createMenuTable(con, myMenuTableName);

        ScoreDBConn.insertDataIntoTable2(con, myTableName, "201958001", "컴공", "홍길동", 90,80,70);
        ScoreDBConn.insertDataIntoTable2(con, myTableName, "201958002", "컴공", "이순신", 91,81,71);
        ScoreDBConn.insertDataIntoTable2(con, myTableName, "201958003", "컴공", "강감찬", 92,82,72);
        ScoreDBConn.insertDataIntoTable2(con, myTableName, "201958004", "컴공", "홍길동", 93,83,73);

        ScoreDBConn.insertMenuIntoTable2(con, myMenuTableName, "콜라", 3000);
        ScoreDBConn.insertMenuIntoTable2(con, myMenuTableName, "사이다", 4000);
        ScoreDBConn.insertMenuIntoTable2(con, myMenuTableName, "커피", 5000);
        ScoreDBConn.insertMenuIntoTable2(con, myMenuTableName, "오렌지", 2000);

        ArrayList<String> list = ScoreDBConn.getDataFromTable(con,myTableName);
        ScoreDBConn.PrintList(list);

        // 테이블 값 개수와 header 개수 를 맞춰준다
        // header를 만들고 -> model에 넣고 -> data를 model에 세팅 -> model을 table에 집어넣고
        // -> table을 scrollpane에 집에 넣고 -> scrollpane을 this에 붙이는데 center에 붙인다.
        for(int i = 0; i<fieldName.length; i++) {
            header.add(fieldName[i]);
        }

        data = selectDB(con, myTableName); // 내가 지정한 테이블에 있는 값들을 가져오는 풩션

        // DefaultTableModel 안에 저장
        //DefaultTableModel model = new DefaultTableModel(header, 0);
        model = new DefaultTableModel(header, 0);   // DefaultTableModel model --> model 로 변경, 위에서 선언 했는데 밑에 서 사용 하면 또 다른 로컬 변수가 만들어지는 것이기 때문에 지운다
        model.setDataVector(data, header);	// 벡터형태로 자동으로 변환되는 동적 모델 setDataVector


        table = new JTable(model);	// model 을 갖는 table 에 스크롤 기능을 넣는다
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(this); // table에 관하여 마우스리스너를 붙인다
        this.add(scrollPane, BorderLayout.CENTER); // 센터에 스크롤 펜 생성

        // 서쪽 패널 제작
        southPanel.setLayout(new GridLayout(0,2)); // new 가 꼭 있어야함 / 0,2 west로 설정 하면 왼쪽에 붙는다
        // southPanel label, tf
        for(int i = 0; i<fieldName.length; i++) {
            label[i] = new JLabel(fieldName[i], JLabel.CENTER);
            tf[i] = new JTextField(tfSize[i]);
            southPanel.add(label[i]);   // southpanel의 label 이름
            southPanel.add(tf[i]);      // southpanel의 tf 는 클릭을 하면 들어오는 값들이 있음
        }

        // south panel에 삽입,삭제 등 버튼을 삽입 - addActionListener 추가(버튼을 눌렀을 때 동작 추가)
        for(int i = 0; i<btnText.length; i++) {
            btn[i] = new JButton(btnText[i]);
            btn[i].addActionListener(this);
            southPanel.add(btn[i]);
        }

        // 밑에 버튼을 또 만들어서 또 다른 menu테이블에서 정보를 가져와서 버튼 제작 및 삽입
        String menuSelectSQL = "SELECT * FROM " + myMenuTableName + " ;";
        try {
            pstmt = con.prepareStatement(menuSelectSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // 앞 뒤로 움직이기 위한 부분
            result = pstmt.executeQuery(menuSelectSQL);

            // Menu 수 만큼 동적으로 만드는 것
            int size = 0;
            if(result != null) {    //result 값이 null 이 아니면 라인번호가 1부터 result 값이 맨 뒤로 간다, 맨 뒤로 갔을 때의 row값 라인 수가 사이즈가 된다
                result.last();  // moves cursor to the last row
                size = result.getRow(); // get row id
            }

            result.first();
            menuBtn = new JButton[size]; // menu 버튼의 사이즈를 알고싶은 것 , 동적으로 사이즈 조절 위 Menu 수 만큼 통적으로 만드는 것으로 알 수 있다

            for(int i=0; i<menuBtn.length; i++) {
                menuBtn[i] = new JButton();
                menuBtn[i].setText(result.getString("menu") + " : " + result.getString("price"));   // 값을 가져와서 버튼에 세팅
                result.next(); // result 가 하나가 세팅이 되면 다음으로 넘어감
                southPanel.add(menuBtn[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.add(southPanel, BorderLayout.WEST);
        this.setVisible(true);
    }

    private Vector selectDB(Connection con, String myTableName) {
        data.clear();
        String selectSQL = "SELECT * FROM " + myTableName + ";";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(selectSQL);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                Vector<String> row = new Vector<String >();
                row.add(result.getString("std_id"));
                row.add(result.getString("dept"));
                row.add(result.getString("name"));
                row.add("" + result.getInt("kor"));
                row.add("" + result.getInt("eng"));
                row.add("" + result.getInt("math"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow();
        Vector<String> row = new Vector<String>();
        row = (Vector<String>) data.get(index);

        for(int i=0; i < tf.length; i++) {
            tf[i].setText(row.get(i));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn[0]) {   //insert
            // 값을 가져온다
            ScoreDBConn.insertDataIntoTable2(con, myTableName, tf[0].getText(), tf[1].getText(), tf[2].getText(), Integer.parseInt(tf[3].getText()), Integer.parseInt(tf[4].getText()), Integer.parseInt(tf[5].getText()));
        }
        if(e.getSource() == btn[1]) {   //delete
            ScoreDBConn.deleteDataFromTable(con, myTableName, tf[0].getText());
        }

        data = selectDB(con, myTableName);
        model.setDataVector(data, header);
    }
}
