package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class Arifmeticeskoe extends Main {

	private JFrame frame = new JFrame();
	private JPanel contentPane;
	public Arifmeticeskoe() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 833, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Average of every row");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 797, 36);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 41, 797, 487);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(m, 1, 0, 0));
		
		  double sum = 0;
	        for (int j = 0; j < m; j++) {
	            for (int i = 0; i < n; i++) {
	                sum = sum + x[i][j];
	            }
	            sum = sum / n;
	            JLabel lblNewLabel_4 = new JLabel("Среднее арифметическое " + (j + 1) + " столбца: " + sum);
	            lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_4);
	            sum = 0;
	        }
		
	}

}
