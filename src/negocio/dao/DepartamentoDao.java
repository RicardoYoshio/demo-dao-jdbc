package negocio.dao;

import java.util.List;

import entidade.negocio.Departamento;

public interface DepartamentoDao {

	void insert(Departamento obs);
	void update(Departamento obj);
	void deleteById(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();
	
}
