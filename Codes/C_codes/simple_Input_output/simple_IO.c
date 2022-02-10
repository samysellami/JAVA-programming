#include <stdio.h>
int main() {
   // printf() displays the string inside quotation


   FILE *input = fopen("input.txt","r");
   FILE *output = fopen("output.txt","w"); 
   
   if((input == NULL) || (output == NULL)){
      printf("Cannot open the files!");   
      return 0;
   }

   do {
      // Taking input single character at a time
      char c = fgetc(input);
      printf("%c", c);


      // Checking for end of file
      if ((feof(input)) || c == '\0')
         break ;

      // Input string into the file
      // single character at a time         
      fputc(c, output);
 
   }  while(1);


   fclose(input);
   fclose(output);

   return 0;
}


