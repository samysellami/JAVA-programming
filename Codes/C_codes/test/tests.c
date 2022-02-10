#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

#define BASE_YEAR 1900

struct date
{
    unsigned short day : 5;
    unsigned short month : 4;
    unsigned short year : 7;
};

// exercice 1 
void func() {
	static int x = 5;
	int y = 5;
	while (y < 10 && x < 10) {
		printf("x = %d, y = %d\n", x, y);
		x++;
		y++;
		func();
    }
}

// exercice 4
int birthday() {
    struct date birthday;
    birthday.day = 16;
    birthday.month = 12;
    birthday.year = 2000 - BASE_YEAR;          // birthday.year = 100
    printf("\n My birthday is %u.%u.%u \n", birthday.day, birthday.month, birthday.year + BASE_YEAR);
    printf("\n Size of birthday structure is %lu bytes", sizeof(birthday));
    getchar();
    return 0;
}



// Midterm solutions check

void question1(){
    int A[5] = { 7, 6, 5, 4, 3 };
    int i = *(A+2);
    printf("i = %d\n", i);
}



void question2(){
    int a=9, b=8, c=7;
    int* A[3] = { &a, &b, &c };
    int res = **(A+2);
    printf("res = %d\n", res);
}


int question3(int p){
    int* ptr = (int*)malloc(sizeof(int));
    *ptr = p;
    return p*2;
}


int question4(int p){
    int* ptr = (int*)malloc(sizeof(int));
    *ptr = p;
    return p*2;
}

int* question5(int p)
{
    int* ptr = (int*)malloc(2*sizeof(int));
    *ptr = p;
    *(ptr+1) = p*p;
    return ptr;
}


void question6(){
    int A[5] = { 1, 2, 3, 4, 5 };
    int* ptr1 = A;
    int* ptr2 = &A[4];
    int x = *ptr1 + *ptr2;
    printf("x= %d\n", x);
}


int square(int p) { return p*p; }
int sum(int* p, int len, int (*f)(int)){
    int res= 0;
    for (int i=0; i<len; i++)
    res += f(p[i]);
    return res;
}

void question8(){
    struct { int a, b; }* g(int (*)());
}

int question9(){
    int A[5] = { 1, 2, 3, 4, 5 };
    int squares = sum(A,5,square);
    printf("squares= %d\n", squares);

}

void question10(){
    struct S{
        int a, b;
    };
    struct S s = { .a = 7, .b = 77 };
    struct S* ptr1 = &s;
    int* ptr2 = &s.a;
    int res = ptr1->b + *ptr2;
    printf("res= %d\n", res);
}

void question11(){
    struct S {
    int a, b;
    } s = { .a = 7, .b = 77 };
    int res = s.a + (&s)->b;
    printf("res= %d\n", res);
}

long square1(long i) { return i*i; }
void question13(){
    typedef long (*F)(long);
    F f1 = &square1;
    F f2 = square1;
    // F f3 = square1(3);
}

long identity(long i) { return i; }
long square2(long i) { return i*i; }
long cube(long i) { return i*i*i; }
void question14(){
typedef long (*F)(long);
    F A[3] = { identity, square2, cube };
    long res= 0;
    for (int i=0; i<3; i++)
        res += A[i](i+1);
    printf("res= %d\n", res);
}

void question18(){
    double A[5];
    for ( int i=0; i<5; i++)
        *(A+i) = i;
    for ( int i=1; i<=5; i++ )
        A[i-1] = (i>1 ? A[i-2] : 1) * A[i];
    for ( int i=0; i<=5; i++)
        printf("A[%d]= %d\n",i, A[i]);
 
}

void question19(){
    int x, y = 7;
    #define M(a) if (a) x = a; else x = 1
    M(y>10);
    printf("x= %d\n", x);
}

int main() {  
    
    // int p;
    // int *ptr;

    // question1(); //ok
    
    // question2(); //ok
    
    // question3(p); // I think memory leak is more like a problem and not a bug (error)

    // question4(p); // same as question 3 (no bug)

    // ptr = question5(p); // missing semicolon => bug
    // free(ptr);

    // question6(); //ok

    // question7(): 
    // double* (*f)(int,int);
    // - A pointer to a function with two parameters returning a pointer to double

    // question8(): //ok
    // question9(); //ok
    // question10(); //ok
    // question11(); //ok
    // question12(): //ok
    // question13(); //ok
    // question14(); //ok
    // question15(); //ok
    // question16(); //ok
    // question17(); //ok

    // question18(); // no bugs when running, but accessing A[6] in in array of length 5 (line5)
    
    // question19(); //ok
    // question20(); //ok
    // question21(); //ok
    // question22(); //ok
    // question23(); //ok
    // question24(); //ok
    // question25(); //ok
    // question26(); //ok
    // question27(); //ok
    // question28(); //ok
    // question29(); //ok
    // question30(); //ok
    // question31(); //ok
    // question32(); //not clear what is the response (should be response 4)
    // question33(); //ok
    // question34(); //ok
    // question35(); //ok
    // question36(); //ok
    // question37(); //ok
    // question38(); // should be true but give segmentation fault
    // question39(); //ok
    // question40(); //does (not a proper function) means (incorrect) ??
}



