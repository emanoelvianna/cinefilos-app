package com.cinefilos_backend.negocio;


import java.util.Date;
import java.util.List;

public class Filme {
	private int codFilme;
	private String titulo;
	private Date dataLancamento;
	private int duracao;
	private String diretor;
	private int classificacaoIndicativa;
	private String idioma;
	private byte cartaz;
	List<Genero> generos;
	
	public void setCodFilme(int codFilme) { this.codFilme = codFilme; } 
	public int getCodFilme() { return codFilme; }
	
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getTitulo() { return titulo; }
	
	public void setIdioma(String idioma) { this.idioma = idioma; }
	public String getIdioma() { return idioma; }
	
	public void setCartaz(byte cartaz) { this.cartaz = cartaz; }
	public byte getCartaz() { return cartaz; }
	
	public void setClassificacaoIndicativa(int ci) { this.classificacaoIndicativa = ci; }
	public int getClassificacaoIndicativa() { return classificacaoIndicativa; }
	
	public void setDataLancamento(Date dataLancamento) { this.dataLancamento = dataLancamento; }
	public Date getDataLancamento() { return dataLancamento; }

	public void setDuracao(int duracao_p) { duracao = duracao_p; }
	public int getDuracao() { return duracao; }
	
	public void setDiretor(String diretor) { this.diretor = diretor; }
	public String getDiretor() { return diretor; }
	
	public void setGeneros(List<Genero> generos) { this.generos = generos; }
	public List<Genero> getGeneros() { return generos; }
}