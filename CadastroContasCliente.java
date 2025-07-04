import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Classe que representa uma conta bancária
class Conta implements Comparable<Conta> {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo  = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Implementa a ordenação natural pelo saldo
    @Override
    public int compareTo(Conta outra) {
        return Double.compare(this.saldo, outra.saldo);
    }

    @Override
    public String toString() {
        return String.format("Conta nº %d | Saldo: %.2f", numero, saldo);
    }
}

// Classe que representa um cliente, com várias contas
class Cliente {
    private String nome;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}

public class CadastroContasCliente {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Informe o nome do cliente: ");
            String nomeCliente = sc.nextLine().trim();
            Cliente cliente = new Cliente(nomeCliente);

            while (true) {
                System.out.print("Digite o numero da conta (ou -1 para sair): ");
                if (!sc.hasNextInt()) {
                    System.out.println("Entrada invalida. Digite um numero inteiro.");
                    sc.next(); // descarta token inválido
                    continue;
                }
                int numeroConta = sc.nextInt();
                if (numeroConta == -1) {
                    break;
                }

                System.out.print("Digite o saldo da conta: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("Entrada invalida. Digite um valor numerico.");
                    sc.next(); // descarta token inválido
                    continue;
                }
                double saldoConta = sc.nextDouble();
                sc.nextLine(); // consome o \n pendente

                cliente.adicionarConta(new Conta(numeroConta, saldoConta));
            }

            ArrayList<Conta> lista = cliente.getContas();
            if (lista.isEmpty()) {
                System.out.println("\nNenhuma conta cadastrada para " + cliente.getNome() + ".");
                return;
            }

            // Ordena usando o compareTo implementado em Conta
            Collections.sort(lista);

            // Exibe as contas ordenadas
            System.out.println("\nContas do cliente " + cliente.getNome() + " ordenadas por saldo:");
            for (Conta c : lista) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
