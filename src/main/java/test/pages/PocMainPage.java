/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.krohm.cvv.beans.UserData;
import org.krohm.cvv.datapanels.UserDataNewPanel;
import org.krohm.generic.dao.GenericDao;
import org.krohm.generic.panels.beans.BeanListPanel;
import test.Pannels.HeaderPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class PocMainPage extends WebPage {

    private static final Logger logger = LoggerFactory.getLogger(PocMainPage.class);

    public PocMainPage(PageParameters parameters) {
        super(parameters);
        add(new HeaderPanel("HeaderPanel"));
        //  add(new BeanListPanel<UserData>("TestPanel",currentList));
        add(new UserDataNewPanel("TestPanel"));
    }
}
