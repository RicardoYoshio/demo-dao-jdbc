package negocio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entidade.negocio.Departamento;
import entidade.negocio.Vendedor;
import negocio.dao.VendedorDao;

public class VendedorDaoJDBC implements VendedorDao{

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = instantiateDepartamento(rs);
				Vendedor obj = instantiateVendedor(rs, dep);	
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Vendedor instantiateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalario(rs.getDouble("BaseSalary"));
		obj.setNascimento(rs.getDate("BirthDate"));
		obj.setDepartamento(dep);	
		return obj;
	}

	private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instantiateVendedor(rs, dep);	
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			st.setInt(1, departamento.getId());
			
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instantiateVendedor(rs, dep);	
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}