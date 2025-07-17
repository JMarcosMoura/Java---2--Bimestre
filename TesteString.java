public class TesteString {

    private static void aumentarLetras() throws Exception {
        String frase = "teste de frase"; //era para ser "null"
        String novaFrase;

        try {
            novaFrase = frase.toUpperCase();
        } catch (NullPointerException e) {
            throw new Exception("Erro ao converter a frase para maiusculas", e);
        }

        System.out.println("Frase antiga: " + frase);
        System.out.println("Frase nova: " + novaFrase);
    }

    public static void main(String[] args) {
        try {
            aumentarLetras();
        } catch (Exception e) {
            System.out.println("Ocorreu uma excecao ao executar o metodo aumentarLetras(): " + e);
        }
    }
}
