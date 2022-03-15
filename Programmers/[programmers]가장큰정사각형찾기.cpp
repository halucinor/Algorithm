/*
    Programmers
    Link : https://programmers.co.kr/learn/courses/30/lessons/12905?language=cpp
    Author : LibertBaek
    Mail : halucinor0@gmail.com
*/
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = board[0][0];

    for (int r = 1; r < board.size(); ++r) {
        for (int c = 1; c < board[0].size(); ++c) {
                    if(board[r][c] > 0){
                    board[r][c] = 1 + min(min(board[r][c - 1], board[r - 1][c]), board[r - 1][c - 1]);
                    answer = max(answer, board[r][c]);
                }
        }
    }
    

    return (int)pow(answer,2);
}