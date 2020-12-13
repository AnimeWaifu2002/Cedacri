package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyApp extends Main{

	private JFrame frame;
	public MyApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 712, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Generate random matrix");
		btnNewButton.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandMatrix();
				Matrix m = new Matrix();
			}
		});
		btnNewButton.setBounds(149, 67, 377, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add info to file");
		btnNewButton_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addInfoToFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(149, 113, 377, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Read from file");
		btnNewButton_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					readFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(149, 159, 377, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnFind = new JButton("Find average in every row");
		btnFind.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SredneeArifmeticeskoe();
				Arifmeticeskoe a = new Arifmeticeskoe();
			}
		});
		btnFind.setBounds(149, 205, 377, 35);
		frame.getContentPane().add(btnFind);
		
		JButton btnFindMaxElement = new JButton("Find max element ");
		btnFindMaxElement.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnFindMaxElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 maxElem max = new maxElem();
				 }
		});
		btnFindMaxElement.setBounds(149, 251, 377, 35);
		frame.getContentPane().add(btnFindMaxElement);
		
		JButton btnDeleteRowAnd = new JButton("Delete row and column with min element on intersection");
		btnDeleteRowAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DeleteColumn();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Matrix m = new Matrix();
			}
		});
		
		JButton btnAddRowcolumn = new JButton("Add row/column");
		btnAddRowcolumn.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnAddRowcolumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sides s = new Sides();
			}
		});
		btnAddRowcolumn.setBounds(149, 297, 377, 35);
		frame.getContentPane().add(btnAddRowcolumn);
		
		JButton btnReadAndOpen = new JButton("Read and open Prime.txt");
		btnReadAndOpen.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnReadAndOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 try { 
                	 Prime p = new Prime();
                	addInfoToFilePrime();
					outputFromPrimeFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReadAndOpen.setBounds(149, 343, 377, 46);
		frame.getContentPane().add(btnReadAndOpen);
		
		JButton btnQuickSortRows = new JButton("Quick sort columns by rows");
		btnQuickSortRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					sortColumnWise();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Matrix m = new Matrix();
			}
		});
		btnQuickSortRows.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnQuickSortRows.setBounds(149, 400, 377, 35);
		frame.getContentPane().add(btnQuickSortRows);
		
		JButton btnDeleteRowAnd1 = new JButton("Delete row and column with min element on intersection");
		btnDeleteRowAnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DeleteColumn();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Matrix m = new Matrix();
			}
		});
		btnDeleteRowAnd1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnDeleteRowAnd1.setBounds(149, 446, 377, 46);
		frame.getContentPane().add(btnDeleteRowAnd1);
		
		JButton btnFindMagicSquare = new JButton("Find magic square in matrix");
		btnFindMagicSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MagicSquare();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFindMagicSquare.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnFindMagicSquare.setBounds(149, 503, 377, 35);
		frame.getContentPane().add(btnFindMagicSquare);
		
		JButton btnLocustsPath = new JButton("Locusts path");
		btnLocustsPath.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		btnLocustsPath.setBounds(149, 547, 377, 35);
		frame.getContentPane().add(btnLocustsPath);
		btnLocustsPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Lacusta l = new Lacusta();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select an operation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 31));
		lblNewLabel.setBounds(149, 11, 377, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Show matrix");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matrix m = new Matrix();
			}
		});
		btnNewButton_3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		btnNewButton_3.setBounds(547, 120, 136, 120);
		frame.getContentPane().add(btnNewButton_3);
		frame.setVisible(true);
	}
}

