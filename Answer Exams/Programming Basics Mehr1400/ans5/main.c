#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n = 0;
    scanf("%d",&n);
    for(int i = n ; i > 0 ; i--){
        for(int j = i ; j > 0 ; j--){
            printf("*");
        }
        for(int j = n - i ; j > 0 ; j--){
            printf("  ");
        }
        for(int j = i ; j > 0 ; j--){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 1 ; i <= n ; i++){
        for(int j = i ; j > 0 ; j--){
            printf("*");
        }
        for(int j = n - i ; j > 0 ; j--){
            printf("  ");
        }
        for(int j = i ; j > 0 ; j--){
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
