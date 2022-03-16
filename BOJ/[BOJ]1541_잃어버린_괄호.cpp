/*
	Baekjoon Online Judge
	Problem number : 1541
	Name: ÀÒ¾î¹ö¸° °ýÈ£
	Link : https://www.acmicpc.net/problem/1541
	Author : LibertBaek
	Mail : halucinor0@gmail.com
*/

#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string formula;
	
	vector<int> nums;

	cin >> formula;

	string tok = "";
	
	bool is_minus = false;
	
	int num = 0;
	int ans = 0;

	for (int i = 0; i < formula.size(); ++i) {
		if (formula[i] >= '0' && formula[i] <= '9') {
			tok += formula[i];
		}
		else {
			num = stoi(tok);
			tok = "";
			if (formula[i] == '-'){
				if (is_minus)
					nums.push_back(-1 * num);
				else
					nums.push_back(num);
				is_minus = true;
			}
			else if (formula[i] == '+') {
				if (is_minus)
					nums.push_back(-1 * num);
				else
					nums.push_back(num);
			}
		}
	}
	int last = stoi(tok);

	if (is_minus) nums.push_back(-1 * last);
	else nums.push_back(last);

	for (int num : nums)
		ans += num;
	

	cout << ans;
	
	return 0;
}