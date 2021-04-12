/*
 *0412윤재필 - 체크박스를 사용한 사칙연산
 *간편한 연산을 위해 ArrayList를 사용하였다.
 */

package com.javalec.exercise;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exersice03 {

	private JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	ArrayList<JCheckBox> checkArr = new ArrayList<JCheckBox>();
	ArrayList<JLabel> labelArr = new ArrayList<JLabel>();
	String[] operator = {"+", "-", "x", "/"};

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exersice03 window = new Exersice03();
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
	public Exersice03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxADD = new JCheckBox("+");
		chckbxADD.addActionListener(new clac());
		chckbxADD.setBounds(293, 23, 128, 23);
		checkArr.add(chckbxADD);
		frame.getContentPane().add(chckbxADD);
		
		JCheckBox chckbxSUB = new JCheckBox("-");
		chckbxSUB.addActionListener(new clac());
		chckbxSUB.setBounds(293, 58, 128, 23);
		checkArr.add(chckbxSUB);
		frame.getContentPane().add(chckbxSUB);
		
		JCheckBox chckbxMUL = new JCheckBox("x");
		chckbxMUL.addActionListener(new clac());
		chckbxMUL.setBounds(293, 93, 128, 23);
		checkArr.add(chckbxMUL);
		frame.getContentPane().add(chckbxMUL);
		
		JCheckBox chckbxDIV = new JCheckBox("/");
		chckbxDIV.addActionListener(new clac());
		chckbxDIV.setBounds(293, 126, 128, 23);
		checkArr.add(chckbxDIV);
		frame.getContentPane().add(chckbxDIV);
		
		JLabel lblADDResult = new JLabel("");
		lblADDResult.setBounds(35, 171, 335, 16);
		labelArr.add(lblADDResult);
		frame.getContentPane().add(lblADDResult);
		
		JLabel lblSUBResult = new JLabel("");
		lblSUBResult.setBounds(35, 199, 335, 16);
		labelArr.add(lblSUBResult);
		frame.getContentPane().add(lblSUBResult);
		
		JLabel lblMULResult = new JLabel("");
		lblMULResult.setBounds(35, 227, 335, 16);
		labelArr.add(lblMULResult);
		frame.getContentPane().add(lblMULResult);
		
		JLabel lblDIVResult = new JLabel("");
		lblDIVResult.setBounds(35, 250, 335, 16);
		labelArr.add(lblDIVResult);
		frame.getContentPane().add(lblDIVResult);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(22, 22, 130, 26);
		frame.getContentPane().add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(22, 57, 130, 26);
		frame.getContentPane().add(tfNum2);
	}
	
	class clac implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tfNum1.getText().equals("")) {
				tfNum1.setText("0");
			}
			if (tfNum2.getText().equals("")) {
				tfNum2.setText("0");
			}
			
			for (int i = 0; i < 4; i ++) {
				if (checkArr.get(i).isSelected() == true) {
					labelArr.get(i).setText(setLable(operator[i]));
				} else {
					labelArr.get(i).setText("");
				}
			}
			
			setLabelLocation();
		}
		
		String setLable(String operator) {
			int x = Integer.parseInt(tfNum1.getText()); 
			int y = Integer.parseInt(tfNum2.getText());
			int result = 0;
			
			switch (operator) {
			case "+":
				result = x + y;
				break;
			case "-":
				result = x - y;
				break;
			case "x":
				result = x * y;
				break;
			case "/":
				if( x == 0 || y == 0) {
					return x + operator + y + " =  0";				
				}
				double doubleResult = x / (y * 1.0);
				doubleResult = Math.round(doubleResult*1000)/1000.0;
				return x + operator + y + " = " + Double.toString(doubleResult);
			}
			return x + operator + y + " = " + Integer.toString(result);
		}
		/*
		 *
		 */
		void setLabelLocation() {
			for (int i = 0; i < 3; i++) {
				if (labelArr.get(i).getText().equals("")) {
					for (int j = i; j < 4; j++) {
						if (!labelArr.get(j).getText().equals("")) {
							labelArr.get(i).setText(labelArr.get(j).getText());
							labelArr.get(j).setText("");
							break;
						}
					}
				}
			}
		}
		
	}

}
