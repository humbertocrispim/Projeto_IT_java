package cadastro;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente {
	
	
	Long IdPaciente;
	String CPF;
	String Nome;
	String Nascimento;
	String Endereco;
	String Telefone;
	String Regiao;
	
	
	
	public Long getIdPaciente() {
		return IdPaciente;
	}
	
	public void setIdPaciente(Long IdPaciente) {
		this.IdPaciente = IdPaciente;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getNascimento() {
		return Nascimento;
	}
	
	public void setNascimento(String Nascimento) {
		this.Nascimento = Nascimento;
	}
	
	public String getEndereco() {
		return Endereco;
	}
	
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
	
	public String getRegiao() {
		return Regiao;
	}
	
	public void setRegiao(String Regiao) {
		this.Regiao = Regiao;
	}
	
	
}

/* public void status() {
	
	System.out.println("Seu CPF: " + this.CPF);
	System.out.println("Seu nome: " + this.Nome);
	System.out.println("Sua data de nascimento: " + this.Nascimento);
	System.out.println("Seu endere�o: " + this.Endereco);
	System.out.println("Seu telefone: " + this.Telefone);
	System.out.println("Sua regi�o: " + this.Regiao);
		

}
*/