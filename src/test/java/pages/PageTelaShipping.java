package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaShipping extends BasePage {

	/**
	 * Clicar no botão Proceed to Checkout da tela Shipping
	 * @throws Exception
	 */
	public void clicarBotaoProceedToCheckout() throws Exception {
		dsl.visibilidadeElementoPorXpath("//button[@name = 'processCarrier']/span", 60);
		BaseTest.takeScreenshot("Clicando no botão Proceed to Checkout");
		dsl.clicarPorXpath("//button[@name = 'processCarrier']/span");
	}
	
	public void clicarCheckboxTermsOfService() throws Exception {
		dsl.visibilidadeElementoPorXpath("//div[@id = 'uniform-cgv']/span", 30);
		dsl.clicarPorXpath("//div[@id = 'uniform-cgv']/span");
	}
	

}
