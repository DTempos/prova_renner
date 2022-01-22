package stepsDefinition;

import java.io.IOException;
import java.util.Collection;

import com.aventstack.extentreports.ExtentReports;

import core.BaseTest;
import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	
	public static Collection<String> cenarioTag = null;
	ExtentReports extent = new ExtentReports();

//	GravarVideo gravarVideo = new GravarVideo();

	String carimbo_teste = BaseTest.getCarimboData("yyyyMMdd");
	String carimbo_dataHora = BaseTest.getCarimboData();

	@Before
	public void inicializa(Scenario cenario) throws Throwable {
		extent.setGherkinDialect("pt");
		cenarioTag = cenario.getSourceTagNames();

		System.setProperty("webdriver.gecko.driver", "resources/Driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "resources/Driver/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "resources/Driver/IEDriverServer.exe");

		BaseTest.testName = cenario.getName();
		BaseTest.execucao = carimbo_dataHora;
		System.out.println("nome da pasta da evidencia: " + carimbo_teste);
		BaseTest.caminho_evidencia = BaseTest
				.criaDiretorio(carimbo_teste + "/" + BaseTest.testName + "/" + BaseTest.execucao);

//		gravarVideo.startRecording(BaseTest.caminho_evidencia);

	}

	@After(order = 1)
	public void aposCenario(Scenario cenario) {
//		try {
//			gravarVideo.FinalizarGravacao();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		if (cenario.isFailed()) {
			BaseTest.testName = cenario.getName();
			BaseTest.caminho_evidencia = BaseTest
					.criaDiretorio(carimbo_teste + "/" + BaseTest.testName + "/" + BaseTest.execucao) + "/erros";
			try {
				BaseTest.takeScreenshot("Failed");
				String diretorio = System.getProperty("user.dir");
				String caminhoEvidenciaErro = BaseTest.caminhoEvidenciaCompletoErros;
				caminhoEvidenciaErro = caminhoEvidenciaErro.replace('/', '\\');
//				String caminhoEmbed = diretorio + "\\" + caminhoEvidenciaErro;
//				Reporter.addScreenCaptureFromPath(caminhoEmbed);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@After(order = 0)
	public void finalizaDriver() {
		DriverFactory.killDriver();
	}

}
