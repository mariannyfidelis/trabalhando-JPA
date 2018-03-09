package br.com.financas.modelo.test;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import br.com.financas.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		Conta conta = movimentacao.getConta();

		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
	}
}
