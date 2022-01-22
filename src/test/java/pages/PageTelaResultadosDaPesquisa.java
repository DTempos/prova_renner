package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaResultadosDaPesquisa extends BasePage {

	
	/**
	 * Validar que está na página onde exibe os produtos pesquisados
	 * @return
	 * @throws Exception
	 */
	public boolean validarQueEstaNaPaginaDePesquisa() throws Exception {
		dsl.visibilidadeElementoPorXpath("//div[@id = 'center_column']/h1/span", 60);
		
		return true;
	}
	
	/**
	 * Ação de posicionar o mouse em cima do produto pesquisado exibindo os botões Add to Cart, More, Add to Wishlist, Add to Compare
	 * @param nome_produto
	 * @throws Exception
	 */
	public void exibirBotoesEscondidosDoProdutoPesquisado(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']", 60);
//		dsl.pressionaTeclaPAGE_DOWN();
		dsl.mouseOver("//h5[@itemprop = 'name']//a[@title = '" + nome_produto +"']");
		BaseTest.takeScreenshot("Visualizando opções de botões escondidos no produto");
	}
	
	/**
	 * Clicar no botão escondido Add to Cart para adicionar produto pesquisado ao carrinho de compras
	 * @throws Exception
	 */
	public void clicarBotaoAddToCart(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']", 60);
		dsl.mouseOver("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']");
		BaseTest.takeScreenshot("Visualizando botão de adicionar produto ao carrinho");
		dsl.clicarPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto +"']/../following-sibling::div[2]//a[@title = 'Add to cart']/span");
	}
	
	/**
	 * Selecionar a cor do produto na tela Resultado da Pesquisa
	 * @param nome_produto
	 * @throws Exception
	 */
	public void selecionarCorProdutoResultadoPesquisa(String nome_produto, String cor_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::div[3]/ul/li//a[@style = 'background:"+ cor_produto +";']", 30);
		BaseTest.takeScreenshot("Selecionando cor verde do produto");
		dsl.clicarPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::div[3]/ul/li//a[@style = 'background:" + cor_produto +";']");
	}
	
	/**
	 * Verificar se o produto está disponível para compra
	 * @param nome_produto
	 * @return
	 * @throws Exception
	 */
	public String verificarSeProdutoPesquisadoEstaDisponivel(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::span/span", 30);
		dsl.pressionaTeclaPAGE_DOWN();
		BaseTest.takeScreenshot("Produto disponível em estoque");
		String disponibilidade_produto = dsl.obterTextoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::span/span");
		
		return disponibilidade_produto; 
	}
	
	/**
	 * Clicar no botão escondido More para ir à tela do produto
	 * @throws Exception
	 */
	public void clicarBotaoMore(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']", 60);
		dsl.mouseOver("//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']");
		BaseTest.takeScreenshot("Clicando no botão More para acessar produto");
		dsl.clicarPorXpath("//h5[@itemprop = 'name']//a[@title = '" + nome_produto +"']/../following-sibling::div[2]//a[@title = 'View']/span");
	}
	
	/**
	 * Verificar se o primeiro produto encontrado está disponível para compra
	 * @param nome_produto
	 * @return
	 * @throws Exception
	 */
	public String verificarSeProdutoPesquisadoEstaDisponivelPrimeiroEncontrado(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("(//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::span/span/link)[1]", 60);
		String disponibilidade_produto = dsl.obterTextoPorXpath("(//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "']/../following-sibling::span/span/link)[1]");
		
		return disponibilidade_produto; 
	}
	
	/**
	 * Clicar no botão escondido More para ir à tela do produto para primeiro encontrado
	 * @throws Exception
	 */
	public void clicarBotaoMorePrimeiroEncontrado(String nome_produto) throws Exception {
		dsl.visibilidadeElementoPorXpath("(//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "'])[1]", 60);
		dsl.mouseOver("(//h5[@itemprop = 'name']//a[@title = '" + nome_produto + "'])[1]");
		BaseTest.takeScreenshot("Visualizando botão de adicionar produto ao carrinho");
		dsl.clicarPorXpath("(//h5[@itemprop = 'name']//a[@title = '" + nome_produto +"']/../following-sibling::div[2]//a[@title = 'View']/span)[1]");
	}
	

}
