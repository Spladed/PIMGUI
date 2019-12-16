package Display;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class body {
	private static JPanel rightPanel;
	
	private static Object[] rowName= {"周日","周一","周二","周三","周四","周五","周六"};
	private static Object[][] rowData;
	
	public static JPanel bodyPanel(int month,int year) {
		JPanel rightPanel=new JPanel(null);
		rightPanel.setBackground(SystemColor.window);
		
		rowData=Cal.Solution(month, year);
		
		for(int i=0,x=10,y=10;i<rowName.length;i++,x+=100) {
			JLabel label=new JLabel((String)rowName[i]);
			label.setBounds(x, y, 100, 100);
			label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
			label.setHorizontalAlignment(SwingConstants.CENTER);
//			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			rightPanel.add(label);
		}
		
		for(int i=0,x=10,y=110;i<rowData.length;i++,y+=100) {
			x=10;
			for(int j=0;j<7;j++,x+=100) {
				String str=rowData[i][j]+"";
				if(str.length()!=0) {
					JButton btn=new JButton(rowData[i][j]+"号");
					btn.setBounds(x, y, 100, 100);
					btn.setContentAreaFilled(false);
					btn.setBorderPainted(false);
					btn.setHorizontalAlignment(JButton.LEFT);
					btn.setVerticalAlignment(JButton.TOP);
					btn.addActionListener(addEventAction());
					rightPanel.add(btn);
				}
			}
		}
		
		return rightPanel;
	}
	
	private static ActionListener addEventAction() {
		ActionListener ac=new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		return ac;
	}
}
