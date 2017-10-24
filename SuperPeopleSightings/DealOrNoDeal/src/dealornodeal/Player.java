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
public class Player {
    Case selectedCase;

    public Player(Case selectedCase) {
        this.selectedCase = selectedCase;
    }

    public Case getSelectedCase() {
        return selectedCase;
    }

    public void setSelectedCase(Case selectedCase) {
        this.selectedCase = selectedCase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.selectedCase);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.selectedCase, other.selectedCase)) {
            return false;
        }
        return true;
    }
    
}