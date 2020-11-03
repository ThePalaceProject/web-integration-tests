package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.pages.ElementAttributesConstants;
import models.BookInfo;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SubcategoryPage extends Form {
    private ILabel lblPageName = getElementFactory().getLabel(By.xpath("//h1"), "Header");
    private IComboBox cmbSortByFormat = getElementFactory().getComboBox(By.id("facet-selector-Formats"), "Sort by format");
    private ILabel lblFirstBookTitle = getElementFactory().getLabel(By.xpath("//div//h2"), "First book title");
    private ILabel lblFirstBookAuthor = getElementFactory().getLabel(By.xpath("//span[@aria-label='Authors']"), "First book author");
    private ILabel lblFirstBookFormat = getElementFactory().getLabel(By.xpath("//div//*[name()='svg' and contains(@aria-label,'Book Medium:')]"), "First book format");
    private IButton btnViewFirstBookDetails = getElementFactory().getButton(By.xpath("//div//a[contains(text(),'Read more')]"), "View first book details");

    public SubcategoryPage() {
        super(By.id("facet-selector-Sort by"), "Subcategory");
    }

    public String getSubcategoryName() {
        return lblPageName.getText();
    }

    public void sortByFormat(String format) {
        cmbSortByFormat.selectByContainingText(format);
    }

    public BookInfo openFirstBook() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setAuthor(lblFirstBookAuthor.getText());
        bookInfo.setBookType(lblFirstBookFormat.getAttribute(ElementAttributesConstants.ARIA_LABEL_ATTRIBUTE));
        bookInfo.setTitle(lblFirstBookTitle.getText());
        btnViewFirstBookDetails.click();
        return bookInfo;
    }

    public List<String> getBookTitles() {
        return getListOfTextValues(getListOfElements("//li//h2"));
    }

    public List<String> getAuthors() {
        return getListOfTextValues(getListOfElements("//span[@aria-label='Authors']"));
    }

    private List<String> getListOfTextValues(List<IElement> list) {
        return list.stream().map(IElement::getText).collect(Collectors.toList());
    }

    private List<IElement> getListOfElements(String s) {
        return getElementFactory().findElements(By.xpath(s), ElementType.LABEL);
    }
}
