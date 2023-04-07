def solution(x):
    digit_sum = sum(map(int, str(x)))
    return x % digit_sum == 0