
# Data Type Justification

## Bank Branch Accounts Management System

The following data types are selected based on the nature of the stored information.

| Column | Data Type | Reason |
|---|---|---|
| customer_id | INT | Numeric unique identifier |
| customer_name | VARCHAR(100) | Variable-length customer name |
| address_line | VARCHAR(150) | Variable-length address |
| city | VARCHAR(60) | City name |
| state | VARCHAR(60) | State name |
| postal_code | VARCHAR(10) | Preserves postal codes with leading zeroes |
| email | VARCHAR(120) | Stores email addresses |
| phone | VARCHAR(15) | Preserves phone numbers and country codes |
| branch_id | INT | Numeric branch identifier |
| ifsc_code | CHAR(11) | Fixed-length IFSC identifier |
| account_number | VARCHAR(20) | Preserves leading zeroes |
| balance | DECIMAL(15,2) | Exact monetary value with two decimal places |
| opened_date | DATE | Stores account opening date |
| account_type_name | VARCHAR(30) | Stores account category |
| manager_name | VARCHAR(100) | Stores manager name |

## Why DECIMAL instead of FLOAT?

DECIMAL stores exact decimal values and is suitable for financial calculations.

FLOAT uses approximate binary floating-point representation, which can introduce rounding errors.

Therefore, DECIMAL(15,2) is used for account balances.

## Why VARCHAR for account numbers?

Account numbers are identifiers, not values used for arithmetic.

VARCHAR preserves leading zeroes and supports different account number formats.

## Why AUTO_INCREMENT?

AUTO_INCREMENT automatically generates unique numeric identifiers for new records.

It reduces the need to manually assign primary key values.
