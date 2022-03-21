/*
	Baekjoon Online Judge
	Problem number : 1012
	Link : https://www.acmicpc.net/problem/1012
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/

#include <iostream>
#include <queue>
#include <vector>
#include <memory.h>

#define VVI vector<vector<int>>
#define VVB vector<vector<bool>>
#define PII pair<int,int>

using namespace std;

int dr[4] = { 0,1,0,-1 };
int dc[4] = { 1,0,-1,0 };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T, M, N, K;
    int x, y;
    cin >> T;

    int map[50][50] = { 0, };
    bool is_visited[50][50] = { 0, };

    for (int t = 0; t < T; ++t) {
        cin >> M >> N >> K;

        for (int k = 0; k < K; ++k) {
            cin >> x >> y;
            map[y][x] = 1;
        }

        int cnt = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                if (map[r][c] == 1 && !is_visited[r][c]) {
                    cnt++;
                    queue<PII> q;

                    q.push(PII(r, c));
                    is_visited[r][c] = true;
                    while (!q.empty()) {
                        PII pos = q.front();
                        q.pop();

                        for (int i = 0; i < 4; ++i) {
                            int nr = pos.first + dr[i];
                            int nc = pos.second + dc[i];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                                if (map[nr][nc] == 1 && !is_visited[nr][nc]) {
                                    q.push(PII(nr, nc));
                                    is_visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        memset(map, 0, sizeof(map));
        memset(is_visited, false, sizeof(is_visited));

        cout << cnt << "\n";
    }

    return 0;
}