package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		// Conexão com o banco de dados pegando as configurações do persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		// remover
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		System.out.println("Pronto");
		em.close();
		emf.close();
		
	}

}
