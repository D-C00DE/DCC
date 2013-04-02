package dcc.frame.minis;

import java.io.File;

import javax.swing.JFileChooser;

public class getfile {
/*
 * Hmm, I want to use multithreading, and this static modifier here looks scary to me :/
 * I might change this...
 */
	public static File one(dcc.DCoutputH log,String title) {
                log.println(title);
		JFileChooser dialog = new JFileChooser();
		File file;
		dialog.setDialogTitle(title);
		dialog.showOpenDialog(dialog);
		dialog.setMultiSelectionEnabled(false);
		dialog.setVisible(true);
		file = dialog.getSelectedFile();
                log.println("loading file: " + file);
		return file;
	}

}
