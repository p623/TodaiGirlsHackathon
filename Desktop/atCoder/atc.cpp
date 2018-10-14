#include <bits/stdc++.h>
using namespace std;

int gcd( int m, int n )
{
	// 引数に０がある場合は０を返す
	if ( ( 0 == m ) || ( 0 == n ) )
		return 0;
	
	// ユークリッドの方法
	while( m != n )
	{
		if ( m > n ) m = m - n;
		else         n = n - m;
	}
	return m;
}//gcd

int lcm( int m, int n )
{
	// 引数に０がある場合は０を返す
	if ( ( 0 == m ) || ( 0 == n ) )
		return 0;
	
	return ((m / gcd(m, n)) * n); // lcm = m * n / gcd(m,n)
}//lcm

int main() {
 int a, b, n;
 cin >> a >> b >> n; 
 int kobai = lcm(a, b);
 int index=1;
 while (true){
     if (kobai*index > n-1){
        cout << kobai*index << endl;
        break;
     }else{
         index++;
     }
 }
 
}


