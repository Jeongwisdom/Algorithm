SELECT PRODUCT_CODE, P.PRICE * SUM(O.SALES_AMOUNT) AS SALES FROM PRODUCT P
JOIN OFFLINE_SALE O ON O.PRODUCT_ID = P.PRODUCT_ID 
GROUP BY O.PRODUCT_ID 
ORDER BY SALES DESC, PRODUCT_CODE;