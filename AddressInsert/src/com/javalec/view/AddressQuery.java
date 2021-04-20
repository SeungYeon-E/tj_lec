package com.javalec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.modle.DBMS;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddressQuery {

	DBMS dbms;
	
	private JFrame frame;
	private JTextField tfSearch;
	private JTable Inner_Table;
	private JTextField tfSeqNo;
	private JTextField tfTelNo;
	private JTextField tfAddress;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfRelation;
	private JTextField tfCount;
	
	ArrayList<JTextField> tfArr;
	
	//Table 설정
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void run(DBMS dbms) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressQuery window = new AddressQuery(dbms);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddressQuery(DBMS dbms) {
		this.dbms = dbms;
		tfArr = new ArrayList<JTextField>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setBounds(100, 100, 450, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cbSelection = new JComboBox();
		cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호", "이메일", "주소", "관계"}));
		cbSelection.setBounds(27, 24, 85, 27);
		frame.getContentPane().add(cbSelection);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(124, 23, 247, 26);
		frame.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSeach = new JButton("검색");
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeach.setBounds(369, 23, 75, 29);
		frame.getContentPane().add(btnSeach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 63, 382, 106);
		frame.getContentPane().add(scrollPane);
		
		Inner_Table = new JTable();
		Inner_Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//테이블 설정 부착
		Inner_Table.setModel(Outer_Table);
		scrollPane.setViewportView(Inner_Table);
		
		JLabel lblNewLabel = new JLabel("Seq No");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(27, 200, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		tfSeqNo = new JTextField();
		tfSeqNo.setEditable(false);
		tfSeqNo.setBounds(93, 195, 75, 26);
		frame.getContentPane().add(tfSeqNo);
		tfSeqNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(27, 261, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfTelNo = new JTextField();
		tfTelNo.setEditable(false);
		tfTelNo.setColumns(10);
		tfTelNo.setBounds(91, 256, 130, 26);
		frame.getContentPane().add(tfTelNo);
		
		JLabel lblNewLabel_2 = new JLabel("주소");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(27, 321, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfAddress = new JTextField();
		tfAddress.setEditable(false);
		tfAddress.setColumns(10);
		tfAddress.setBounds(91, 316, 280, 26);
		frame.getContentPane().add(tfAddress);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(27, 228, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(93, 223, 130, 26);
		frame.getContentPane().add(tfName);
		
		JLabel lblNewLabel_4 = new JLabel("이메일");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(27, 293, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(91, 288, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_2_1 = new JLabel("관계");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(27, 349, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		tfRelation = new JTextField();
		tfRelation.setEditable(false);
		tfRelation.setColumns(10);
		tfRelation.setBounds(91, 344, 130, 26);
		frame.getContentPane().add(tfRelation);
		
		tfCount = new JTextField();
		tfCount.setEditable(false);
		tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCount.setColumns(10);
		tfCount.setBounds(354, 176, 51, 26);
		frame.getContentPane().add(tfCount);
		
		JLabel lblNewLabel_5 = new JLabel("명");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(395, 181, 24, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfArr.add(tfSeqNo);
		tfArr.add(tfName);
		tfArr.add(tfTelNo);
		tfArr.add(tfAddress);
		tfArr.add(tfEmail);
		tfArr.add(tfRelation);
	}
	
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4);
		
		int rowCount = Outer_Table.getRowCount();
		for (int i = 0; i <rowCount; i++) {
			//0번째 row를 제거 
			Outer_Table.removeRow(0);
		}
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		//컬럼의 순서에 크기값 지정
		TableColumn col;
		
		col= Inner_Table.getColumnModel().getColumn(0);
		col.setPreferredWidth(30);
		
		col = Inner_Table.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = Inner_Table.getColumnModel().getColumn(2);
		col.setPreferredWidth(100);
		
		col = Inner_Table.getColumnModel().getColumn(3);
		col.setPreferredWidth(200);
	}
	
	private void searchAction(){
		ArrayList<String[]> rsArr = dbms.searchUser();
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table.addRow(rsArr.get(i));
		}
		tfCount.setText(Integer.toString(rsArr.size()));
	}
	
	private void tableClick() {
		ArrayList<String> rsArr = new ArrayList<String>();
		int row = Inner_Table.getSelectedRow();
		String wkSeq = (String) Inner_Table.getValueAt(row, 0);
		System.out.println("선택된 열 : " + row + " // seq번호 :" + wkSeq);
		
		//seqno, name, telno, address, email, relation
		rsArr = dbms.searchOneUser(wkSeq);
		
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			tfArr.get(i).setText( rsArr.get(i) );
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
