/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.Views;

import org.apache.wicket.markup.html.basic.Label;
import org.krohm.generic.panels.beans.util.BeanIntrospectionUtil;

/**
 *
 * @author arnaud
 */
public class BeanMemberView<T> extends Label {


    
    public BeanMemberView(String id, T currentBean, String currentMember) {
        super(id, getLabelString(currentBean, currentMember));
    }

    private static final String getLabelString(Object currentBean, String currentMember) {
        Object targetObject = BeanIntrospectionUtil.getMemberValue(currentBean, currentMember);
        if(targetObject == null)
        {
            return null;
        }
        return targetObject.toString();
    }
}


