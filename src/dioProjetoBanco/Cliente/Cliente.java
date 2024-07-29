package dioProjetoBanco.Cliente;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
	private String nome;
	private String email;
	private int cpf;
	private int telefone;
	private LocalDate dataDeNascimento;
	
	public Cliente(String nome,String email, int cpf,int telefone, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getCpf() {
		return cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return cpf == other.cpf;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " Email: " + email + " CPF: " + cpf + " Telefone: " + telefone + " Data de nascimento: " + dataDeNascimento + "\n";
	}

	

	
	
}
