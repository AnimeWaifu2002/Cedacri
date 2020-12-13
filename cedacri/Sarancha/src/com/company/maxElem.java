package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class maxElem extends Main {
	private JFrame frame = new JFrame();
	private JPanel contentPane;
	public maxElem() {
		frame.setVisible(true);
		frame.setBounds(100, 100, 561, 240);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("There are ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 31));
		lblNewLabel.setBounds(10, 11, 525, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 50, 525, 50);
		JLabel Label = new JLabel(printStroka());
		Label.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 31));
		panel.add (Label);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 29));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rows that contain the max element");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(10, 112, 525, 37);
		contentPane.add(lblNewLabel_2);
	}
}
