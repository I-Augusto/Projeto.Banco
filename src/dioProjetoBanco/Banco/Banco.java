package dioProjetoBanco.Banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dioProjetoBanco.Cliente.Cliente;
import dioProjetoBanco.Conta.Conta;
import dioProjetoBanco.Transacao.Transacao;

public class Banco {

	private Set<Cliente> clientes = new HashSet<Cliente>();
	private Map<Integer, Conta> contas;
	private List<Transacao> transacoes;

	public Banco() {
		this.clientes = new HashSet<Cliente>();
		this.contas = new HashMap<Integer, Conta>();
		this.transacoes = new ArrayList<Transacao>();
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public Map<Integer, Conta> getContas() {
		return contas;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void adicionarClienteBanco(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void adicionarContaBanco(int numeroDaConta,Conta conta) {
		this.contas.put(numeroDaConta, conta);
	}
	
	public void adicionarTransacaoBanco(Transacao transacao) {
		this.transacoes.add(transacao);
	}

	public void imprimirClientes() {
		System.out.println("CLIENTES");
		System.out.println(clientes);
	}

	public void imprimirContas() {
		System.out.println("CONTAS");
		System.out.println(contas);
	}
	
	public void imprimirHistoricoTransacoes() {
		System.out.println("TRANSAÇÕES");
		System.out.println(transacoes);
	}
	
	public void bloquearConta(Conta conta) {
		conta.setEstadoDaConta(false);
	}
	
	public void desbloquearConta(Conta conta) {
		conta.setEstadoDaConta(true);
	}
	
	public void alterarLimiteCredito(Conta conta, double limiteDeCredito) {
		conta.setLimiteDeCredito(limiteDeCredito);
	}
	
	public void consultarSaldo(Conta conta) {
		conta.consultarSaldo();
	}
	
	public void verificarLimiteCredito(Conta conta) {
		conta.verificarLimiteCredito();
	}
	
	public void consultarDadosConta(Conta conta) {
		Cliente cliente = conta.getCliente();
		System.out.println(String.format("Cliente: %s", cliente.getNome()));
		System.out.println(String.format("CPF do titular: %d", cliente.getCpf()));
		System.out.println(String.format("Email do titular: %s", cliente.getEmail()));
		System.out.println(String.format("Telefone do titular: %d", cliente.getTelefone()));
		System.out.println(String.format("Data de nascimento do titular: %s", cliente.getDataDeNascimento()));
		System.out.println(String.format("Saldo atual: %.2f", conta.getSaldo()));
		System.out.println(String.format("Agência: %d", conta.getAgencia()));
		System.out.println(String.format("Número da conta: %d", conta.getNumeroDaConta()));
		System.out.println(String.format("Estado da conta: " + (conta.isEstadoDaConta() ? "Ativa" : "Inativa")));
		System.out.println(String.format("Limitede crédito: %.2f", conta.getLimiteDeCredito()));
	}
	
}
