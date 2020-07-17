package com.loiane.estruturadados.fila.teste;

import com.loiane.estruturadados.fila.FilaComPrioridade;

public class Aula24 {

	public static void main(String[] args) {

		FilaComPrioridade<Integer> fila = new FilaComPrioridade<>();

		fila.enfileira(1);
		fila.enfileira(6);
		fila.enfileira(2);
		fila.enfileira(3);
		fila.enfileira(5);
		fila.enfileira(4);

		System.out.println(fila);

		System.out.println(fila.desenfileira());

		System.out.println(fila);

		FilaComPrioridade<Paciente> filaDePaciente = new FilaComPrioridade<>();

		filaDePaciente.enfileira(new Paciente("A", 2));
		filaDePaciente.enfileira(new Paciente("C", 1));
		filaDePaciente.enfileira(new Paciente("B", 3));

		System.out.println(filaDePaciente); // 1 2 3 e nao 1 3 2

		System.out.println(filaDePaciente.desenfileira());

		System.out.println(filaDePaciente);

	}

}
