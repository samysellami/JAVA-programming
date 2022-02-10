#include <stdio.h>

// void swap(int *a, int *b);
void swap2(int *a, int *b);
void swap3(int *a, int *b);
void swap4(int *a, int *b);
void swap5(int *a, int *b);

int main ()
{
    int a, b;
    printf("Enter the first integer: a = ");
    scanf("%d", &a);

    printf("Enter the second integer: b = ");
    scanf("%d", &b);

    swap(&a, &b);
    printf("After swapping: a = %d, b = %d \n", a, b);
    return 0;
}

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

// another solution - wrong
void swap2(int *a, int *b){
    int *temp = a;
    *a = *b;
    *b = *temp;
}

// another solution - wrong 
void swap3(int *a, int *b){
    int *temp = a;
    a = b;
    b = temp;
    printf("After swapping: a = %d, b = %d \n", *a, *b);
}

void swap4(int *a, int *b){
    *a =  *a + *b;
    *b =  *a - *b;
    *a =  *a - *b;
}


void swap5(int *a, int *b){
    *a =  *a ^ *b;
    *b =  *a ^ *b;
    *a =  *a ^ *b;
}
