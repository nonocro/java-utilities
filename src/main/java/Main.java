import java.util.Objects;
import java.util.Scanner;
import exceptions.CalculatorException;
import services.Calculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans la calculatrice !");
        System.out.println("Opérations disponibles :");
        System.out.println("1. Addition (+)");
        System.out.println("2. Soustraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        try {
            boolean wantToContinue = true;
            while (wantToContinue) {
                System.out.print("Entrez le premier nombre : ");
                double x = scanner.nextDouble();

                System.out.print("Entrez le deuxième nombre : ");
                double y = scanner.nextDouble();

                System.out.print("Choisissez l'opération (+, -, *, /) : ");
                String operation = scanner.next();

                double result;

                switch (operation) {
                    case "+":
                        result = Calculator.add(x, y);
                        break;
                    case "-":
                        result = Calculator.sub(x, y);
                        break;
                    case "*":
                        result = Calculator.times(x, y);
                        break;
                    case "/":
                        try {
                            result = Calculator.divide(x, y);
                        } catch (CalculatorException e) {
                            System.out.println("Erreur : " + e.getMessage());
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Opération non reconnue !");
                        continue;
                }

                System.out.printf("Résultat : %.2f %s %.2f = %.2f%n", x, operation, y, result);

                System.out.print("Voulez vous continuer (y/n) : ");
                String wantToContinueResponse = scanner.next();

                wantToContinue = Objects.equals(wantToContinueResponse, "y");
            }
        } catch (Exception e) {
            System.out.println("Erreur : Saisie Invalide !");
        } finally {
            scanner.close();
        }
    }
}
