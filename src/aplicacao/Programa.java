package aplicacao;

import entidade.negocio.Vendedor;
import negocio.dao.FabricaDao;
import negocio.dao.VendedorDao;

public class Programa {
	
	public static void main(String[] args) {
	
	
	VendedorDao vendedorDao = FabricaDao.createVendedorDao();
	
	System.out.println("=== Teste 1: Vendedor finById =====");
	Vendedor vendedor = vendedorDao.findById(3);
	System.out.println(vendedor);
	}
}
