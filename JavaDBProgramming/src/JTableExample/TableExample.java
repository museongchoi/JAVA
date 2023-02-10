package JTableExample;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableExample extends JFrame implements ListSelectionListener, MouseListener {
	
	String data[][]={ {"101","Lee","670000", "ddd"},
            		  {"102","Kim","780000", "ddd"},
            		  {"102","Park","700000", "ddd"},
				 	  {"101","Lee","670000", "ddd"},
					  {"102","Kim","780000", "ddd"},
					  {"102","Park","700000", "ddd"},
					  {"101","Lee","670000", "ddd"},
					  {"102","Kim","780000", "ddd"},
					  {"102","Park","700000", "ddd"} };
	
	String column[]={"ID","NAME","SALARY", "Dept."};
	JTable table;		//테이블 생성
    public TableExample(){    
	        
	    table = new JTable(data,column);	//위 data, column 을 table에 넣어준다, data 와 colimn 은 단위가 맞아야 한다
	    table.setBounds(30,40,200,150);
	    table.setCellSelectionEnabled(true);
	    
	    JScrollPane sp=new JScrollPane(table);	//위에서 만든 table을 넣어주면 스크롤 기능 생성
	    
	    ListSelectionModel select= table.getSelectionModel();
	    select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        select.addListSelectionListener(this);	// 우리가 클릭했을 때 어떤것이 선택됬는지 보여주는 addListSelectionListener 인터페이스 추가를 하면 valueChanged 생성

		table.addMouseListener(this); // 마우스를 클릭했을 때 보여주는 인터페이스 추가

	    this.add(sp);          
	    this.setSize(300,400);    
	    this.setVisible(true);    

    }
    
    public static void main(String[] args) {    
		new TableExample();
    }

	@Override
	public void valueChanged(ListSelectionEvent e) {	// 테이블의 정보 low, column 값을 가져온다, 스크롤 추가 기능
		// TODO Auto-generated method stub
//		String Data = null;
//		int[] row = table.getSelectedRows();
//		int[] columns = table.getSelectedColumns();
//		for (int i = 0; i < row.length; i++) {
//			for (int j = 0; j < columns.length; j++) {
//				Data = (String) table.getValueAt(row[i], columns[j]); // 해당 위치 값을 가져와서 string 으로 뽑아내어 Data에 저장
//			}
//		}
//		System.out.println("Table element selected is: " + Data);
	}

	@Override
	public void mouseClicked(MouseEvent e) {	// 마우스 클릭 기능, 위와 똑같이 값을 가져온다
		String Data = null;
		int[] row = table.getSelectedRows();
		int[] columns = table.getSelectedColumns();
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				Data = (String) table.getValueAt(row[i], columns[j]); // 해당 위치 값을 가져와서 string 으로 뽑아내어 Data에 저장
			}
		}
		System.out.println("Table element selected is: " + Data);
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