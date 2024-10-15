#language: pt


  Funcionalidade:  Deletar uma entrega

    Contexto: Cadastro de entregas bem-sucedido
      Dado que eu tenha os seguintes dados de entrega:
        | campo          | valor        |
        | numeroPedido   | 1            |
        | nomeEntregador | Ana Silva    |
        | statusEntrega  | EM_SEPARACAO |
        | dataEntrega    | 2024-08-22   |
      Quando eu enviar a requisicao para o endpoint "/entregas" de cadastro de entregas
      Entao status code da resposta deve ser 201

    Cenário: Deve ser possivel deletar uma entrega
      Dado que eu recupere o ID criado no contexto
      Quando eu enviar o ID na requisicao para o endpoint "/entregas" de delecao de entregas
      Entao status code da resposta deve ser 400
