/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealornodeal;

import java.util.Objects;

/**
 *
 * @author Hayden
 */
public class Case {

    public int id;
    public CaseValue value;
    public boolean open;

    public Case(int id, CaseValue value) {
        this.id = id;
        this.value = value;
        open = false;
    }

    public Case(int id) {
        this.id = id;
        open = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CaseValue getValue() {
        return value;
    }

    public void setValue(CaseValue value) {
        this.value = value;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void openCase() {
        open = true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.value);
        hash = 67 * hash + (this.open ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Case other = (Case) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.open != other.open) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.open) {
            return this.id + " contains $" + this.value.getCashValue();
        } else {
            return "" + this.id;
        }
    }
}
