package com.loiane.estruturadados.vetor;

public class Vetor {

	private String[] elementos;
	private int tamanho;

	// construtor que vai receber a capacidade de elementos do vetor
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
	// metodo que adiciona um elemento ao vetor
	/* public void adiciona(String elemento) {
		for (int i = 0; i < this.elementos.length; i++) {
			// verifica se a posição do vetor esta nula
			if (this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	} */
	
	/* public void adiciona(String elemento) throws Exception {
		
		// verifica se o tamanho é menor que a capacidade do vetor de elementos
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos.");
		}
		
	} */

	public boolean adiciona(String elemento) {
		this.aumentaCapacidade();
		// verifica se o tamanho é menor que a capacidade do vetor de elementos
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	// 0 1 2 3 4 5 6 = tamanho é 5
	// B C E F G + +
	// overloading do metodo, usado para add um elemento em qualquer posicao
	public boolean adiciona(int posicao, String elemento) {
		// verificar se a posicao é valida
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		this.aumentaCapacidade();
		
		// logica para mover os elementos
		for (int i = this.tamanho - 1; i >=  posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		// atribuir o elemento para posicao
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return true;
	}
	
	// metodo para aumentar a capacidade do vetor
	private void aumentaCapacidade() {
		// verificar quando que sera necessario aumentar a capacidade do vetor
		if (this.tamanho == this.elementos.length) {
			String[] elementosNovos = new String[this.elementos.length * 2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	// metodo de busca
	public String busca(int posicao) {
		// verifica se a posição é invalida ou null
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		return this.elementos[posicao];
	}
	
	public int busca(String elemento) {
		// verificar se o elemento existe ou não, fazer uma busca sequencial
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	// B G D E F -> posicao a ser removida é 1 (G)
	// 0 1 2 3 4 -> tamanho é 5
	// vetor[1] = vetor[2]
	// vetor[2] = vetor[3]
	// vetor[3] = vetor[4]
	// metodo para remover um elemento
	public void remove(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.tamanho--;
	}
	
	// retorna o tamanho do vetor
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}
		
		s.append("]");
		
		return s.toString();
	}

}
