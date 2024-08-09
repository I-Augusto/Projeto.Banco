package sistemaBancarioFacade;


import Cliente.Cliente;
import Conta.Conta;

public class SistemaBancario {

	private static class Instancia {
		public static SistemaBancario instancia = new SistemaBancario();
	}
	
	private SistemaBancario() {
		super();
	}
	
	public static SistemaBancario getInstancia() {
		return Instancia.instancia;
	}
	
	public void consultarSaldo(Conta conta) {
		System.out.println(String.format("Saldo da conta: %.2f", conta.getSaldo()));
	}
	
	public void verificarLimiteCredito(Conta conta) {
		System.out.println(String.format("Limite atual: %.2f", conta.getLimiteDeCredito()));
	}
	
	public void consultarDadosConta(Conta conta, Cliente cliente) {
		System.out.println(String.format("Cliente: %s", cliente.getNome()));
		System.out.println(String.format("CPF do titular: %d", cliente.getCpf()));
		System.out.println(String.format("Email do titular: %s", cliente.getEmail()));
		System.out.println(String.format("Telefone do titular: %d", cliente.getTelefone()));
		System.out.println(String.format("Data de nascimento do titular: %s", cliente.getDataDeNascimento()));
		System.out.println(String.format("Saldo atual: %.2f", conta.getSaldo()));
		System.out.println(String.format("Agência: %d", conta.getAgencia()));
		System.out.println(String.format("Número da conta: %d", conta.getNumeroDaConta()));
		System.out.println(String.format("Estado da conta: " + (conta.isEstadoDaConta() ? "Ativa" : "Inativa")));
		System.out.println(String.format("Limite de crédito: %.2f", conta.getLimiteDeCredito()));
	}
	

	
	
}
