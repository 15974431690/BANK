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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.hodo.model.Acct;
import com.hodo.model.User;
import com.hodo.service.AcctService;
import com.hodo.service.UserService;
import com.hodo.util.IdUtil;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegFrame1 extends JFrame {
	
	private UserService as=new UserService();
	private JPanel contentPane;
	
	private Integer id;
	private JTextField usrnm;
	private JPasswordField pwd;
	private JTextField nm;
	
	private JLabel label;
	public static RegFrame1 frame;
	private JComboBox sex;
	public AcctService acctService = new AcctService();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrame1 frame = new RegFrame1();
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
	public RegFrame1() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(71, 39, 54, 15);
		contentPane.add(lblNewLabel);
		
		usrnm = new JTextField();
		usrnm.setBounds(135, 36, 156, 21);
		contentPane.add(usrnm);
		usrnm.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(71, 125, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(71, 177, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnNewButton.setBounds(135, 261, 93, 23);
		contentPane.add(btnNewButton);
		
	    SpinnerModel spinnerModel1 = new SpinnerNumberModel(20, // initial value
                0, // min
                100, // max
                1);
       
		
		label = new JLabel("密码：");
		label.setBounds(71, 76, 54, 15);
		contentPane.add(label);
		
		pwd = new JPasswordField();
		pwd.setBounds(135, 73, 156, 21);
		contentPane.add(pwd);
		
		nm = new JTextField();
		nm.setBounds(132, 122, 159, 21);
		contentPane.add(nm);
		nm.setColumns(10);
		
		sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));
		sex.setBounds(130, 174, 161, 21);
		contentPane.add(sex);
	}
	//修改
	private void update() {
		User a;
		int i = -1;
		if(this.getId()!=null && this.getId()!=0){
			a=as.queryOne(this.getId());
			a.setUsrnm(this.getUsrnm().getText());
			a.setPwd(String.valueOf(this.getPwd().getPassword()));
			a.setNm(this.getNm().getText());
			a.setSex(this.getSex().getSelectedItem().toString());
			
			i = as.update(a);
		} else {
			a = new User();
			
			a.setUsrnm(this.getUsrnm().getText());
			a.setPwd(String.valueOf(this.getPwd().getPassword()));
			a.setNm(this.getNm().getText());
			a.setSex(this.getSex().getSelectedItem().toString());
			a.setUsrGroup("用户");
			int j=as.insert(a);
			if(j==0) {
				Acct acct = new Acct();
				
				acct.setAcctNo(IdUtil.generateSequenceNo());
				acct.setAmt(10000);
				User user = as.queryOneLast();
				acct.setUserId(user.getId());
				i=acctService.insert(acct);
				
			}
			
		}
		
		if(i==0) {
			
			JOptionPane.showMessageDialog(null, "操作成功");
			dispose();
			return;
		}else {
			JOptionPane.showMessageDialog(null, "操作失败");
		}
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JPasswordField getPwd() {
		return pwd;
	}

	public void setPwd(JPasswordField pwd) {
		this.pwd = pwd;
	}

	public JTextField getNm() {
		return nm;
	}

	public void setNm(JTextField nm) {
		this.nm = nm;
	}

	public JTextField getUsrnm() {
		return usrnm;
	}

	public void setUsrnm(JTextField usrnm) {
		this.usrnm = usrnm;
	}

	public JComboBox getSex() {
		return sex;
	}

	public void setSex(JComboBox sex) {
		this.sex = sex;
	}

}
