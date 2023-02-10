package JTableExample;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableExampleWithVector extends JFrame {

	String dbTableData[][]={ {"제품1","1","1000", "2020", "12.31"},
			{"제품2","2","2000", "2021", "12.31"},
			{"제품3","3","3000", "2022", "12.31"},
			{"제품4","4","4000", "2023", "12.31"} };

	String dbFieldName[] = {"제품명", "수량", "가격","등록기간", "유통기한" };

	public JTable table;
	public Vector column = new Vector();	// vector : 데이터가 크기와 방향을 갖는 , column = header 정보이다
	public Vector data = new Vector();

	@SuppressWarnings("unchecked")
	public TableExampleWithVector() {
		// TODO Auto-generated constructor stub
		this.setTitle("Table Example with Vector");
		this.setSize(300, 200);

		column.add(dbFieldName[0]);
		column.add(dbFieldName[1]);
		column.add(dbFieldName[2]);
		column.add(dbFieldName[3]);
		column.add(dbFieldName[4]);

		// 벡터 형태를 갖는 라인 하나를 만든다 row1 을 벡터 형태의 data에 넣는다
		Vector<String> row1 = new Vector<String>();
		row1.add("아이폰");
		row1.add("1");
		row1.add("1,000,000");
		row1.add("11.23");
		row1.add("12.31");
		data.add(row1);

		// row1, row2 두줄이 들어간다
		Vector<String> row2 = new Vector<String>();
		row2.add("ee");
		row2.add("ee");
		row2.add("ee");
		row2.add("ee");
		row2.add("ee");
		data.add(row2);

		// DefaultTableModel 안에 저장
		DefaultTableModel model = new DefaultTableModel(column, 0);
		model.setDataVector(data, column);	// 벡터형태로 자동으로 변환되는 동적 모델 setDataVector

		table = new JTable(model);	// model 을 갖는 table 에 스크롤 기능으 넣는다
		JScrollPane scrollPane = new JScrollPane(table);

		// 저장할 데이터들을 읽어와 model 에 뿌린다
		for (int i=0; i<dbTableData.length; i++) {
			Vector<String> rowNew = new Vector<String>();
			for (int j=0; j<dbTableData[i].length; j++) {
				System.out.println(dbTableData[i][j]);
				rowNew.add(""+dbTableData[i][j]);
			}
			data.add(rowNew);
		}

		model.setDataVector(data, column);
		this.add(scrollPane);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableExampleWithVector();
	}

}