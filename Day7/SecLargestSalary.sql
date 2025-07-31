/* 1.	Find the second highest salary from an Employees table */
/*  Method 1: Using DISTINCT and LIMIT */
SELECT DISTINCT salary
FROM Employees
ORDER BY salary DESC
LIMIT 1 OFFSET 1;


/* Method 2: Using a subquery */
SELECT MAX(salary) AS second_highest_salary
FROM Employees
WHERE salary < (SELECT MAX(salary) FROM Employees);

/* Method 3: Using DENSE_RANK() */
SELECT salary
FROM (
  SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
  FROM Employees
) AS ranked
WHERE rnk = 2;
/* Method 4: Using ROW_NUMBER() */
SELECT salary
FROM (
  SELECT salary, ROW_NUMBER() OVER (ORDER BY salary DESC) AS rnk
  FROM Employees
) AS ranked
WHERE rnk = 2;