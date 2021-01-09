package com.hodo.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hodo.model.Acct;
import com.hodo.model.Log;
import com.hodo.service.AcctService;
import com.hodo.service.LogService;
import com.hodo.util.NumberUtil;
import com.hodo.util.Util;

public class GetFrame extends JFrame {

	private LogService ls=new LogService();
	private JPanel contentPane;
	private JTextField amt;
	private JLabel amtLabel;
	public AcctService acctService = new AcctService();
	public Acct acct ;
	public static GetFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GetFrame();
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
	public GetFrame() {
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
		label.setBounds(46, 40, 160, 72);
		contentPane.add(label);
		
		
		
		//账户余额
		Integer userId=LoginFrame1.getUsr();
		acct = acctService.queryOneByUserId(userId);
		Integer amtOld=acct.getAmt();
		
		amtLabel = new JLabel(String.valueOf(amtOld));
		amtLabel.setForeground(Color.RED);
		amtLabel.setFont(new Font("宋体", Font.BOLD, 30));
		amtLabel.setBounds(211, 40, 160, 72);
		contentPane.add(amtLabel);
		
		JLabel label_2 = new JLabel("元");
		label_2.setFont(new Font("宋体", Font.BOLD, 30));
		label_2.setBounds(362, 40, 126, 72);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("请输入取款金额：");
		label_3.setFont(new Font("宋体", Font.BOLD, 30));
		label_3.setBounds(46, 173, 273, 72);
		contentPane.add(label_3);
		
		amt = new JTextField();
		amt.setFont(new Font("宋体", Font.BOLD, 30));
		amt.setBounds(329, 183, 126, 53);
		contentPane.add(amt);
		amt.setColumns(10);
		
		JButton button = new JButton("取款");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String amtString=amt.getText();
				if(NumberUtil.isInteger(amtString)) {
					Integer amtInt =Integer.parseInt(amtString);
					if(amtInt<=0) {
						JOptionPane.showMessageDialog(null, "请输入正整数！");
					} else {
						if(amtInt%100!=0) {
							JOptionPane.showMessageDialog(null, "取款金额必须为100的倍数！");
						} else if(amtInt>5000) {
							JOptionPane.showMessageDialog(null, "取款金额不能超过5000元！");
						} else if(amtInt>Integer.parseInt(amtLabel.getText())) {
							JOptionPane.showMessageDialog(null, "您的余额不足，支取金额不允许透支！");
						} else {
							
//							LoginFrame.atmData.setAmt(LoginFrame.atmData.getAmt()-amtInt);
							
							Integer userId=LoginFrame1.getUsr();
							acct = acctService.queryOneByUserId(userId);
							acct.setAmt(acct.getAmt()-amtInt);
							int i = acctService.update(acct);
							if(i==0) {
								JOptionPane.showMessageDialog(null, "取款成功！");
								ls.insert(new Log("取款"+amtInt+"元",LoginFrame1.usr));
								//更新本页面显示的余额
								amtLabel.setText(String.valueOf(Integer.parseInt(amtLabel.getText())-amtInt));
								frame.setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "取款失败！");
								frame.setVisible(false);
							}
		
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入正确的取款金额！");
				}
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 30));
		button.setBounds(188, 272, 131, 44);
		contentPane.add(button);
	}

}
