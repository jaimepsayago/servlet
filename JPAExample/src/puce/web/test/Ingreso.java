package puce.web.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Ingreso {
	//private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		Insert();

	}
	
	public static void Insert() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("persistencia");
		EntityManager em = emf.createEntityManager();
	
		//factory = Persistence.createEntityManagerFactory("persistencia");
	    //EntityManager em = factory.createEntityManager();
		
		try {
			Alergia alergia = new Alergia();
			alergia.setId(null);
			alergia.setDescripcion("ayuda111");
			em.getTransaction().begin();
			em.persist(alergia);
			em.getTransaction().commit();
			System.out.println("el proceso de grabado fue un exito");
			} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("error" + e.getMessage());
			}finally{
			em.close();
			emf.close();
			}
			}
	}
