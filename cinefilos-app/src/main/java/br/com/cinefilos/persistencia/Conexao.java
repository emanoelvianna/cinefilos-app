package br.com.cinefilos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Conexao {

	private static final String STR_DRIVER = "org.postgresql.Driver";
	private static final String STR_CONNECTION = "jdbc:postgresql://localhost:5432/cinefilos";
	private static final String STR_DATABASE_USER = "postgres";
	private static final String STR_DATABASE_PWD = "postgres";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(STR_CONNECTION, STR_DATABASE_USER, STR_DATABASE_PWD);
			System.out.println("Conexão realizada com Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
