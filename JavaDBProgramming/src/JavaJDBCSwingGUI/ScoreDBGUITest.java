package JavaJDBCSwingGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ScoreDBGUITest extends JFrame implements ActionListener, MouseListener {
    static Connection con = null;
    static String ItemTable = "ItemTable_201958142";

    private Vector header = new Vector();
    private Vector data = new Vector();
    private DefaultTableModel model;
    private JTable table;

    // 맨 하단 : 이름 총점 평균 최고점 최저점
    static String[] fieldName = {"메뉴", "가격", "바코드", "개수"};
    JPanel southPanel = new JPanel();   // label, tf, menubtn 가 southpanel
    // 왼쪽 하단 패널 제작 sorceDBGUI 맨 아래 쪽에 코드
    JLabel[] label = new JLabel[fieldName.length]; //맨 왼쪽 fieldName 생성
    JTextField[] tf = new JTextField[fieldName.length];
    int[] tfSize = {10,10,7,5,5,5}; // 각 size 설정
    String[] btnText = {"추가", "삭제", "수정", "clear", "POS 실행", "개발자"};
    JButton[] btn = new JButton[btnText.length];


    private PreparedStatement pstmt;
    private ResultSet result;

    public ScoreDBGUITest() {
        this.setTitle("POS : Item Manager!!! 201958142 컴퓨터공학부 최무성");
        this.setSize(700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        con = ScoreDBConnTest.makeConnection();
        //ScoreDBConnTest.dropTable(con, ItemTable);
        ScoreDBConnTest.createMenuTable(con, ItemTable);

        ScoreDBConnTest.insertDataIntoTable(con, ItemTable, "피자", 5000, "01234512345",1);
        ScoreDBConnTest.insertDataIntoTable(con, ItemTable, "계란", 2000, "02123412345",1);
        ScoreDBConnTest.insertDataIntoTable(con, ItemTable, "콜라", 1000, "03123412345",1);
        ScoreDBConnTest.insertDataIntoTable(con, ItemTable, "닭가슴살", 3000, "04123412345",1);
        ScoreDBConnTest.insertDataIntoTable(con, ItemTable, "최무성", 7777, "00201958142",1);

        ArrayList<String> list = ScoreDBConnTest.getDataFromTable(con, ItemTable);
        ScoreDBConnTest.PrintList(list);

        // 스크롤 생성
        for(int i=0; i<fieldName.length; i++) {
            header.add(fieldName[i]);
        }
        data = selectDB(con, ItemTable);
        model = new DefaultTableModel(header, 0);
        model.setDataVector(data, header);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(this);
        this.add(scrollPane, BorderLayout.CENTER);

        //서쪽패널
        southPanel.setLayout(new GridLayout(0,2));
        for(int i=0; i<fieldName.length; i++) {
            label[i] = new JLabel(fieldName[i], JLabel.CENTER);
            tf[i] = new JTextField(tfSize[i]);
            southPanel.add(label[i]);
            southPanel.add(tf[i]);
        }
        for(int i=0; i< btnText.length; i++) {
            btn[i] = new JButton(btnText[i]);
            btn[i].addActionListener(this);
            southPanel.add(btn[i]);
        }
        this.add(southPanel, BorderLayout.WEST);
        this.setVisible(true);
    }
    private Vector selectDB(Connection con, String ItemTable) {
        data.clear();
        String selectSQL = "SELECT * FROM " + ItemTable + ";";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(selectSQL);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                Vector<String> row = new Vector<String >();
                row.add(result.getString("menu"));
                row.add("" + result.getInt("price"));
                row.add(result.getString("ea"));
                row.add("" + result.getInt("numb"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn[0]) {   //insert
            // 값을 가져온다
            ScoreDBConnTest.insertDataIntoTable(con, ItemTable, tf[0].getText(), Integer.parseInt(tf[1].getText()), tf[2].getText(), Integer.parseInt(tf[3].getText()));
        }
        if(e.getSource() == btn[1]) {   //delete
            ScoreDBConnTest.deleteDataFromTable(con, ItemTable, tf[0].getText());
        }
        if(e.getSource() == btn[2]) {

        }
        if(e.getSource() == btn[3]) {
            for(int i=0; i<tf.length; i++) {
                tf[i].setText("");
            }
        }
        if(e.getSource() == btn[4]) {
            new Order_GUI();
        }
        if(e.getSource() == btn[5]) {
            JOptionPane.showMessageDialog(null, "개발자 : 201958142, 최무성 Ver.2.0 \n 2022.12.14", "Message", JOptionPane.INFORMATION_MESSAGE);
        }


        data = selectDB(con, ItemTable);
        model.setDataVector(data, header);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow();
        Vector<String> row = new Vector<String>();
        row = (Vector<String>) data.get(index); // 값들을 하나씩 쪼개서 가져옴

        for(int i=0; i<tf.length; i++){
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
}
