package sampleTestCase;

import org.testng.annotations.Test;

public class PracticeTestNG {

	@Test(priority=1)
	public void createUser() {
		System.out.println("User Created");
	}

	@Test(priority=2)
	public void modifyUser() {
		System.out.println("User modified");
	}

	@Test(priority=3)
	public void deleteUser() {
		System.out.println("User deleted");
	}

}
