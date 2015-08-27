// ButtonHandler.java
// 버튼 핸들러 예제
// p.460
package sist.awt.sample;
import java.awt.event.*;

public class ButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		System.out.println(cmd + "선택 하셨습니다.!");
	}
}