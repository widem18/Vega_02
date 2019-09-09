package ContextoProblema;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Polera {
    String[] tipoPolera = new String[3];
    String[] talla = new String[4];
    ArrayList<String> pedido = new ArrayList<String>();


    /**
     * Metodo de tipo Arraylist que crea un Arraylist "pedido" donde se almacenara toda la informacion
     *
     * @param tipo      es un String que entrega la posicion del arreglo tipoP de tipo String que tiene almacenado variables
     * @param talla     es un String que entrega la posicion del arreglo talla de tipo String que tiene almacenado variables
     * @param estampado es un String que dice si la polera tiene o no estampado
     * @return pedido es el Arraylist llamado "pedido"
     */
    public ArrayList<String> crearPedido(String tipo, String talla, String estampado) {
        this.pedido.add(tipo + "," + talla + "," + estampado);
        return pedido;
    }

    /**
     * Metodo no estatico de tipo String que pregunta por distintas opciones de tipo String para almacenar en el arreglo "tipoPolera"
     *
     * @return tipoPolera[opcion] es el indice elegido del arreglo "tipoPolera"
     */
    public String tipoP() {
        System.out.println("Ingrese el tipo de polera que desea: 0 es para Algodon, 1 es para Polyester y 2 es para Spandex");
        int opcion = pedirNum();
        this.tipoPolera[0] = "Algodon";
        this.tipoPolera[1] = "Polyester";
        this.tipoPolera[2] = "Spandex";
        return tipoPolera[opcion];
    }

    /**
     * Metodo no estatico de tipo String que pregunta por distintas opciones de tipo String para almacenar en el arreglo "talla"
     *
     * @return talla[opcion] es el indice elegido del arreglo "talla"
     */
    public String talla() {
        System.out.println("Ingrese el tipo de talla para su polera: 0 es para S, 1 es para M, 2 es para L y 3 es para XL ");
        int opcion = pedirNum();
        this.talla[0] = "S";
        this.talla[1] = "M";
        this.talla[2] = "L";
        this.talla[3] = "XL";
        return talla[opcion];
    }

    /**
     * Metodo de tipo String que a traves del metodo estamp()  retorna cierta informacion.
     *
     * @return aux identifica si tiene estampado, o no.
     */
    public static String estampado() {
        String aux = "";
        boolean estamp = true;
        System.out.println("Ingrese 0 si quiere estampado, y 1 si es que no ");
        int opcion = pedirNum();
        if (opcion == 0) {
            aux = "Con estampado";
        }
        if (opcion == 1) {
            estamp = false;
            aux = "Sin estampado";
        }
        return aux;
    }

    /**
     * Metodo de tipo void que tiene un "switch case" dentro, el cual ejecuta todas las acciones del programa
     */
    public void menu() {
        boolean validador = true;
        while (validador) {
            System.out.println("Ingrese la opcion que desee: 1 para mostrar los pedidos, 2 para crear un pedido nuevo, 3 para eliminar un pedido o 4 para salir ");
            int option = pedirNum();
            switch (option) {
                case 1:
                    mostrar(pedido);
                    break;
                case 2:
                    crearPedido(tipoP(), talla(), estampado());
                    break;
                case 3:
                    System.out.println("Seleccione que pedido desea eliminar");
                    eliminarPedido();
                    System.out.println("El pedido ha sido removido");
                    break;
                case 4:
                    System.out.println("Usted ha salido del programa");
                    validador = false;
                    break;
            }
        }
    }

    /**
     * Metodo de tipo int que llama a la clase "Scanner" y hace una instancia de la misma y se asegura de que el dato entregado sea un numero
     *
     * @return num es un entero que se utilizara para dar informacion en los otros metodos
     */
    public static int pedirNum() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return num;
    }

    /**
     * Metodo de tipo void que muestra los elementos del Arraylist "pedido"
     */
    public static void mostrar(ArrayList<String> pedido) {
        for (int i = 0; i < pedido.size(); i++) {
            System.out.println(pedido.get(i));
        }
    }

    /**
     * Metodo de tipo void que se encarga de eliminar un elemento del Arraylist "pedido"
     */
    public void eliminarPedido() {
        int num = pedirNum();
        pedido.remove(num - 1);
    }

    /**
     * Metodo de tipo void que muestra un mensaje si el Arraylist "pedido" tiene tamaño cero
     */
    public void validTamanPedido() {
        if (pedido.size() == 0) {
            System.out.println("No hay pedidos disponibles");
        }
    }

    public static int valid(int numero) {
        try {
            numero = pedirNum();

        } catch (InputMismatchException e) {
            System.out.println("Solo se admitiran numeros y que sean positivos");
            numero = pedirNum();
        }
        return numero;
    }

    public static int validExtremosTipo(int numero) {
        try {
            if (0 <= pedirNum() && pedirNum() < 3) {
                numero = pedirNum();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Solo se admitiran numeros propuestos");
            numero = pedirNum();
        }
        return numero;
    }

    public static int validExtremosTalla(int numero) {
        try {
            if (0 <= pedirNum() && pedirNum() < 4) {
                numero = pedirNum();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Solo se admitiran numeros propuestos");
            numero = pedirNum();
        }
        return numero;
    }

    public static int validExtremosEstamp(int numero) {
        try {
            if (0 == pedirNum() || pedirNum() == 1) {
                numero = pedirNum();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Solo se admitiran numeros propuestos");
            numero = pedirNum();
        }
        return numero;
    }

}
