CREATE VIEW REPORT_GROUPBY_CREDIT
AS SELECT s.id, s.code, s.name AS credit, sum(j.amount) AS subtotal
FROM acc_subjects s, acc_journals j
WHERE j.credit = s.id
GROUP BY s.id, s.code, s.name;
