package com.loiane.estruturadados.pilha.teste;

import java.util.Stack;

// import com.loiane.estruturadados.pilha.Pilha;

public class Aula18 {

	public static void main(String[] args) {

		// Pilha<Integer> pilha = new Pilha<>();

		// Pilha
		Stack<Integer> stack = new Stack<>();

		System.out.println(stack.isEmpty());

		// empilhar
		stack.push(1);
		stack.push(2);
		stack.push(3);

		// verifica se esta vazio
		System.out.println(stack.isEmpty());
		// tamanho da pilha
		System.out.println(stack.size());
		System.out.println(stack);

		// espiar
		System.out.println(stack.peek());

		// desempilha
		System.out.println(stack.pop());

		System.out.println(stack);

	}

}
