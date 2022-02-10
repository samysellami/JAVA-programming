#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// A utility function to swap two elements 
void swap(int* a, int* b) 
{ 
    int t = *a; 
    *a = *b; 
    *b = t; 
} 
  
/* This function takes last element as pivot, places the pivot element at its correct position in sorted 
array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot */
int partition (int arr[], int low, int high) 
{ 
    int pivot = arr[high]; // pivot 
    int i = (low - 1); // Index of smaller element and indicates the right position of pivot found so far
  
    for (int j = low; j <= high - 1; j++) 
    { 
        // If current element is smaller than the pivot 
        if (arr[j] < pivot) 
        { 
            i++; // increment index of smaller element 
            swap(&arr[i], &arr[j]); 
        } 
    } 
    swap(&arr[i + 1], &arr[high]); 
    return (i + 1); 
} 
  
/* The main function that implements QuickSort arr[] --> Array to be sorted, 
low --> Starting index, 
high --> Ending index */
void quickSort(int arr[], int low, int high) 
{ 
    if (low < high) 
    { 
        /* pi is partitioning index, arr[p] is now 
        at right place */
        int pi = partition(arr, low, high); 
  
        // Separately sort elements before 
        // partition and after partition 
        quickSort(arr, low, pi - 1); 
        quickSort(arr, pi + 1, high); 
    } 
} 

/* function to print an array */
void printArray(int arr[], int size) 
{ 
    int i; 
    for (i = 0; i < size; i++) 
        printf("%x\n", arr[i]);
} 
      


int main() {

    int hexa[50]; // array of hexadecimal numbers 
    int n; // size of the array
    int *p_hexa = hexa; // pointer that points to the first element of the array
    
    FILE *input = fopen("input.txt","r");
    FILE *output = fopen("output.txt","w"); 
   
    if((input == NULL) || (output == NULL)){
        printf("Cannot open the files!");   
        return 0;
    }

    // read the hexadecimel numbers
    while(!feof(input)) {
        fscanf(input, "%x", p_hexa); 
        p_hexa++;
    }
    n = p_hexa - hexa; // number of hexadecimel numbers

    // sort the array using quick sort algorithm
    quickSort(hexa, 0, n - 1);
    // printArray(hexa, n); 

    // writing to the output file
    for(int i = 0; i < n; i++)
        fprintf(output, "%X ", hexa[i]);

    fclose(input);
    fclose(output);

    return 0;
}


