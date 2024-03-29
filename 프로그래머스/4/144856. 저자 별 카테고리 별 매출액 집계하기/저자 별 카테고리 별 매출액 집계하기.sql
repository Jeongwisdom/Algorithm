SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) TOTAL_SALES FROM BOOK B 
JOIN AUTHOR A USING(AUTHOR_ID) 
JOIN BOOK_SALES S USING(BOOK_ID)
WHERE S.SALES_DATE LIKE '2022-01%'
GROUP BY B.AUTHOR_ID, B.CATEGORY
ORDER BY B.AUTHOR_ID, B.CATEGORY DESC;