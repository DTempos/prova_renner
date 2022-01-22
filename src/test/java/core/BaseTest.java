package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	public static String testName;
	public static String caminho = "target/evidencias/";
	public static String caminho_evidencia;
	public static String caminhoEvidenciaCompletoErros = "";
	public static String execucao;
	public static int contadorPassos = 1;
	public static String ambienteTeste = null;

	@After
	public static void finaliza() throws IOException {
		takeScreenshot();
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

	public static void takeScreenshot() throws IOException {
		String carimbo_data = getCarimboData();
		File arquivo = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String fullPath = caminho_evidencia + "/" + carimbo_data + "-" + testName + ".png";
		FileUtils.copyFile(arquivo, new File(fullPath));
	}

	/*
	 * Screenshot da tela aplica nome da tela no nome do screenshot variables tela
	 */
	public static void takeScreenshot(String screen) throws IOException {
		String carimbo_data = getCarimboData();
		System.out.println(getDriver());
		File arquivo = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String fullPath = caminho_evidencia + "/" + carimbo_data + " - " + "Passo " + contadorPassos + " - " + screen
				+ ".png";
		caminhoEvidenciaCompletoErros = fullPath;

		FileUtils.copyFile(arquivo, new File(fullPath));
		contadorPassos++;
	}

	/*
	 * retorna o carimbo da data no formato selecionado
	 * 
	 * variables formato = default null
	 */
	public static String getCarimboData() {
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		return date;
	}

	/*
	 * retorna o carimbo da data no formato selecionado
	 * 
	 * variables formato = default null
	 */
	public static String getCarimboData(String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		return date;
	}

	/*
	 * cria diretorio da evidencia
	 * 
	 * variable String nome_diretorio
	 */
	public static String criaDiretorio(String nome_diretorio) {
		String caminho_completo = caminho + nome_diretorio;
		System.out.println("Caminho completo: " + caminho_completo);
		System.out.println("Nome diretorio: " + nome_diretorio);

		return caminho_completo;
	}

}