package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

import com.cinefilos_backend.negocio.BackendConfig;


public class Conexao {
	private static BackendConfig backendConfig = BackendConfig.getInstance();
	private static Connection conn;
	
	public static void criarConexao() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");		
		} catch(ClassNotFoundException e) {
			System.out.println("Suporte PostgreSQL indisponivel");
		}
		
		conn = null;
		String server = "jdbc:postgresql://" + 
		backendConfig.getDBServer() + ":" + backendConfig.getDBPort() + "/" + 
		backendConfig.getDBName();
		conn = DriverManager.getConnection(	server, 
											backendConfig.getDBUsername(),
											backendConfig.getDBPassword());
	}

	public static void criarBaseDeDados() throws Exception {
		
	}
	
	public static void pararConexao() throws Exception {
		conn.close();
	}
	
	public static Connection getConexao() throws Exception {
		criarConexao();
		return conn;
	}
}