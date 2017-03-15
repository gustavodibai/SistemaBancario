package business;

import entidades.CaixaEletronico;
import entidades.ContaCorrente;

/**
 * Created by Usuário on 14/03/2017.
 */

public class ContaCorrenteBusiness {

    public void sacar(ContaCorrente conta, CaixaEletronico caixa, double quantidade){
        double saldoContaCorrente = conta.getBalance();
        double saldoCaixaEletronico = caixa.getTotal();


        if(saldoContaCorrente < 0 || saldoContaCorrente < quantidade){
            System.out.println("O saldo da Conta Corrente está zerado, ou você tentou retirar " +
                    "uma quantidade que não tem na sua Conta Corrente.");
        } else {
            saldoContaCorrente -= quantidade;
        }

        //Modificar para poder depois deixar o saldo da ContaCorrente negativo.
        //Mas assim vai criar uma divida para o Cliente.
        if(saldoCaixaEletronico < 0 || saldoCaixaEletronico < quantidade){
            System.out.println("O saldo do Caixa Eletronico está zerado, ou você tentou retirar " +
                    "uma quantidade que não temos no Caixa Eletronico.");
        } else {
            saldoCaixaEletronico -= quantidade;
        }
    }

    public void depositar(ContaCorrente conta, CaixaEletronico caixa, double quantidade){
        
        /* Deposita na ContaCorrente e no CaixaEletronico, por enquanto não precisa de uma
        validação mas futuramente posso utilizar uma validação para colocar uma quantia minima
        ou uma quantia maxima para ser depositada. */

        double saldoContaCorrente = conta.getBalance();
        double saldoCaixaEletronico = caixa.getTotal();

        saldoCaixaEletronico += quantidade;
        saldoContaCorrente += quantidade;
    }

    public double transferir(ContaCorrente conta, CaixaEletronico caixa, double quantidade){

        double saldoContaCorrente = conta.getBalance();
        double saldoCaixaEletronico = caixa.getTotal();

        double valorTransferido;

        valorTransferido = saldoContaCorrente -= quantidade;

        if(saldoCaixaEletronico < 0 || saldoCaixaEletronico < quantidade){
            System.out.println("Você está tentando transferir uma quantia que o caixa eletronico não possui ou" +
                    " o saldo do caixa eletronico é igual a 0!");
        } else {
            saldoCaixaEletronico -= quantidade;
        }

        //Modificar para depois poder deixar o saldo da ContaCorrente negativo.
        //Mas assim vai criar uma divida para o Cliente.
        if(saldoContaCorrente < 0 || saldoContaCorrente < quantidade){
            System.out.println("Você está tentando transferir uma quantia que sua conta corrente não possue ou" +
                    " o saldo da sua conta corrente está zerado.");
        } else {
            saldoContaCorrente -= quantidade;
        }

        return valorTransferido;
    }
}
