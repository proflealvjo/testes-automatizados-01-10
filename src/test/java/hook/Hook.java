package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {

    @BeforeAll
    public  static void beforeAll(){
        inicializarAmbiente();
    }

    @AfterAll
    public static void afterAll(){
        limparAmbiente();
    }

    @Before
    public void before(){
        prepararDadosParaTeste();
    }

    @After
    public void after(){
        limparDadosDepoisDoTeste();
    }

    private static void inicializarAmbiente() {
        // Simulação de inicialização do ambiente
        System.out.println("Ambiente inicializado.");
    }

    private static void limparAmbiente() {
        // Simulação de limpeza do ambiente
        System.out.println("Ambiente limpo.");
    }

    private void prepararDadosParaTeste() {
        // Simulação de preparação de dados para o teste
        System.out.println("Dados preparados para o cenário de teste.");
    }

    private void limparDadosDepoisDoTeste() {
        // Simulação de limpeza de dados após o teste
        System.out.println("Dados limpos após o cenário de teste.");
    }
}
