package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaShoppingCartSummary extends BasePage {

	/**
	 * Clicar no botão Proceed to Checkout da tela Shopping Cart Summary
	 * @throws Exception
	 */
	public void clicarBotaoProceedToCheckout() throws Exception {
		dsl.visibilidadeElementoPorXpath("//*[@class = 'cart_navigation clearfix']/a/span", 60);
		BaseTest.takeScreenshot("Clicando no botão Proceed to Checkout");
		dsl.clicarPorXpath("//*[@class = 'cart_navigation clearfix']/a/span");
	}
	
	public void teclaPageDown() throws Exception {
		dsl.pressionaTeclaPAGE_DOWN();
		Thread.sleep(2000);
	}

}
