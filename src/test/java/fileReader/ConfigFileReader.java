package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {

	private static final Path currentRelativePath = Paths.get("");
	private static final String currentPath = currentRelativePath.toAbsolutePath().toString();
	private static final String propertyFilePath = currentPath + "\\resources\\configs\\config.properties";

	private Properties properties;

	public ConfigFileReader() {
		try {
			BufferedReader readerProperties = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(readerProperties);
				readerProperties.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"ARQUIVO (Configuration.properties) NÃO ENCONTRADO NO CAMINHO ESPECIFICADO: " + propertyFilePath);
		}

	}

	public String getReportConfigPath() {
		String atributte = properties.getProperty("reportPath");
		new ConfigFileReader();
		if (atributte != null) {
			return atributte;
		} else
			throw new RuntimeException(
					"Report Config Path not specified in the config.properties file for the Key:reportPath");

	}

	public String getBrowserToRun() {
		String browser = properties.getProperty("browser");
		new ConfigFileReader();
		return browser;

	}

	public String getURLAutomationPractice() {
		String url_automation_practice = properties.getProperty("url_automation_practice");
		new ConfigFileReader();
		return url_automation_practice;
	}
	
	public String getEmailLogin() {
		String email_login = properties.getProperty("email_login");
		new ConfigFileReader();
		return email_login;
	}
	
	public String getSenhaLogin() {
		String senha_login = properties.getProperty("senha_login");
		new ConfigFileReader();
		return senha_login;
	}

}
