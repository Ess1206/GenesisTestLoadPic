package loadPic;

import core.CustomConditions;
import core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by Stan on 26.08.2017.
 */
public class LoadImpl extends LoadForm {


    Element newPost = new Element(By.cssSelector(".upload-button"), "New Post - Button");
    Element imgURLField = new Element(By.id("paste-url-input"), "imgURL - Field");
    Element browseButton = new Element(By.cssSelector(".browse-btn"), "Browse - Button");
    Element closeUploadWindow = new Element(By.cssSelector(".icon-x"), "CloseUploadWindow - Button");
    Element deleteIMG = new Element(By.cssSelector(".extra-option.delete"), "deleteIMG - Button");
    Element confirmDeleteButton = new Element(By.cssSelector(".right.btn-confirm-yes.btn-danger"), "confirmDelete - Button");
    Element titlefield = new Element(By.cssSelector(".post-title.post-contenteditable"), "Title - field");
    Element descriptionField = new Element(By.cssSelector(".post-image-description.post-image-description--editable.post-contenteditable"), "Description - field");

    @Override
    protected void openPage() {
        get("http://imgur.com/");
    }

    @Override
    protected void typeNewPostButton() {
        this.newPost.click();
    }

    @Override
    protected void typeBrowserButton(String imgpathname) {

        this.browseButton.click();

        getwebDriverWait(10000);

        File file = new File(imgpathname);
        setClipboardData(file.getAbsolutePath());

        //load file by Windows Robot
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);



    }

    @Override
    protected void setIMGURL(String imgURL)  {
        this.imgURLField.click();
        setClipboardData(imgURL);

        getwebDriverWait(5000).until(CustomConditions.pageLoader());

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);
    }


    @Override
    protected void setTitle(String title) {
        titlefield.click();
        titlefield.type("");
        titlefield.type(title);
    }

    @Override
    protected void setDescription(String description) {
        descriptionField.click();
        descriptionField.type("");
        descriptionField.type(description);

    }

    @Override
    protected void deleteImg() {
        deleteIMG.click();

    }


    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }
}
