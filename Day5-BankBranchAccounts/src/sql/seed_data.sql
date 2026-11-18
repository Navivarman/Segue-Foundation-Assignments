
-- ==========================================
-- bank branch accounts management system
-- sample data
-- ==========================================

use bankbranchaccounts;

-- ==========================================
-- 1. customers
-- ==========================================

insert into customers
(customer_name, address_line, city, state, postal_code, email, phone)
values
('Arun Kumar', '12 Lake View Road', 'Chennai', 'Tamil Nadu', '600001', 'arun@example.com', '9000000001'),
('Priya Nair', '8 Race Course Road', 'Coimbatore', 'Tamil Nadu', '641018', 'priya@example.com', '9000000002'),
('Karthik Raj', '21 Main Road', 'Madurai', 'Tamil Nadu', '625001', 'karthik@example.com', '9000000003'),
('Divya S', '4 Gandhi Street', 'Trichy', 'Tamil Nadu', '620001', 'divya@example.com', '9000000004'),
('Rahul M', '17 Temple Road', 'Chennai', 'Tamil Nadu', '600028', 'rahul@example.com', '9000000005'),
('Sneha R', '3 Park Avenue', 'Salem', 'Tamil Nadu', '636001', 'sneha@example.com', '9000000006'),
('Vijay P', '9 Market Street', 'Coimbatore', 'Tamil Nadu', '641001', 'vijay@example.com', '9000000007'),
('Meena K', '15 River Road', 'Madurai', 'Tamil Nadu', '625020', 'meena@example.com', '9000000008');

-- ==========================================
-- 2. branches
-- ==========================================

insert into branches
(branch_name, address_line, city, state, ifsc_code)
values
('Chennai Main Branch', '100 Anna Salai', 'Chennai', 'Tamil Nadu', 'BANK0000001'),
('Coimbatore Branch', '25 Avinashi Road', 'Coimbatore', 'Tamil Nadu', 'BANK0000002'),
('Madurai Branch', '40 KK Nagar', 'Madurai', 'Tamil Nadu', 'BANK0000003');

-- ==========================================
-- 3. account types
-- ==========================================

insert into account_types (account_type_name)
values
('Savings'),
('Current'),
('Fixed Deposit'),
('Recurring Deposit');

-- ==========================================
-- 4. relationship managers
-- ==========================================

insert into relationship_managers
(manager_name, email, phone)
values
('Suresh Kumar', 'suresh.manager@example.com', '9100000001'),
('Anitha Devi', 'anitha.manager@example.com', '9100000002'),
('Mohan Raj', 'mohan.manager@example.com', '9100000003'),
('Lakshmi S', 'lakshmi.manager@example.com', '9100000004');

-- ==========================================
-- 5. accounts
-- ==========================================

insert into accounts
(account_number, account_type_id, branch_id, manager_id, balance, opened_date)
values
('000100000001', 1, 1, 1, 25000.00, '2026-07-05'),
('000100000002', 2, 1, 2, 85000.00, '2026-07-18'),
('000100000003', 1, 2, 2, 12000.00, '2026-08-02'),
('000100000004', 3, 2, 3, 150000.00, '2026-08-15'),
('000100000005', 4, 3, 4, 8000.00, '2026-09-01'),
('000100000006', 1, 3, 1, 45000.00, '2026-09-20'),
('000100000007', 2, 1, 3, 5000.00, '2026-10-10'),
('000100000008', 1, 2, 4, 32000.00, '2026-10-22'),
('000100000009', 3, 3, 2, 200000.00, '2026-06-12'),
('000100000010', 1, 1, 1, 18000.00, '2026-11-02'),
('000100000011', 4, 2, 3, 10000.00, '2026-07-25'),
('000100000012', 2, 3, 4, 65000.00, '2026-08-28');

-- ==========================================
-- 6. account holders
-- ==========================================

insert into account_holders
(account_id, customer_id, holder_role)
values
(1, 1, 'Primary'),
(2, 1, 'Primary'),
(3, 2, 'Primary'),
(4, 2, 'Primary'),
(4, 3, 'Joint'),
(5, 3, 'Primary'),
(6, 4, 'Primary'),
(7, 5, 'Primary'),
(8, 5, 'Primary'),
(9, 6, 'Primary'),
(10, 7, 'Primary'),
(11, 8, 'Primary'),
(12, 8, 'Primary');

-- ==========================================
-- verify inserted records
-- ==========================================

select * from customers;
select * from branches;
select * from account_types;
select * from relationship_managers;
select * from accounts;
select * from account_holders;
