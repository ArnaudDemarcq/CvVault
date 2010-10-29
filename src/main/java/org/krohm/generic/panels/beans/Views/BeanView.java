/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.Views;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.krohm.generic.panels.beans.util.BeanIntrospectionUtil;

/**
 *
 * @author arnaud
 */
public class BeanView<T> extends ListView<String> {

    private T targetBean;

    private Class<T> tClass;

    public BeanView(String string, T targetBean) {
        super(string, BeanIntrospectionUtil.getMembers(targetBean.getClass()));
        this.targetBean = targetBean;
    }

    @Override
    protected void populateItem(ListItem<String> listItem) {
        String currentBeanMember = listItem.getModelObject();
        listItem.add(new BeanMemberView("currentLabel", targetBean, currentBeanMember));
    }
}
