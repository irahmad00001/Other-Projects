#include <stdio.h>
#include <stdlib.h>

int main()
{
    float input[30];
    for(int i = 0 ; i < 30 ; i++){
        scanf("%f", &input[i]);
    }
    float avg1 = 0 , avg2 = 0 , avg3 = 0 , temp = 0;
    for(int i = 0 ; i < 10 ; i++){
        temp += input[i];
    }
    avg1 = temp / 10;
    temp = 0;
    for(int i = 10 ; i < 20 ; i++){
        temp += input[i];
    }
    avg2 = temp /10;
    temp = 0;
    for(int i = 20 ; i < 30 ; i++){
        temp += input[i];
    }
    avg3 = temp /10;
    printf("%f \n" , avg1);
    printf("%f \n" , avg2);
    printf("%f \n" , avg3);
    return 0;
}
