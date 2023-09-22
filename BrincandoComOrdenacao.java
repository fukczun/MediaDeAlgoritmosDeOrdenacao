package atividade2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BrincandoComOrdenacao {
	public static int[] gerarVetor (int tamanho, boolean isCrescente) {
		int[] vetor = new int[tamanho];
		
		if (isCrescente) {
			for (int i=1; i<=tamanho; i++) {
				vetor[i-1] = i;
			}
		} else {
			for (int i=tamanho; i>=1; i--) {
				vetor[tamanho-i] = i;
			}
		}
		
		return vetor;
	}
	
	public static int[] gerarVetorAleatorio(int tamanho, int faixa) {
		Random random = new Random();
        
		int[] vetor = new int[tamanho];
		
		for (int i=0; i<tamanho; i++) {
			int randomElemento = random.nextInt(faixa+1);
			vetor[i] = randomElemento;
		}
		
		return vetor;
	}
	
	
	public static void main(String[] args) {
		Ordenacao_IF o = new Ordenacao();
		// Variáveis de controle
		int c1 = 1, c2=0; 
		int[] tamanhoVetores = {5000, 10000, 15000};
		
		// Gerando vetores
		int[][] vetoresC = {gerarVetor(tamanhoVetores[0], true), gerarVetor(tamanhoVetores[1], true), gerarVetor(tamanhoVetores[2], true)};
		int[][] vetoresD = {gerarVetor(tamanhoVetores[0], false), gerarVetor(tamanhoVetores[1], false), gerarVetor(tamanhoVetores[2], false)};
		int[][] vetoresAleatorio = {gerarVetorAleatorio(tamanhoVetores[0], tamanhoVetores[0]), gerarVetorAleatorio(tamanhoVetores[1], tamanhoVetores[1]), gerarVetorAleatorio(tamanhoVetores[2], tamanhoVetores[2])};
		
		// Controle de média de tempo de execução
		double[] bubbleSortC = {0,0,0}, bubbleSortD = {0,0,0}, bubbleSortAleatorio = {0,0,0};
		double[] selectionSortC = {0,0,0}, selectionSortD = {0,0,0}, selectionSortAleatorio = {0,0,0};
		double[] insertionSortC = {0,0,0}, insertionSortD = {0,0,0}, insertionSortAleatorio = {0,0,0};
		double[] mergeSortC = {0,0,0}, mergeSortD = {0,0,0}, mergeSortAleatorio = {0,0,0};
		double[] quickSortC = {0,0,0}, quickSortD = {0,0,0}, quickSortAleatorio = {0,0,0};
		double[] randomQuickSortC = {0,0,0}, randomQuickSortD = {0,0,0}, randomQuickSortAleatorio = {0,0,0};
		double[] quickSortJavaC = {0,0,0}, quickSortJavaD = {0,0,0}, quickSortJavaAleatorio = {0,0,0};
		double[] countingSortC = {0,0,0}, countingSortD = {0,0,0}, countingSortAleatorio = {0,0,0};
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<50; j++) {
				bubbleSortC[i] += (double) o.bubbleSort(vetoresC[i].clone())/1000000000;
				bubbleSortD[i] += (double) o.bubbleSort(vetoresD[i].clone())/1000000000;
				bubbleSortAleatorio[i] += (double) o.bubbleSort(vetoresAleatorio[i].clone())/1000000000;
				
				selectionSortC[i] += (double) o.selectionSort(vetoresC[i].clone())/1000000000;
				selectionSortD[i] += (double) o.selectionSort(vetoresD[i].clone())/1000000000;
				selectionSortAleatorio[i] += (double) o.selectionSort(vetoresAleatorio[i].clone())/1000000000;
				
				insertionSortC[i] += (double) o.insertionSort(vetoresC[i].clone())/1000000000;
				insertionSortD[i] += (double) o.insertionSort(vetoresD[i].clone())/1000000000;
				insertionSortAleatorio[i] += (double) o.insertionSort(vetoresAleatorio[i].clone())/1000000000;
				
				mergeSortC[i] += (double) o.mergeSort(vetoresC[i].clone())/1000000000;
				mergeSortD[i] += (double) o.mergeSort(vetoresD[i].clone())/1000000000;
				mergeSortAleatorio[i] += (double) o.mergeSort(vetoresAleatorio[i].clone())/1000000000;
				
				quickSortC[i] += (double) o.quickSort(vetoresC[i].clone())/1000000000;
				quickSortD[i] += (double) o.quickSort(vetoresD[i].clone())/1000000000;
				quickSortAleatorio[i] += (double) o.quickSort(vetoresAleatorio[i].clone())/1000000000;
				
				randomQuickSortC[i] += (double) o.random_quickSort(vetoresC[i].clone())/1000000000;
				randomQuickSortD[i] += (double) o.random_quickSort(vetoresD[i].clone())/1000000000;
				randomQuickSortAleatorio[i] += (double) o.random_quickSort(vetoresAleatorio[i].clone())/1000000000;
				
				quickSortJavaC[i] += (double) o.quickSort_Java(vetoresC[i].clone())/1000000000;
				quickSortJavaD[i] += (double) o.quickSort_Java(vetoresD[i].clone())/1000000000;
				quickSortJavaAleatorio[i] += (double) o.quickSort_Java(vetoresAleatorio[i].clone())/1000000000;
				
				countingSortC[i] += (double) o.countingSort(vetoresC[i].clone())/1000000000;
				countingSortD[i] += (double) o.countingSort(vetoresD[i].clone())/1000000000;
				countingSortAleatorio[i] += (double) o.countingSort(vetoresAleatorio[i].clone())/1000000000;
				System.out.println(c1++ + " execução(ões) completa(s)");
			}
			System.out.println("\nCópia dos vetores de " + tamanhoVetores[c2++] + " elementos foram "
					+ "ordenados pelos algoritmos selecionados, 50 vezes\n");
			c1 = 1;
		}
		
		
		System.out.println("//MÉDIAS:");
		for (int i=0; i<3; i++) {
			System.out.println("Para vetores de tamanho " + tamanhoVetores[i] + " (em segundos): \n");
			
			System.out.println("Bubble Sort:");
			System.out.println("* Crescente: " + bubbleSortC[i]);
			System.out.println("* Decrescente: " + bubbleSortD[i]);
			System.out.println("* Aleatório: " + bubbleSortAleatorio[i] + "\n");
			
			System.out.println("Selection Sort: \n");
			System.out.println("* Crescente: " + selectionSortC[i]);
			System.out.println("* Decrescente: " + selectionSortD[i]);
			System.out.println("* Aleatório: " + selectionSortAleatorio[i] + "\n");
			
			System.out.println("Insertion Sort: \n");
			System.out.println("* Crescente: " + insertionSortC[i]);
			System.out.println("* Decrescente: " + insertionSortD[i]);
			System.out.println("* Aleatório: " + insertionSortAleatorio[i] + "\n");
			
			System.out.println("Merge Sort: \n");
			System.out.println("* Crescente: " + mergeSortC[i]);
			System.out.println("* Decrescente: " + mergeSortD[i]);
			System.out.println("* Aleatório: " + mergeSortAleatorio[i] + "\n");
			
			System.out.println("Quick Sort: \n");
			System.out.println("* Crescente: " + quickSortC[i]);
			System.out.println("* Decrescente: " + quickSortD[i]);
			System.out.println("* Aleatório: " + quickSortAleatorio[i] + "\n");
			
			System.out.println("Random Quick Sort: \n");
			System.out.println("* Crescente: " + randomQuickSortC[i]);
			System.out.println("* Decrescente: " + randomQuickSortD[i]);
			System.out.println("* Aleatório: " + randomQuickSortAleatorio[i] + "\n");
			
			System.out.println("Quick Sort Java: \n");
			System.out.println("* Crescente: " + quickSortJavaC[i]);
			System.out.println("* Decrescente: " + quickSortJavaD[i]);
			System.out.println("* Aleatório: " + quickSortJavaAleatorio[i] + "\n");
			
			System.out.println("Counting Sort: \n");
			System.out.println("* Crescente: " + countingSortC[i]);
			System.out.println("* Decrescente: " + countingSortD[i]);
			System.out.println("* Aleatório: " + countingSortAleatorio[i] + "\n");
		}
	}
}
