package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

public class FolderHelper extends HelpersBase{

	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			list.add(""+child);
		}
		return new Folders(list);
	}

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog= new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", 3000);
	}

	public void deleteFolder(Folders oldFolders, String folderName) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		int row = oldFolders.findFolder(folderName);
		if (row >= 0) {
			tree.selectRow(row);
			manager.getMenuHelper().pushDeleteFolder();
			JDialogOperator dialog= new JDialogOperator(mainFrame);
			new JButtonOperator(dialog, "Yes").push();
		}
	}

	public String deleteFolder(int index) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		tree.selectRow(index);
		manager.getMenuHelper().pushDeleteFolder();
		JDialogOperator dialog= new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
		return waitMessageDialog("Warning", 3000);
	}

}
