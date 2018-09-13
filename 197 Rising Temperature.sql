SELECT w1.Id FROM Weather as w1 INNER JOIN Weather as w2 
ON TO_DAYS(w1.Date)=TO_DAYS(w2.Date)+1 and w1.Temperature>w2.Temperature