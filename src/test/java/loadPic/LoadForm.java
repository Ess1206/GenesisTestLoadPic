package loadPic;

import core.MethodsFactory;

import java.awt.*;

/**
 * Created by Stan on 26.08.2017.
 */
public abstract class LoadForm extends MethodsFactory {

    abstract protected void openPage();

    abstract protected void typeNewPostButton();

    abstract protected void typeBrowserButton(String imgpathname);

    abstract protected void setIMGURL(String imgURL) ;

    abstract protected void setTitle(String title);

    abstract protected void setDescription(String description);

    abstract protected void deleteImg();

}
