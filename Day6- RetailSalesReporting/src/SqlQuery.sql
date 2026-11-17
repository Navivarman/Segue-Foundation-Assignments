
// Task - 1

1.select
    p.product_id,
    p.product_name,
    sum(oi.quantity * oi.unit_price) as total_revenue
from products p
join order_items oi
    on p.product_id = oi.product_id
group by p.product_id, p.product_name
order by total_revenue desc
limit 5;



2.select
    date_format(o.order_date, '%M %Y') as sales_month,
    round(sum(oi.quantity * oi.unit_price), 2) as total_sales
from orders o
join order_items oi
    on o.order_id = oi.order_id
group by
    year(o.order_date),
    month(o.order_date)
order by
    year(o.order_date),
    month(o.order_date);


3.select
    c.customer_id,
    c.customer_name,
    count(o.order_id) as total_orders
from customers c
join orders o
    on c.customer_id = o.customer_id
group by
    c.customer_id,
    c.customer_name
having count(o.order_id) > 3;



4.select
    city,
    round(avg(order_total), 2) as avg_basket_value
from (
    select
        c.city,
        o.order_id,
        sum(oi.quantity * oi.unit_price) as order_total
    from customers c
    join orders o
        on c.customer_id = o.customer_id
    join order_items oi
        on o.order_id = oi.order_id
    group by
        c.city,
        o.order_id
) as order_summary
group by city
order by avg_basket_value desc;



5.select
    o.order_id,
    o.customer_id,
    o.order_date
from orders o
left join payments p
    on o.order_id = p.order_id
where p.payment_id is null;



6.select
    c.customer_id,
    c.customer_name,
    c.city
from customers c
left join orders o
    on c.customer_id = o.customer_id
where o.order_id is null;



7.select
    p.category,
    sum(oi.quantity * oi.unit_price) as category_revenue,
    round(
        sum(oi.quantity * oi.unit_price) /
        (select sum(quantity * unit_price)
         from order_items) * 100,
        2
    ) as revenue_share_percentage
from products p
join order_items oi
    on p.product_id = oi.product_id
group by p.category
order by category_revenue desc;



8.select
    o.order_date,
    round(sum(oi.quantity * oi.unit_price), 2) as daily_sales
from orders o
join order_items oi
    on o.order_id = oi.order_id
group by o.order_date
order by daily_sales desc
limit 1;

// Task-2

-- 1. UPPER()
-- Convert customer names into uppercase
select
    customer_id,
    upper(customer_name) as customer_name
from customers;

-- 2. CONCAT()
-- Combine customer name and city
select
    concat(customer_name, ' - ', city) as customer_details
from customers;

-- 3. DATEDIFF()
-- Calculate the number of days since each order
select
    order_id,
    order_date,
    datediff(curdate(), order_date) as days_since_order
from orders;

-- 4. DATE_FORMAT()
-- Display order date in a customer-friendly format
select
    order_id,
    date_format(order_date, '%d-%m-%Y') as formatted_date
from orders;

-- 5. ROUND()
-- Round product prices to two decimal places
select
    product_name,
    round(price, 2) as rounded_price
from products;

// Task-3

create table null_demo (
    employee_id int primary key,
    employee_name varchar(50),
    salary decimal(10,2),
    bonus decimal(10,2)
);

insert into null_demo values
(1, 'Arun', 30000, 5000),
(2, 'Priya', 40000, null),
(3, 'Karthik', 35000, 3000),
(4, 'Divya', 45000, null),
(5, 'Rahul', 50000, 7000);


select count(*) as total_records from null_demo;
select count(bonus) as available_bonus from null_demo;
select sum(bonus) as total_bonus from null_demo;
select avg(bonus) as average_bonus from null_demo;


// Task - 4
select *
from orders
where customer_id = 1;

select
    customer_id,
    count(order_id) as total_orders
from orders
group by customer_id
having count(order_id) > 3;

select
    customer_id,
    count(order_id) as total_orders
from orders
where year(order_date) = 2026
group by customer_id
having count(order_id) > 1;