-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME,
        (CASE WHEN SEX_UPON_INTAKE like '%Neutered%' OR SEX_UPON_INTAKE like '%Spayed%' THEN 'O'
        ELSE 'X' END) as 중성화
    FROM ANIMAL_INS 
ORDER BY ANIMAL_ID