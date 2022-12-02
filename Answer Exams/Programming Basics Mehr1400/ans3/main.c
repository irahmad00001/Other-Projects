#include <stdio.h>
#include <stdlib.h>

int main()
{
    float ans = 0;
    for(float i = 1 , j = 1; i < 199 ; i += 2){
        if(j == 1){
            ans = ans + (4 / i);
            j = 0;
        }else{
            ans = ans - (4 / i);
            j = 1;
        }
    }
    printf("%f \n" , ans);
    return 0;
}
