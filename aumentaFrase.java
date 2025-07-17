public class aumentaFrase {
    public static void main(String args[])
    {
        String frase = "teste de frase"; //era para ser "null"
        String novaFrase = null;
        try{
            novaFrase = frase.toUpperCase();
        }
        catch(NullPointerException e)
        {
            System.out.println("A frase inicial esta nula, para solucionar tal pronblema foi atribuido um valor default.");
            frase = "Frase vazia";
        }
        finally{
            novaFrase = frase.toUpperCase();
        }
        System.out.println("Frase antiga:"+frase);
        System.out.println("Frase nova:"+novaFrase);
    }
}
