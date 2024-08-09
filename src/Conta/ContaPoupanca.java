package Conta;

import java.time.LocalDate;


public class ContaPoupanca extends Conta{

	public ContaPoupanca(String nomeCliente, String emailCliente, int cpfCliente, int telefoneCliente,
			LocalDate dataDeNascimentoCliente) {
		super(nomeCliente, emailCliente, cpfCliente, telefoneCliente, dataDeNascimentoCliente);
		banco.adicionarContaBanco(numeroDaConta, this);
	}

	public void consultarDadosConta() {
		System.out.println("======= DADOS DA CONTA =======");
		System.out.println("======= CONTA POUPANÇA =======");
		super.consultarDadosConta();
	}
}
