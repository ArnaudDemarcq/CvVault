/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.cvv.datapanels;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.krohm.cvv.beans.UserData;
import org.krohm.cvv.datapanels.form.UserDataForm;
import org.krohm.generic.dao.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.Index;

/**
 *
 * @author arnaud
 */
public class UserDataNewPanel extends Panel {
    
    private static final Logger logger = LoggerFactory.getLogger(UserDataNewPanel.class);

    public UserDataNewPanel(String id) {
        super(id);

        UserData userData = new UserData();

        Form userDataForm = new UserDataForm("newUserForm", userData, Index.class);
        add(userDataForm);

    }
}
