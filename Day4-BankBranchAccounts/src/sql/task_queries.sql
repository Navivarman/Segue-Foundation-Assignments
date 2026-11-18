
-- ==========================================
-- bank branch accounts management system
-- case study tasks
-- ==========================================

use bankbranchaccounts;

-- ==========================================
-- TASK 3: DELETE, TRUNCATE AND DROP
-- ==========================================

-- create a separate test table

drop table if exists test_accounts;

create table test_accounts (
    id int auto_increment primary key,
    customer_name varchar(50)
);

insert into test_accounts (customer_name)
values ('Arun'), ('Priya'), ('Rahul');

select * from test_accounts;

-- 1. DELETE

delete from test_accounts
where id = 2;

select * from test_accounts;

-- insert another record to check auto_increment

insert into test_accounts (customer_name)
values ('Sneha');

select * from test_accounts;

-- 2. ROLLBACK demonstration

start transaction;

delete from test_accounts;

select * from test_accounts;

rollback;

select * from test_accounts;

-- 3. TRUNCATE

truncate table test_accounts;

insert into test_accounts (customer_name)
values ('Vijay');

select * from test_accounts;

-- 4. DROP

drop table test_accounts;


-- ==========================================
-- TASK 4: INSERT, UPDATE AND DELETE
-- ==========================================

-- INSERT

insert into customers
(customer_name, address_line, city, state, postal_code, email, phone)
values
('Test Customer', '1 Test Street', 'Chennai', 'Tamil Nadu',
 '600010', 'test.customer@example.com', '9000000099');

-- UPDATE

update customers
set city = 'Coimbatore'
where email = 'test.customer@example.com';

-- DELETE

delete from customers
where email = 'test.customer@example.com';


-- ==========================================
-- TASK 4: FILTERING OPERATORS
-- ==========================================

-- accounts opened in Q3 2026 with balance above 10000
-- using AND, OR, IN, BETWEEN and LIKE

select distinct
    a.account_number,
    c.customer_name,
    at.account_type_name,
    b.branch_name,
    a.opened_date,
    a.balance
from accounts a
join account_types at
    on a.account_type_id = at.account_type_id
join branches b
    on a.branch_id = b.branch_id
join account_holders ah
    on a.account_id = ah.account_id
join customers c
    on ah.customer_id = c.customer_id
where a.opened_date between '2026-07-01' and '2026-09-30'
and a.balance > 10000
and a.balance between 10001 and 200000
and (
    at.account_type_name in ('Savings', 'Current')
    or c.customer_name like 'A%'
)
order by a.opened_date;


-- AND

select *
from accounts
where balance > 10000
and branch_id = 1;

-- OR

select *
from accounts
where branch_id = 1
or branch_id = 2;

-- IN

select *
from accounts
where account_type_id in (1, 2);

-- BETWEEN

select *
from accounts
where balance between 10000 and 50000;

-- LIKE

select *
from customers
where customer_name like 'A%';


-- ==========================================
-- TASK 5: ALTER TABLE
-- ==========================================

-- 1. add kyc_status column

alter table customers
add column kyc_status varchar(20) not null default 'Pending';

-- add check constraint

alter table customers
add constraint chk_customers_kyc_status
check (kyc_status in ('Pending', 'Verified', 'Rejected'));

-- 2. update kyc status

update customers
set kyc_status = 'Verified'
where customer_id = 1;

-- 3. rename table

rename table account_types to account_categories;

-- 4. drop check constraint

alter table account_categories
drop check chk_account_type_name;

-- 5. add check constraint back

alter table account_categories
add constraint chk_account_type_name
check (
    account_type_name in (
        'Savings',
        'Current',
        'Fixed Deposit',
        'Recurring Deposit'
    )
);

-- 6. rename table back

rename table account_categories to account_types;

-- ==========================================
-- VERIFY CHANGES
-- ==========================================

describe customers;

show create table customers;

show create table account_types;
