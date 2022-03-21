/*
	Baekjoon Online Judge
	Problem number : 2579
	Link : https://www.acmicpc.net/problem/2579
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/
#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int steps;
	int scores[301] = {0,};

	cin >> steps;

	for (int i = 0; i < steps; ++i) {
		cin >> scores[i];
	}
	//k 연속으로 한칸을 밟은 횟수 n번째 계단일 때 최대 점수
	int dp[2][301] = { 0, };

	//initilize
	dp[0][0] = scores[0];
	dp[1][0] = 0;
	dp[0][1] = scores[1];
	dp[1][1] = scores[1] + dp[0][0];

	for (int i = 2; i < steps; ++i) {
		dp[0][i] = scores[i] + max(dp[0][i - 2], dp[1][i - 2]);
		dp[1][i] = scores[i] + dp[0][i - 1];
	}
	cout << max(dp[0][steps - 1], dp[1][steps - 1]);
	return 0;
}