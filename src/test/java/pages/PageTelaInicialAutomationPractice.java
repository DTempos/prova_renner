package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaInicialAutomationPractice extends BasePage {

	/**
	 * Abrir a página do Automation Practice
	 * 
	 * @throws Exception
	 */
	public void abrirPagina(String url) throws Exception {
		dsl.abrirUrl(url);
	}
	
	/**
	 * Clicar no botão 'Sign In' no menu superior para fazer login
	 * @throws Exception
	 */
	public void clicarBotaoSignIn() throws Exception {
		dsl.visibilidadeElementoPorXpath("//a[@title ='Log in to your customer account']", 60);
		BaseTest.takeScreenshot("Clicando no botão Sign In");
		dsl.clicarPorXpath("//a[@title ='Log in to your customer account']");
	}
	
	/**
	 * Digitar palavra-chave para pesquisar na tela inicial
	 * @param palavra_pesquisa
	 * @throws Exception
	 */
	public void digitarPalavraParaPesquisar(String palavra_pesquisa) throws Exception {
		dsl.visibilidadeElementoPorId("search_query_top", 60);
		dsl.limparCampoPorId("search_query_top");
		dsl.escrevePorId("search_query_top", palavra_pesquisa);
	}
	
	/**
	 * Clicar no botão Pesquisar da tela inicial
	 * @throws Exception
	 */
	public void clicarBotaoPesquisarTelaInicial() throws Exception {
		dsl.visibilidadeElementoPorXpath("//button[@name = 'submit_search']", 30);
		dsl.clicarPorXpath("//button[@name = 'submit_search']");
	}

}
