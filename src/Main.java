import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args)  throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);
        boolean registrar = true, add = false, menu = true, positivo = false, volver;
        int numLlamadas=0, minutos=0, opcMenu, llamada, opcAdd, minutosTotales = 0, decision,
        llamadasLocales=0, llamadasDistancia=0, llamadasCelular=0;
        double minutoPorLlamadaLocal=0, minutoPorLlamadaDistancia=0, minutoPorLlamadaCelular=0,
                costoTotal = 0;

        while (menu){
            registrar = true;
            add = false;
            System.out.println("\tMenú" +
                    "\n1. Añadir llamada" +
                    "\n2. Mostrar información de la línea" +
                    "\n3. Reiniciar línea telefónica" +
                    "\n4. Salir");
            opcMenu = teclado.nextInt();
            if (opcMenu == 1) {
                while (registrar) {
                    add = false;
                    positivo = false;
                    while (!positivo) {
                        System.out.println("Ingrese la cantidad de minutos usados: ");
                        minutos = teclado.nextInt();
                        if (minutos > 0){
                            positivo = true;
                        } else {
                            System.out.println("Introduzca un número positivo.");
                        }
                    }
                    System.out.println("Que tipo de llamada es?" +
                            "\n1. Llamada Local" +
                            "\n2. Llamada a Distancia" +
                            "\n3. Llamada Celular");
                    llamada = teclado.nextInt();
                    switch (llamada) {
                        case 1 -> {
                            llamadasLocales++;
                            minutosTotales += minutos;
                            numLlamadas++;
                            minutoPorLlamadaLocal += minutos * 50;
                            costoTotal += minutoPorLlamadaLocal;
                            while (!add) {
                                System.out.println("Desea añadir otra llamada?" +
                                        "\n1. Si" +
                                        "\n2. No");
                                opcAdd = teclado.nextInt();
                                if (opcAdd == 1) {
                                    add = true;
                                } else if (opcAdd == 2){
                                    registrar = false;
                                    add = true;
                                } else {
                                    System.out.println("Esa no es una opción.");
                                }
                            }
                        }
                        case 2 -> {
                            llamadasDistancia++;
                            minutosTotales += minutos;
                            numLlamadas++;
                            minutoPorLlamadaDistancia += minutos * 350;
                            costoTotal += minutoPorLlamadaDistancia;
                            while (!add) {
                                System.out.println("Desea añadir otra llamada?" +
                                        "\n1. Si" +
                                        "\n2. No");
                                opcAdd = teclado.nextInt();
                                if (opcAdd == 1) {
                                    add = true;
                                } else if (opcAdd == 2){
                                    registrar = false;
                                    add = true;
                                } else {
                                    System.out.println("Esa no es una opción.");
                                }
                            }
                        }
                        case 3 -> {
                            llamadasCelular++;
                            minutosTotales += minutos;
                            numLlamadas++;
                            minutoPorLlamadaCelular += minutos * 150;
                            costoTotal = minutoPorLlamadaCelular;
                            while (!add) {
                                System.out.println("Desea añadir otra llamada?" +
                                        "\n1. Si" +
                                        "\n2. No");
                                opcAdd = teclado.nextInt();
                                if (opcAdd == 1) {
                                    add = true;
                                } else if (opcAdd == 2){
                                    registrar = false;
                                    add = true;
                                } else {
                                    System.out.println("Esa no es una opción.");
                                }
                            }
                        }
                        default -> System.out.println("Esa no es una opción.");
                    }
                }
            } else if (opcMenu == 2){
                volver = false;
                System.out.println("\tInformación de la línea:" +
                        "\nNúmero de llamadas = " + numLlamadas + " llamada/s" +
                        "\nLlamadas Locales = " + llamadasLocales +
                        "\nLlamadas a Distancia = " + llamadasDistancia +
                        "\nLlamadas Celulares = " + llamadasCelular +
                        "\nDuración de las llamadas = " + minutosTotales + " minutos" +
                        "\nCosto total de las llamadas = " + costoTotal + " pesos" +
                        "\nLocal = " + minutoPorLlamadaLocal + " pesos" +
                        "\nDistancia = "+ minutoPorLlamadaDistancia + " pesos" +
                        "\nCelular = " + minutoPorLlamadaCelular + " pesos");
                while (!volver){
                    System.out.println("1. Volver al menú" +
                            "\n2. Salir");
                    decision = teclado.nextInt();
                    if (decision == 1){
                        volver = true;
                    } if (decision == 2){
                        volver = true;
                        menu = false;
                    }
                }
            } else if (opcMenu == 3){
                numLlamadas=0;
                minutos=0;
                minutosTotales = 0;
                minutoPorLlamadaLocal=0;
                minutoPorLlamadaDistancia=0;
                minutoPorLlamadaCelular=0;
                costoTotal = 0;
                minutoPorLlamadaLocal = 0;
                minutoPorLlamadaCelular = 0;
                minutoPorLlamadaDistancia = 0;
                System.out.println("Se ha reiniciado la línea telefónica.");
                Thread.sleep(1000);
            } else if (opcMenu == 4){
                menu = false;
            } else {
                System.out.println("Esa no es una opcion valida");
                Thread.sleep(1000);
            }
        }
    }
}