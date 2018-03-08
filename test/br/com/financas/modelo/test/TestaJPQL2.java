package br.com.financas.modelo.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TestaJPQL2 {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		@SuppressWarnings("deprecation")
		Categoria categoria = new Categoria();
		categoria.setId(1);
		String quey_jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		Query query = em.createQuery(quey_jpql);
		query.setParameter("pCategoria", categoria);

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
