package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.Filme;
import com.cinefilos_backend.negocio.IFilmesDAO;



public class FilmeDAO implements IFilmesDAO {

	public List<Filme> listarTodos() throws DBException {
		List<Filme> lista = new ArrayList<Filme>();
		Filme f = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT f.cod_filme, f.titulo, f.data_lancamento, f.duracao, "
					+ "	f.diretor, f.class_indicativa, f.idioma "
					+ "FROM filme f";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				f = new Filme();
				f.setCodFilme(rs.getInt("cod_filme"));
				f.setTitulo(rs.getString("titulo"));
				//f.setDataLancamento(rs.getDate("data_lancamento"));
				f.setDuracao(rs.getInt("duracao"));
				f.setDiretor(rs.getString("diretor"));
				f.setClassificacaoIndicativa(rs.getInt("class_indicativa"));
				f.setIdioma(rs.getString("idioma"));
				lista.add(f);
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return lista;
	}

	@Override
	public boolean cadastrar(Filme filme) throws DBException {
		boolean ret = false;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "INSERT INTO filme (titulo, duracao, diretor, class_indicativa, idioma) " +
						"VALUES (?, ?, ?, ?, ?)";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  filme.getTitulo());
			cmd.setInt(2, filme.getDuracao());
			cmd.setString(3, filme.getDiretor());
			cmd.setInt(4,  filme.getClassificacaoIndicativa());
			cmd.setString(5, filme.getIdioma());
			int res = cmd.executeUpdate();
			ret = res > 0 ? true : false;
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
			
		return ret;
	}

	@Override
	public boolean excluir(Filme filme) throws DBException {
		boolean ret = false;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "DELETE FROM filme WHERE cod_filme = ?";
											
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1,  filme.getCodFilme());
			int res = cmd.executeUpdate();
			ret = res > 0 ? true : false;
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
			
		return ret;
	}

	@Override
	public Filme buscarPorNome(String nome) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme buscarPorCodigo(int codigo) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizar(Filme filme) throws DBException {
		boolean ret = false;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "UPDATE filme SET titulo=?, duracao=?, diretor=?, class_indicativa=?, idioma=? " +
						"WHERE cod_filme=?";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  filme.getTitulo());
			cmd.setInt(2, filme.getDuracao());
			cmd.setString(3, filme.getDiretor());
			cmd.setInt(4,  filme.getClassificacaoIndicativa());
			cmd.setString(5, filme.getIdioma());
			cmd.setInt(6, filme.getCodFilme());
			int res = cmd.executeUpdate();
			ret = res > 0 ? true : false;
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
			
		return ret;

	}
}