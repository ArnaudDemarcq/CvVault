/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.generic.panels.beans.metainf;

/**
 *
 * @author arnaud
 */
public class MemberMetaInf {

    private String name;
    private String label;
    private boolean visible = true;
    private boolean required = true;
    private boolean editable = true;

    public MemberMetaInf(String name) {
        this.name = name;
        this.label = name;
    }

    public MemberMetaInf() {
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
