-- Drop tables if they exist
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS instrument;
DROP TABLE IF EXISTS reconciliation_run;

-- Trade Table
CREATE TABLE trade (
    id SERIAL PRIMARY KEY,
    trade_id VARCHAR(255),
    instrument VARCHAR(255),
    price NUMERIC,
    quantity INTEGER,
    source_system VARCHAR(255),
    trade_date DATE
);



-- Instrument Table
CREATE TABLE instrument (
    id SERIAL PRIMARY KEY,
    symbol VARCHAR(50),
    name VARCHAR(100),
    isin VARCHAR(20)
);

-- Reconciliation Run Table
CREATE TABLE reconciliation_run (
    id SERIAL PRIMARY KEY,
    run_date TIMESTAMP,
    status VARCHAR(20),
    matched_count INTEGER,
    unmatched_count INTEGER
);
