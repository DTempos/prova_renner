package core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import stepsDefinition.Hooks;

public class BaseWebservice {
	
	public static String caminho_evidencia = "target/evidencias_webservice/";
	public static String carimbo_teste = BaseTest.getCarimboData("yyyyMMdd");
	
	public static void exportarEvidencia(String url, String body) throws IOException {
		String carimbo_data = BaseTest.getCarimboData();
		String fileData = null;
		FileOutputStream fos = null;

		if (Hooks.cenarioTag.contains("@API")) {
			fileData = "Tags com ID: " + Hooks.cenarioTag + "\n\n" + "URL: " + url + "\n\n"
					+ "Cenario: " + BaseTest.testName + "\n\n" + "Response:" + "\n\n" + body;

			String fullDirectory = System.getProperty("user.dir") + File.separator + caminho_evidencia + carimbo_teste
					+ File.separator + BaseTest.testName + File.separator + carimbo_data + File.separator;
			fullDirectory = fullDirectory.replace("/", File.separator);

			File dir = new File(fullDirectory);
			if (!dir.exists())
				dir.mkdirs();

			fos = new FileOutputStream(fullDirectory + "api" + "_" + carimbo_data + ".txt");
		}

		fos.write(fileData.getBytes());
		fos.flush();
		fos.close();

	}

}
