package br.edu.ifpi.restaurante.modelo;

public class Pedido {
	private String produto;
	private double preco;
	
	

	public Pedido(String produto, double preco) {
		this.produto = produto;
		this.preco = preco;
	}


	public String getProduto() {
		return produto;
	}


	public double getPreco() {
		return preco;
	}


	@Override
	public String toString() {
		return "Produto =" + produto + ", Preco=" + preco + "\n";
	}
	
	



	
	

}
