package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Prime extends Main {

	private JPanel contentPane;
	private JFrame frame = new JFrame();
	public Prime() {
		String[] s = printPrimeNumbers();
		frame.setVisible(true);
		frame.setBounds(100, 100, 676, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prime.txt");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 31));
		lblNewLabel.setBounds(10, 11, 640, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 53, 640, 380);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(Integer.parseInt(s[0]), 1, 0, 0));
		for(int i = 0; i < Integer.parseInt(s[0]); i++) {
			panel.add(new JLabel(s[i + 1]));
		}
	}

}
