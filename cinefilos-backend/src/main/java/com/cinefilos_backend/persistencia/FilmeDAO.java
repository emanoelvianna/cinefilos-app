package com.cinefilos_backend.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cinefilos_backend.negocio.Filme;
import com.cinefilos_backend.negocio.IFilmeDao;



public class FilmeDAO implements IFilmeDao {

	public List<Filme> listarTodos() throws DBException {
		List<Filme> lista = new ArrayList<Filme>();
		Filme f = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT f.cod_filme, f.titulo, f.data_lancamento, f.duracao, "
					+ "	f.diretor, f.class_indicativa, f.idioma "
					+ "FROM filmes f";
					
			Statement cmd = conn.createStatement();
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				f = new Filme();
				f.setCodFilme(rs.getInt("cod_filme"));
				f.setTitulo(rs.getString("titulo"));
				f.setDataLancamento(rs.getDate("data_lancamento"));
				f.setDuracao(rs.getTime("duracao"));
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
	public void cadastrar(Filme filme) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "INSERT INTO filmes (titulo, duracao, diretor, class_indicativa, idioma) " +
						"VALUES (?, ?, ?, ?, ?)";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  filme.getTitulo());
			cmd.setTime(2, filme.getDuracao());
			cmd.setString(3, filme.getDiretor());
			cmd.setInt(4,  filme.getClassificacaoIndicativa());
			cmd.setString(5, filme.getIdioma());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public void excluir(Filme filme) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "DELETE FROM filmes WHERE cod_filme = ?";
											
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setInt(1,  filme.getCodFilme());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}

	@Override
	public Filme buscarPorNome(String nome) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme buscarPorCodigo(int codigo) throws DBException {
		Filme f = null;
		
		try(Connection conn = Conexao.getConexao()) {
			String sql = "SELECT cod_filme, titulo, data_lancamento, duracao, "
					+ "	diretor, class_indicativa, imagem_cartaz_path, sinopse "
					+ "FROM filmes WHERE cod_filme=1";
					
			
			PreparedStatement cmd = conn.prepareStatement(sql);
			System.out.println("SQL=" + cmd.toString());
			//cmd.setInt(1, codigo);
			ResultSet rs = cmd.executeQuery(sql);
			
			while(rs.next()) {
				f = new Filme();
				f.setCodFilme(rs.getInt("cod_filme"));
				//f.setTitulo(rs.getString("titulo"));
				//f.setDataLancamento(rs.getDate("data_lancamento"));
				//f.setDuracao(rs.getTime("duracao"));
				//f.setDiretor(rs.getString("diretor"));
				//f.setClassificacaoIndicativa(rs.getInt("class_indicativa"));
			}
		} catch(Exception e) {
			throw new DBException("Falha ao conectar ao BD");
		}
		return f;	
	}

	@Override
	public void atualizar(Filme filme) throws DBException {
		try(Connection conn = Conexao.getConexao()) {
			String sql = "UPDATE filmes SET titulo=?, duracao=?, diretor=?, class_indicativa=?, idioma=? " +
						"WHERE cod_filme=?";
								
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1,  filme.getTitulo());
			cmd.setTime(2, filme.getDuracao());
			cmd.setString(3, filme.getDiretor());
			cmd.setInt(4,  filme.getClassificacaoIndicativa());
			cmd.setString(5, filme.getIdioma());
			cmd.setInt(6, filme.getCodFilme());
			cmd.executeUpdate();
			
			cmd.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new DBException("Falha ao conectar ao BD");
		}
	}
}