package com.cinefilos_backend.negocio;

import java.sql.Time;
import java.util.Date;

public class Filme {
	private int codFilme;
	private String titulo;
	private Date dataLancamento;
	private Time duracao;	// minutos
	private String diretor;
	private int classificacaoIndicativa;
	private String idioma;
	private byte cartaz;
	
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

	public void setDuracao(int duracao) { this.duracao = duracao; }
	public int getDuracao() { return duracao; }
	
	public void setDiretor(String diretor) { this.diretor = diretor; }
	public String getDiretor() { return diretor; }
	
	public String toString() {
		return 	"toString[Codigo: " + codFilme +
				" Titulo: " + titulo +
				" Duracao: " + duracao +
				" Diretor: " + diretor +
				" Classificacao: " + classificacaoIndicativa +
				" Idioma: " + idioma + "]";				
	}
}