/*
	Baekjoon Online Judge
	Problem number : 10162
	Name: 전자레인지
	Link : https://www.acmicpc.net/problem/10162
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/

#include <iostream>

using namespace std;

static int _time[] = { 300, 60, 10 };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	
	int ans[3] = { 0, };

	int T;
	cin >> T;
	
	int cnt = 0;

	for (int i = 0; i < 3; ++i) {
		cnt = T / _time[i];
		ans[i] = cnt;
		T -= _time[i] * cnt;
	}

	if (T != 0) {
		cout << -1;
	}
	else {
		for (int i = 0; i < 3; ++i)
			cout << ans[i] << " ";
	}

	return 0;
}