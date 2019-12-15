package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.UIManager;

public class display {

	private JFrame frame;
	private JTable table;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1256, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(SystemColor.control);
		topPanel.setBounds(0, 0, 1238, 50);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JButton fold = new JButton("");
		fold.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\flod.png"));
		fold.setBounds(0, 0, 50, 50);
		topPanel.add(fold);
		fold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		fold.setContentAreaFilled(false);
		fold.setBorderPainted(false);
		
		JButton left = new JButton("");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		left.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\left.png"));
		left.setBorderPainted(false);
		left.setContentAreaFilled(false);
		left.setBackground(SystemColor.control);
		left.setBounds(392, 0, 50, 50);
		topPanel.add(left);
		
		JButton right = new JButton("");
		right.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\right.png"));
		right.setBorderPainted(false);
		right.setContentAreaFilled(false);
		right.setBounds(456, 0, 50, 50);
		topPanel.add(right);
		
		JButton today = new JButton("");
		today.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\today.png"));
		today.setContentAreaFilled(false);
		today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		today.setBorderPainted(false);
		today.setBounds(230, 0, 150, 50);
		topPanel.add(today);
		
		JButton newEvent = new JButton("");
		newEvent.setBounds(64, 0, 150, 50);
		topPanel.add(newEvent);
		newEvent.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\new event.png"));
		newEvent.setContentAreaFilled(false);
		newEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		newEvent.setBorderPainted(false);
		
		JComboBox date = new JComboBox();
		date.setModel(new DefaultComboBoxModel(new String[] {"heiheihei", "hahaha", "666", "777"}));
		date.setBackground(SystemColor.control);
		date.setBounds(570, 0, 220, 50);
		topPanel.add(date);
		
		JPanel belowPanel = new JPanel();
		belowPanel.setToolTipText("");
		belowPanel.setBackground(Color.WHITE);
		belowPanel.setBounds(0, 50, 1238, 633);
		frame.getContentPane().add(belowPanel);
		belowPanel.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(SystemColor.window);
		splitPane.setDividerLocation(300);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBounds(0, 0, 1238, 633);
		belowPanel.add(splitPane);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(SystemColor.window);
		splitPane.setRightComponent(rightPanel);
		rightPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		leftPanel.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(0, 0, 200, 50);
		leftPanel.add(comboBox_1);
		
		JButton up = new JButton("New button");
		up.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\up.png"));
		up.setBounds(200, 0, 50, 50);
		up.setContentAreaFilled(false);
		up.setBorderPainted(false);
		leftPanel.add(up);
		
		JButton down = new JButton("New button");
		down.setIcon(new ImageIcon("C:\\Coding\\Java\\eclipse-workspace\\PIMGUI\\icon\\down.png"));
		down.setBounds(250, 0, 50, 50);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		leftPanel.add(down);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setBounds(0, 50, 300, 300);
		leftPanel.add(table);
	}
}
