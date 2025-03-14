package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.cs.Utilis.ScreenshotUtils;

public final class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenShot()).build());
    }

}
