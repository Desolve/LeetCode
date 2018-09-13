# Write your MySQL query statement below
SELECT a.FirstName, a.LastName, b.City, b.State 
FROM Person a LEFT OUTER JOIN Address b USING (PersonId);