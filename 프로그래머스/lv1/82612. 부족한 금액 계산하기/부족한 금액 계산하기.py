def solution(price, money, count):
    total = sum(price*i for i in range(1,count+1))
    return 0 if money-total>=0 else total-money 