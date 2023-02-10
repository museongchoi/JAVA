package DBConn;

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

public class BookDBGUI extends JFrame implements ActionListener, MouseListener {
    String[] labelText = {"ID", "Title", "Publisher", "Year", "Price"};
    JLabel[] label = new JLabel[labelText.length];
    JTextField[] tf = new JTextField[labelText.length];
    String[] buttonText = {"Previous", "Next", "Insert", "Delete", "Reset", "Sorting"};
    JButton[] bt = new JButton[buttonText.length];

    Connection con = null;
    static String myTableName = "bookTable_201958142";
    PreparedStatement pstmt = null;
    ResultSet result = null;

    private Vector header = new Vector(); // 반드시 설정
    private Vector data = new Vector(); // 반드시 설정
    private DefaultTableModel model;
    private JTable table;

    static String[] fieldName = {"ID", "제목", "출판사", "연도", "금액"};

    public BookDBGUI() {
        this.setTitle("Book DB GUI by Choi Moo-Sung, 201958142");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);

        JPanel leftPanel = new JPanel();    // JPanel 추가

        leftPanel.setLayout(new GridLayout(0, 2)); // this --> leftPanel
        for(int i = 0; i < labelText.length; i++) {
            label[i] = new JLabel(labelText[i], JLabel.CENTER);
            tf[i] = new JTextField(8);
            leftPanel.add(label[i]); // this --> leftPanel
            leftPanel.add(tf[i]); // this --> leftPanel
        }

        for(int j = 0; j < bt.length; j++) {
            bt[j] = new JButton(buttonText[j]);
            leftPanel.add(bt[j]); // this --> leftPanel
            bt[j].addActionListener(this);
        }

        for(int i = 0; i< fieldName.length; i++) {
            header.add(fieldName[i]);
        }

        //data 의 값을 넣어줌 직접 지정하여 넣어준 것
        Vector<String> row1 = new Vector<String>();
        row1.add("1");
        row1.add("자바");
        row1.add("한신출판사");
        row1.add("2022");
        row1.add("12000");
        data.add(row1);

        con = DBConnOnConcole.makeConnection(); // connection 이 먼저 된 후

        data = selectDB(con, myTableName); // 내가 지정한 테이블에 있는 값들을 가져오는 풩션

        // DefaultTableModel 안에 저장
        DefaultTableModel model = new DefaultTableModel(header, 0);
        model.setDataVector(data, header);	// 벡터형태로 자동으로 변환되는 동적 모델 setDataVector

        table = new JTable(model);	// model 을 갖는 table 에 스크롤 기능을 넣는다
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(this); // table에 관하여 마우스리스너를 붙인다

        this.add(scrollPane, BorderLayout.CENTER); // 센터에 스크롤 펜 생성

        String selectDataSQL = "SELECT * FROM " + myTableName + "; ";

        try {
            pstmt = con.prepareStatement(selectDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = pstmt.executeQuery(selectDataSQL);
            System.out.println("GUI : Select SQL OK!!!");
        } catch (SQLException e) {
            System.out.println("GUI : Select SQL Error!!!");
        }
        this.add(leftPanel, BorderLayout.WEST); // Frame 에 서쪽에 생성
        this.setVisible(true);
    }

