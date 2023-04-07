def solution(n):
    tmp = ''
    while n:
        tmp += str(n % 3)
        n = n // 3
    print(tmp)
    answer = int(tmp, 3)
    return answer

