package br.com.financas.modelo.test;

import java.util.Arrays;
import java.util.Calendar;
import java.math.BigDecimal;
import br.com.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;

public class TestaMovimentacoesComCategoria {

	public static void main(String[] args) {

		@SuppressWarnings("deprecation")
		Categoria categoria1 = new Categoria();
		categoria1.setNome("viagem");

		@SuppressWarnings("deprecation")
		Categoria categoria2 = new Categoria();
		categoria2.setNome("negócios");

		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); // hoje
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.0"));
		movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance()); // hoje
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		// Deve-se primeiro setar as categorias pois estas são Transients to Managed

		em.persist(categoria1);
		em.persist(categoria2);

		em.persist(movimentacao1);
		em.persist(movimentacao2);

		em.getTransaction().commit();
		em.close();
	}
}
