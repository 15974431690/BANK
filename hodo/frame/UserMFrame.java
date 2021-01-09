package com.hodo.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hodo.model.User;
import com.hodo.service.UserService;
import com.hodo.util.DateUtil;

public class UserMFrame extends JFrame {

	private JPanel contentPane;
	private String[] columnCount= {"序号","用户名","密码","姓名","性别","身份"};
	private List<User> list;
	private JTable table;
	private UserService as=new UserService();
	public static UserMFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserMFrame();
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
	public UserMFrame() {
		setTitle("用户管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton searchButton = new JButton("查询");
		searchButton.setBounds(36, 21, 93, 23);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quaryAll();
			}
		});
		contentPane.add(searchButton);
		
		JButton button_1 = new JButton("添加");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserEditFrame af=new UserEditFrame();
				af.setVisible(true);
			}
		});
		button_1.setBounds(165, 21, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				//quaryAll();
			}
		});
		button_2.setBounds(304, 21, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("删除");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
				quaryAll();
			}
		});
		button_3.setBounds(438, 21, 93, 23);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 618, 439);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
	}
	
	//查询
	public void quaryAll() {
		list = as.queryAll();
		if(list==null) {
			JOptionPane.showMessageDialog(null, "服务器繁忙");
			return;
		}
		Object[][] data = DateUtil.userListToArray(list);
		table.setModel(new DefaultTableModel(data, columnCount));
	}
	//修改
	private void update() {
		int i = table.getSelectedRow();
		if(i!=-1){
			User user = list.get(i);
			UserEditFrame af=new UserEditFrame();
			af.setId(user.getId());
			af.getUsrnm().setText(user.getUsrnm());
			af.getPwd().setText(user.getPwd());
			af.getNm().setText(user.getNm());
			af.getSex().setSelectedItem(user.getSex());
			af.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,"请选择一条记录！");
		}
	}
	//删除
	private void remove() {
		int i = table.getSelectedRow();
		if(i!=-1){
			User s = list.get(i);
			int code = as.delete(s.getId());
			if(code==0) {
				JOptionPane.showMessageDialog(null, "删除成功");
				return;
			}else {
				JOptionPane.showMessageDialog(null,"操作失败" );
			}
			quaryAll();
		} else {
			JOptionPane.showMessageDialog(null,"操作失败");
		}
		
	}
}
