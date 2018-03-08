package br.com.financas.modelo.test;

import java.util.Calendar;
import java.math.BigDecimal;
import br.com.financas.util.JPAUtil;
import br.com.financas.modelo.Conta;
import javax.persistence.EntityManager;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;

public class TestaRelacionamentoJPA {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("José Júnior");
		conta.setBanco("Bradescoss");
		conta.setAgencia("7972879237429");
		conta.setNumero("8977-1");

		Movimentacao movimentacao = new Movimentacao();
	    movimentacao.setData(Calendar.getInstance());
	    movimentacao.setDescricao("Churrascaria");
	    movimentacao.setTipo(TipoMovimentacao.SAIDA);
	    movimentacao.setValor(new BigDecimal("200.0"));

	    movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}
