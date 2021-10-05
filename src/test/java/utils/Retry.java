package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                System.out.println("Retry once more time ...  ");
                return true;
            } else {
                iTestResult.setStatus(iTestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(iTestResult.SUCCESS);
        }
        return false;
    }
}
