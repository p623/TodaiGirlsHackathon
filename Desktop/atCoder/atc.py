
n, m = map(int, input().split())
listS = list(input())
listT = list(input())


def gcd(a, b):
	while b:
		a, b = b, a % b
	return a


l = n*m // gcd(n, m)
a = l//n
b = l//m

if listS[0] != listT[0]:
    print(-1)
else:
    checkI = a*b // gcd(a, b)
    if checkI > l:
        print(l)
    else:
        index = 0
        flag = 0
        while index < l//min(a, b):
            if index*checkI//a > len(listS)-1 or index*checkI//b > len(listT)-1:
                break
            elif listS[index*checkI//a] != listT[index*checkI//b]:
                print(-1)
                flag = 1
                break
            else:
                index += 1
        if flag == 0:
            print(l)
        






