/**
 * 
 */
package sist.awt.adaptor;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 *
 */
public class AdapterSample {
	Frame frame;
	Button btnWest;
	Button btnEast;
	Button btnNorth;
	Button btnSouth;
	Button btnCenter;
	
	public AdapterSample() {
		frame = new Frame("Adapter");
		btnWest   = new Button("West");
		btnEast   = new Button("East");
		btnNorth  = new Button("North");
		btnSouth  = new Button("South");
		btnCenter = new Button("Center");
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void launchFrame() {
		frame.add(btnWest, "West");
		frame.add(btnEast, "East");
		frame.add(btnNorth, "North");
		frame.add(btnSouth, "South");
		frame.add(btnCenter, "Center");
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		AdapterSample as = new AdapterSample();
		as.launchFrame();
	}
}
