#language: pt


  Funcionalidade: Validar contrato de cadastro de entrega

    Cenário: Validar o contrato ao realizar um cadastro de entrega bem sucedida
      Dado que eu tenha os seguintes dados de entrega:
        | campo          | valor        |
        | numeroPedido   | 1            |
        | nomeEntregador | Ana Silva    |
        | statusEntrega  | EM_SEPARACAO |
        | dataEntrega    | 2024-08-22   |
      Quando eu enviar a requisicao para o endpoint "/entregas" de cadastro de entregas
      Entao status code da resposta deve ser 201
      E o contrato selecionado vai ser "Cadastro de entrega bem sucedida"
      Entao a resposta da requisicao de acordo com o contrato selecionado

