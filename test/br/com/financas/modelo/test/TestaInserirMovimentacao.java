package br.com.financas.modelo.test;

import java.util.List;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import br.com.financas.modelo.Movimentacao;

public class TestaInserirMovimentacao {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		List<Movimentacao> movimentacoes = conta.getMovimentacoes();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentacao - " + movimentacao.getDescricao());
		}
		em.close();
	}
}
