
# Database Normalization

## Bank Branch Accounts Management System

### 1. Introduction

Database normalization is the process of organizing database tables to reduce data redundancy and avoid insertion, update and deletion anomalies.

This project follows 3NF and is designed to satisfy BCNF under the stated functional dependencies.

### 2. First Normal Form (1NF)

A table satisfies 1NF when:

- Every column contains atomic values.
- There are no repeating groups.
- Each row can be uniquely identified.

Implementation:

- Customer details are stored in the customers table.
- Account details are stored in the accounts table.
- Multiple account holders are represented using account_holders.

### 3. Second Normal Form (2NF)

A table satisfies 2NF when:

- It is already in 1NF.
- There are no partial functional dependencies.

Implementation:

- Customer details depend on customer_id.
- Account details depend on account_id.
- In account_holders, holder_role depends on the complete composite key (account_id, customer_id).

### 4. Third Normal Form (3NF)

A table satisfies 3NF when:

- It is already in 2NF.
- There are no transitive dependencies of non-key attributes on candidate keys.

Implementation:

- Branch details are stored separately.
- Account type details are stored separately.
- Relationship manager details are stored separately.
- Accounts reference these tables through foreign keys.

This avoids repeating branch, account type and manager information in every account record.

### 5. Boyce-Codd Normal Form (BCNF)

A table satisfies BCNF when every determinant is a candidate key.

Under the assumptions documented in this project, each determinant in the designed relations is a candidate key.

Therefore, the proposed schema satisfies BCNF.

### 6. Benefits

- Reduces data duplication.
- Improves data consistency.
- Avoids insertion anomalies.
- Avoids update anomalies.
- Avoids deletion anomalies.
- Maintains referential integrity.
