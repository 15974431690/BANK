package com.hodo.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hodo.model.Acct;
import com.hodo.model.Log;
import com.hodo.service.AcctService;
import com.hodo.service.LogService;
import com.hodo.util.Util;

public class AmtFrame extends JFrame {
	
	private LogService ls=new LogService();
	
	private JPanel contentPane;
	public static AmtFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AmtFrame();
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
	public AmtFrame() {
		setTitle("欢迎光临XX银行自动柜员机");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //设置frame窗口居中显示
        Util.setCenter(this,533,379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账户余额：");
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(65, 106, 160, 72);
		contentPane.add(label);
		
		//账户余额
		Integer userId=LoginFrame1.getUsr();
		AcctService acctService = new AcctService();
		Acct acct = acctService.queryOneByUserId(userId);
		
		Integer amt=acct.getAmt();
		
		JLabel label_1 = new JLabel(String.valueOf(amt));
		
		ls.insert(new Log("查询账户余额"+amt+"元",LoginFrame1.usr));
		
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(230, 106, 160, 72);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("元");
		label_2.setFont(new Font("宋体", Font.BOLD, 30));
		label_2.setBounds(381, 106, 126, 72);
		contentPane.add(label_2);
	}

}
