SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE FROM REST_INFO RI
JOIN REST_REVIEW RR ON RR.REST_ID = RI.REST_ID  
WHERE RI.ADDRESS LIKE '서울%' 
GROUP BY RR.REST_ID 
ORDER BY SCORE DESC, RI.FAVORITES DESC;