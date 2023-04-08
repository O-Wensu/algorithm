def solution(s):
    a = s.split(" ")
    b = list()
    for l in a:
        c = list(l)
        for i in range(len(c)):
            if i%2==0:
                c[i] = c[i].upper()
            else :
                c[i] = c[i].lower()
        b.append("".join(c))
    return " ".join(b) 