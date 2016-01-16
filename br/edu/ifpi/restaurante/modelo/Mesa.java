package br.edu.ifpi.restaurante.modelo;

public class Mesa {
	
	public final static String DISPONIVEL = "Disponivel";
	public final static String OCUPADA = "Ocupada";
	public final static String PRINCIPAL = "Principal";
	public final static String SECUNDARIA = "Secundaria";
	
	
	private int numero;
	private String status;
	private Pedido[] pedidos;
	private Pedido[] p1;
	private int numPedidos;
	private boolean comTaxa;
	private int rateio;
	private String tipo;
	private Mesa ligacao;
	
	

	public Mesa(int numero) {
		this.numero = numero;
		this.status = Mesa.DISPONIVEL;
		this.numPedidos = 0;
		this.comTaxa = true;
		this.rateio = 1;
		this.tipo = Mesa.PRINCIPAL;
		this.ligacao = this;
		pedidos = new Pedido[numPedidos];
	}
	
	public void abrir(){
		this.status = Mesa.OCUPADA;
	}
	
	
	public void inicializacao(Pedido[] p1){
		this.pedidos = new Pedido[numPedidos];
		for( int i = 0; i < p1.length; i++){
			this.pedidos[i]= this.p1[i];
		}
	}
	
	
	public void addPedido(Pedido pedido){
		ligacao.numPedidos++;
		ligacao.p1 = ligacao.pedidos;
		ligacao.inicializacao(ligacao.p1);
		ligacao.pedidos[ligacao.numPedidos-1] = pedido;
	}
	
	public void juntar(Mesa mesa){
		mesa.ligacao =  this;
		mesa.tipo = Mesa.SECUNDARIA;
		for (Pedido pedido : mesa.getPedidos()){
			addPedido(pedido);
		}
	}


	public double conta(){
		double valor = 0;
		for(Pedido pedido : pedidos){
			valor += pedido.getPreco();
		}
		if (comTaxa){valor *= 1.1;}
		return valor;
	}
	
	private Pedido[] getPedidos() {
		return pedidos;
	}
	
	public void setComTaxa(boolean comTaxa) {
		this.comTaxa = comTaxa;
	}

	public String getStatus() {
		return status;
	}
	
	
	public void setRateio(int rateio){
		this.rateio = rateio;
	}
	
	public int getNumero() {
		return numero;
	}



	public String toString() {
		if (this.tipo == Mesa.SECUNDARIA){
			return "\n_________________________\nConta da Mesa " + numero 
					+ " está na mesa principal: Mesa " 
					+ ligacao.getNumero() 
					+ "\n_________________________\n"; 
		}
		if (getStatus() == Mesa.OCUPADA){
			String str ="\n_________________________\n" 
					+ "Mesa "+ numero 
					+ "\nPedidos Realizados: " + (this.numPedidos)
					+ "\n-------------------------\nProduto - Preco\n" ;	
			for(Pedido pedido : pedidos){
				str += pedido.getProduto() + " - R$ " + pedido.getPreco() + "\n";
			} 
			str += "-------------------------" 
					+ "\nValor da conta R$ " + (float)conta()
					+ "\n" + rateio + "x " + (float)(conta()/rateio)
					+ "\n_________________________\n";
			return str;
		}return "";
	}

	


}
