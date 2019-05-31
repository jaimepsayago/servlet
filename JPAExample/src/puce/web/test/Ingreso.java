package puce.web.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class Ingreso {
	
	static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("persistencia");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		insertOnetoMany();
	}
	
	public static void insertOnetoMany() {
		try {
			
			BookCategory bc = new BookCategory();
			bc.setName("categoria programacion");
			
			Book b = new Book();
			//b.setId();
			b.setName("programacion java");
			b.setBookCategory(bc);
			
			Book b1 = new Book();
			b1.setName("programacion ruby");
			b1.setBookCategory(bc);
			
			bc.getBooks().add(b);//agregar el one to many
			bc.getBooks().add(b1);
			
			BookCategory bc1 = new BookCategory();
			bc1.setName("categoria cuentos");
		
			b1.setBookCategory(bc1);
			
			bc1.getBooks().add(b1);
		
			
			em.getTransaction().begin();
			em.persist(b);
			em.persist(b1);
			em.persist(bc);
			em.persist(bc1);
			em.getTransaction().commit();
			System.out.println("datos guardados ok");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("error"+e.getMessage());
		}
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

public static void modificar() {
	try {
		Carpeta carpeta = new Carpeta();
		carpeta.setId(1);
		carpeta.setNombre("ayuda modificada");
		em.getTransaction().begin();//empezar la transaccion
		em.merge(carpeta);//modificar
		em.getTransaction().commit();//guardar la transaccion
		System.out.println("guardado ok");
	} catch (Exception e) {
		em.getTransaction().rollback();//si existe error regresa toda la
		//transaccion
		System.out.println("error"+e.getMessage());
	}
}

public static void eliminar() {
	try {
		Carpeta carpeta =  new Carpeta();
		carpeta = em.find(Carpeta.class, 2);
		if(carpeta == null) {
			System.out.println("no existen datos");
		}else {
			carpeta.mostrar(); //mostrar objeto encontrado
			em.getTransaction().begin();
			em.remove(carpeta);
			em.getTransaction().commit();
			System.out.println("objeto eliminado correctamente");
		}
		
	} catch (Exception e) {
		em.getTransaction().rollback();
	}
}


}