/**
 * 
 */
package com.tradingview.ru.util;

import com.tradingview.ru.base.BaseTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

/**
 *  These is ScreenShot listener, which is needed to create
 * 	screens on test cases failures.
 * 	ScreenShot are usually saved in path.
 */

public class ScreenShot extends TestListenerAdapter {
	private static final Logger LOGGER = Logger.getLogger(ScreenShot.class);

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.setCurrentTestResult(result);

		try {
			BaseTest.captureScreenShot(result.getName());
		} catch (Exception e) {
			LOGGER.warn("Unable to capture screenshot.  Continuing...", e);
		}
		Reporter.setCurrentTestResult(null);
	}

}
