    #include "stdio.h"
    #include <stdlib.h>
    #include <string.h>


    void invalidInputError(FILE * output, char * name);

    int checkValidDate(char * date, FILE * output, char * file_name);

    int checkValidTime(char * time, FILE * output, char * file_name);

    int checkValidName(char * name, FILE * output, char * file_name);

    int main()
    {
        FILE * input, * output;

        input = fopen("input.txt", "r");
        output = fopen("output.txt", "w");
        char file_name[] = "output.txt";

        int more_cases = 0;

        do
        {
            int number_of_items = 0;
            char name[100];
            char * raw_date = malloc(sizeof(char)*100);
            char * raw_date_second = malloc(sizeof(char)*100);
            char * items[15];
            

            if (input == NULL)
            {
                printf("Cannot open input file");
                exit(1);
            }

            
            fgets(name, 100, input);
            fgets(raw_date, 100, input);
            strcpy(raw_date_second, raw_date);

            /*======================================================================*/
            
            char current_line_string[600] = "";

            do
            {   char * item = malloc(sizeof(char)*100);

                fgets(item, 100, input);
                items[number_of_items++] = item;

                if (item[0] == '\n')
                {
                    --number_of_items;
                    ++more_cases;
                    break;
                } 
                
                printf("items = '%s'\n", items[number_of_items-1]);
            } while (!feof(input));

            char * date = malloc(sizeof(char)*20);
            char * time = malloc(sizeof(char)*20);
            char * tokenized;
            
            int * date_counter = malloc(sizeof(int));
            
            for (int i = 0; (i < 2) && ((tokenized = strsep(&raw_date, " ")) != NULL); ++i)
            {
                if (i == 0)
                    strcpy(date, tokenized);
                else
                    strcpy(time, tokenized);
            }

            printf("date = '%s'\n", date);
            printf("time = '%s'\n", time);

            if (checkValidDate(date, output, file_name) == 1 || checkValidTime(time, output, file_name) == 1 || checkValidName(name, output, file_name) == 1)
            {
                return 0;
            }

            int items_measurement_units[number_of_items]; // pair = 0 pcs = 1
            int items_sizes[number_of_items];
            int items_number[number_of_items];
            char items_names[number_of_items][20];

            for (int i = 0; i < number_of_items; ++i)
            {
                for (int j = 0; j < 4 && ((tokenized = strsep(&items[i], " ")) != NULL); ++j)
                {
                    printf("Tokenized = '%s'\n", tokenized);
                    if (j == 0)
                    {
                        strcpy(items_names[i], tokenized);
                    }
                    if (j == 1)
                    {
                        items_sizes[i] = atoi(tokenized);
                    }
                    if (j == 2)
                    {
                        items_number[i] = atoi(tokenized);
                    }
                    if (j == 3)
                    {
                        if (tokenized[1] == 'a')
                            items_measurement_units[i] = 0;
                        else
                            items_measurement_units[i] = 1;
                    }
                }
            }    

            for (int i = 0; i < number_of_items; ++i)
            {
                if (checkValidName(items_names[i], output, file_name) == 1)
                {
                    return 0;
                }
            }

            strncat(current_line_string, name, strlen(name));
            strcat(current_line_string, "has rented ");
            
            //itoa(num, snum, 10)

            for (int i = 0; i < number_of_items; ++i)
            {
                char temp_str[100];
                snprintf(temp_str, 100, "%i ", items_number[i]);
                
                if (items_measurement_units[i] == 0)
                {
                    if (items_number[i] > 1) strcat(temp_str, "pairs of ");
                    else strcat(temp_str, "pair of ");
                }
                else
                {
                    strcat(temp_str, "pcs of ");
                }
                
                strcat(temp_str, items_names[i]);
                strcat(current_line_string, temp_str);

                snprintf(temp_str, 100, " of size %i", items_sizes[i]);
                strcat(current_line_string, temp_str);

                if ((number_of_items - i - 1) == 1)
                {
                    strcat(current_line_string, " and ");
                }
                else if ((number_of_items - i - 1) == 0)
                {
                    strcat(current_line_string, " ");
                }
                else strcat(current_line_string, ", ");
            }  

            char * true_date = malloc(sizeof(char)*20);
            char * true_time = malloc(sizeof(char)*20);
            printf("%s\n", raw_date_second);

            for (int i = 0; (i < 2) && ((tokenized = strsep(&raw_date_second, " ")) != NULL); ++i)
            {
                if (i == 0)
                    strcpy(true_date, tokenized);
                else
                    strcpy(true_time, tokenized);
            }
            true_time[strcspn(true_time, "\n")] = 0;
            strcat(current_line_string, "on ");
            strcat(current_line_string, true_date);
            strcat(current_line_string, " at ");
            strcat(current_line_string, true_time);
            strcat(current_line_string, ".");

            current_line_string[strcspn(current_line_string, "\n")] = ' ';

            printf("Result string = '%s'\n", current_line_string);

            fputs(current_line_string, output);

            /*FREE VARIABLES AFTER WRITING IN RESULT STRING*/
            free(date);
            free(time);
            free(true_time);
            free(true_date);
            free(date_counter);
            free(raw_date);
            free(raw_date_second);

            for (int i = 0; i < number_of_items; ++i) free(items[i]);

            char check[2];

            if (!feof(input))
            {
                fgets(check, 1, input);
                fputs("\n", output);
                more_cases = 1;
            }
            else
            {
                more_cases = 0;
            }
            /*======================================================================*/
            
            //printf("%s has rented %i pcs of %s of size %i, %i pair of %s of size %i and %i pcs of %s of size %i on %s at %s");
        }while(more_cases != 0);

        fclose(input);    
        fclose(output);
        printf("%s\n", "End.");

        return 0;
    }

    void invalidInputError(FILE * output, char * file_name)
    {
        fclose(output);
        output = fopen(file_name, "w");
        fputs("Invalid input!\n", output);
    }

    int checkValidDate(char * date, FILE * output, char * file_name)
    {
        char * tokenized;
        for (int i = 0; (i < 3) && ((tokenized = strsep(&date, "/")) != NULL); ++i)
        {   
            if (i == 0)
            {
                if (atoi(tokenized) > 31 || atoi(tokenized) < 1)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            else if (i == 1)
            {
                if (atoi(tokenized) > 12 || atoi(tokenized) < 1)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            else
            {
                if (atoi(tokenized) < 0)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            printf("%i\n", atoi(tokenized));
        }
        return 0;
    }

    int checkValidTime(char * time, FILE * output, char * file_name)
    {
        char * tokenized;
        for (int i = 0; (i < 3) && ((tokenized = strsep(&time, ":")) != NULL); ++i)
        {   
            if (i == 0)
            {
                if (atoi(tokenized) > 23 || atoi(tokenized) < 0)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            else if (i == 1)
            {
                if (atoi(tokenized) > 59 || atoi(tokenized) < 0)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            else
            {
                if (atoi(tokenized) > 59 || atoi(tokenized) < 0)
                {
                    invalidInputError(output, file_name);
                    return 1;
                }
            }
            printf("%i\n", atoi(tokenized));
        }
        return 0;
    }

    int checkValidName(char * name, FILE * output, char * file_name)
    {
        char restricted_chars[27] = {
            '!', '@', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0',
            '#', '"', '/', '?', '&', '|',
            '$', ';', '.', ',', '-',
            '+', '_', '(', ')' 
        };
        char * flag = NULL;

        for (int i = 0; i < 27; ++i)
        {
            flag = strchr(name, restricted_chars[i]);
            if (flag != NULL)
            {
                invalidInputError(output, file_name);
                return 1;
            }    
        }
        
        return 0;
    }