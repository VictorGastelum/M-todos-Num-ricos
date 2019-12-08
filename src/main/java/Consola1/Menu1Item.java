/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola1;

/**
 *
 * @author holkv
 */
public class Menu1Item {
    
        private MenuCallback1 funcion;
    private String texto;
    private boolean menu=false;

    public boolean isMenu() {
        return menu;
    }

    public Menu1Item setMenu(boolean menu) {
        this.menu = menu;
        return this;
    }

   /**
    * agrega un item al menu
    * 
    * @param texto texto del menu
    * @param funcion funcion del menu
    */
    public Menu1Item(String texto, MenuCallback1 funcion) {
        this.funcion = funcion;
        this.texto = texto;
    }

    
    public MenuCallback1 getMenuCallback() {
        return this.funcion;
    }

    public String getTexto() {
        return this.texto;
    }
    
}