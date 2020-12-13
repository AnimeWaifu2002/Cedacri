package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Matrix extends Main {

	private JPanel contentPane;
	private JFrame frame = new JFrame();
	
	public Matrix() {
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		frame.setResizable(true);
		frame.setBounds(100, 100, 550 , 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Random matrix");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 31));
		lblNewLabel.setBounds(0, 11, 442, 26);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 40, m * 50,n * 50 - 50 );
		contentPane.add(panel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Matrix dimensions:" + n +" "+ m);
		lblNewLabel_1.setBounds(349, 11, 208, 26);
		contentPane.add(lblNewLabel_1);
		
		panel.setLayout(new GridLayout(m, n, 0, 0));
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				JLabel lblNewLabel_3 = new JLabel(Integer.toString(x[i][j]));
				panel.add(lblNewLabel_3);	
			}
		}
	}
}
