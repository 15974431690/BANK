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

import com.hodo.model.Log;
import com.hodo.service.LogService;
import com.hodo.util.DateUtil;

public class LogMFrame extends JFrame {

	private JPanel contentPane;
	private String[] columnCount= {"序号","处理内容","时间","用户"};
	private List<Log> list;
	private JTable table;
	private LogService as=new LogService();
	public static LogMFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogMFrame();
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
	public LogMFrame() {
		setTitle("日志管理");
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
		
		JButton button_3 = new JButton("删除");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
				quaryAll();
			}
		});
		button_3.setBounds(153, 21, 93, 23);
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
		Object[][] data = DateUtil.logListToArray(list);
		table.setModel(new DefaultTableModel(data, columnCount));
	}

	//删除
	private void remove() {
		int i = table.getSelectedRow();
		if(i!=-1){
			Log s = list.get(i);
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
