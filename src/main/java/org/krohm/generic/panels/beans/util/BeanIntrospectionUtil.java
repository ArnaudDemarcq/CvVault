/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class BeanIntrospectionUtil {

    private static final Logger logger = LoggerFactory.getLogger(BeanIntrospectionUtil.class);

    public static final List<String> getMembers(Class clazz) {
        List<String> members = new ArrayList<String>();
        for (Method currentMethod : clazz.getMethods()) {
            String currentMethodName = currentMethod.getName();
            if (currentMethodName.startsWith("get") && (! (currentMethodName.equals("getClass")))) {
                members.add(currentMethod.getName().substring(3));
            }
        }
        return members;
    }

    public static final Object getMemberValue(Object currentInstance, String memberName) {
        String methodName = "get" + memberName;
        try {
            Method getterMethod = currentInstance.getClass().getMethod(methodName);
            return getterMethod.invoke(currentInstance);

        } catch (Exception ex) {
            logger.warn("member Does not exist : <" + methodName + ">");
            return null;
        }

    }

    public static final Class getMemberClass(Object currentInstance, String memberName) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static final List<String> getBeanMembers(Object currentInstance) {


        throw new UnsupportedOperationException("Not supported yet.");
    }
}
