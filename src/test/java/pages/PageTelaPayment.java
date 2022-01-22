package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaPayment extends BasePage {

	/**
	 * Clicar no botão Pay by bank-wire
	 * @throws Exception
	 */
	public void clicarBotaoPayByBankWire() throws Exception {
		dsl.visibilidadeElementoPorXpath("//a[@title = 'Pay by bank wire']", 60);
		BaseTest.takeScreenshot("Clicando em Pagar por transferência bancária");
		dsl.clicarPorXpath("//a[@title = 'Pay by bank wire']");
	}
	
	/**
	 * Clicar no botão I confirm my order
	 * @throws Exception
	 */
	public void clicarBotaoIConfirmMyOrder() throws Exception {
		dsl.visibilidadeElementoPorXpath("//p[@id = 'cart_navigation']/button/span", 60);
		BaseTest.takeScreenshot("Clicando no botão para Confirmar Pedido");
		dsl.clicarPorXpath("//p[@id = 'cart_navigation']/button/span");
	}

	/**
	 * Validar se pedido foi finalizado com sucesso
	 * @return
	 * @throws Exception
	 */
	public boolean validarSePedidoFoiFinalizadoComSucesso() throws Exception {
		dsl.visibilidadeElementoPorXpath("//strong[text() = 'Your order on My Store is complete.']", 60);
		
		return true;
	}
}
