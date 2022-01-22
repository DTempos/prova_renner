package pages;

import core.BasePage;

public class PageTelaProduto extends BasePage {

	
	/**
	 * Selecionar o tamanho do produto na tela do produto
	 * @param tamanho_produto
	 * @throws Exception
	 */
	public void selecionarTamanhoProduto(String tamanho_produto) throws Exception {
		dsl.esperarElementoPorXpath("//div[@id = 'attributes']/fieldset[1]/div/div/select", 30);
//		dsl.esperarElementoPorId("group_1", 30);
		dsl.selecionarComboPorXpath("//div[@id = 'attributes']/fieldset[1]/div/div/select", tamanho_produto);
	}
	
	/**
	 * Clicar no botão Add to cart da tela do produto
	 * @throws Exception
	 */
	public void clicarBotaoAddToCart() throws Exception {
		dsl.visibilidadeElementoPorXpath("//button[@name = 'Submit']/span", 30);
		dsl.clicarPorXpath("//button[@name = 'Submit']/span");
	}
	
	/**
	 * Retorna o nome do produto adicionado ao carrinho na tela do produto
	 * @return
	 * @throws Exception
	 */
	public String validarNomeProdutoCorretoAdicionadoAoCarrinho() throws Exception {
		dsl.visibilidadeElementoPorXpath("//span[@id = 'layer_cart_product_title']", 30);
		String nome_produto = dsl.obterTextoPorXpath("//span[@id = 'layer_cart_product_title']");
		
		return nome_produto; 
	}
	
	/**
	 * Retorna os atributos do produto adicionado ao carrinho na tela do produto
	 * @return
	 * @throws Exception
	 */
	public String validarAtributosProdutoCorretoAdicionadoAoCarrinho() throws Exception {
		dsl.visibilidadeElementoPorXpath("//span[@id = 'layer_cart_product_attributes']", 30);
		String atributos_produto = dsl.obterTextoPorXpath("//span[@id = 'layer_cart_product_attributes']");
		
		return atributos_produto; 
	}
	
	/**
	 * Clicar no botão Continue Shopping
	 * @throws Exception
	 */
	public void clicarBotaoContinueShopping() throws Exception {
		dsl.visibilidadeElementoPorXpath("//span[@title = 'Continue shopping']", 30);
		dsl.clicarPorXpath("//span[@title = 'Continue shopping']");
	}

	/**
	 * Clicar no botão Proceed to Checkout
	 * @throws Exception
	 */
	public void clicarBotaoProceedToCheckout() throws Exception {
		dsl.visibilidadeElementoPorXpath("//a[@title = 'Proceed to checkout']", 30);
		dsl.clicarPorXpath("//a[@title = 'Proceed to checkout']");
	}
	
	public void selecionarQtdeProduto(String qtde_produto) throws Exception {
		dsl.visibilidadeElementoPorId("quantity_wanted", 60);
		dsl.limparCampoPorId("quantity_wanted");
		Thread.sleep(3000);
		dsl.escrevePorId("quantity_wanted", qtde_produto);
	}
	
	/**
	 * Selecionar a cor do produto
	 * @param nome_ingles_cor_produto
	 * @throws Exception
	 */
	public void selecionarCorProduto(String nome_ingles_cor_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//a[@title = '" + nome_ingles_cor_produto +"']", 30);
		dsl.clicarPorXpath("//a[@title = '" + nome_ingles_cor_produto + "']");
	}
	
}
