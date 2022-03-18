/*
	Baekjoon Online Judge
	Problem number : 2212
	Link : https://www.acmicpc.net/problem/2212
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int N, K;
	vector<int> sensors;

	cin >> N >> K;
	int pos;
	for (int i = 0; i < N; ++i) {
		cin >> pos;
		sensors.push_back(pos);
	}

	sort(sensors.begin(), sensors.end());
	vector<int> dist;
	for (int i = 1; i < N; ++i) {
		dist.push_back(sensors[i] - sensors[i - 1]);
	}
	
	//Desending
	sort(dist.begin(), dist.end(), greater<int>());

	int idx = K - 1;
	int ans = 0;
	for (int i = idx; i < dist.size(); ++i)
		ans += dist[i];

	cout << ans;
	
	return 0;
}