/*
  	Baekjoon Online Judge
  	Problem number : 2585
  	Link : https://www.acmicpc.net/problem/2585
  	Author : LibertBaek
  	Mail : halucinor0@gmail.com
  */

#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <queue>
#include <cstring>

#define PII pair<int,int>

using namespace std;

int get_fuel(PII a, PII b) {
	int dx = a.first - b.first;
	int dy = a.second - b.second;
	//int dist = sqrt((dx * dx) +(dy * dy));

	return (int) ceil(sqrt((dx * dx) + (dy * dy)) / 10.0);
}

bool comp(PII a, PII b) {
	int fuel_a = get_fuel(PII(0, 0), a);
	int fuel_b = get_fuel(PII(0, 0), b);
	
	if (fuel_a < fuel_b) return true;
	else return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, k, x, y;
	
	cin >> n >> k;
	
	vector<PII> positions;
	positions.push_back(PII(0, 0));
	for (int i = 0; i < n; ++i) {
		cin >> x >> y;
		positions.push_back(PII(x, y));
	}
	
	sort(positions.begin(), positions.end(), comp);

	PII _s = PII(0, 0);
	PII _t = PII(10000, 10000);

	int left = 0;
	int right = get_fuel(_s, _t);

	positions.push_back(_t);
	
	vector<vector<int>> fuel_map(positions.size(), vector<int>(positions.size(), 0));

	for (int i = 0; i < positions.size(); ++i) {
		for (int j = i + 1; j < positions.size(); ++j) {
			fuel_map[i][j] = get_fuel(positions[i], positions[j]);
			fuel_map[j][i] = fuel_map[i][j];
		}
	}
	bool is_visited[1002] = { false, };
	int ans = 0;
	while (left <= right) {
		int fuel = (left + right) / 2;

		queue<PII> q; //(position index, k)

		q.push(PII(0, 0)); // start, k
		is_visited[0] = true;
		int k_ = k+1;
		while (!q.empty()) {
			PII _temp = q.front(); q.pop();

			int idx = _temp.first;
			int _k = _temp.second;

			if (idx == positions.size() - 1) {
				k_ = _k - 1;
				break;
			}

			for (int i = 1; i < positions.size(); ++i) {
				if (is_visited[i]) continue;
				if (fuel_map[idx][i] <= fuel){
					is_visited[i] = true;
					q.push(PII(i, _k + 1));
				}
			}
		}

		memset(is_visited, false, sizeof(is_visited));

		if (k_ <= k) {
			right = fuel - 1;
		}
		else {
			left = fuel + 1;
		}
	}

	cout << left;
	return 0;
}
