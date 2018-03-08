package br.com.financas.modelo.test;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;
import br.com.financas.modelo.Cliente;
import javax.persistence.EntityManager;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Professor");

		Conta conta = new Conta();
		conta.setId(2);

		cliente.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}
}
