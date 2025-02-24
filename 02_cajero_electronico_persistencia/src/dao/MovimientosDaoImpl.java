package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import locator.LocatorEntityManager;
import model.Movimiento;

class MovimientosDaoImpl implements MovimientosDao {
	EntityManager em = LocatorEntityManager.getEntityManager(); 
//	No se puede repetir el id cuenta, así que optional no tiene mucho sentido en éste caso
//	public Optional<Movimiento> findByCuenta(int idCuenta) {
//		String jpql="select c from Cuentas c where c.idCuenta=?1";
//		TypedQuery<Movimiento> query=em.createQuery(jpql,Movimiento.class);
//		query.setParameter(1, idCuenta);
//		List<Movimiento> movimiento=new ArrayList<Movimiento>();
//		return movimiento.isEmpty()?Optional.empty():Optional.of(query.getResultList().get(0));
//	} 

	@Override
	public List<Movimiento> findByCuenta(int idCuenta) {
		String jpql="select c from Movimientos c where idCuenta=?1";
		TypedQuery<Movimiento> query=em.createQuery(jpql,Movimiento.class);
		return query.getResultList();
	} 

	@Override
	public void save(Movimiento movimiento) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(movimiento);
		tx.commit();		
	} 

}
