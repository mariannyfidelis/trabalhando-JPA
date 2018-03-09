package br.com.financas.modelo.test;

import java.math.BigDecimal;
import javax.persistence.Query;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import br.com.financas.dao.MovimentacaoDAO;

public class TestandosFuncoesComplementaresJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		MovimentacaoDAO dao = new MovimentacaoDAO(em);

		// Testando a função Somatório (SUM)
		BigDecimal somatorio = dao.getSomatorioMovimentacao(em);
		System.out.println("Somatório dos valores: " + somatorio);

		// Testando a função Média (AVG)
		Double media = dao.getMediaDasMovimentacoes();
		System.out.println("Média dos valores: " + media);

		// Testando a função MAX
		BigDecimal maiorValor = dao.getMaiorValorTransacao(em);
		System.out.println("O maior valor gasto foi : " + maiorValor);

		// Testando a função COUNT
		// Contagem de todas as movimentações independe das contas
		Long contaValores = dao.getContagemMovimentacoes(em);
		System.out.println("O número de movimentações: " + contaValores);

		em.getTransaction().commit();
		em.close();
	}

}
