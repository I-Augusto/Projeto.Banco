package dioProjetoBanco.Conta;

import java.time.LocalDate;

import dioProjetoBanco.Banco.Banco;


public class ContaCorrente extends Conta{

	public ContaCorrente(String nomeCliente, String emailCliente, int cpfCliente, int telefoneCliente,
			LocalDate dataDeNascimentoCliente, Banco banco) {
		super(nomeCliente, emailCliente, cpfCliente, telefoneCliente, dataDeNascimentoCliente, banco);
		banco.adicionarContaBanco(numeroDaConta, this);
	}
	
	@Override
	public void consultarDadosConta() {
		System.out.println("======= DADOS DA CONTA =======");
		System.out.println("======= CONTA CORRENTE =======");
		super.consultarDadosConta();
	}

}
