package negocio.dao;

import java.util.List;

import entidade.negocio.Vendedor;

public interface VendedorDao {


	void insert(Vendedor obs);
	void ipdate(Vendedor obj);
	void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();
		
}
	

