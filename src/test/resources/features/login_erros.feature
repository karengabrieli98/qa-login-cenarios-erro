# language: pt
Funcionalidade: Login com dados inválidos

  Cenário: Login com senha incorreta
    Dado que estou na página de login
    Quando informo o usuário "standard_user" e a senha "senha_errada"
    E clico no botão de login
    Então devo ver a mensagem de erro "Epic sadface: Username and password do not match any user in this service"

  Cenário: Login sem informar o usuário
    Dado que estou na página de login
    Quando informo o usuário "" e a senha "secret_sauce"
    E clico no botão de login
    Então devo ver a mensagem de erro "Epic sadface: Username is required"

  Cenário: Login sem informar a senha
    Dado que estou na página de login
    Quando informo o usuário "standard_user" e a senha ""
    E clico no botão de login
    Então devo ver a mensagem de erro "Epic sadface: Password is required"

  Cenário: Login com usuário bloqueado
    Dado que estou na página de login
    Quando informo o usuário "locked_out_user" e a senha "secret_sauce"
    E clico no botão de login
    Então devo ver a mensagem de erro "Epic sadface: Sorry, this user has been locked out."
