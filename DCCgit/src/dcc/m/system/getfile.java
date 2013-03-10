package dcc.m.system;

import java.io.File;

import javax.swing.JFileChooser;

public class getfile {

	public static File one(dcc.DCoutputH log) {
		JFileChooser dialog = new JFileChooser();
		File file = null;
		boolean checking = true;
		dialog.showOpenDialog(dialog);
		dialog.setMultiSelectionEnabled(false);
		dialog.setVisible(true);
		while (checking == true){
			file = dialog.getSelectedFile();
			log.println("loading file: " + file);
			if (file != null){
				checking = false;
				return file;
			}
		}
		return file;
	}

}
