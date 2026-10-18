package com.qa.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Localizadores dos elementos da tela
    private final By campoUsuario = By.id("user-name");
    private final By campoSenha = By.id("password");
    private final By botaoLogin = By.id("login-button");
    private final By mensagemErro = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrir() {
        driver.get("https://www.saucedemo.com/");
    }

    public void informarUsuario(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void informarSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEmLogin() {
        driver.findElement(botaoLogin).click();
    }

    public String obterMensagemErro() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro)).getText();
    }
}
