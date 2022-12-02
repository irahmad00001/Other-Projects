#include <iostream>
#include <stack>
#include <utility>

using namespace std;
class n_queen{
    private :
        int number;
        bool** arr;

    public:
        bool isSafe(int,int);
        bool* backtracking();
        n_queen(int n){
            number = n;
        }
        **arr = new bool[number][number];
        bool** backtracking(){
            stack<pair<int,int>> st;
            for(int i = 0 ; i < number ; i++){
                for(int j = 0 ; j < number ; j++){
                    arr[i][j] = false
;                }
            }
            for(int i = 0 ; i < number ; i++){
                for(int j = 0 ; j < nmber ; j++){
                    if(isSafe(i , j)){
                        arr[i][j] = true;
                        pair<int, int> temp;
                        temp.first = i;
                        temp.second = j;
                        st.push(temp);
                        break;
                    }
                    if(j == number - 1){
                        pair<int, int> temp1;
                        temp1 = st.pop();
                        arr[temp1.first][temp1.second] = false;
                        i = temp1.first;
                        j = temp1.second;
                    }while( j == number - 1){
                        pair<int, int> temp1;
                        temp1 = st.pop();
                        arr[temp1.first][temp1.second] = false;
                        i = temp1.first;
                        j = temp1.second;
                    }
                }
            }
            return arr;
        }
        bool isSafe(int _i , int _j){
            for(int i = 0 ; i < number ; i++){
              if(arr[_i][i] == true)
                    return false;
              if(arr[i][_j] == true)
                    return false;
            }
            for(int i = 0 ; i < number ; i++){
                for(int j = 0 ; j < number ; j++){
                    if(abs(i - _i) == abs(j - _j))
                        return false;
                }
            }
            return true;
        }
};



int main(){
    n_queen(8) nq;
    bool** ptr = nq.backtracking();
    for(int i = 0 ; i < 8 ; i++){
        for(int j = 0 ; j < 8 ; j++){
            cout << ptr[i][j];
        }
    }

return 0;
}
