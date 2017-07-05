package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.Genero;
import com.cinefilos_backend.negocio.IGeneroDao;

public class GeneroDao implements IGeneroDao {

	@Override
	public void cadastrar(Genero genero) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "INSERT INTO generos (nome) " +
						"VALUES (?)";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  genero.getNome());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public Genero buscaPorNome(String nome) throws DBException {
		Genero g = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_genero, nome FROM generos" +
						"WHERE nome=?";
					
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1, nome);
			ResultSet rs = cmd.executeQuery();
			
			g = new Genero();
			g.setCodGenero(rs.getInt("cod_genero"));
			g.setNome(rs.getString("nome"));
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return g;
	}

	@Override
	public Genero buscaPorCodigo(int codigo) throws DBException {
		Genero g = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_genero, nome FROM generos " +
						"WHERE cod_genero=?";
					
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, codigo);
			ResultSet rs = cmd.executeQuery();
			
			g = new Genero();
			g.setCodGenero(rs.getInt("cod_genero"));
			g.setNome(rs.getString("nome"));
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return g;
	}

	@Override
	public void excluir(Genero genero) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "DELETE FROM generos WHERE cod_genero = ?";
											
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, genero.getCodGenero());
			cmd.executeUpdate();
						
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public List<Genero> listarTodos() throws DBException {
		List<Genero> lista = new ArrayList<Genero>();
		Genero g = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_genero, nome FROM generos";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				g = new Genero();
				g.setCodGenero(rs.getInt("cod_genero"));
				g.setNome(rs.getString("nome"));
				lista.add(g);
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return lista;	}

}
