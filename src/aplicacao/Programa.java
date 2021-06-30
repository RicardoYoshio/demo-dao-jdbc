package aplicacao;

import java.util.Date;

import entidade.negocio.Departamento;
import entidade.negocio.Vendedor;

public class Programa {
	
	public static void main(String[] args) {
	
	Departamento obj = new Departamento(1, "Livro");
	Vendedor vendedor = new Vendedor (32, "Bob", "bob@gmail.com", new Date(), 3000.00, obj);
	System.out.println(vendedor);
	}
}
