package br.edu.ifpi.restaurante.principal;
import br.edu.ifpi.restaurante.modelo.*;

public class TestaRestaurante {
	public static void main(String[] arg){
		Restaurante r1 = new Restaurante("Come bem", 10);
		

		
		Mesa m = r1.abrirMesa(1);
		m.addPedido(new Pedido("Pizza", 20.00));
		m.addPedido(new Pedido("Refri", 4.00));
		m.setComTaxa(true);
		m.setRateio(2);
	

		Mesa m2 = r1.abrirMesa(2);
		m2.addPedido(new Pedido("Skol", 4.00));
		m2.addPedido(new Pedido("Skol", 4.00));
		m2.addPedido(new Pedido("Skol", 4.00));
		m2.addPedido(new Pedido("File com fritas", 50.00));
		m2.addPedido(new Pedido("Refri", 4.00));
		m2.setComTaxa(true);
		m2.setRateio(4);
		
		Mesa m3 = r1.abrirMesa(5);
		m3.addPedido(new Pedido("Sanduiche", 6.00));
		m.juntar(m3);
		m3.addPedido(new Pedido("Suco", 3.00));
		m3.addPedido(new Pedido("Milk Shake", 10.00));
		
		
		
		
		System.out.println(r1);
		
		
		System.out.println(r1.disponibilidade());
		
		r1.totalNoMomento();
		

		
		
	}
	
}
