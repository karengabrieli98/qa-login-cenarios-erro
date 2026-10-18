\# Testes de Login com Cenários de Erro



Projeto de automação de \*\*testes negativos\*\* (cenários de erro) da tela de login do site de demonstração \[SauceDemo](https://www.saucedemo.com/).



O objetivo é validar que o sistema \*\*não deixa o login acontecer com dados inválidos\*\* e exibe a \*\*mensagem de erro correta\*\*.



\## Tecnologias



| Tecnologia | Para que serve |

|---|---|

| Java  | Linguagem dos testes |

| Maven | Baixa as dependências e executa os testes |

| Selenium WebDriver | Controla o navegador (Chrome) |

| Cucumber (BDD) | Permite escrever os cenários em português |

| JUnit 5 | Executa o Cucumber e faz as validações (asserts) |



\## Cenários testados



Arquivo: `src/test/resources/features/login\_erros.feature`



| # | Cenário | Mensagem esperada |

|---|---|---|

| 1 | Login com senha incorreta | `Epic sadface: Username and password do not match any user in this service` |

| 2 | Login sem informar o usuário | `Epic sadface: Username is required` |

| 3 | Login sem informar a senha | `Epic sadface: Password is required` |

| 4 | Login com usuário bloqueado | `Epic sadface: Sorry, this user has been locked out.` |



Exemplo de cenário em BDD:



```gherkin

Cenário: Login sem informar a senha

&#x20; Dado que estou na página de login

&#x20; Quando informo o usuário "standard\_user" e a senha ""

&#x20; E clico no botão de login

&#x20; Então devo ver a mensagem de erro "Epic sadface: Password is required"

```



\## Estrutura do projeto



```

login-erros

├── pom.xml

└── src/test

&#x20;   ├── java/com/qa/erros

&#x20;   │   ├── RunCucumberTest.java   -> ponto de entrada: o JUnit executa o Cucumber a partir daqui

&#x20;   │   ├── LoginSteps.java        -> liga cada frase do .feature ao código Selenium

&#x20;   │   └── LoginPage.java         -> Page Object: elementos e ações da tela de login

&#x20;   └── resources

&#x20;       ├── junit-platform.properties  -> configurações do Cucumber e do relatório

&#x20;       └── features

&#x20;           └── login\_erros.feature    -> cenários escritos em Gherkin (português)

```



\### Por que o Page Object?



Os localizadores e as ações da tela de login ficam todos na classe `LoginPage`. Se o `id` de um campo mudar, só esse arquivo precisa ser alterado, e os steps continuam iguais.



\## Como executar



```bash

git clone https://github.com/karengabrieli98/qa-login-cenarios-erro.git

cd qa-login-cenarios-erro

mvn test

```



Também é possível rodar pelo Eclipse: botão direito no projeto, depois \*\*Run As > Maven test\*\*.



O Selenium 4 baixa o driver do Chrome automaticamente, então não é necessário instalar o chromedriver.



\### Relatório



Ao final da execução, o relatório HTML é gerado em `target/relatorio.html`. A pasta `target` não é versionada, pois é criada a cada execução.



\## Boas práticas aplicadas



\- \*\*BDD\*\* com cenários legíveis por qualquer pessoa do time

\- \*\*Page Object\*\* para separar a tela dos testes

\- \*\*Espera explícita\*\* (`WebDriverWait`) em vez de `Thread.sleep`

\- Um navegador novo por cenário (`@Before` e `@After`), para um teste não afetar o outro

\- `.gitignore` para não versionar arquivos gerados (`target`) nem arquivos da IDE



\## Próximos passos



\- \[ ] Reunir os cenários de campos inválidos em um Esquema do Cenário

\- \[ ] Acesso à página de produtos sem estar logado

\- \[ ] Cenários de erro no checkout

\- \[ ] Screenshot automático quando um teste falhar

\- \[ ] Execução automática com GitHub Actions



\## Autora



\[karengabrieli98](https://github.com/karengabrieli98)

