package br.com.nebulastar;
import java.util.Scanner; // para o usuario poder colocar as notas
// importar um scanner!

/**
 * @author Nebula Stardust
 */
public class Calculadora2 {
    public static void main(String[] args) {
    int nota1, nota2, nota3, nota4, media;

    Scanner scan = new Scanner(System.in); // o scanner colocado pro usuario colocar suas notas
    System.out.println("Digite a primeiro nota: ");
    nota1 = scan.nextInt(); // como ele escaneira " int " ele vai querer um numero!
        // caso coloque letras ele retornara um erro!
    System.out.println("Digite a segunda nota: ");
    nota2 = scan.nextInt();
    System.out.println("Digite a terceira nota: ");
    nota3 = scan.nextInt();
    System.out.println("Digite a quarta nota: ");
    nota4 = scan.nextInt();

    media = (nota1+nota2+nota3+nota4)/4;

    if (media>=5 && media<7) {
        System.out.println("Sua media é " + media + " Você esta de Recuperação!");
    } else if (media >= 7) {
        System.out.println("Sua média é " + media + " Você foi Aprovado!");
    } else {
		System.out.println("Sua média é " + media + " Você foi Reprovado!");
	}

    }
}
