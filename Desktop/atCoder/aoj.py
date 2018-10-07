#atCoder abc112 D
import math
import time
n, m = map(int, input().split())
flag=0
if m%n==0:
    print(m//n)

else:
    start = time.time()
    index=m//n
    while index >0:
        elapsedTime = time.time()-start
        if elapsedTime > 1:
            flag=1
            break
        elif m%index==0:
            print(index)
            break
        index-=1

    if flag==1:
        index = 1
        while index < m+1:
            if m % index == 0:
                if index > n-1:
                    print(m//index)
                    break
            index += 1


    
