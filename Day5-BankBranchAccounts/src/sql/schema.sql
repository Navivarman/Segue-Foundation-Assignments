
-- ==========================================
-- bank branch accounts management system
-- database schema
-- ==========================================

create database if not exists bankbranchaccounts;

use bankbranchaccounts;

-- drop existing tables in child-to-parent order
drop table if exists account_holders;
drop table if exists accounts;
drop table if exists relationship_managers;
drop table if exists account_types;
drop table if exists branches;
drop table if exists customers;

-- ==========================================
-- 1. customers table
-- ==========================================

create table customers (
    customer_id int auto_increment primary key,
    customer_name varchar(100) not null,
    address_line varchar(150) not null,
    city varchar(60) not null,
    state varchar(60) not null,
    postal_code varchar(10) not null,
    email varchar(120) not null unique,
    phone varchar(15) not null unique
);

-- ==========================================
-- 2. branches table
-- ==========================================

create table branches (
    branch_id int auto_increment primary key,
    branch_name varchar(100) not null,
    address_line varchar(150) not null,
    city varchar(60) not null,
    state varchar(60) not null,
    ifsc_code char(11) not null unique
);

-- ==========================================
-- 3. account types table
-- ==========================================

create table account_types (
    account_type_id int auto_increment primary key,
    account_type_name varchar(30) not null unique,

    constraint chk_account_type_name
    check (
        account_type_name in (
            'Savings',
            'Current',
            'Fixed Deposit',
            'Recurring Deposit'
        )
    )
);

-- ==========================================
-- 4. relationship managers table
-- ==========================================

create table relationship_managers (
    manager_id int auto_increment primary key,
    manager_name varchar(100) not null,
    email varchar(120) not null unique,
    phone varchar(15) not null unique
);

-- ==========================================
-- 5. accounts table
-- ==========================================

create table accounts (
    account_id int auto_increment primary key,
    account_number varchar(20) not null unique,
    account_type_id int not null,
    branch_id int not null,
    manager_id int not null,
    balance decimal(15,2) not null default 0.00,
    opened_date date not null,

    constraint chk_accounts_balance
    check (balance >= 0.00),

    constraint fk_accounts_type
    foreign key (account_type_id)
    references account_types(account_type_id),

    constraint fk_accounts_branch
    foreign key (branch_id)
    references branches(branch_id),

    constraint fk_accounts_manager
    foreign key (manager_id)
    references relationship_managers(manager_id)
);

-- ==========================================
-- 6. account holders table
-- supports joint accounts
-- ==========================================

create table account_holders (
    account_id int not null,
    customer_id int not null,
    holder_role varchar(20) not null default 'Primary',

    primary key (account_id, customer_id),

    constraint chk_holder_role
    check (holder_role in ('Primary', 'Joint')),

    constraint fk_holders_account
    foreign key (account_id)
    references accounts(account_id)
    on delete cascade,

    constraint fk_holders_customer
    foreign key (customer_id)
    references customers(customer_id)
    on delete cascade
);
