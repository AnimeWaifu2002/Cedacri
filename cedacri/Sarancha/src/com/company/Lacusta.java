package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Lacusta extends Main {

	private JPanel contentPane;
	private JFrame frame = new JFrame();

	public Lacusta() throws IOException {
		readFromFile();
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		frame.setResizable(true);
		frame.setBounds(100, 100, 550 , 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblNewLabel = new JLabel("Locust's path");
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

		int[][] C = new int[100][100];
		System.out.println("n = " + n);
		System.out.println("m = " + m);
		C[0][0]=x[0][0];
		for(int i=1; i<n; i++)
			C[i][0]=x[i][0]+C[i-1][0];
		for(int j=1; j<m; j++)
			C[0][j]=x[0][j]+C[0][j-1];
		for (int k=1; k<n+m-1; k++)
			for(int i=1; i<n; i++)
				for(int j=1; j<m; j++)
					if (i+j-1==k) {
						C[i][j]=x[i][j]+Min(C[i][j-1], C[i-1][j]);
					}
		System.out.println();
		System.out.println("Cmin = " + C[n-1][m-1]);
		File f = new File("Lacusta.out.txt");
		if (!f.exists()) {
			f.createNewFile();
		}
		PrintWriter pw = new PrintWriter(f);
		pw.println(C[n-1][m-1]);
		for(int i=0; i<n/2; i++){
			for(int j=0; j<m; j++){
				int t = C[i][j];
				C[i][j] = C[n-i-1][j];
				C[n-i-1][j] = t;
			}
		}
		class R {
			final int Rj;
			final int Ri;
			public R(int Rj,int Ri){
				this.Rj = Rj;
				this.Ri = Ri;
			}
		}
		Vector<R> R= new Vector<R>(50);
		int Ri=0,Rj=0;
		while(Ri<n-1 && Rj<m){
			pw.print("(" + Ri + ", " + Rj + ")");
			R waypoint = new R (Rj,Ri);
			R.add(waypoint);
			if(C[Ri][Rj+1]>C[Ri+1][Rj]){
				Rj++;
			}
			else{
				Ri++;
			}
			if(!(Ri == n - 1 || Rj == m))
				pw.print("->");
		}
		pw.close();
		R[] Array = R.toArray(new R[0]);
		JLabel lblNewLabel_3;
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				lblNewLabel_3 = new JLabel(Integer.toString(x[i][j]));
				for (R r : Array) {
					if (r.Ri == i && r.Rj == j) {
						lblNewLabel_3.setForeground(Color.red);
						break;
					}
				}
				panel.add(lblNewLabel_3);
			}
		}
	}
}

