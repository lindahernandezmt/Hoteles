/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mintic.usa.ciclo3.ejemplosoring;

/**
 *
 * @author lindi
 */
public class ReservasStatus {
    private int complet;
    private int cancelled;

    public int getComplet() {
        return complet;
    }

    public void setComplet(int complet) {
        this.complet = complet;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public ReservasStatus(int complet, int cancelled) {
        this.complet = complet;
        this.cancelled = cancelled;
    }
    
    
}
