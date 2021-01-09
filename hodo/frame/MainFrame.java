package com.hodo.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hodo.util.Util;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static MainFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("欢迎光临XX银行自动柜员机");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        //设置frame窗口居中显示
        Util.setCenter(this,652,650);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_2 = new JButton("查询余额");
		button_2.setFont(new Font("宋体", Font.BOLD, 21));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AmtFrame af = new AmtFrame();
				af.frame=af;
				af.setVisible(true);
			}
		});
		
		button_2.setBounds(238, 49, 151, 50);
		contentPane.add(button_2);
		
		JButton btnAtm = new JButton("ATM取款");
		btnAtm.setFont(new Font("宋体", Font.BOLD, 21));
		btnAtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetFrame gf = new GetFrame();
				gf.frame=gf;
				gf.setVisible(true);
			}
		});
		btnAtm.setBounds(238, 138, 151, 50);
		contentPane.add(btnAtm);
		
		JButton btnNewButton_1 = new JButton("ATM存款");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFrame sf = new SaveFrame();
				sf.frame=sf;
				sf.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(238, 227, 151, 50);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("修改密码");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChgPwdFrame cf = new ChgPwdFrame();
				cf.frame=cf;
				cf.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 21));
		button.setBounds(238, 399, 151, 49);
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("用户管理");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserMFrame umf = new UserMFrame();
				umf.frame=umf;
				umf.setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 21));
		button_1.setBounds(427, 49, 151, 50);
		if("管理员".equals(LoginFrame1.usrGroup)) {
			contentPane.add(button_1);
		}
		
		
		JButton btnAtm_1 = new JButton("ATM转账");
		btnAtm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransFrame tf = new TransFrame();
				tf.frame=tf;
				tf.setVisible(true);
			}
		});
		btnAtm_1.setFont(new Font("宋体", Font.BOLD, 21));
		btnAtm_1.setBounds(238, 314, 151, 50);
		contentPane.add(btnAtm_1);
		
		JButton button_3 = new JButton("退出系统");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_3.setFont(new Font("宋体", Font.BOLD, 21));
		button_3.setBounds(238, 485, 151, 49);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("日志管理");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogMFrame lmf = new LogMFrame();
				lmf.frame=lmf;
				lmf.setVisible(true);
			}
		});
		button_4.setFont(new Font("宋体", Font.BOLD, 21));
		button_4.setBounds(427, 138, 151, 50);
		if("管理员".equals(LoginFrame1.usrGroup)) {
			contentPane.add(button_4);
		}
//		contentPane.add(button_4);
		
	}
}
