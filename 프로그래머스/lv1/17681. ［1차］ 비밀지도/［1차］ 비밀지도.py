def solution(n, arr1, arr2):
    ls1 = [bin(i)[2:].rjust(n,'0') for i in arr1]
    ls2 = [bin(i)[2:].rjust(n,'0') for i in arr2]
    result = []
    for i in range(n):
        word = ""
        for j in range(n):
            if int(ls1[i][j]) or int(ls2[i][j]):
                word += "#"
            else:
                word += " "
        result.append(word)
    return result
        
    