package dioProjetoBanco.Transacao;

import java.time.LocalDate;

public class Transacao {
	
	private int conta;
	private int contaDestino;
	private double saldoAtual;
	private LocalDate dataDaTransacao;
	private boolean temContaDestino;
	
	
	
	public Transacao(int conta, int contaDestino, double saldoAtual, LocalDate dataDaTransacao) {
		this.conta = conta;
		this.contaDestino = contaDestino;
		this.saldoAtual = saldoAtual;
		this.dataDaTransacao = dataDaTransacao;
		this.temContaDestino = true;
	}
	public Transacao(int conta, double saldoAtual, LocalDate dataDaTransacao) {
		this.conta = conta;
		this.saldoAtual = saldoAtual;
		this.dataDaTransacao = dataDaTransacao;
		this.temContaDestino = false;
	}
	public int getConta() {
		return conta;
	}
	public int getContaDestino() {
		return contaDestino;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public LocalDate getDataDaTransacao() {
		return dataDaTransacao;
	}
	
	@Override
	public String toString() {
		if(temContaDestino) {
			return "Conta: " + conta + " Conta de destino: " + contaDestino + " Saldo: " + saldoAtual + " Data da transação: " + dataDaTransacao + "\n";	
		}else {
			return "Conta: " + conta + " Saldo: " + saldoAtual + " Data da transação: " + dataDaTransacao + "\n";			
		}
	}
	
}
