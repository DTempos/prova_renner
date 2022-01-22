package stepsDefinition;

import Functions.FunctionsRealizarCompra;
import core.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

public class StepsRealizarCompra extends BaseTest {

	static FunctionsRealizarCompra functionsRealizarCompra = new FunctionsRealizarCompra();

	@Dado("^que acesse o site Automation Practice$")
	public void que_acesse_o_site_Automation_Practice() throws Throwable {
		functionsRealizarCompra.abrirTelaInicialAutomationPractice();
	}
	
	@Dado("^realize o login no site$")
	public void realize_o_login_no_site() throws Throwable {
		functionsRealizarCompra.acessarTelaDeLogin();
	}

	@Quando("^realizar a compra do produto \"([^\"]*)\" na cor \"([^\"]*)\" e tamanho \"([^\"]*)\" e quantidade igual a \"([^\"]*)\"$")
	public void realizar_a_compra_do_produto(String nome_produto, String cor_produto, String tamanho_produto, String qtde_produto) throws Throwable {
		functionsRealizarCompra.pesquisarProdutoTelaInicial(nome_produto);
		functionsRealizarCompra.selecionarProdutoPesquisado(nome_produto, cor_produto, tamanho_produto, qtde_produto);
	}
	
	@Quando("^continuar comprando no site$")
	public void continuar_comprando_no_site() throws Throwable {
		functionsRealizarCompra.continuarComprando();
	}
	
	@Quando("^ir para checkout no site$")
	public void ir_para_checkout_no_site() throws Throwable {
		functionsRealizarCompra.irParaCheckout();
	}
	
	@Quando("^avançar na tela de Shopping Cart Summary$")
	public void avancar_na_tela_de_shopping_cart_summary() throws Throwable {
		functionsRealizarCompra.avancarParaProximaTelaEmShoppingCartSummary();
	}
	
	@Quando("^avançar na tela de Address$")
	public void avancar_na_tela_de_address() throws Throwable {
		functionsRealizarCompra.avancarParaProximaTelaEmAddress();
	}
	
	@Quando("^avançar na tela de Shipping$")
	public void avancar_na_tela_de_shipping() throws Throwable {
		functionsRealizarCompra.avancarParaProximaTelaEmShipping();
	}
	
	@Quando("^selecionar a opção de pagamento$")
	public void selecionar_a_opcao_de_pagamento() throws Throwable {
		functionsRealizarCompra.realizarOpcaoDePagamento();
	}

	@Então("^validar que o pedido foi finalizado com sucesso$")
	public void validar_que_o_pedido_foi_finalizado_com_sucesso() throws Throwable {
		functionsRealizarCompra.validarPedidoFinalizadoComSucesso();
	}

}
