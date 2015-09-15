/**
 * 
 */
package sist.class4.dtmanager.screen;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author owner
 *
 */
public class GridArea extends JPanel {
	
	// Instance attributes used in this example
//	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	
	public GridArea() {
		
		// Set the frame characteristics
		setLayout( new BorderLayout() );
		
		// Create columns names
		String columnNames[] = { "Column 1", "Column 2", "Column 3" };

		// Create some data
		String dataValues[][] =
		{
			{ "12", "234", "67" },
			{ "-123", "43", "853" },
			{ "93", "89.2", "109" },
			{ "12", "234", "67" },
			{ "-13", "43", "853" },
			{ "3", "8.2", "109" },
			{ "12", "34", "67" },
			{ "23", "43", "853" },
			{ "9", "9.2", "109" },
			{ "279", "9033", "3092" }
		};

		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		add( scrollPane, BorderLayout.CENTER );
	}
	
}
