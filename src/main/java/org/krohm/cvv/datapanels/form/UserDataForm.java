/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.cvv.datapanels.form;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.krohm.cvv.beans.UserData;
import org.krohm.generic.dao.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class UserDataForm extends Form<UserData> {

    @SpringBean(name = "UserDao")
    private GenericDao<UserData> userDataDao;
    private static final Logger logger = LoggerFactory.getLogger(UserDataForm.class);
    private Class<? extends Page> pageClass;

    public UserDataForm(String id, UserData userData, Class<? extends Page> targetPageClass) {
        super(id);
        setModel(new CompoundPropertyModel(userData));
        add(new RequiredTextField("userFirstName"));
        add(new RequiredTextField("userLastName"));
        add(new RequiredTextField("userEmail"));
        pageClass = targetPageClass;

        add(new FeedbackPanel("feedback"));
    }

    @Override
    protected void onSubmit() {
        UserData userData = getModel().getObject();
        Long beanId = userData.getId();
        if (beanId == null) {
            userDataDao.create(userData);
            logger.info("User created with ID :<" + userData.getId() + ">");
        } else {
            userDataDao.update(userData);
            logger.info("User Updated with ID :<" + userData.getId() + ">");
        }
        setResponsePage(pageClass);
    }
}
