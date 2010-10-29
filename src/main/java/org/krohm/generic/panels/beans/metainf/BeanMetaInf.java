/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.metainf;

import java.util.LinkedHashMap;
import java.util.Map;
import org.krohm.generic.panels.beans.util.BeanIntrospectionUtil;

/**
 *
 * @author arnaud
 */
public class BeanMetaInf<T> {

    private Class<T> beanClass;
    private final Map<String, MemberMetaInf> memberInfo = new LinkedHashMap<String, MemberMetaInf>();

    public BeanMetaInf(Class<T> beanClass) {
        this.beanClass = beanClass;
        for (String memberName : BeanIntrospectionUtil.getMembers(beanClass))
        {

        }
    }

    public Class<T> getBeanClass() {
        return beanClass;
    }

    public Map<String, MemberMetaInf> getMemberInfo() {
        return memberInfo;
    }
}
