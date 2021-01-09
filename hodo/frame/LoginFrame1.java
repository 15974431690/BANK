package com.hodo.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hodo.model.Log;
import com.hodo.model.User;
import com.hodo.service.LogService;
import com.hodo.service.UserService;

/*
 * @author asaa
 * @version 版本1
 * @param 参数
 * @return 返回值意义
 * @throws 异常描述
 */

public class LoginFrame1 extends JFrame {
	private LogService ls=new LogService();
	private UserService as=new UserService();
	private JPanel contentPane;
	private Integer id;
	private JTextField nick;
	private JPasswordField pwd;
	private JLabel label;
	private JButton button;
	public static Integer usr;
	public static String pw;
	public static String usrGroup;//身份(用户/管理员);
	public static LoginFrame1 frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame1();
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
	public LoginFrame1() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(71, 39, 54, 15);
		contentPane.add(lblNewLabel);
		
		nick = new JTextField();
		nick.setBounds(135, 36, 156, 21);
		contentPane.add(nick);
		nick.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setBounds(198, 133, 93, 23);
		contentPane.add(btnNewButton);
	 
		
		label = new JLabel("密码：");
		label.setBounds(71, 76, 54, 15);
		contentPane.add(label);
		
		pwd = new JPasswordField();
		pwd.setBounds(135, 73, 156, 21);
		contentPane.add(pwd);
		
		button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegFrame1 rf = new RegFrame1();
				rf.frame = rf;
				rf.setVisible(true);
			}
		});
		button.setBounds(95, 133, 93, 23);
		contentPane.add(button);
	}
	//登陆
	private void login() {
		String nick = this.getNick().getText();
		String pwd = String.valueOf(this.getPwd().getPassword());
		User at=as.queryByLogin(nick,pwd);
		if(at!=null) {
			
			usr=at.getId();
			pw=at.getPwd();
			usrGroup=at.getUsrGroup();
			
			ls.insert(new Log("登录",at.getId()));
			
			this.setVisible(false);
			MainFrame pf = new MainFrame();
			pf.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "登录失败,用户名或者密码错误！");
		}
		
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public JTextField getNick() {
		return nick;
	}

	public void setNick(JTextField nick) {
		this.nick = nick;
	}

	public JPasswordField getPwd() {
		return pwd;
	}

	public void setPwd(JPasswordField pwd) {
		this.pwd = pwd;
	}
	public static Integer getUsr() {
		return usr;
	}

	public static void setUsr(Integer usr) {
		LoginFrame1.usr = usr;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		LoginFrame1.pw = pw;
	}

	public static String getUsrGroup() {
		return usrGroup;
	}

	public static void setUsrGroup(String usrGroup) {
		LoginFrame1.usrGroup = usrGroup;
	}
}
