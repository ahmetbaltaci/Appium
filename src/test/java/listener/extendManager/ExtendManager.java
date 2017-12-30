package listener.extendManager;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtendManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "report.html", true);
        }
        return extent;
    }
}
