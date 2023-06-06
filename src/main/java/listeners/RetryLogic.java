package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {

    int maxCount = 3;
    int count = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
            if (count < maxCount) {
                count++;
                return true;
            }

        return false;
    }
}
