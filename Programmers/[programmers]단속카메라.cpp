/*
    Programmers
    Link : https://programmers.co.kr/learn/courses/30/lessons/42884
    Author : LibertBaek
    Mail : halucinor0@gmail.com
*/
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(vector<int> car1, vector<int> car2) {
    if (car1[1] < car2[1]) return true;
    else if(car1[1] == car2[1]){
        if (car1[0] < car2[0]) return true;
        else false;
    }
    return false;
}

int solution(vector<vector<int>> routes) {
    int answer = 0;

    int _cars = routes.size();

    stable_sort(routes.begin(), routes.end(), comp);

    int last_point = 300001;
    for (int i = 0; i < _cars;) {
            answer++;
            last_point = routes[i][1]; //진출시점에 설치
        for (i; i < _cars;) {
            if (routes[i][0] <= last_point) i++;
            else break;
        }
    }

    return answer;
}