import java.time.LocalDate;
import java.time.Month;

import Banco.Banco;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Main {
	
	//variavel criada para organizar vizualização
	public static void espaco() {
		System.out.println("");
	}
	
	public static void main(String[] args) {
		/*
		 * metodos banco: 
		 * imprimirClientes 
		 * imprimirContas 
		 * imprimirHistoricoTransacoes
		 * bloquearConta (conta)
		 * desbloquearConta (conta)
		 * alterarLimiteCredito (conta, novo limite)
		 * consultarSaldo (conta) 
		 * verificarLimiteCredito (conta) 
		 * consultarDadosConta (conta)
		 */
		Banco banco = Banco.getInstancia();
		/*
		 * metodos contas: 
		 * consultarSaldo 
		 * sacar (valor, data)
		 * depositar (valor, data)
		 * transferir (valor, conta destino, data)
		 * verificarLimiteCredito 
		 * consultarDadosConta (conta)
		 */	
		ContaCorrente cc1 = new ContaCorrente("Pedro", "pedro@email.com", 123456789, 1978945623, LocalDate.of(2002, Month.JULY, 19));
		ContaPoupanca cp1 = new ContaPoupanca("cezar", "cezar@email.com", 987654321, 1978944598, LocalDate.of(2003, 12, 17));
		ContaPoupanca cp2 = new ContaPoupanca("aline", "aline@email.com", 985754321, 1978464598, LocalDate.of(2004, 10, 2));
		
		cc1.consultarSaldo();
		espaco();
		cc1.depositar(200, LocalDate.of(2024, 6, 20));
		espaco();
		cc1.sacar(100, LocalDate.of(2024, 6, 22));
		espaco();
		cc1.sacar(200, LocalDate.of(2024, 6, 22));
		espaco();
		cc1.consultarSaldo();
		espaco();
		cc1.transferir(40, cp1, LocalDate.of(2024,  6, 24));
		espaco();
		cp1.verificarLimiteCredito();
		espaco();
		cp1.consultarDadosConta();
		espaco();
		cc1.consultarDadosConta();
		espaco();
		cp2.consultarDadosConta();
		
		espaco();
		banco.imprimirClientes();
		espaco();
		banco.imprimirContas();
		espaco();
		banco.imprimirHistoricoTransacoes();
		banco.bloquearConta(cc1);
		espaco();
		cc1.consultarDadosConta();
		banco.desbloquearConta(cc1);
		espaco();
		cc1.consultarDadosConta();
		banco.alterarLimiteCredito(cp2, 200);
		espaco();
		cp2.verificarLimiteCredito();
		espaco();
		banco.consultarDadosConta(cp2);
	}
}
