package com.hodo.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.hodo.model.Log;
import com.hodo.model.User;
import com.hodo.service.LogService;
import com.hodo.service.UserService;
import com.hodo.util.Util;

public class ChgPwdFrame extends JFrame {

	private LogService ls=new LogService();
	private JPanel contentPane;
	private JPasswordField pwd;
	private JPasswordField pwdc;
	private JPasswordField oldpwd;
	private JLabel label_2;
	public static ChgPwdFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChgPwdFrame();
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
	public ChgPwdFrame() {
		setTitle("欢迎光临XX银行自动柜员机");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置frame窗口居中显示
        Util.setCenter(this,533,379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("新密码：");
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(68, 90, 173, 72);
		contentPane.add(label);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("宋体", Font.PLAIN, 30));
		pwd.setBounds(251, 103, 189, 48);
		contentPane.add(pwd);
		
		JLabel label_1 = new JLabel("确认密码：");
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(68, 172, 173, 72);
		contentPane.add(label_1);
		
		pwdc = new JPasswordField();
		pwdc.setFont(new Font("宋体", Font.PLAIN, 30));
		pwdc.setBounds(251, 185, 189, 48);
		contentPane.add(pwdc);
		
		JButton button = new JButton("提交修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String oPwd =LoginFrame.atmData.getPwd();
				
				String oPwd =LoginFrame1.pw;
				
//				String oldpwd.getText();
//				String pwd.getText();
//				String pwdc.getText();
				if(Util.isEmpty(oldpwd.getText()) || Util.isEmpty(pwd.getText()) || Util.isEmpty(pwdc.getText()) ) {
					JOptionPane.showMessageDialog(null, "请输入原密码、新密码、确认密码！");
				} else if(pwd.getText().length()<6) {
					JOptionPane.showMessageDialog(null, "新密码长度不能小于6位！");
				} else if(Util.isSameChars(pwd.getText())) {
					JOptionPane.showMessageDialog(null, "密码不能只使用一种字符！");
				} else if(!pwd.getText().equals(pwdc.getText())) {
					JOptionPane.showMessageDialog(null, "新密码、确认密码输入不一致！");
				} else if(!oPwd.equals(oldpwd.getText())) {
					JOptionPane.showMessageDialog(null, "旧密码不正确！");
				} else {
					
					//修改存储ATM机的密码数据
//					LoginFrame.atmData.setPwd(pwd.getText());
					
					UserService userService = new UserService();
					User user = userService.queryOne(LoginFrame1.usr);
					user.setPwd(pwd.getText().toString());
					int i = userService.update(user);
					if(i==0) {
						//清空三个输入框
						oldpwd.setText("");
						pwd.setText("");
						pwdc.setText("");
						JOptionPane.showMessageDialog(null, "密码修改成功");
						ls.insert(new Log("密码修改成功为："+pwd.getText().toString(),LoginFrame1.usr));
						ChgPwdFrame.frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "密码修改失败");
					}
					
				}
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 30));
		button.setBounds(170, 268, 173, 51);
		contentPane.add(button);
		
		oldpwd = new JPasswordField();
		oldpwd.setFont(new Font("宋体", Font.PLAIN, 30));
		oldpwd.setBounds(251, 23, 189, 48);
		contentPane.add(oldpwd);
		
		label_2 = new JLabel("原密码：");
		label_2.setFont(new Font("宋体", Font.BOLD, 30));
		label_2.setBounds(68, 10, 173, 72);
		contentPane.add(label_2);
	}

}
