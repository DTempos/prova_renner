package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaAddress extends BasePage {

	/**
	 * Clicar no botão Proceed to Checkout da tela Address
	 * @throws Exception
	 */
	public void clicarBotaoProceedToCheckout() throws Exception {
		dsl.visibilidadeElementoPorXpath("//button[@name = 'processAddress']/span", 60);
		BaseTest.takeScreenshot("Clicando no botão Proceed to Checkout");
		dsl.clicarPorXpath("//button[@name = 'processAddress']/span");
	}
	
}
