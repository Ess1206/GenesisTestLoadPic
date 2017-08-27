package loadPic;

import core.BrowserFactory;
import core.CustomConditions;
import org.testng.annotations.Test;

/**
 * Created by Stan on 26.08.2017.
 */
public class TestLoadPic extends BrowserFactory {


    LoadImpl page = new LoadImpl();

    @Test(priority = 0, testName = "Open Page")
    public void tsetOpenPage() {
        page.openPage();
    }

    @Test(priority = 1, testName = "NewPost Button - type")
    public void WhenTypeOnNewPostButtonThenUploadImgWindowIsShow() {
        page.typeNewPostButton();
        page.closeUploadWindow.click();
    }

    @Test
            (priority = 2, testName = "Load image by SetURL ")
    public void WhenSetURLOnUploadImgwindowThenSelectPicAndLoadIt() {
        page.openPage();
        page.typeNewPostButton();
        page.setIMGURL("https://nplus1.ru/images/2016/04/10/0f921576b75c5baf1236cc936ac12b12.png");

        page.setDescription("testLoadPic - descripton");
        page.setTitle("testLoadPic - Title");
        page.deleteImg();
        page.confirmDeleteButton.click();
    }


    @Test(enabled = false, priority = 5, testName = "Load image by browser Button")
    public void WhenTypeOnBrowserButtonOnUploadImgwindowAndLoadImgWindowIsShowThenSelectPicAndLoadIt() {
        page.openPage();
        page.typeNewPostButton();
        page.typeBrowserButton("src\\main\\resources\\1.jpg");

        page.setDescription("testLoadPic - descripton");
        page.setTitle("testLoadPic - Title");
        page.deleteImg();
        page.confirmDeleteButton.click();
    }
}
