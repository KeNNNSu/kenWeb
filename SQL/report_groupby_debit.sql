SELECT s.id, s.code, s.name AS debit, sum(j.amount) AS subtotal
FROM acc_subjects s, acc_journals j
WHERE j.debit = s.id
GROUP BY s.id, s.code, s.name