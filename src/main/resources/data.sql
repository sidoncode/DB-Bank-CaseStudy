INSERT INTO trade (trade_id, instrument, price, quantity, source_system, trade_date)
VALUES
('T123', 'AAPL', 150.0, 10, 'Bloomberg', '2024-06-15'),
('T124', 'GOOG', 2800.0, 5, 'Reuters', '2024-06-14');


-- Sample Instruments
INSERT INTO instrument (symbol, name, isin)
VALUES
('AAPL', 'Apple Inc.', 'US0378331005'),
('GOOGL', 'Alphabet Inc.', 'US02079K3059'),
('MSFT', 'Microsoft Corp.', 'US5949181045');

-- Sample Reconciliation Run
INSERT INTO reconciliation_run (run_date, status, matched_count, unmatched_count)
VALUES
(NOW(), 'COMPLETED', 2, 1);
