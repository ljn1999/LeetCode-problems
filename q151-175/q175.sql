/* 2021.04.18
Problem Statement:
https://leetcode.com/problems/combine-two-tables/ 
Oh no, I've forgot everything about sql! */


/* Write your MySQL query statement below */
SELECT P.FirstName, P.LastName, A.City, A.State 
FROM Person P LEFT JOIN Address A /* regardless of address provided or not, instead of regardless of name provided or not */
ON P.PersonId = A.PersonId;