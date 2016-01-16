package br.edu.ifpi.restaurante.modelo;


public class Restaurante {
	
	private String nome;
	private Mesa[] mesas;

	public Restaurante(String nome, int qtd) {
		this.nome = nome;
		this.mesas = new Mesa[qtd];
		for (int i = 0; i < mesas.length; i++) {
			mesas[i] = new Mesa(i+1);
		}
	}
	
	
	public Mesa abrirMesa(int num){
		mesas[num-1].abrir();
		return mesas[num-1];
	}
	
	public String disponibilidade(){
		int qtdOcupadas = 0;
		int qtdDisponiveis = 0;
		for(Mesa mesa : mesas){
			if (mesa.getStatus() == Mesa.OCUPADA){++qtdOcupadas;}
			else{++qtdDisponiveis;}
		}
		return "\n\n-----------------\n|Ocupadas: " + qtdOcupadas 
				+"|\n|Disponiveis: " + qtdDisponiveis 
				+ "|\n-----------------";
	}
	
	public void totalNoMomento(){
		double total = 0;
		for(Mesa mesa : mesas){
			if (mesa.getStatus()== Mesa.OCUPADA){ total += mesa.conta();}
		}
		System.out.format("\n\nValor total das mesas ocupadas: R$ %.2f\n", total);
	}
	
	
	
//	public void juntarContas(int numMesa1, int numMesa2){
//		mesas[numMesa1-1].setConta(mesas[numMesa1-1].getConta() + mesas[numMesa2-1].getConta());
//		System.out.println("\nConta da Mesa " + numMesa2 + " foi transferida para a conta da Mesa " + numMesa1);
//	}


	@Override
	public String toString() {
		String str = "Restaurante " + nome + "\nMesas Ocupadas\n";
		for (Mesa mesa : getMesas()){
			if (mesa.getStatus() == Mesa.OCUPADA)
				str +=mesa;
		}
		return str;
	}


	public Mesa[] getMesas() {
		return mesas;
	}


}
