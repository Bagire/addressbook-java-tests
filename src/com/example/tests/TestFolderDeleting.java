package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderDeleting extends TestBase {

	@Test
	public void testOneFolderDeleting() {
		String folder = "newfolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().deleteFolder(oldFolders, folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withoutDeleted(folder)));
	}

	@Test
	public void testOneFolderDeletingByIndex() {
		int index = 0;
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().deleteFolder(index), is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withoutDeleted(index)));
	}
}
