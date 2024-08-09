package Banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Cliente.Cliente;
import Conta.Conta;
import Transacao.Transacao;
import sistemaBancarioFacade.SistemaBancario;

public class Banco {

	private Set<Cliente> clientes = new HashSet<Cliente>();
	private Map<Integer, Conta> contas;
	private List<Transacao> transacoes;
	SistemaBancario sistemaBanco = SistemaBancario.getInstancia();
	
	private static class Instancia {
		public static Banco instancia = new Banco();
	}
	
	private Banco() {
		this.clientes = new HashSet<Cliente>();
		this.contas = new HashMap<Integer, Conta>();
		this.transacoes = new ArrayList<Transacao>();
	}
	
	public static Banco getInstancia() {
		return Instancia.instancia;
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
		sistemaBanco.consultarSaldo(conta);
	}
	
	public void verificarLimiteCredito(Conta conta) {
		sistemaBanco.verificarLimiteCredito(conta);
	}
	
	public void consultarDadosConta(Conta conta) {
		Cliente cliente = conta.getCliente();
		sistemaBanco.consultarDadosConta(conta, cliente);
	}
	
}
