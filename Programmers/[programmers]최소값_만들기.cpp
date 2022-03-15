/*
    Programmers
    Link : https://programmers.co.kr/learn/courses/30/lessons/12941
    Author : LibertBaek
    Mail : halucinor0@gmail.com
*/
#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    //내림차순
    sort(A.begin(), A.end(),greater<int>());
    
    //오름차순
    sort(B.begin(), B.end(),less<int>());

    for (int i = 0; i < A.size(); ++i) {
        answer += A[i] * B[i];
    }

    return answer;
}