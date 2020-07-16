package com.loiane.estruturadados.vetor.teste;

import java.util.ArrayList;

public class Aula12 {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<>();

		// adiciona sem posiçao
		arrayList.add("A");
		arrayList.add("C");

		System.out.println(arrayList);

		// adiciona com posição
		arrayList.add(1, "B");

		System.out.println(arrayList);

		// verifica se o elemento existe no array
		boolean existe = arrayList.contains("A");
		if (existe) {
			System.out.println("Elemento existe no array");
		} else {
			System.out.println("Elemento não existe no array");
		}

		// verifica se o elemento existe no array, podendo retornar a posiçao do mesmo
		int pos = arrayList.indexOf("B");
		if (pos > -1) {
			System.out.println("Elemento existe no array " + pos);
		} else {
			System.out.println("Elemento não existe no array " + pos);
		}

		// busca por posição
		System.out.println(arrayList.get(2));

		// remove o elemento
		arrayList.remove(0);
		arrayList.remove("B");

		System.out.println(arrayList);

		// verifica o tamanho do array
		System.out.println(arrayList.size());

	}

}
