/* 2021.04.21
Problem Statement:
https://leetcode.com/problems/second-highest-salary/ 
Copied from the solution page, sorry I've forgot everything about sql*/

/* Write your MySQL query statement below */
select max(Salary) as SecondHighestSalary
from Employee
where Salary< (select max(Salary) from Employee)