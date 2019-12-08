/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola1;

import java.io.*;
import java.util.*;
import Metodos.Base;

/**
 *
 * @author holkv
 */
public class Menu1 extends Consola1 {
    
     ArrayList<Menu1Item> lista = new ArrayList<Menu1Item>();
    private String titulo = "";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Menu1() {
        super();
    }

    /**
     * agrega un item al menu
     * 
     * @param titulo titulo del item
     * @param callback funcion del item
     */
    public void agregar(String titulo, MenuCallback1 callback) {
        lista.add(new Menu1Item(titulo, callback));
    }

    /**
     * agrega un submenu al menu
     * 
     * @param titulo titulo del submenu
     * @param menu menu
     */
    public void agregar(String titulo, final Menu1 menu) {
        final Menu1 padre = this;

        if (menu.getTitulo().equals("")) {
            menu.setTitulo(titulo);
        }



        menu.agregar("Regresar", new MenuCallback1() {
            public void ejecutar() {
                padre.mostrar();
            }
        });
        lista.add(new Menu1Item(titulo, new MenuCallback1() {
            public void ejecutar() {

                menu.mostrar();
            }
        }).setMenu(true));
    }

    /**
     * muestra el menu
     */
    public void mostrar() {

        this.limpiarPantalla();
        int choosen = 0;
        Scanner in = new Scanner(this.in);
        Base base = new Base();


        if (!this.getTitulo().equals("")) {
            int ancho_titulo = this.titulo.length();
            ancho_titulo = ancho_titulo < 60 ? 60 : ancho_titulo;
            System.out.println(base.repetir("-", ancho_titulo  ));
            System.out.println("-" + base.redondear(this.titulo, ancho_titulo-2, true) + "-");
            System.out.println(base.repetir("-", ancho_titulo ));
        }

        int i = 0;
        for (i = 0; i < lista.size(); ++i) {
            Menu1Item mi = lista.get(i);
            System.out.printf("[%d] %s \n", i + 1, mi.getTexto());
        }

        System.out.printf("[%d] %s \n", i + 1, "Salir");

        System.out.println();
        System.out.print("Selecciona una Opcion:");

        try {
            choosen = in.nextInt();
        } catch (Exception e1) {
        }




        if (choosen == lista.size() + 1) {

            System.out.println("");
            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Adios, que tengas buen dia ;) ...", 60, true));
            System.out.println(base.repetir("*", 60));


            System.exit(1);
        } else if (choosen > lista.size() || choosen < 1) {


            System.out.println("");
            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Opcion Invalida, Presione Enter Para ir al Menu...", 60, true));
            System.out.println(base.repetir("*", 60));
            in.nextLine();
            in.nextLine();
            this.mostrar();
        } else {

            Menu1Item mi = lista.get(choosen - 1);
            MenuCallback1 mc = mi.getMenuCallback();

            this.limpiarPantalla();

            if (!mi.isMenu() && !mi.getTexto().equals("Regresar")) {

                System.out.println(base.repetir("-", 60));
                System.out.println(base.redondear(mi.getTexto(), 60, true));
                System.out.println(base.repetir("-", 60));

                System.out.println("");
            }
            mc.ejecutar();


            System.out.println("");

            System.out.println(base.repetir("*", 60));
            System.out.println(base.redondear("Presione ENTER para ir al menu...", 60, true));
            System.out.println(base.repetir("*", 60));

            in.nextLine();
            in.nextLine();
            this.mostrar();
        }
    }   
}