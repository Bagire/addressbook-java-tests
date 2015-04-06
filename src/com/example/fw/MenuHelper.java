package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper extends HelpersBase {

	public MenuHelper(ApplicationManager Manager) {
		super (Manager);
	}

	public void pushCreateFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|New folder...");
	}

	public void pushDeleteFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|Delete");
	}

}
