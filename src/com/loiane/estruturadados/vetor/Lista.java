package com.loiane.estruturadados.vetor;

import java.lang.reflect.Array;

public class Lista<T> {

	private T[] elementos;
	private int tamanho;

	// 1° solução(é a melhor solução)
	public Lista(int capacidade) {
		this.elementos = (T[]) new Object[capacidade]; // solução do livro "Java Efetivo"
		this.tamanho = 0;
	}

	// 2° solução
	public Lista(int capacidade, Class<T> tipoClasse) {
		// Java Reflection, é uma API que permite você acessar dinamicamente as classes,
		// atributos, permitindo a manipulação desses elementos
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.tamanho = 0;
	}

	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public boolean adiciona(int posicao, T elemento) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		this.aumentaCapacidade();

		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;

		return true;
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

	public T busca(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		return this.elementos[posicao];
	}

	public int busca(T elemento) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	// exercicio 02
	public int ultimoIndice(T elemento) {
		
		for (int i = this.tamanho - 1; i >=0; i--) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		
		return - 1;
	}
	
	// exercicio 01
	public boolean contem(T elemento) {
		
		/*int pos = busca(elemento);
		if (pos > -1) {
			return true;
		}
		return false; */
		
		return busca(elemento) > - 1; // >= 0
	}

	public void remove(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.tamanho--;
	}

	// exercicio 03
	public void remove(T elemento) {
		 int pos = this.busca(elemento);
		 if (pos > -1) {
			 this.remove(pos);
		 }
	}
	
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