    private Vector selectDB(Connection con, String myTableName) {
        data.clear(); // 쌓여있는 데이터 청소
        String selectSQL = "SELECT * FROM " + myTableName + "; ";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(selectSQL);
            ResultSet result = pstmt.executeQuery(); // 검색한 테이블의 값들을 콘솔로 찍어주는 것이 아니라 값들을 vector 로 변환한 한줄을 data 넣고 리턴
            while (result.next()) {
                Vector<String> row = new Vector<String>();
                row.add(result.getString("book_id"));
                row.add(result.getString("title"));
                row.add(result.getString("publisher"));
                row.add(result.getString("year"));
                row.add("" + result.getInt("price"));
                data.add(row); // 이 한줄을 data에 추가 계속 한줄 씩 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt[0]) {
            try {

                if(result.previous()) {
                    tf[0].setText(result.getString("book_id"));
                    tf[1].setText(result.getString("title"));
                    tf[2].setText(result.getString("publisher"));
                    tf[3].setText(result.getString("year"));
                    tf[4].setText("" + result.getString("price"));
                    System.out.println("Previous OK!!!");
                }
                else {
                    System.out.println("Non-Previous Data!!!");
                }
            } catch (SQLException ex) {
                System.out.println("Previous Error!!!");
            }
        }
        if(e.getSource() == bt[1]) {
            try {

                if(result.next()) {
                    tf[0].setText(result.getString("book_id"));
                    tf[1].setText(result.getString("title"));
                    tf[2].setText(result.getString("publisher"));
                    tf[3].setText(result.getString("year"));
                    tf[4].setText("" + result.getString("price"));
                    System.out.println("Next OK!!!");
                }
                else {
                    System.out.println("Non-Next Data!!!");
                }
            } catch (SQLException ex) {
                System.out.println("Next Error!!!");
            }
        }
        //insert button clicked...
        if(e.getSource() == bt[2]) {
            DBConnOnConcole.insertDataIntoTable2(con, myTableName, tf[1].getText(), tf[2].getText(), tf[3].getText(), Integer.parseInt(tf[4].getText()));
            ArrayList<String> list = DBConnOnConcole.getDataFromTable(con, myTableName);
            DBConnOnConcole.PrintList(list);

            Vector data1 = new Vector();
            DefaultTableModel model = new DefaultTableModel(header, 0);
            data1 = selectDB(con, myTableName);
            model.setDataVector(data1, header);

            String selectDataSQL = "SELECT * FROM " + myTableName + "; ";
            try {
                pstmt = con.prepareStatement(selectDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                result = pstmt.executeQuery(selectDataSQL);
                System.out.println("Insert Update OK!!!");
            } catch (SQLException e1) {
                System.out.println("Insert Update Error!!!");
            }
        }
        //delete button clicked...
        if(e.getSource() == bt[3]) {
            // 아래를 모듈화 하여 DBConnOnConcole 에 만들었다
//            String deleteDataSQL = "DELETE FROM " + myTableName + " WHERE book_id = ?";
//
//            try {
//                pstmt = con.prepareStatement(deleteDataSQL);
//                pstmt.setString(1, tf[0].getText());
//                pstmt.executeUpdate();
//                System.out.println("Delete Data book_id: " + tf[0].getText() + " 번 OK!!!");
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//                System.out.println("Delete Data Error!!!");
//            }
            DBConnOnConcole.deleteDataFromTable(con, myTableName, tf[0].getText());
            System.out.println("GUI : Delete SQL OK!!!");
            ArrayList<String> list = DBConnOnConcole.getDataFromTable(con, myTableName);
            DBConnOnConcole.PrintList(list);

            //수정해야함
            Vector data2 = new Vector();
            DefaultTableModel model = new DefaultTableModel(header, 0);
            data2 = selectDB(con, myTableName);
            model.setDataVector(data2, header);

            String selectDataSQL = "SELECT * FROM " + myTableName + "; ";
            try {
                pstmt = con.prepareStatement(selectDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                result = pstmt.executeQuery(selectDataSQL);
                System.out.println("Delete Update OK!!!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("Delete Update Error!!!");
            }
        }

        if(e.getSource() == bt[4]) {
            DBConnOnConcole.dropTable(myTableName);
            DBConnOnConcole.createTable(myTableName);

            String selectDataSQL = "SELECT * FROM " + myTableName + "; ";
            try {
                pstmt = con.prepareStatement(selectDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                result = pstmt.executeQuery(selectDataSQL);
                System.out.println("Delete Update OK!!!");
            } catch (SQLException e1) {
                System.out.println("Delete Update Error!!!");
            }
        }
        //Sorting button click...
        if(e.getSource() == bt[5]) {
            String sortingDataSQL = "SELECT * FROM " + myTableName + " ORDER BY title DESC ; ";
            try {
                pstmt = con.prepareStatement(sortingDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //pstmt.setString(1, "title"); // Title 값을 기준으로 정렬...
                result = pstmt.executeQuery(sortingDataSQL); // result 값이 반영이 되어야 하기 때문에 풩션으로 만들면 안된다
                System.out.println("DUI : Sorting SQL OK!!!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("GUI : Sorting SQL Error!!!");
            }
        }

    }

    // table에 마우스리스너를 달아서 클릭했을때 값을 로우로 가져오고 그것을 또 하나씩 잘라낸다.
    @Override
    public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow(); // table의 몇번째를 눌렀는지 가져오는것, selectDB에 한줄씩 추가한 것을 하나씩 빼오면 된다
        Vector<String> row = new Vector<String>();
        row = (Vector<String>) data.get(index);
//        String book_id = row.get(0);
//        String title = row.get(1);
//        String publisher = row.get(2);
//        String year = row.get(3);
//        String price = row.get(4);
//
//        tf[0].setText(book_id);
//        tf[1].setText(title);
//        tf[2].setText(publisher);
//        tf[3].setText(year);
//        tf[4].setText(price);

        for(int i=0; i< tf.length; i++) {
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
