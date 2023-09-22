package atividade2;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF {

	@Override
	public boolean checaVetorOrdenado(int[] numeros) {
		for (int i=0; i<numeros.length; i++) {
			if (Math.abs(numeros[i+1] - numeros[i]) != 1) return false;
		}
		return true;
	}

	@Override
	public long bubbleSort(int[] numeros) {
		long startTime = System.nanoTime();

        int n = numeros.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
	}

	@Override
	public long selectionSort(int[] numeros) {
		long startTime = System.nanoTime();

        int n = numeros.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[indiceMinimo]) indiceMinimo = j;
            }
            
            int temp = numeros[i];
            numeros[i] = numeros[indiceMinimo];
            numeros[indiceMinimo] = temp;
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
	}

	@Override
	public long insertionSort(int[] numeros) {
		long startTime = System.nanoTime();

        int n = numeros.length;

        for (int i = 1; i < n; i++) {
            int chave = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > chave) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            
            numeros[j + 1] = chave;
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
	}

	@Override
	public long mergeSort(int[] numeros) {
		long startTime = System.nanoTime();

		int n = numeros.length;
		
		if (n != 1) {
			int meio = n / 2;
		    int[] left = new int[meio];
		    int[] right = new int[n - meio];
		    
		    for (int i = 0; i < meio; i++) {
		        left[i] = numeros[i];
		    }
		    for (int i = meio; i < n; i++) {
		        right[i - meio] = numeros[i];
		    }
		    mergeSort(left);
		    mergeSort(right);
		    
		    merge(numeros, left, right);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
	}
	
	public void merge(int[] numeros, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

	    while (i < left.length && j < right.length) {
	        if (left[i] <= right[j]) {
	            numeros[k++] = left[i++];
	        } else {
	            numeros[k++] = right[j++];
	        }
	    }

	    while (i < left.length) {
	        numeros[k++] = left[i++];
	    }

	    while (j < right.length) {
	        numeros[k++] = right[j++];
	    }
	}

	@Override
	public long quickSort(int[] numeros) {
        long startTime = System.nanoTime();

        quickSortRecursive(numeros, 0, numeros.length - 1);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void quickSortRecursive(int[] numeros, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = partition(numeros, inicio, fim);
            quickSortRecursive(numeros, inicio, indicePivo - 1);
            quickSortRecursive(numeros, indicePivo + 1, fim);
        }
    }

    private static int partition(int[] numeros, int inicio, int fim) {
        int pivo = numeros[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (numeros[j] <= pivo) {
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }

        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[fim];
        numeros[fim] = temp;

        return i + 1;
    }

	@Override
	public long random_quickSort(int[] numeros) {
		long startTime = System.nanoTime();

        randomizedQuickSortRecursive(numeros, 0, numeros.length - 1);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void randomizedQuickSortRecursive(int[] numeros, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = randomizedPartition(numeros, inicio, fim);
            randomizedQuickSortRecursive(numeros, inicio, indicePivo - 1);
            randomizedQuickSortRecursive(numeros, indicePivo + 1, fim);
        }
    }

    private static int randomizedPartition(int[] numeros, int inicio, int fim) {
        Random random = new Random();
        int randomIndex = random.nextInt(fim - inicio + 1) + inicio;
        
        int temp = numeros[fim];
        numeros[fim] = numeros[randomIndex];
        numeros[randomIndex] = temp;

        return partition(numeros, inicio, fim);
    }

	@Override
	public long quickSort_Java(int[] numeros) {
		long startTime = System.nanoTime();

		Arrays.sort(numeros);
		
        long endTime = System.nanoTime();
        return endTime - startTime;
	}

	@Override
	public long countingSort(int[] numeros) {
		long startTime = System.nanoTime();

        int n = numeros.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : numeros) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int[] contagem = new int[max - min + 1];

        for (int num : numeros) {
            contagem[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < contagem.length; i++) {
            while (contagem[i] > 0) {
                numeros[index] = i + min;
                index++;
                contagem[i]--;
            }
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
	}
	
}
