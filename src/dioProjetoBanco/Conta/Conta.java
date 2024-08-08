package dioProjetoBanco.Conta;

import java.time.LocalDate;

import dioProjetoBanco.Banco.Banco;
import dioProjetoBanco.Cliente.Cliente;
import dioProjetoBanco.Transacao.Transacao;

public class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIA_CONTA= 1;
	
	protected int agencia;
	protected int numeroDaConta;
	protected double saldo;
	protected double limiteDeCredito;
	protected boolean estadoDaConta;
	protected Cliente cliente;
	protected Banco banco;
	protected Conta conta;
	protected Transacao transacao;
	
	public Conta(String nomeCliente,String emailCliente, int cpfCliente, int telefoneCliente, LocalDate dataDeNascimentoCliente, Banco banco) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroDaConta = SEQUENCIA_CONTA++;
		this.saldo = 0;
		this.limiteDeCredito = 0;
		this.estadoDaConta = true;
		this.cliente = new Cliente(nomeCliente, emailCliente, cpfCliente, telefoneCliente, dataDeNascimentoCliente );
		this.banco = banco;
		banco.adicionarClienteBanco(cliente);	
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumeroDaConta() {
		return numeroDaConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}
	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	public boolean isEstadoDaConta() {
		return estadoDaConta;
	}
	public void setEstadoDaConta(boolean estadoDaConta) {
		this.estadoDaConta = estadoDaConta;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void consultarSaldo() {
		System.out.println(String.format("Saldo da conta: %.2f", saldo));
	}
	
	public void sacar(double valor, LocalDate data) {
		if(valor <= saldo + this.limiteDeCredito) {
		saldo -= valor;
		System.out.println(String.format("Saldo atual: %.2f", saldo));
		this.transacao = new Transacao(this.numeroDaConta, saldo, data);
		banco.adicionarTransacaoBanco(transacao);
		} else {
			System.out.println("Saldo insulficiente");
		}
	}
	
	public void depositar(double valor, LocalDate data) {
		saldo += valor;
		System.out.println(String.format("Saldo da conta após deposito: %.2f", saldo));
		this.transacao = new Transacao(this.numeroDaConta, saldo, data);
		banco.adicionarTransacaoBanco(transacao);
	}
	
	public void transferir(double valor, Conta contaDestino, LocalDate data) {
		this.sacar(valor, data);
		contaDestino.depositar(valor, data);
		this.transacao = new Transacao(this.numeroDaConta, contaDestino.getNumeroDaConta(), saldo, data);
		banco.adicionarTransacaoBanco(transacao);

	}
	
	public void verificarLimiteCredito() {
		System.out.println(String.format("Limite atual: %.2f", this.limiteDeCredito));
	}
	
	protected void consultarDadosConta() {
		//System.out.println("======= DADOS DA CONTA =======");
		System.out.println(String.format("Cliente: %s", cliente.getNome()));
		System.out.println(String.format("CPF do titular: %d", cliente.getCpf()));
		System.out.println(String.format("Email do titular: %s", cliente.getEmail()));
		System.out.println(String.format("Telefone do titular: %d", cliente.getTelefone()));
		System.out.println(String.format("Data de nascimento do titular: %s", cliente.getDataDeNascimento()));
		System.out.println(String.format("Saldo atual: %.2f", this.saldo));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número da conta: %d", this.numeroDaConta));
		System.out.println(String.format("Estado da conta: " + (this.estadoDaConta ? "Ativa" : "Inativa")));
		System.out.println(String.format("Limitede crédito: %.2f", this.limiteDeCredito));
		
	}
	
	@Override
	public String toString() {
		return "Agencia: " + agencia + 
				" Numero da conta: " + this.numeroDaConta + 
				" Saldo da conta: " + this.saldo + 
				" Limite de crédito da conta: " + this.limiteDeCredito + 
				" Estado da conta: " + ((this.estadoDaConta) ? "Ativa" : "Inativa") + 
				" Cliente: " + this.cliente;
	}
	
}
