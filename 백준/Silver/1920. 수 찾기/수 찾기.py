from typing import Any, Sequence 
def bin_search(a:Sequence, key:Any) -> int : #이진 탐색
    pl = 0 #검색 범위 맨 앞 원소의 인덱스
    pr = len(a)-1 #검색 범위 맨 끝 원소의 인덱스
    while True :
        pc = (pl+pr)//2 #중앙 원소의 인덱스
        if a[pc] == key :
            return 1
        elif a[pc] < key :
            pl = pc+1 #검색 범위를 뒤쪽 절반으로 좁힘
        else :
            pr = pc -1 
        if pl > pr : break
    return -1
N = int(input())
n_list = [None]*N
n_list = list(map(int,input().split()))
M = int(input())
m_list = [None]*M
m_list = list(map(int,input().split()))
n_list.sort() #오름차순 정렬
for i in range(len(m_list)) :
    ky = m_list[i]
    in_ = bin_search(n_list,ky)
    print("1" if in_ == 1 else "0")