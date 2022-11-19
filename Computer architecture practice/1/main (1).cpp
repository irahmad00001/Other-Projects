/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include <string>
#include <algorithm> 

using namespace std;

int main()
{
    double num = 0;
    unsigned int cor_num = 0;
    double dec_num = 0;
    string ans = "";
    cin >> num;
    if(num >= 0){
        cor_num = (int) num;
        dec_num = num - (double) cor_num;
    }else{
        cor_num = -((int) num);
        dec_num = - (num + (double) cor_num);
    }
    while((int)cor_num % 16 > 0){
        int temp = cor_num % 16;
        if(temp < 10){
            ans = ans + to_string(temp);
        }
        if(temp == 10){
            ans = ans + "A";
        }
        if(temp == 11){
            ans = ans + "B";
        }
        if(temp == 12){
            ans = ans + "C";
        }
        if(temp == 13){
            ans = ans + "D";
        }
        if(temp == 14){
            ans = ans + "E";
        }
        if(temp == 15){
            ans = ans + "F";
        }
        cor_num = cor_num / 16 ;
    }
    if(num < 0){
        ans = ans + "-";
    }
    reverse(ans.begin() , ans.end());
    if(dec_num != 0){
        ans = ans + ".";
        while(dec_num > 0){
            double temp = dec_num * 16;
            if(temp < 10){
            ans = ans + to_string((int)temp);
            }
            if((int)temp == 10){
                ans = ans + "A";
            }
            if((int)temp == 11){
                ans = ans + "B";
            }
            if((int)temp == 12){
                ans = ans + "C";
            }
            if((int)temp == 13){
                ans = ans + "D";
            }
            if((int)temp == 14){
                ans = ans + "E";
            }
            if((int)temp == 15){
                ans = ans + "F";
            }
            dec_num = dec_num - temp;
        }
    }
    cout << ans ;
    return 0;
}