# language: pt
# Author: Danilo Silva Tempos
# encoding UTF-8
Funcionalidade: Testar API
  A fim de testar API no site REQ RES

    @API @CT02 @Reqres @Renner
  Cenário: CT02 Validar retorno com sucesso do serviço Single User na api REQRES
    Quando fazer uma chamada para o serviço Single User da api REQRES
    
    @API @CT03 @Reqres @Renner
    Cenário: CT03 Validar criação de usuário para o serviço Create na api REQRES
    Quando fazer uma chamada para o serviço Create da api REQRES informando name "testando" e job "Renner"
    