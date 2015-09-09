/**
 * 
 */
package sist.awt.exam;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class ChoiceTest {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300, 200);
		f.setLayout(null);
		
		Choice day = new Choice();
		day.add("SUN");
		day.add("MON");
		day.add("TUE");
		day.add("WED");
		day.add("THU");
		day.add("FRI");
		day.add("SAT");
		
		day.setSize(100, 50);
		day.setLocation(100, 70);
		
		f.add(day);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
