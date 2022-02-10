#include <stdio.h>
#include "stdlib.h"
#include "string.h"
 
 
int main() {
    char *buffer = malloc(sizeof(char)*300);
    int max_width;
    FILE *input = fopen("input.txt","r");
    FILE *output = fopen("output.txt","w");
 
    input = fopen("input.txt", "r");
 
    if (input == NULL)
    {
        printf("Cannot open input file");
        exit(1);
    }
    


    fgets(buffer, 300, input);
    fscanf(input, "%i", &max_width);
    
    fclose(input);
 
    buffer[strcspn(buffer, "\n")] = 0;
    printf("%s\n", buffer);
    char delim[1] = " ";
    char *tokenized;
    char words[100][20];
    int words_counter = 0;
    
    while ((tokenized = strsep(&buffer, delim)))
    {
        strcpy(words[words_counter], tokenized);
        printf("%s\n", tokenized);
        ++words_counter;
    } 

    // while (tokenized != NULL)
    // {
    //     strcpy(words[words_counter], tokenized);
    //     printf("%s\n", tokenized);
    //     ++words_counter;
    //     tokenized = strsep(NULL, delim);
    // }
    
    int current_line_length = 0;
    char current_line_words[40][max_width];
    int current_line_words_num = 0;
    char result_string[300] = "";
    
    printf("buffer is '%s\n", buffer);
    printf("words counter is '%i'\n", words_counter);

    for (int curr_word = 0; curr_word < words_counter; ++curr_word)
    {
        if ((strlen(words[curr_word]) + current_line_length) < max_width && (words_counter - curr_word) != 1)
        {
            current_line_length += strlen(words[curr_word]);
            ++current_line_words_num;
            if (current_line_words_num > 1) ++current_line_length;
            strcpy(current_line_words[current_line_words_num-1], words[curr_word]);
        }
        else if((strlen(words[curr_word]) + current_line_length) >= max_width || (words_counter - curr_word) == 1)
        {
            if ((strlen(words[curr_word]) + current_line_length) >= max_width)
            {
                if (current_line_words_num > 1)
                {
                    int num_of_available_spaces = max_width - current_line_length + (current_line_words_num-1);
                    int curr_word_num = 0;
 
                    while(num_of_available_spaces != 0)
                    {
                        char sp = ' ';
                        strncat(current_line_words[curr_word_num], &sp, 1);
                        ++curr_word_num;
                        --num_of_available_spaces;
                        if (num_of_available_spaces == 0) break;
                        if (curr_word_num >= current_line_words_num - 1) curr_word_num = 0;
                    }
                    for (int i = 0; i < current_line_words_num; ++i)
                    {
                        strncat(result_string, current_line_words[i], strlen(current_line_words[i]));
                        // fputs(current_line_words[i], output);
                    }
                    strncat(result_string, "\n", 2);
                    // fputc('\n', output);
                }else{
                    strncat(result_string, current_line_words[0], strlen(current_line_words[0]));
                    strncat(result_string, "\n", 2);
                    // fputs(current_line_words[0], output);
                    // fputc('\n', output);
                }
            }
 
            if ((strlen(words[curr_word]) + current_line_length) >= max_width)
            {
                /* REFRESHING */
                strcpy(current_line_words[0], words[curr_word]);
                current_line_length = strlen(words[curr_word]);
                current_line_words_num = 1;
            }else{
                ++current_line_words_num;
                strcpy(current_line_words[current_line_words_num-1], words[curr_word]);
            }
 
            if (words_counter - curr_word == 1)
            {
 
                int num_of_available_spaces = current_line_words_num-1;
                int fill_other_spaces = max_width - current_line_length;
                int curr_word_num = 0;
 
                for(int i = 0; i < num_of_available_spaces; ++i)
                {
                    char sp = ' ';
                    strncat(current_line_words[curr_word_num], &sp, 1);
                    ++curr_word_num;
                    if (num_of_available_spaces == 0) break;
                    if (curr_word_num >= current_line_words_num - 1) curr_word_num = 0;
                }
                for (int i = 0; i < current_line_words_num; ++i)
                {
                    strncat(result_string, current_line_words[i], strlen(current_line_words[i]));
                    //fputs(current_line_words[i], output);
                }
            }
        }
    }
 
    //for (int i = 0; i < strlen(result_string); ++i) fputc(result_string[i], output);
    fputs(result_string, output);
    fclose(output);
    printf("%s", result_string);
 
    return 0;
}