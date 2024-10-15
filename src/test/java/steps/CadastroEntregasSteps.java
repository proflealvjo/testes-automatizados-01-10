package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ErrorMassageModel;
import org.junit.Assert;
import services.CadastroEntregasService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroEntregasSteps {

    CadastroEntregasService cadastroEntregasService = new CadastroEntregasService();

    @Dado("que eu tenha os seguintes dados de entrega:")
    public void queEuTenhaOsSeguintesDadosDeEntrega(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastroEntregasService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao para o endpoint {string} de cadastro de entregas")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeEntregas(String endpoint) {
        cadastroEntregasService.createDelivery(endpoint);
    }

    @Entao("status code da resposta deve ser {int}")
    public void statusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroEntregasService.response.statusCode());
    }

    @E("a resposta de mensagem de erro deve ser {string}")
    public void aRespostaDeMensagemDeErroDeveSer(String message) {
        ErrorMassageModel errorMassageModel = cadastroEntregasService.gson.fromJson(
                cadastroEntregasService.response.jsonPath().prettify(), ErrorMassageModel.class);

        Assert.assertEquals(message, errorMassageModel.getMessage());
    }

    @Dado("que eu recupere o ID criado no contexto")
    public void queEuRecupereOIDCriadoNoContexto() {
        cadastroEntregasService.retrieveId();
    }

    @Quando("eu enviar o ID na requisicao para o endpoint {string} de delecao de entregas")
    public void euEnviarOIDNaRequisicaoParaOEndpointDeDelecaoDeEntregas(String endpoint) {
        cadastroEntregasService.deleteDelivery(endpoint);
    }

    @E("o contrato selecionado vai ser {string}")
    public void oContratoSelecionadoVaiSer(String contrato) throws IOException {
        cadastroEntregasService.setContrato(contrato);
    }

    @Entao("a resposta da requisicao de acordo com o contrato selecionado")
    public void aRespostaDaRequisicaoDeAcordoComOContratoSelecionado() throws IOException {
        //Recupera se o contrato esta com algum tipo de erro
        Set<ValidationMessage> validateResponse = cadastroEntregasService.validateResponseAgainstSchema();
        //Faz o assert validando se o contrato esta de acordo com o esperado
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}
