package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	monochrome = true,
					dryRun = false,
					features = { "resources/features" },
					glue = { "stepsDefinition" },
					plugin = { 
								"json:target/cucumber.json",
//								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/report.html"
							},
					tags = "@CT02"
					//test
				)

public class RunnerTest {

	@AfterClass
	public static void escreveExtentReport() throws Exception {
//		ExtentReports extentReports = new ExtentReports();
//		extentReports.flush();
//		extentReports.setGherkinDialect("pt"); 
//		Reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
	}
	
}

