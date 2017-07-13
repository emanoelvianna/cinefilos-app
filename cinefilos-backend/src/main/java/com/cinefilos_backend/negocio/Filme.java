package com.cinefilos_backend.negocio;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Filme {
	private int codFilme;
	private String titulo;
	private Date dataLancamento;
	private Time duracao;
	private String diretor;
	private int classificacaoIndicativa;
	private String imagem_cartaz_path;
	private String sinopse;
	List<Genero> generos;
	
	public void setCodFilme(int codFilme) { this.codFilme = codFilme; } 
	public int getCodFilme() { return codFilme; }
	
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getTitulo() { return titulo; }
	
	public void setCartazPath(String imagem_cartaz_path) { this.imagem_cartaz_path = imagem_cartaz_path; }
	public String getCartazPath() { return imagem_cartaz_path; }
	
	public void setSinopse(String sinopse) { this.sinopse = sinopse; }
	public String getSinopse() { return sinopse; }
	
	public void setClassificacaoIndicativa(int ci) { this.classificacaoIndicativa = ci; }
	public int getClassificacaoIndicativa() { return classificacaoIndicativa; }
	
	public void setDataLancamento(Date dataLancamento) { this.dataLancamento = dataLancamento; }
	public Date getDataLancamento() { return dataLancamento; }

	public void setDuracao(Time duracao_p) { duracao = duracao_p; }
	public Time getDuracao() { return duracao; }
	
	public void setDiretor(String diretor) { this.diretor = diretor; }
	public String getDiretor() { return diretor; }
	
	public void setGeneros(List<Genero> generos) { this.generos = generos; }
	public List<Genero> getGeneros() { return generos; }
}