def solution(array, commands):
    a = []
    for i,j,k in commands:
        ls = array[i-1:j]
        ls.sort()
        a.append(ls[k-1])
    return a