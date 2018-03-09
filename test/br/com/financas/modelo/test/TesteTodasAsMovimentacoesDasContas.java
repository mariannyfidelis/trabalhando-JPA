package br.com.financas.modelo.test;

import java.util.List;
import javax.persistence.Query;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String jpql = "select distinct c from Conta c join fetch c.movimentacoes";

		Query query = em.createQuery(jpql);

		List<Conta> todasAsContas = query.getResultList();

		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());
		}

	}

}
