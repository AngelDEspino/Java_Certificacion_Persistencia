package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import locator.LocatorEntityManager;
import model.Cuenta;


class CuentasDaoImpl implements CuentasDao {
	EntityManager em = LocatorEntityManager.getEntityManager(); 
	@Override
	public Cuenta findById(int idCuenta) {
//		try (Connection c = LocatorConnection.getConnection()) {
//			String sql = "SELECT * FROM cuentas	WHERE numeroCuenta = ?";
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, idCuenta);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				return new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipocuenta"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null; 
		return em.find(Cuenta.class, idCuenta);
	}

	@Override
	public void updateSaldo(int idCuenta, double nuevoSaldo){
		String jpql="update c from Cuentas c set c.saldo=?1 where c.numeroCuenta=?2 ";
		Query query=em.createQuery(jpql);
		query.setParameter(1, nuevoSaldo);
		query.setParameter(2, idCuenta);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

}
