package Conta;

import java.time.LocalDate;

import Banco.Banco;
import Cliente.Cliente;
import Transacao.Transacao;
import sistemaBancarioFacade.SistemaBancario;

public class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIA_CONTA= 1;
	
	protected int agencia;
	protected int numeroDaConta;
	protected double saldo;
	protected double limiteDeCredito;
	protected boolean estadoDaConta;
	protected Cliente cliente;
	protected Banco banco = Banco.getInstancia();
	protected Conta conta;
	protected Transacao transacao;
	SistemaBancario sistemaBanco = SistemaBancario.getInstancia();
	
	public Conta(String nomeCliente,String emailCliente, int cpfCliente, int telefoneCliente, LocalDate dataDeNascimentoCliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroDaConta = SEQUENCIA_CONTA++;
		this.saldo = 0;
		this.limiteDeCredito = 0;
		this.estadoDaConta = true;
		this.cliente = new Cliente(nomeCliente, emailCliente, cpfCliente, telefoneCliente, dataDeNascimentoCliente );
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
		sistemaBanco.consultarSaldo(this);
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
		sistemaBanco.verificarLimiteCredito(this);
	}
	
	protected void consultarDadosConta() {		
		sistemaBanco.consultarDadosConta(this, cliente);
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
