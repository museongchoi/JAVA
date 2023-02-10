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
import java.util.Vector;

public class Order_GUI extends JFrame implements MouseListener, ActionListener {

    static Connection con = null;
    static String ItemTable = "ItemTable_201958142";

    public JTable table;
    public Vector header = new Vector();
    public Vector data = new Vector();
    DefaultTableModel model;

    String[] oderItemName = {"메뉴","가격","개수"};

    JPanel calcBtnPanel = new JPanel(); // calcPanel 생성
    String[] calcBtnText = {"주문", "취소", "추가기능"};    // calcText 데이터 생성
    JButton[] calcBtn = new JButton[calcBtnText.length];

//    static String[] btnName = {"금액"};
//    JLabel[] label = new JLabel[btnName.length];
//    JTextField[] tf = new JTextField[btnName.length];

    JPanel menuBtnPanel = new JPanel();
    JButton[] menuBtn;
    private PreparedStatement pstmt;
    private ResultSet result;

    public Order_GUI() {
        this.setSize(500,300);
        this.setTitle("POS : Order_GUI!!! 201958142 컴퓨터공학부 최무성");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        con = ScoreDBConnTest.makeConnection();

        for(int i=0; i<oderItemName.length; i++) {
            header.add(oderItemName[i]);
        }

        model = new DefaultTableModel(header, 0);
        model.setDataVector(data, header);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(this);
        this.add(scrollPane, BorderLayout.CENTER);

        menuBtnPanel.setLayout(new GridLayout(0,2));
        String SelectSQL = "SELECT * FROM " + ItemTable + " ;";
        try {
            pstmt = con.prepareStatement(SelectSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // 앞 뒤로 움직이기 위한 부분
            result = pstmt.executeQuery(SelectSQL);

            // Menu 수 만큼 동적으로 만드는 것
            int size = 0;
            if (result != null) {    //result 값이 null 이 아니면 라인번호가 1부터 result 값이 맨 뒤로 간다, 맨 뒤로 갔을 때의 row값 라인 수가 사이즈가 된다
                result.last();  // moves cursor to the last row
                size = result.getRow(); // get row id
            }

            result.first();
            menuBtn = new JButton[size]; // menu 버튼의 사이즈를 알고싶은 것 , 동적으로 사이즈 조절 위 Menu 수 만큼 통적으로 만드는 것으로 알 수 있다

            for (int i = 0; i < menuBtn.length; i++) {
                menuBtn[i] = new JButton();
                menuBtn[i].setText(result.getString("menu") + " : "  + result.getInt("price"));   // 값을 가져와서 버튼에 세팅
                result.next(); // result 가 하나가 세팅이 되면 다음으로 넘어감
                menuBtnPanel.add(menuBtn[i]);
                menuBtn[i].addActionListener(this);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        this.add(menuBtnPanel, BorderLayout.EAST);

        calcBtnPanel.setLayout(new FlowLayout());
        for(int i=0; i<calcBtn.length; i++) {
            calcBtn[i] = new JButton(calcBtnText[i]);
            calcBtnPanel.add(calcBtn[i]);
            calcBtn[i].addActionListener(this);
        }

        this.add(calcBtnPanel, BorderLayout.SOUTH);
        this.repaint();

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        for(int i=0; i<menuBtn.length; i++) {
            if(e.getSource() == menuBtn[i]) {
                String menuText = menuBtn[i].getText(); // 예 : menuText = "라면:2000"
                String[] menuTextSplit = menuText.split(":"); // : 를 기준으로 양 옆 데이터
                // 예시) menuTextSplit[0] = "라면", menuTextSplit[1] = "2000"
                Vector<String> row = new Vector<String>();
                row.add(menuTextSplit[0]);
                row.add(menuTextSplit[1]);
                row.add("1");

                data.add(row);
                model.setDataVector(data, header);
            }
        }
        if(e.getSource() == calcBtn[0]) {
            int sum = 0;
            Vector<String> row = new Vector<String>();
            for(int i=0; i< model.getRowCount(); i++) {
                row = (Vector<String>) data.get(i);  // data에 들어가 있는 것을 다시 얻어 온다 그때 string 으로 캐스팅을 해야한다
                // 예시) row.get(0) 번은 메뉴에 들어가있는 값, row.get(1) 번은 가격에 들어가있는 값, row.get(3) 번은 개수에 들어가있는 값
                sum += Integer.parseInt(row.get(1))*Integer.parseInt(row.get(2)); // 현재 문자열이기 때문에 바꿔주어야한다
            }
            System.out.println("총 금액 :"+sum+"원");
        }
        if(e.getSource() == calcBtn[1]) {

        }
        if(e.getSource() == calcBtn[2]) {

        }
    }
}
