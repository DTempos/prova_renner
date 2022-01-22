# language: pt
# Author: Danilo Silva Tempos
# encoding UTF-8
Funcionalidade: Realizar compras
  A fim de realizar compras no site Automation Practice

  @web @CT01 @AutomationPractice @Renner
  Cenário: CT01 Realizar compra de 4 produtos no site Automation Practice
    Dado que acesse o site Automation Practice
    E realize o login no site
    Quando realizar a compra do produto "Printed Chiffon Dress" na cor "verde" e tamanho "M" e quantidade igual a ""
    E continuar comprando no site
    E realizar a compra do produto "Faded Short Sleeve T-shirts" na cor "azul" e tamanho "" e quantidade igual a ""
    E continuar comprando no site
    E realizar a compra do produto "Blouse" na cor "" e tamanho "" e quantidade igual a "2"
    E continuar comprando no site
    E realizar a compra do produto "Printed Dress" na cor "" e tamanho "" e quantidade igual a ""
    Quando ir para checkout no site
    E avançar na tela de Shopping Cart Summary
    E avançar na tela de Address
    E avançar na tela de Shipping
    E selecionar a opção de pagamento
    Então validar que o pedido foi finalizado com sucesso
    
