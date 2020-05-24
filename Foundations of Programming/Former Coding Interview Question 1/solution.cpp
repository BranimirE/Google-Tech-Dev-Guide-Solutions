#include <bits/stdc++.h>

using namespace std;

#ifdef ACMTUYO
struct RTC{~RTC(){cerr << "Time: " << clock() * 1.0 / CLOCKS_PER_SEC <<" seconds\n";}} runtimecount;
#define DBG(X) cerr << #X << " = " << X << '\n';
#else
struct RTC{};
#define DBG(X)
#endif

#define fast_io() ios_base::sync_with_stdio(false)
#define mp make_pair
#define mt make_tuple
#define pb push_back
#define eb emplace_back
#define sz(x) ((int)(x).size())
#define all(c) (c).begin(),(c).end()
#define forn(i, n) for (int i = 0; i < (n); i++)
using ll = long long int;
vector<string> solution(const string &S, vector<string> &D) {
  vector<int> idxs_subsequences;
  map<char, list<pair<int, int> > > buckets;
  forn (i, sz(D)) {
    string &w = D[i];
    if (sz(w) > 0) {
      buckets[w[0]].eb(i, 0);
    }
  }
  for (char c: S) {
    auto pairs_list = buckets[c];
    buckets[c].clear();
    for (auto &p: pairs_list) {
      int idx_str = p.first, next_idx = p.second + 1;
      if (next_idx == sz(D[idx_str])) {//end of the string
          idxs_subsequences.pb(idx_str);
      } else {//match char c in S, pass it to the next bucket
        char next_chr = D[idx_str][next_idx];
        buckets[next_chr].eb(idx_str, next_idx);
      }
    }
  }
  vector<string> answer;
  if (sz(idxs_subsequences) > 0) {
    int max_lenght = 0;
    for (int idx: idxs_subsequences) {
      max_lenght = max(max_lenght, sz(D[idx]));
    }
    for (int idx: idxs_subsequences) {
      if (sz(D[idx]) == max_lenght) {
        answer.pb(D[idx]);
      }
    }
  }
  return answer;
}
int main() {
  string S = "abppplee";
  vector<string> D = {"able", "ale", "apple", "bale", "kangaroo"};
  auto answers = solution(S, D);
  for (auto &answer: answers) {
    printf("%s\n", answer.c_str());
  }
  return 0;
}
