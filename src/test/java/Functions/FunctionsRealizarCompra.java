package Functions;

import static org.junit.Assert.assertTrue;

import javax.management.RuntimeErrorException;

import core.BaseTest;
import managers.FileReaderManager;
import pages.PageTelaAddress;
import pages.PageTelaInicialAutomationPractice;
import pages.PageTelaLogin;
import pages.PageTelaPayment;
import pages.PageTelaProduto;
import pages.PageTelaResultadosDaPesquisa;
import pages.PageTelaShipping;
import pages.PageTelaShoppingCartSummary;

public class FunctionsRealizarCompra {

	PageTelaInicialAutomationPractice pageTelaInicialAutomationPractice = new PageTelaInicialAutomationPractice();
	PageTelaLogin pageTelaLogin = new PageTelaLogin();
	PageTelaResultadosDaPesquisa pageTelaResultadosDaPesquisa = new PageTelaResultadosDaPesquisa();
	PageTelaProduto pageTelaProduto = new PageTelaProduto();
	PageTelaShoppingCartSummary pageTelaShoppingCartSummary = new PageTelaShoppingCartSummary();
	PageTelaAddress pageTelaAddress = new PageTelaAddress();
	PageTelaShipping pageTelaShipping = new PageTelaShipping();
	PageTelaPayment pageTelaPayment = new PageTelaPayment();
	
	
	public void abrirTelaInicialAutomationPractice() throws Exception {
		String url = null;
		url = FileReaderManager.getInstance().getConfigReader().getURLAutomationPractice();
		pageTelaInicialAutomationPractice.abrirPagina(url);
	}

	public void acessarTelaDeLogin() throws Exception {
		String email_login = FileReaderManager.getInstance().getConfigReader().getEmailLogin();
		String senha_login = FileReaderManager.getInstance().getConfigReader().getSenhaLogin();
		
		pageTelaInicialAutomationPractice.clicarBotaoSignIn();
		pageTelaLogin.informarEmailLogin(email_login);
		pageTelaLogin.informarSenhaLogin(senha_login);
		BaseTest.takeScreenshot("Login preenchido");
		pageTelaLogin.clicarBotaoSignIn();
	}
	
	public void pesquisarProdutoTelaInicial(String nome_produto) throws Exception {
		pageTelaInicialAutomationPractice.digitarPalavraParaPesquisar(nome_produto);
		BaseTest.takeScreenshot("Pesquisando produto");
		pageTelaInicialAutomationPractice.clicarBotaoPesquisarTelaInicial();
	}
	
