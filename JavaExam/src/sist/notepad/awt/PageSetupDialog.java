/**
 * 
 */
package sist.notepad.awt;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

/**
 * @author owner
 *
 */
public class PageSetupDialog {
	PageSetupDialog() {
		PrinterJob job = PrinterJob.getPrinterJob();

		PageFormat pf = job.pageDialog(job.defaultPage());
	}
}
