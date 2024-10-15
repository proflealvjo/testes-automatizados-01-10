#language: pt

@regressivo @smoke
Funcionalidade: Cadastro de entregas
  Como usuario da api
  Quero cadastrar uma nova entrega
  Para que o registro seja salvo corretamente

  @padrao @smoke
  Cenário: Cadastro de entregas bem-sucedido
    Dado que eu tenha os seguintes dados de entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisicao para o endpoint "/entregas" de cadastro de entregas
    Entao status code da resposta deve ser 201


  Cenário: Cadastro de entregas sem sucesso de entrega ao enviar o statusEntrega inavalido
    Dado que eu tenha os seguintes dados de entrega:
      | campo          | valor      |
      | numeroPedido   | 1          |
      | nomeEntregador | Ana Silva  |
      | statusEntrega  | EM_VOO     |
      | dataEntrega    | 2024-08-22 |
    Quando eu enviar a requisicao para o endpoint "/entregas" de cadastro de entregas
    Entao status code da resposta deve ser 400
    E a resposta de mensagem de erro deve ser "Dados fornecidos estão em formato inválido."