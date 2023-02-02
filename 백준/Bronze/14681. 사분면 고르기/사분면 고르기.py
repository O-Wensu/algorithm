p1 = int(input());p2 = int(input())
result=0
if p1>0:
    if p2>0:result=1
    elif p2<0:result=4
elif p1<0:
    if p2>0:result=2
    elif p2<0:result=3
print(f"{result}")