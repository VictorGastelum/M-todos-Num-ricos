package Main2;

import Consola1.Menu1;
import Consola1.MenuCallback1;
import Metodos.*;

public class Run {
    public static void main(String[] args) {
         Menu1 menu = new Menu1();
        menu.setTitulo("Metodos Numericos");

        menu.agregar("Biseccion", new MenuCallback1() {
            public void ejecutar() {
                Biseccion metodo = new Biseccion();
                metodo.consola();
            }
        });

        menu.agregar("Newton Raphson", new MenuCallback1() {
            public void ejecutar() {
                NewtonRaphson metodo = new NewtonRaphson();
                metodo.consola();
            }
        });

        menu.agregar("Secante", new MenuCallback1() {
            public void ejecutar() {
                Secante metodo = new Secante();
                metodo.consola();
            }
        });
        menu.agregar("Gauss", new MenuCallback1() {
            public void ejecutar() {
                Gauss metodo = new Gauss();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Jordan", new MenuCallback1() {
            public void ejecutar() {
                GaussJordan metodo = new GaussJordan();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Seidel", new MenuCallback1() {
            public void ejecutar() {
                GaussSeidel metodo = new GaussSeidel();
                metodo.consola();
            }
        });
        menu.agregar("Gauss-Jacobi", new MenuCallback1() {
            public void ejecutar() {
                GaussJacobi metodo = new GaussJacobi();
                metodo.consola();
            }
        });

        menu.agregar("Metodo de Euler", new MenuCallback1() {
            public void ejecutar() {
                Euler metodo = new Euler();
                metodo.consola();
            }
        });
        menu.agregar("Metodo de Runge Kutta", new MenuCallback1() {
            public void ejecutar() {
                RungeKutta metodo = new RungeKutta();
                metodo.consola();
            }
        });
        menu.mostrar();
    }
    }