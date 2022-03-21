/*
	Baekjoon Online Judge
	Problem number : 2293
	Link : https://www.acmicpc.net/problem/2293
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/
#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, k;
	cin >> n >> k;

	vector<int> coins(n + 1, 0);

	int dp[10001] = { 0, };
	for (int i = 1; i <= n; ++i) {
		cin >> coins[i];
	}
	sort(coins.begin(),coins.end(), less<int>());

	dp[0] = 1;

	for (int i = 1; i <= n; ++i) {
		for (int j = coins[i]; j <= k; ++j)
			dp[j] += dp[j - coins[i]];
	}

	cout << dp[k];

	return 0;
}