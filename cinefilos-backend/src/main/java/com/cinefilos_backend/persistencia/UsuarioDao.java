package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.IUsuarioDao;
import com.cinefilos_backend.negocio.Usuario;

public class UsuarioDao implements IUsuarioDao {

	@Override
	public void cadastrar(Usuario usuario) throws DBException {
	
		try(Connection conn = Conexao.getConexao()) {
			String sql = "INSERT INTO usuario (login, senha, permissao) " +
						"VALUES (?, ?, ?)";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  usuario.getLogin());
			cmd.setString(2, usuario.getSenha());
			cmd.setInt(3,  usuario.getPermissao());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public Usuario buscarPorCodigo(int codigo) throws DBException {
		Usuario u = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_usuario, login, senha, permissao FROM usuario " +
						"WHERE cod_usuario=?";
					
			
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, codigo);
			ResultSet rs = cmd.executeQuery(sql);
			
			u = new Usuario();
			u.setCodUsuario(rs.getInt("cod_usuario"));
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			u.setPermissao(rs.getInt("permissao"));
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return u;
	}

	@Override
	public void excluirUsuario(Usuario usuario) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "DELETE FROM usuario WHERE cod_usuario = ?";
											
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1, usuario.getCodUsuario());
			cmd.executeUpdate();
						
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public List<Usuario> listarTodos() throws DBException {
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario u = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_usuario, login, senha, permissao FROM usuario";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				u = new Usuario();
				u.setCodUsuario(rs.getInt("cod_usuario"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setPermissao(rs.getInt("permissao"));
				lista.add(u);
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return lista;
	}

	@Override
	public void atualizar(Usuario usuario) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "UPDATE usuario SET login=?, senha=?, permissao=? " +
						"WHERE cod_usuario=?";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  usuario.getLogin());
			cmd.setString(2, usuario.getSenha());
			cmd.setInt(3, usuario.getPermissao());
			cmd.setInt(4,  usuario.getCodUsuario());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}
}
