package pages;

import core.BasePage;

public class PageTelaLogin extends BasePage {

	/**
	 * Inserir email de login
	 * @param email_login
	 * @throws Exception
	 */
	public void informarEmailLogin(String email_login) throws Exception {
		dsl.visibilidadeElementoPorId("email", 60);
		dsl.escrevePorId("email", email_login);
	}
	
	/**
	 * Inserir senha de login
	 * @param senha_login
	 * @throws Exception
	 */
	public void informarSenhaLogin(String senha_login) throws Exception {
		dsl.visibilidadeElementoPorId("passwd", 60);
		dsl.escrevePorId("passwd", senha_login);
	}
	
	/**
	 * Clicar no botão Sign In da tela de login
	 * @throws Exception
	 */
	public void clicarBotaoSignIn() throws Exception {
		dsl.visibilidadeElementoPorXpath("//button[@id = 'SubmitLogin']/span/i", 60);
		dsl.clicarPorXpath("//button[@id = 'SubmitLogin']/span/i");
	}

}
