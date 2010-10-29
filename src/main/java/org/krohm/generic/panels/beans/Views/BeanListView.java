/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.Views;

import java.util.List;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

/**
 *
 * @author arnaud
 */
public class BeanListView<T> extends ListView<T> {



    public BeanListView(String string, List<T> list) {
        super(string, list);
    }

    @Override
    protected void populateItem(ListItem<T> listItem) {
        T currentObject = listItem.getModelObject();
        listItem.add(new BeanView("currentBean",currentObject));
    }
}
