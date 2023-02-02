piece = [1,1,2,2,2,8]
find = list(input().split())
for i in range(len(piece)):
    print(f"{piece[i]-int(find[i])}",end=' ')