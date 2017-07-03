package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import junit.framework.Assert;

public class Testeo {

	@Test
	public void queElBarEsteAbierto() {
		Bar unBar = new Bar();
		
		unBar.abrirBar();
		
		Assert.assertTrue(unBar.barAbierto());
	}

	@Test
	public void queLosClientesIngresenAlBarConNombresIguales(){
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Cliente1", 21));
		miBar.ingresarCliente(new Cliente("Cliente1", 22));
		miBar.ingresarCliente(new Cliente("Cliente2", 23));
		miBar.ingresarCliente(new Cliente("Cliente3", 24));
		miBar.ingresarCliente(new Cliente("Cliente1", 25));
		
		Assert.assertEquals(miBar.getClientes().size(), 3);
	}
	
	@Test
	public void queLosClientesSeOrdenenPorNombre(){
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Cliente1", 21));
		miBar.ingresarCliente(new Cliente("Cliente1", 22));
		miBar.ingresarCliente(new Cliente("Cliente2", 23));
		miBar.ingresarCliente(new Cliente("Cliente3", 24));
		miBar.ingresarCliente(new Cliente("Cliente1", 25));
	//	System.out.println(miBar.getClientes().first().getNombre());
		Assert.assertEquals(miBar.getClientes().first().getNombre(), "Cliente1");
		Assert.assertEquals(miBar.getClientes().last().getNombre(), "Cliente3");
	}
	
	@Test
	public void compararClientesPorNombre(){
		Cliente miCliente1 = new Cliente("Cliente1", 21);
		Cliente miCliente2 = new Cliente("Cliente1", 22);
		Cliente miCliente3 = new Cliente("Cliente2", 23);
		
		Assert.assertEquals(miCliente1.compareTo(miCliente2), 0);
		
	}
	
	@Test
	public void queLosClientesSeOrdenenPorEdad(){
		Comparador comparador = new Comparador();
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Cliente1", 21));
		miBar.ingresarCliente(new Cliente("Cliente1", 22));
		miBar.ingresarCliente(new Cliente("Cliente2", 23));
		miBar.ingresarCliente(new Cliente("Cliente3", 24));
		miBar.ingresarCliente(new Cliente("Cliente1", 25));
		
		TreeSet <Cliente> clientesOrdenadosPorEdad = new TreeSet <Cliente>(comparador);
		clientesOrdenadosPorEdad.addAll(miBar.getClientes());
		miBar.setClientes(clientesOrdenadosPorEdad);
		
		Assert.assertEquals("Cliente1", miBar.getClientes().first().getNombre());
		Assert.assertEquals("Cliente3", miBar.getClientes().last().getNombre());
	}

}
