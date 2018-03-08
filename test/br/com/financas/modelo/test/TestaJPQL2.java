package br.com.financas.modelo.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TestaJPQL2 {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(new Integer(2));
		String quey_jpql = "select m from Movimentacao m where id = :contaId";

		Query query = em.createQuery(quey_jpql);
		query.setParameter("contaId", conta.getId());

		em.getTransaction().begin();

		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("ID - " + movimentacao.getId());
			System.out.println("Descrição - " + movimentacao.getDescricao());
		}

		em.getTransaction().commit();
		em.close();
	}

}
