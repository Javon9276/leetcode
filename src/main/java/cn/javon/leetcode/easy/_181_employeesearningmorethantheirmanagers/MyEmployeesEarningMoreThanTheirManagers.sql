SELECT E. NAME EMPLOYEE FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGERID = M.ID WHERE M.SALARY < E.SALARY