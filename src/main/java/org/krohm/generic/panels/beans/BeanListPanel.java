/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.panel.Panel;
import org.krohm.generic.panels.beans.Views.BeanListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class BeanListPanel<T> extends Panel {

    private static final Logger logger = LoggerFactory.getLogger(BeanListPanel.class);

    public BeanListPanel(String id, List<T> beanObjects) {
        super(id);
        if (beanObjects != null && beanObjects.size() > 0) {
            add(new BeanListView<T>("beanList", beanObjects));
        } else {
            List<EmptyListBean> emptyListBean = new ArrayList<EmptyListBean>();
            emptyListBean.add(new EmptyListBean());
            add(new BeanListView<EmptyListBean>("beanList", emptyListBean));
        }
    }

    private class EmptyListBean {
        public String getInfo() {
            return "No Match Found";
        }
    }
}
