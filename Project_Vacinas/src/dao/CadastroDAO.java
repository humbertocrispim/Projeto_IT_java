package dao;

import conexao.ConexaoBD;
import java.util.Date;
import cadastro.Paciente;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDAO {
	
	public void inserir(Paciente paciente) throws SQLException {
		
		try {
		Connection connection = ConexaoBD.getConnection();
		
		String sql = "INSERT INTO paciente(CPF, Nome, Nascimento, Endereco, Telefone, Regiao) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, paciente.getCPF());
		statement.setString(2, paciente.getNome());
		statement.setString(3, paciente.getNascimento());
		statement.setString(4, paciente.getEndereco());
		statement.setString(5, paciente.getTelefone());
		statement.setString(6, paciente.getRegiao());
		
		statement.execute();
		
		connection.close();
		
		System.out.print("Inserido com sucesso!");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
	
	public void remover (String CPF) {
		try {
			Connection connection = ConexaoBD.getConnection();
			
			String sql = "DELETE FROM PACIENTE WHERE CPF = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(2, CPF);
			
			statement.execute();
			statement.close();
			
			System.out.print("Removido com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Paciente> listarTodos() {
		List<Paciente> listaPaciente = new ArrayList<Paciente>();
		try {
			Connection connection = ConexaoBD.getConnection();
			
			String sql = "SELECT * FROM PACIENTE";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs= statement.executeQuery();
			
			while(rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setIdPaciente(rs.getLong("IdPaciente"));
				paciente.setCPF(rs.getString("CPF"));
				paciente.setNome(rs.getString("Nome"));
				paciente.setNascimento(rs.getString("Nascimento"));
				paciente.setEndereco(rs.getString("Endereco"));
				paciente.setTelefone(rs.getString("Telefone"));
				paciente.setRegiao(rs.getString("Regiao"));
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPaciente;
	}
	
	public void atualizar(Paciente paciente) {
		try {
			
			Connection connection = ConexaoBD.getConnection();
			
			String sql = "UPDATE PACIENTE SET CPF = ?, Nome = ?, Nascimento =?, Endereco = ?, Telefone = ?, Regiao = ?  WHERE IdPaciente = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setLong(1, paciente.getIdPaciente());
			statement.setString(2, paciente.getCPF());
			statement.setString(3, paciente.getNome());
			statement.setString(4, paciente.getNascimento());
			statement.setString(5, paciente.getEndereco());
			statement.setString(6, paciente.getTelefone());
			statement.setString(7, paciente.getRegiao());
			
			statement.execute();
			statement.close();
			
			System.out.print("Atualizado com sucesso!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String [] args) throws SQLException, ParseException {
		
		Scanner scan = new Scanner(System.in);
		Paciente paciente = new Paciente();
		
		System.out.print("Por gentileza, informe o seu CPF: ");
		String CPF = scan.nextLine();
		
		System.out.print("Nome: ");
		String Nome = scan.nextLine();

		System.out.print("Data de Nascimento: ");
		String Nascimento = scan.nextLine();
		
		System.out.print("Endereco: ");
		String Endereco = scan.nextLine();
		
		System.out.print("Telefone: ");
		String Telefone = scan.nextLine();
		
		System.out.print("Regiao em que reside (Norte, Sul, Leste, Oeste, Centro): ");
		String Regiao = scan.nextLine();
		
		paciente.setCPF(CPF);
		paciente.setNome(Nome);
		paciente.setNascimento(Nascimento);
		paciente.setEndereco(Endereco);
		paciente.setTelefone(Telefone);
		paciente.setRegiao(Regiao);
		
		CadastroDAO cadastro = new CadastroDAO();
		
		cadastro.inserir(paciente);
	}
	
	
	
	
}	
	/*
	Long IdPaciente;
	String CPF;
	String Nome;
	String Nascimento;
	String Endereco;
	String Telefone;
	String Regiao; */