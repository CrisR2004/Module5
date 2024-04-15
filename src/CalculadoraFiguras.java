import java.util.Scanner;

public class CalculadoraFiguras {

    // Constantes para opciones de figura y operación
    private static final int CIRCULO = 1;
    private static final int CUADRADO = 2;
    private static final int TRIANGULO = 3;
    private static final int RECTANGULO = 4;
    private static final int PENTAGONO = 5;
    private static final int CALCULAR_AREA = 1;
    private static final int CALCULAR_PERIMETRO = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int figuraSeleccionada;
        do {
            System.out.println("Elija una figura:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            figuraSeleccionada = scanner.nextInt();
        } while (figuraSeleccionada < CIRCULO || figuraSeleccionada > PENTAGONO);

        int operacionSeleccionada;
        do {
            System.out.println("\nElija una operación:");
            System.out.println("1. Calcular área");
            System.out.println("2. Calcular perímetro");
            operacionSeleccionada = scanner.nextInt();
        } while (operacionSeleccionada < CALCULAR_AREA || operacionSeleccionada > CALCULAR_PERIMETRO);

        double resultado = 0;
        switch (figuraSeleccionada) {
            case CIRCULO:
                resultado = calcularCirculo(operacionSeleccionada, scanner);
                break;
            case CUADRADO:
                resultado = calcularCuadrado(operacionSeleccionada, scanner);
                break;
            case TRIANGULO:
                resultado = calcularTriangulo(operacionSeleccionada, scanner);
                break;
            case RECTANGULO:
                resultado = calcularRectangulo(operacionSeleccionada, scanner);
                break;
            case PENTAGONO:
                resultado = calcularPentagono(operacionSeleccionada, scanner);
                break;
        }

        System.out.println("\nResultado:");
        if (operacionSeleccionada == CALCULAR_AREA) {
            System.out.printf("El área de la figura es: %.2f", resultado);
        } else {
            System.out.printf("El perímetro de la figura es: %.2f", resultado);
        }
    }

    private static double calcularCirculo(int operacionSeleccionada, Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();
        return (operacionSeleccionada == CALCULAR_AREA) ? calcularAreaCirculo(radio) : calcularPerimetroCirculo(radio);
    }

    private static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    private static double calcularPerimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    private static double calcularCuadrado(int operacionSeleccionada, Scanner scanner) {
        System.out.print("Ingrese la longitud de un lado del cuadrado: ");
        double lado = scanner.nextDouble();
        return (operacionSeleccionada == CALCULAR_AREA) ? calcularAreaCuadrado(lado) : calcularPerimetroCuadrado(lado);
    }

    private static double calcularAreaCuadrado(double lado) {
        return lado * lado;
    }

    private static double calcularPerimetroCuadrado(double lado) {
        return 4 * lado;
    }

    private static double calcularTriangulo(int operacionSeleccionada, Scanner scanner) {
        System.out.print("Ingrese la longitud de la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = scanner.nextDouble();
        return (operacionSeleccionada == CALCULAR_AREA) ? calcularAreaTriangulo(base, altura) : calcularPerimetroTriangulo(base, altura);
    }

    private static double calcularAreaTriangulo(double base, double altura) {
        return base * altura / 2;
    }

    private static double calcularPerimetroTriangulo(double base, double altura) {
        // Solo implementado para un triángulo equilátero
        return 3 * base;
    }

    private static double calcularRectangulo(int operacionSeleccionada, Scanner scanner) {
        System.out.print("Ingrese la longitud de la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        return (operacionSeleccionada == CALCULAR_AREA) ? calcularAreaRectangulo(base, altura) : calcularPerimetroRectangulo(base, altura);
    }

    private static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    private static double calcularPerimetroRectangulo(double base, double altura) {
        return 2 * (base + altura);
    }

    private static double calcularPentagono(int operacionSeleccionada, Scanner scanner) {
        System.out.print("Ingrese la longitud de un lado del pentágono: ");
        double lado = scanner.nextDouble();
        System.out.print("Ingrese la longitud del apotema del pentágono: ");
        double apotema = scanner.nextDouble();
        return (operacionSeleccionada == CALCULAR_AREA) ? calcularAreaPentagono(lado, apotema) : calcularPerimetroPentagono(lado);
    }

    private static double calcularAreaPentagono(double lado, double apotema) {
        return 0.5 * 5 * lado * apotema;
    }

    private static double calcularPerimetroPentagono(double lado) {
        return 5 * lado;
    }
}

