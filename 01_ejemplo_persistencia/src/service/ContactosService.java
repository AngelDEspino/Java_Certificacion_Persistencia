package service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import model.Contacto;

public class ContactosService {
	EntityManager em;
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("agemdaPU");
		em=factory.createEntityManager();
	}
		public void altaContacto(Contacto contacto) {
			// Las altas, bajas y actualizaciones, deben estar embebidas en una transacción
			//Si no, no funciona.
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(contacto);
			tx.commit();
		}
		
		public void eliminarContacto(int idContacto) {
			Contacto contacto=buscarContacto(idContacto);
			if(contacto!=null) {
				EntityTransaction tx=em.getTransaction();
				tx.begin();
				em.remove(contacto);
				tx.commit();
			}
		}
		
		public Contacto buscarContacto(int idContacto) {
			return em.find(Contacto.class, idContacto);
		}
		//Entity manager solo sirve para las 4 básicas del CRUD, para otras operaciones
		//hay que realizar consultas JPA utilizando JPQL
		public List<Contacto> recuperarTodos(){
			String jpql="select c from Contacto c";
			TypedQuery<Contacto> query=em.createQuery(jpql, Contacto.class);
			return query.getResultList();
		}

		
		
		//Optional para casos en los que no haya resultado
		public Optional<Contacto> buscarContactoEmail(String email) {
			String jpql="select c from Contacto c where c.email=?1";
			TypedQuery<Contacto> query=em.createQuery(jpql,Contacto.class);
			query.setParameter(1, email);
			//si hay resultado devuelva el resultado en el optional u optionalVacio, al final
			//acabas recurriendo al resultlist, para eso... mejor ir directamente a él
//			try {
//				return Optional.of(query.getSingleResult());
//			}catch(NoResultException ex) {
//				return Optional.empty();
//			}
//			catch (NonUniqueResultException ex) {
//				return Optional.of(query.getResultList().get(0));
//			}
			List<Contacto> contactos=query.getResultList();
			return contactos.isEmpty()?Optional.empty():Optional.of(query.getResultList().get(0));
		}
		
		public void eliminarContactoNombre(String nombre) {
			String jpql="delete from Contacto c where c.nombre=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, nombre);
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			query.executeUpdate();
			tx.commit();
		}
}
