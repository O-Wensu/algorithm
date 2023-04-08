def solution(n):
    list1 = [i for i in range(1,n+1) if n % i == 0]
    return sum(list1)