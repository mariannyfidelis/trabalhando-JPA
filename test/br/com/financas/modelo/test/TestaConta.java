package br.com.financas.modelo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financas.modelo.Conta;

public class TestaConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Marianny");
		conta.setBanco("Bradesco");
		conta.setAgencia("0809");
		conta.setNumero("1234-1");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