	public void selecionarProdutoPesquisado(String nome_produto, String cor_produto, String tamanho_produto, String qtde_produto) throws Exception {
		assertTrue(pageTelaResultadosDaPesquisa.validarQueEstaNaPaginaDePesquisa());
		BaseTest.takeScreenshot("Exibindo produtos");
		String nome_ingles_cor_produto = null;
		
		pageTelaResultadosDaPesquisa.exibirBotoesEscondidosDoProdutoPesquisado(nome_produto);
		
		switch (cor_produto) {
			case "verde":
				cor_produto = "#A0D468";
				nome_ingles_cor_produto = "Green";
				break;
			case "azul":
				cor_produto = "#5D9CEC";
				nome_ingles_cor_produto = "Blue";
				break;
		}
		
		if (cor_produto.isBlank() & tamanho_produto.isBlank() & qtde_produto != null) {
			try {
				if (pageTelaResultadosDaPesquisa.verificarSeProdutoPesquisadoEstaDisponivel(nome_produto).equalsIgnoreCase("in stock")) {
					BaseTest.takeScreenshot("Produto selecionado");
					pageTelaResultadosDaPesquisa.clicarBotaoMore(nome_produto);
					pageTelaProduto.selecionarQtdeProduto(qtde_produto);
					pageTelaProduto.clicarBotaoAddToCart();
					assertTrue(pageTelaProduto.validarNomeProdutoCorretoAdicionadoAoCarrinho().equalsIgnoreCase(nome_produto));
					BaseTest.takeScreenshot("Validando informações do produto correto adicionado ao carrinho");
				}
			} catch (RuntimeErrorException e) {
				BaseTest.takeScreenshot("Produto não encontrado");
				System.out.println("Produto não encontrado");
			}
		} else if (tamanho_produto.isBlank()) {
			try {
				if (pageTelaResultadosDaPesquisa.verificarSeProdutoPesquisadoEstaDisponivel(nome_produto).equalsIgnoreCase("in stock")) {
					pageTelaResultadosDaPesquisa.clicarBotaoMore(nome_produto);
					Thread.sleep(2000);//automação rápida não dah tempo de selecionar cor
					pageTelaProduto.selecionarCorProduto(nome_ingles_cor_produto);
					BaseTest.takeScreenshot("Produto selecionado na cor desejada");
					pageTelaProduto.clicarBotaoAddToCart();
					assertTrue(pageTelaProduto.validarNomeProdutoCorretoAdicionadoAoCarrinho().equalsIgnoreCase(nome_produto));
					assertTrue(pageTelaProduto.validarAtributosProdutoCorretoAdicionadoAoCarrinho().contains(nome_ingles_cor_produto));
					BaseTest.takeScreenshot("Validando informações do produto correto adicionado ao carrinho");
				}
			} catch (RuntimeErrorException e) {
				BaseTest.takeScreenshot("Produto não encontrado");
				System.out.println("Produto não encontrado");
			}
		} else if (cor_produto.isBlank() & tamanho_produto.isBlank() & qtde_produto.isBlank()) {
			try {
				if (pageTelaResultadosDaPesquisa.verificarSeProdutoPesquisadoEstaDisponivelPrimeiroEncontrado(nome_produto).equalsIgnoreCase("in stock")) {
					BaseTest.takeScreenshot("Produto selecionado");
					pageTelaResultadosDaPesquisa.clicarBotaoMorePrimeiroEncontrado(nome_produto);
					pageTelaProduto.clicarBotaoAddToCart();
					assertTrue(pageTelaProduto.validarNomeProdutoCorretoAdicionadoAoCarrinho().equalsIgnoreCase(nome_produto));
					BaseTest.takeScreenshot("Validando informações do produto correto adicionado ao carrinho");
				}
			} catch (RuntimeErrorException e) {
				BaseTest.takeScreenshot("Produto não encontrado");
				System.out.println("Produto não encontrado");
			}
		} else {
			try {
				if (pageTelaResultadosDaPesquisa.verificarSeProdutoPesquisadoEstaDisponivel(nome_produto).equalsIgnoreCase("in stock")) {
					pageTelaResultadosDaPesquisa.clicarBotaoMore(nome_produto);
					pageTelaProduto.selecionarCorProduto(nome_ingles_cor_produto);
					pageTelaProduto.selecionarTamanhoProduto(tamanho_produto);
					BaseTest.takeScreenshot("Produto selecionado na cor e tamanho desejado");
					pageTelaProduto.clicarBotaoAddToCart();
					assertTrue(pageTelaProduto.validarNomeProdutoCorretoAdicionadoAoCarrinho().equalsIgnoreCase(nome_produto));
					assertTrue(pageTelaProduto.validarAtributosProdutoCorretoAdicionadoAoCarrinho().contains(nome_ingles_cor_produto));
					assertTrue(pageTelaProduto.validarAtributosProdutoCorretoAdicionadoAoCarrinho().contains(tamanho_produto));
					BaseTest.takeScreenshot("Validando informações do produto correto adicionado ao carrinho");
				}
			} catch (RuntimeErrorException e) {
				BaseTest.takeScreenshot("Produto não encontrado");
				System.out.println("Produto não encontrado");
			}
		}
		
	}
	
	public void continuarComprando() throws Exception {
		BaseTest.takeScreenshot("Continuar comprando");
		pageTelaProduto.clicarBotaoContinueShopping();
	}
	
	public void irParaCheckout() throws Exception {
		BaseTest.takeScreenshot("Ir para checkout");
		pageTelaProduto.clicarBotaoProceedToCheckout();
	}

	public void avancarParaProximaTelaEmShoppingCartSummary() throws Exception {
		BaseTest.takeScreenshot("Tela com informações de Shopping Cart Summary");
		pageTelaShoppingCartSummary.teclaPageDown();
		BaseTest.takeScreenshot("Tela com informações de Shopping Cart Summary");
		pageTelaShoppingCartSummary.clicarBotaoProceedToCheckout();
	}
	
	public void avancarParaProximaTelaEmAddress() throws Exception {
		BaseTest.takeScreenshot("Tela com informações de Address");
		pageTelaShoppingCartSummary.teclaPageDown();
		BaseTest.takeScreenshot("Tela com informações de Address");
		pageTelaAddress.clicarBotaoProceedToCheckout();
	}
	
	public void avancarParaProximaTelaEmShipping() throws Exception {
		BaseTest.takeScreenshot("Tela com informações de Shipping");
		pageTelaShoppingCartSummary.teclaPageDown();
		BaseTest.takeScreenshot("Tela com informações de Shipping");
		pageTelaShipping.clicarCheckboxTermsOfService();
		pageTelaShipping.clicarBotaoProceedToCheckout();
	}
	
	public void realizarOpcaoDePagamento() throws Exception {
		BaseTest.takeScreenshot("Tela com informações de Pagamento");
		pageTelaShoppingCartSummary.teclaPageDown();
		BaseTest.takeScreenshot("Tela com informações de Pagamento");
		pageTelaPayment.clicarBotaoPayByBankWire();
		pageTelaPayment.clicarBotaoIConfirmMyOrder();
	}
	
	public void validarPedidoFinalizadoComSucesso() throws Exception {
		assertTrue(pageTelaPayment.validarSePedidoFoiFinalizadoComSucesso());
		BaseTest.takeScreenshot("Pedido finalizado com sucesso");
	}
	
	
}
