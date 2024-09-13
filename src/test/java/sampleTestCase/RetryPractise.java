package sampleTestCase;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryPractise {
	@Test(retryAnalyzer = genericLibrary.RetryAnalyserImplementation.class)
	public void retryPractise() {
		Assert.fail();
		System.out.println("Retry-Practise");
	}
}
