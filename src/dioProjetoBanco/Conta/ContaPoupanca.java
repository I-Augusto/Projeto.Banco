package dioProjetoBanco.Conta;

import java.time.LocalDate;

import dioProjetoBanco.Banco.Banco;


public class ContaPoupanca extends Conta{

	public ContaPoupanca(String nomeCliente, String emailCliente, int cpfCliente, int telefoneCliente,
			LocalDate dataDeNascimentoCliente, Banco banco) {
		super(nomeCliente, emailCliente, cpfCliente, telefoneCliente, dataDeNascimentoCliente, banco);
		banco.adicionarContaBanco(numeroDaConta, this);
	}

	public void consultarDadosConta() {
		System.out.println("======= DADOS DA CONTA =======");
		System.out.println("======= CONTA POUPANÇA =======");
		super.consultarDadosConta();
	}
}
