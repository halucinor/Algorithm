/*
	Baekjoon Online Judge
	Problem number : 2930
	Name: 가위바위보
	Link : https://www.acmicpc.net/problem/2930
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/

#include <iostream>
#include <math.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int R , N;
	char sign;

	char sang_gun[50] = { ' ', };

	char sign_map[50][50] = {' ',};
	
	char same_sign[3]= {'S', 'P', 'R'};
	char win_sign[3] = { 'P', 'R', 'S' };

	cin >> R;

	for (int i = 0; i < R; ++i) {
		cin >> sign;
		sang_gun[i] = sign;
	}
	
	cin >> N;

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < R; ++j) {
			cin >> sign;
			sign_map[i][j] = sign;
		}
	}

	int current_score = 0;
	int max_score = 0;

	for (int r = 0; r < R; ++r) {
		int _max = -1;
		for (int i = 0; i < 3; ++i) {
			int _score = 0;
			for (int n = 0; n < N; ++n) {	
				if (sign_map[n][r] == win_sign[i])
					_score += 2;
				if (sign_map[n][r] == same_sign[i])
					_score += 1;
			}
			if (sang_gun[r] == same_sign[i])
				current_score += _score;
			_max = max(_score, _max);
		}
		max_score += _max;
	}

	cout << current_score << "\n" << max_score;

	return 0;
}