package TableButtonGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class TableButton_GUI extends JFrame implements MouseListener, ActionListener {
    public JTable table;
    public Vector header = new Vector();
    public Vector data = new Vector();
    DefaultTableModel model;

    String[] oderItemName = {"메뉴","가격","개수"};

    String[] menuBtnText = {"라면:2000", "사이다:2000", "치킨:5000", "콜라:1000"};
    JButton[] menuBtn = new JButton[menuBtnText.length];
    JPanel menuBtnPanel = new JPanel();

    JPanel calcBtnPanel = new JPanel(); // calcPanel 생성
    String[] calcBtnText = {"주문", "취소"};    // calcText 데이터 생성
    JButton[] calcBtn = new JButton[calcBtnText.length]; // 버튼 길이 생성

    public TableButton_GUI() {
        this.setSize(400,300);
        this.setTitle("TableButton_GUI");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        // header를 이용 table 생성 및 위치 잡기
        for(int i=0; i<oderItemName.length; i++) {
            header.add(oderItemName[i]);
        }

        model = new DefaultTableModel(header, 0);
        model.setDataVector(data, header);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(this);

        this.add(scrollPane, BorderLayout.CENTER);

        // 메뉴버튼패널 영역 생성
        menuBtnPanel.setLayout(new GridLayout(0,2));

        for(int i=0; i<menuBtn.length; i++) {
            menuBtn[i]=new JButton(menuBtnText[i]); // 메뉴버튼에 text 삽입
            menuBtnPanel.add(menuBtn[i]);   // text 삽입한 메뉴 버튼을 패널에 만듬
            menuBtn[i].addActionListener(this); // 패널에 있는 메뉴 버튼을 눌렀을 때 기능 동작
        }

        this.add(menuBtnPanel, BorderLayout.EAST); // 메뉴버튼패널을 최종 위치

        //계산 패널 생성
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
        // 주문 버튼 total 가격
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
    }
}
