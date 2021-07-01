package negocio.dao;

import db.DB;
import negocio.dao.impl.VendedorDaoJDBC;

public class FabricaDao {
	
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
		
	}
}
