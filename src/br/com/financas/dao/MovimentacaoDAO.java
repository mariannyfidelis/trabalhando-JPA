package br.com.financas.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MovimentacaoDAO {

	EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public Double getMediaDasMovimentacoes() {
		String jpql_media = "select avg(m.valor) from Movimentacao m";
		Query query = em.createQuery(jpql_media);
		return (Double) query.getSingleResult();
	}

	public BigDecimal getMaiorValorTransacao(EntityManager em) {
		Query query;
		String jpql_max = "select max(m.valor) from Movimentacao m";
		query = em.createQuery(jpql_max);
		BigDecimal maiorValor = (BigDecimal) query.getSingleResult();
		return maiorValor;
	}

	public BigDecimal getSomatorioMovimentacao(EntityManager em) {
		String jpql_somatorio = "select sum(m.valor) from Movimentacao m";
		Query query = em.createQuery(jpql_somatorio);
		BigDecimal somatorio = (BigDecimal) query.getSingleResult();
		return somatorio;
	}

	public Long getContagemMovimentacoes(EntityManager em) {
		String jpql_count = "select count(m.id) from Movimentacao m";

		Query query = em.createQuery(jpql_count);
		Long contaValores = (Long) query.getSingleResult();
		return contaValores;
	}
}
