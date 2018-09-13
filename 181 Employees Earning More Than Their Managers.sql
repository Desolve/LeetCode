# Write your MySQL query statement below
SELECT a.Name FROM Employee a, Employee b
WHERE a.ManagerId = b.Id AND a.Salary > b.Salary