package stepsDefinition;

import api.TestesAPI;
import core.BaseTest;
import io.cucumber.java.pt.Quando;

public class StepsTestesAPI extends BaseTest {
	
	static TestesAPI testesAPI = new TestesAPI();

	@Quando("^fazer uma chamada para o serviço Create da api REQRES informando name \"([^\"]*)\" e job \"([^\"]*)\"$")
	public void realizar_a_compra_do_produto(String name, String job) throws Throwable {
		testesAPI.testPostCreate(name, job);
	}
	
	@Quando("^fazer uma chamada para o serviço Single User da api REQRES$")
	public void fazer_uma_chamada_para_o_servico_single_user_api_reqres() throws Throwable {
		testesAPI.testGetSingleUser();
	}
	
}
