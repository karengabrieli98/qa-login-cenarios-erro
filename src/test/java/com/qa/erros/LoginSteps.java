package com.qa.erros;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void abrirNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void fecharNavegador() {
        driver.quit();
    }

    @Dado("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {
        loginPage.abrir();
    }

    @Quando("informo o usuário {string} e a senha {string}")
    public void informoUsuarioESenha(String usuario, String senha) {
        loginPage.informarUsuario(usuario);
        loginPage.informarSenha(senha);
    }

    @E("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        loginPage.clicarEmLogin();
    }

    @Então("devo ver a mensagem de erro {string}")
    public void devoVerMensagemDeErro(String mensagemEsperada) {
        assertEquals(mensagemEsperada, loginPage.obterMensagemErro());
    }
}
