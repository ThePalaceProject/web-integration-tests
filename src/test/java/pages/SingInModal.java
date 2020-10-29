package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SingInModal extends Form {
    private final ITextBox loginTxb = getElementFactory().getTextBox(By.cssSelector("#login"), "Login");
    private final ITextBox passwordTxb = getElementFactory().getTextBox(By.cssSelector("#password"), "Password");
    private final IButton loginBtn = getElementFactory().getButton(By.xpath("//button[text()='Login']"),
            "Apply login");

    public SingInModal() {
        super(By.xpath("//*[@aria-label='Sign In Form']"), "Sign in modal");
    }

    public void setLogin(String login) {
        loginTxb.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordTxb.sendKeys(password);
    }

    public void applyLogin() {
        loginBtn.click();
    }
}