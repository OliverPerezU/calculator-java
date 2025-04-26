import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        limpiarConsola();
        Scanner scanner = new Scanner(System.in);
        acciones(scanner);
    }

    public static void limpiarConsola() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        System.out.println("¡Bienvenido!");
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("1. Suma \n2. Resta \n3. Multiplicación \n4. División \n5. Salir");
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    public static int obtenerOpcion(Scanner scanner) {
        try {
            System.out.println("Ingresa una opción a realizar");
            int opcion = scanner.nextInt();
            if (opcion > 5 || opcion < 1) {
                System.out.println("Por favor ingresa un número dentro del rango de 1 y 5");
                pressEnterToContinue(scanner);
            }
            return opcion;

        } catch (Exception e) {
            System.out.println("Por favor ingresa una opción válida");
            return obtenerOpcion(scanner);
        }
    }

    public static double obtenerNumero(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Por favor ingresa un número válido");
            return obtenerNumero(scanner);
        }
    }

    public static void suma(Scanner scanner, double num1, double num2) {
        try {
            System.out.println("Ingresa el primer valor");
            num1 = obtenerNumero(scanner);
            System.out.println("Ingresa el segundo valor");
            num2 = obtenerNumero(scanner);
            double resultado = num1 + num2;
            muestraResultado(resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al tratar de realizar la suma");
        }
    }

    public static void resta(Scanner scanner, double num1, double num2) {
        try {
            System.out.println("Ingresa el primer valor");
            num1 = obtenerNumero(scanner);
            System.out.println("Ingresa el segundo valor");
            num2 = obtenerNumero(scanner);
            double resultado = num1 - num2;
            muestraResultado(resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al tratar de realizar la resta");
        }
    }

    public static void multiplicacion(Scanner scanner, double num1, double num2) {
        try {
            System.out.println("Ingresa el primer valor");
            num1 = obtenerNumero(scanner);
            System.out.println("Ingresa el segundo valor");
            num2 = obtenerNumero(scanner);
            double resultado = num1 * num2;
            muestraResultado(resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al tratar de realizar la multiplicación");
        }
    }

    public static void division(Scanner scanner, double num1, double num2) {
        try {
            System.out.println("Ingresa el primer valor");
            num1 = obtenerNumero(scanner);
            System.out.println("Ingresa el segundo valor");
            num2 = obtenerNumero(scanner);
            if (num2 == 0) {
                System.out.println("No se puede dividir un número por 0.");
                pressEnterToContinue(scanner);
            }
            double resultado = num1 / num2;
            muestraResultado(resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al tratar de realizar la división");
        }
    }

    public static void muestraResultado(double resultado) {
        System.out.println("El resultado es: " + resultado);
    }

    public static void acciones(Scanner scanner) {
        int opcion = -1;
        menu();
        do {
            double num1 = 0;
            double num2 = 0;
            opcion = obtenerOpcion(scanner);
            switch (opcion) {
                case 1:
                    System.out.println("Suma");
                    suma(scanner, num1, num2);
                    break;

                case 2:
                    System.out.println("Resta");
                    resta(scanner, num1, num2);
                    break;

                case 3:
                    System.out.println("Multiplicación");
                    multiplicacion(scanner, num1, num2);
                    break;

                case 4:
                    System.out.println("División");
                    division(scanner, num1, num2);
                    break;
                default:
                    pressEnterToContinue(scanner);
            }

        } while (opcion != 5);
        scanner.close();
    }

}
