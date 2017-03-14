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

        if(saldoCaixaEletronico < 0 || saldoCaixaEletronico < quantidade){
            System.out.println("O saldo do Caixa Eletronico está zerado, ou você tentou retirar " +
                    "uma quantidade que não temos no Caixa Eletronico.");
        } else {
            saldoCaixaEletronico -= quantidade;
        }
    }

    public void depositar(ContaCorrente conta, CaixaEletronico caixa, double quantidade){
        double saldoConta = conta.getBalance();
        saldoConta += quantidade;
    }

    public double transferir(ContaCorrente conta, CaixaEletronico caixa, double quantidade){

        double saldoConta = conta.getBalance();
        double valorTransferido;

        valorTransferido = saldoConta -= quantidade;
        saldoConta -= quantidade;

        return valorTransferido;
    }
}
