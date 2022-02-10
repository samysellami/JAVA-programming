#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int mod(int a, int b) {
    // function to keep the value of a in the range [0,b]
    int c = a % b;
    return (c < 0) ? c + b : c;
}

int linear_search(char array[], char element) {
    // function to search for 'element' in 'array' in a linear way
    for (int i = 0; i< strlen(array); ++i) {
        if (element == array[i] ){
            return i;
        }
    }
    return -1;
}

int main() {

    char alphabet[] = "abcdefghijklmnopqrstuvwxyz"; 
    char word[255]; 
    int shift;
    char c_output;
    char c_input; 
    bool capital;
    int j;
   
    FILE *input = fopen("input.txt","r");
    FILE *output = fopen("output.txt","w"); 

    if((input == NULL) || (output == NULL)){
        printf("Cannot open the files!");   
        return 0;
    }

    // read the value of the shift
    do {
        fgets(word, 255, input);
        if ((feof(input)))
            break ;
    } while (1);
    shift = atoi(word); // converting the read character into integer

    // put the file pointer at the start of the file
    fseek(input, 0, SEEK_SET);

    do {
        // Read the input file line by line
        fgets(word, 255, input);
        // printf("%s", word);

        // check the end of the file
        if ((feof(input)))
            break ;

        //loop through the word's letter and find the corresponding alphabet's index 
        for (int i = 0; i < strlen(word); ++i){
            c_input = word[i];

            if((c_input >= 'A') && (c_input <= 'Z')) {
                c_input = c_input + 32; //if the character is upper case, convert it to lower case
                capital = true;
            }
            
            j = linear_search(alphabet, c_input);
            if (j == -1) {
                c_output = c_input; // the character is not in the alphabet, keep it as it is
            } else {
                c_output = alphabet[ mod( (j + shift), 26 ) ]; 
                if (capital) {
                    c_output = c_output - 32; //convert the character back to upper case
                    capital = false;
                } 
            }
            fputc( c_output, output ); // write in the output file
        }
    } while (1);

    fclose(input);
    fclose(output);

    return 0;
}