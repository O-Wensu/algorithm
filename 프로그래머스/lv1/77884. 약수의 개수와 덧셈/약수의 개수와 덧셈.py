def solution(left, right):
    ls = []
    for i in range(left,right+1):
        if (len([x for x in range(1,i//2+1) if i%x==0])+1) % 2 == 0:
            ls.append(i)
        else:
            ls.append(-i)
    return sum(ls)

    