package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import Style.myTable;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

public class display {

	private JFrame frame;
	private JTable table;
	private JPanel tableContainerPanel;
	private JLabel dateLabel;
	private JLabel currrentDate;
	private JPanel rightPanel;
	
	private int day;
	private int month;
	private int year;
	
	private Object[] rowName= {"日","一","二","三","四","五","六"};
	private Object[][] rowData;
	
	private int sign;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display window = new display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public display() {
		day=initDate.getInitDay();
		month=initDate.getInitMonth();
		year=initDate.getInitYear();
		rowData= Cal.Solution();
		sign=1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1050, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.control);
		topPanel.setBounds(0, 0, 1032, 50);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		
		//新建事项
		JButton newEvent = new JButton("");
		newEvent.setBounds(64, 0, 150, 50);
		topPanel.add(newEvent);
		newEvent.setIcon(new ImageIcon("icon\\new event.png"));
		newEvent.setContentAreaFilled(false);
		newEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("new event");
			}
		});
		newEvent.setBorderPainted(false);
		
		//当前日期
		dateLabel = new JLabel("2019年11日");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		dateLabel.setBounds(516, 0, 200, 50);
		topPanel.add(dateLabel);
		
		JPanel belowPanel = new JPanel();
		belowPanel.setToolTipText("");
		belowPanel.setBackground(Color.WHITE);
		belowPanel.setBounds(0, 50, 1032, 683);
		frame.getContentPane().add(belowPanel);
		belowPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerSize(1);
		splitPane.setBackground(SystemColor.window);
		splitPane.setDividerLocation(308);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBounds(0, 0, 1031, 683);
		belowPanel.add(splitPane);
		
		rightPanel = new JPanel(null);
		JPanel bodyPanel=body.bodyPanel(month, year);
		bodyPanel.setBounds(0, 0, 750, 680);
		rightPanel.add(bodyPanel);
		rightPanel.setBackground(SystemColor.window);
		splitPane.setRightComponent(rightPanel);
				
		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		leftPanel.setLayout(null);
							
		currrentDate = new JLabel(year+"年"+month+"月");
		currrentDate.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		currrentDate.setHorizontalAlignment(SwingConstants.CENTER);
		currrentDate.setBounds(0, 0, 200, 50);
		leftPanel.add(currrentDate);
		
		//表格的容器面板
		tableContainerPanel = new JPanel();				
		tableContainerPanel.setLocation(0, 0);
		tableContainerPanel.setLayout(null);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(0, 0);
		if(rowData.length==5) {
			tableContainerPanel.setBounds(0, 50, 300, 239);
			scrollPane.setBounds(0, 0, 300, 239);
		}
		if(rowData.length==6) {
			tableContainerPanel.setBounds(0, 50, 300, 281);
			scrollPane.setBounds(0, 0, 300, 281);
		}
		leftPanel.add(tableContainerPanel);
		tableContainerPanel.add(scrollPane);

		//小日历显示			
		table = myTable.table(rowData,rowName);
		scrollPane.setViewportView(table);
		
		//今天
		JButton today = new JButton("");
		today.setIcon(new ImageIcon("icon\\today.png"));
		today.setContentAreaFilled(false);
		today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day=initDate.getInitDay();
				month=initDate.getInitMonth();
				year=initDate.getInitYear();
				tableContainerPanel.removeAll();
				rowData= Cal.Solution(month,year);
				JScrollPane newScrollPane = new JScrollPane();
				if(rowData.length==5) {
					tableContainerPanel.setSize(300, 239);
					newScrollPane.setBounds(0, 0, 300, 239);
				}
				if(rowData.length==6) {
					tableContainerPanel.setSize(300, 281);
					newScrollPane.setBounds(0, 0, 300, 281);
				}
				JTable newTable = myTable.table(rowData,rowName);
				newScrollPane.setViewportView(newTable);				
				tableContainerPanel.add(newScrollPane);	
				currrentDate.setText(year+"年"+month+"月");
				dateLabel.setText(year+"年"+month+"月");
			}
		});
		today.setBorderPainted(false);
		today.setBounds(230, 0, 150, 50);
		topPanel.add(today);
		
		
		//上个月
		JButton up = new JButton("");
		up.addActionListener(dateChangeAction(0));
		up.setIcon(new ImageIcon("icon\\up.png"));
		up.setBounds(200, 0, 50, 50);
		up.setContentAreaFilled(false);
		up.setBorderPainted(false);
		leftPanel.add(up);
		
		//上个月
		JButton left = new JButton("");
		left.addActionListener(dateChangeAction(0));
		left.setIcon(new ImageIcon("icon\\left.png"));
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setBounds(392, 0, 50, 50);
		topPanel.add(left);		
		
		//下个月
		JButton down = new JButton("");
		down.addActionListener(dateChangeAction(1));
		down.setIcon(new ImageIcon("icon\\down.png"));
		down.setBounds(250, 0, 50, 50);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		leftPanel.add(down);
						
		//下个月
		JButton right = new JButton("");
		right.addActionListener(dateChangeAction(1));
		right.setIcon(new ImageIcon("icon\\right.png"));
		right.setBorderPainted(false);
		right.setContentAreaFilled(false);
		right.setBounds(456, 0, 50, 50);
		topPanel.add(right);
		
		//折叠按钮
		JButton fold = new JButton("");
		fold.setIcon(new ImageIcon("icon\\flod.png"));
		fold.setBounds(0, 0, 50, 50);
		topPanel.add(fold);
		fold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sign==1) {
					splitPane.setDividerLocation(0);
					sign=0;
				}
				else if(sign==0) {	
					splitPane.setDividerLocation(300);
					sign=1;
				}
			}
		});
		fold.setContentAreaFilled(false);
		fold.setBorderPainted(false);
	}
	
	//日期更新事假
	private ActionListener dateChangeAction(int choose) {
		ActionListener ac=new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableContainerPanel.removeAll();
				//下个月
				if(choose==1) {
					if(month==12) {
						month=1;
						year+=1;
					}
					else
						month++;
				}
				//上个月
				else if(choose==0) {
					if(month==1) {
						month=12;
						year-=1;
					}
					else 
						month--;
				}
				rowData= Cal.Solution(month,year);
				JScrollPane newScrollPane = new JScrollPane();
				if(rowData.length==5) {
					tableContainerPanel.setSize(300, 239);
					newScrollPane.setBounds(0, 0, 300, 239);
				}
				if(rowData.length==6) {
					tableContainerPanel.setSize(300, 281);
					newScrollPane.setBounds(0, 0, 300, 281);
				}
				JTable newTable = myTable.table(rowData,rowName);
				newScrollPane.setViewportView(newTable);				
				tableContainerPanel.add(newScrollPane);	
				currrentDate.setText(year+"年"+month+"日");
				dateLabel.setText(year+"年"+month+"日");
				rightPanel.removeAll();
				JPanel bodyPanel=body.bodyPanel(month, year);
				bodyPanel.setBounds(0, 0, 750, 680);
				rightPanel.add(bodyPanel);
				rightPanel.updateUI();
			}
		};
		return ac;
	}
}
