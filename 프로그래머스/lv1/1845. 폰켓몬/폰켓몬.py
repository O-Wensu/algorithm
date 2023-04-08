def solution(nums):
    n = len(set(nums))
    select = len(nums)//2
    if n >= select:
        return select
    else:
        return n

    

    