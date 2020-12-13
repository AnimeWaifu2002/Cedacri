package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Sides extends Main {
	private JFrame frame = new JFrame();
	private static Random rand;
	private JPanel contentPane;
	public Sides() {
		rand = new Random();
		frame.setResizable(false);
		frame.setBounds(100, 100, 713, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick a side");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 28));
		lblNewLabel.setBounds(0, 88, 706, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("North");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n++;
	               Arrays.copyOf(x, n);
	               for (int j = 0; j < m; j++) {
	                   for (int i = n - 1; i > 0; i--) {
	                       x[i][j] = x[i - 1][j];
	                   }
	               }
	               for (int i = 0; i < m; i++) {
	                   x[0][i] = rand.nextInt(256) + 1;
	               }
	               try {
	            	    addInfoToFile();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 211, 121, 39);
		contentPane.add(btnNewButton);
		
		JButton btnSouth = new JButton("South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	            	    
						readFromFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				n++;
	               Arrays.copyOf(x, n);
	               for (int i = 0; i < m; i++) {
	                   x[n - 1][i] = rand.nextInt(256) + 1;
	               }
	               try {
	            	    addInfoToFile();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnSouth.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnSouth.setBackground(Color.WHITE);
		btnSouth.setBounds(200, 211, 121, 39);
		contentPane.add(btnSouth);
		
		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	            	    
						readFromFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				m++;
	               Arrays.copyOf(x[0], m);
	               for (int i = 0; i < n; i++) {
	                   x[i][m - 1] = rand.nextInt(256) + 1;
	                   try {
		            	    addInfoToFile();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			}
		});
		btnWest.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnWest.setBackground(Color.WHITE);
		btnWest.setBounds(376, 211, 121, 39);
		contentPane.add(btnWest);
		
		JButton btnEast = new JButton("East");
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	            	    
						readFromFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 m++;
	               Arrays.copyOf(x[0], m);
	               for (int i = 0; i < n; i++) {
	                   System.out.print("x[" + i + "]" + "[" + (m - 1) + "]=");
	                   x[i][m - 1] = rand.nextInt(256) + 1;
	               }
	               try {
	            	    addInfoToFile();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnEast.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnEast.setBackground(Color.WHITE);
		btnEast.setBounds(561, 211, 121, 39);
		contentPane.add(btnEast);
		frame.setVisible(true);
	}
}
