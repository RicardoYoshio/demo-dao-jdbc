package aplicacao;

import java.util.Date;
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
	System.out.println("/n=== Teste 3: Vendedor findAll =====");
	list = vendedorDao.findAll();
	for (Vendedor obj : list) {
		System.out.println(obj);
		}
	System.out.println("/n=== Teste 4: Vendedor inset =====");
	Vendedor newVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
	vendedorDao.insert(newVendedor);
	System.out.println("Inserted! Nem id = " + newVendedor.getId());
	
	}
}