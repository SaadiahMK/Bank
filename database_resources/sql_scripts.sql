
create database bank;

create schema finance; 

/*** Bank Details ***/
create table finance.Bank(
router_number bigint Primary Key,
name varchar(255),
address varchar(255)
);

/*** User Details ***/
create table finance.User_Details(
user_id bigint Primary Key,
router_number bigint,
first_name varchar(255),
last_name varchar(255),
address varchar(255),
date_of_birth date,
contact bigint,
email varchar(255),
account_type varchar(255),
account_number bigint,
proof_of_identification varchar(255),
emergency_contact bigint,
password varchar(10),
user_type varchar(255),
status varchar(255),
date_time timestamp,
FOREIGN KEY (router_number) REFERENCES finance.Bank(router_number)
);
/*** Login Details ***/
create table finance.Login_Details(
user_id bigint,
password varchar(255),
last_login_time_date timestamp,
foreign key(user_id) references finance.user_details(user_id)
);
/*** Account Details ***/
create table finance.Accounts_Details(
account_number bigint Primary Key,
user_id bigint,
account_balance bigint,
foreign key(user_id) references finance.user_details(user_id)
);

/*** Transfer Details ***/
create table finance.Transfer_Details(
transaction_ref_id bigint Primary Key,
router_number bigint,
from_account bigint,
to_account bigint,
amount bigint,
transfer_type varchar(255),
date_time timestamp,
foreign key(router_number) references finance.Bank(router_number),
foreign key(from_account) references finance.Accounts_Details(account_number),
foreign key(to_account) references finance.Accounts_Details(account_number)
);

/*** Bank Details insert record ***/
insert into finance.Bank (Name, Router_Number, Address)
values('TD Bank', 022000097, '21-07 Queens Blvd NY 11373');

insert into finance.Bank(Name, Router_Number, Address)
values('Citi Bank', 032000065, '43-87 Manhattan NY 10003');

insert into finance.Bank(Name, Router_Number, Address)
values('ICIC Bank', 453297450, '32 Madras City Chennai India 438678');

/***  User Detail insert Records ***/
insert into finance.user_details (First_Name, Last_Name, Address, Date_Of_Birth, Contact, Account_Type, Account_Number, Email, 
Proof_Of_Identification, Emergency_Contact, password, user_id, user_type, status, date_time, Router_Number)
values('Ramesh', 'Joseph', '32 Anar Nagar Street Chennai 34000', '1990-02-04', 9669830054, 'Current Account', 
2209258890, 'ramesh88@gamil.com', 'PassPort', 9494002330, 'Brain01!', '9993', 'Client', 'Approve', now(), 453297450); 

***/ Accounts Details insert Records ***/
insert into finance.accounts_details(user_Id, Account_Number, Account_Balance)
values(9993, 2209258890, 5003);

/*** Account Details update ***/
update finance.accounts_details
set account_balance = (select account_balance from finance.transaction_details where user_id = 9993 order by date_time desc limit 1)
where user_id = 9993;
