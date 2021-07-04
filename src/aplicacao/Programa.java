package aplicacao;

import java.util.List;

import entidade.negocio.Departamento;
import entidade.negocio.Vendedor;
import negocio.dao.FabricaDao;
import negocio.dao.VendedorDao;

public class Programa {
	
	public static void main(String[] args) {
	
	
	VendedorDao vendedorDao = FabricaDao.createVendedorDao();
	
	System.out.println("=== Teste 1: Vendedor finById =====");
	Vendedor vendedor = vendedorDao.findById(3);
	System.out.println(vendedor);
	
	
	System.out.println("/n=== Teste 2: Vendedor finByDepartamento =====");
	Departamento departamento = new Departamento(2, null);
	List<Vendedor> list = vendedorDao.findByDepartamento(departamento);
	for (Vendedor obj : list) {
		System.out.println(obj);
	}
	
	}
}
