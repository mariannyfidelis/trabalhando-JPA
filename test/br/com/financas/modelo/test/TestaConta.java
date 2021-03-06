package br.com.financas.modelo.test;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class TestaConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Marianny");
		conta.setBanco("Bradesco");
		conta.setAgencia("0809");
		conta.setNumero("1234-1");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		em.close();
	}
}
