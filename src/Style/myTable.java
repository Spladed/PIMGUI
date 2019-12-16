package Style;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class myTable {
	public static JTable table(Object[][] rowData,Object[] rowName) {
		JTable table=new JTable(rowData,rowName);		
		table.setBackground(SystemColor.control);
		table.setRowHeight(43);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	    tcr.setHorizontalAlignment(SwingConstants.CENTER);
	    table.setDefaultRenderer(Object.class, tcr);		
		return table;
	}
}
