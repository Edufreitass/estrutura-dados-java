package com.loiane.estruturadados.vetor;

import java.util.Arrays;

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

		// verifica se o tamanho é menor que a capacidade do vetor de elementos
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	// metodo de busca
	public String busca(int posicao) {
		// verifica se a posição é invalida ou null
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
		return this.elementos[posicao];
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
