
# Functional Dependencies

## Bank Branch Accounts Management System

A functional dependency describes a relationship between attributes where one attribute or a group of attributes determines another attribute.

It is represented as:

A -> B

Where A is the determinant and B is the dependent attribute.

## 1. Customers

customer_id -> customer_name, address_line, city, state, postal_code, email, phone

email -> customer_id

phone -> customer_id

## 2. Branches

branch_id -> branch_name, address_line, city, state, ifsc_code

ifsc_code -> branch_id

## 3. Account Types

account_type_id -> account_type_name

account_type_name -> account_type_id

## 4. Relationship Managers

manager_id -> manager_name, email, phone

email -> manager_id

phone -> manager_id

## 5. Accounts

account_id -> account_number, account_type_id, branch_id, manager_id, balance, opened_date

account_number -> account_id, account_type_id, branch_id, manager_id, balance, opened_date

## 6. Account Holders

(account_id, customer_id) -> holder_role

## Candidate Keys

| Table | Candidate Keys |
|---|---|
| customers | customer_id, email, phone |
| branches | branch_id, ifsc_code |
| account_types | account_type_id, account_type_name |
| relationship_managers | manager_id, email, phone |
| accounts | account_id, account_number |
| account_holders | (account_id, customer_id) |

## Composite Key

The account_holders table uses a composite primary key:

(account_id, customer_id)

Both attributes together uniquely identify a customer-account relationship.

Neither attribute alone uniquely identifies a relationship because a customer can own multiple accounts and an account can have joint holders.
