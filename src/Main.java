/**
 * Você pode criar uma <b>Cadeira</b> do jeitinho que quiser!
 * Basta ver se a cadeira é uma cadeira ergonômica ou algum outro modelo!
 * E também descrever o quão confortavel ela é!
 *
 * @since version 0.1
 */

public static void main(String[] args) {
    Cadeira cadeira = new Cadeira();
    cadeira.setNome("Cadeira ergonômica");
    cadeira.setTipo("Escritório");
    cadeira.setConforto("Extremamente confortavel!");
    System.out.println(cadeira.nome + " modelo:" + cadeira.tipo + " " + cadeira.conforto);
}