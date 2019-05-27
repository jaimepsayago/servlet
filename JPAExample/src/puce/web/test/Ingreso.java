package puce.web.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class Ingreso {
	public static void main(String[] args) {
		ListarCarpeta();
	}
	public static void Insert() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("persistencia");
		EntityManager em = emf.createEntityManager();
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


public static void ListarCarpeta() {
	EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("persistencia");
	EntityManager em = emf.createEntityManager();
	try {
		//queries = consultas JPQL lenguaje de consultas de JPA
		Query q = em.createQuery("Select obj from Carpeta obj");
		List list = q.getResultList();
		Carpeta carpeta = new Carpeta();
		for(int i=0;i<list.size();i++) {
			carpeta = (Carpeta)list.get(i);
			carpeta.mostrar();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		em.close();
		emf.close();
		}
	
}
}