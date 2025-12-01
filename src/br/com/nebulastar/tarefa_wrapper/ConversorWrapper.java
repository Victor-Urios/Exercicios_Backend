package tarefa_wrapper;
import java.util.Scanner;


/**
 * @author Nebula Stardust
 * Irei comentar bastante nessa atividade por que achei ela bem importante!
 */
public class ConversorWrapper {
    public static void main(String[] args) {
        // Scannerzinho pra digitar o numero
        Scanner scanner = new Scanner(System.in);

        // Pedir para o usuario ler o numero
        System.out.print("Digite um número inteiro primitivo: ");

        // Guardando o numero dentro de uma Int e imprimir o primeiro valor
        int valorPrimitivo = scanner.nextInt();

        // Convertendo o tipo primitivo no caso 'Int' para o tipo wrapper 'Integer'
        // Isso pode ser feito automaticamente pelo metodo do Autoboxing.
        Integer valorWrapper = valorPrimitivo;

        // Outra forma de conversão seria algo mais hardcodado usando o método valueOf()
        // Integer valorWrapper = Integer.valueOf(valorPrimitivo);

        // Imprimindo ambos os valores como o professor solicitou...
        System.out.println("Valor primitivo (int): " + valorPrimitivo);
        System.out.println("Valor wrapper (Integer): " + valorWrapper);
        // Fechar o scanner para evitar vazamento...
        scanner.close();
    }
}
