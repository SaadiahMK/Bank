create schema Finance;

***/Bank Details ***/
create table Bank(
router_number bigint(10) Primary Key,
name varchar(255),
address varchar(255)
);

***/User Details ***/
create table User_Details(
user_id bigint(15) Primary Key,
router_number bigint(10),
first_name varchar(255),
last_name varchar(255),
address varchar(255),
date_of_birth date,
contact bigint(10),
email varchar(255),
account_type varchar(255),
account_number bigint(20),
proof_of_identification varchar(255),
emergency_contact bigint(10),
password varchar(10),
user_type varchar(255),
status varchar(255),
date_time datetime,
FOREIGN KEY (router_number) REFERENCES Bank(router_number)
);

***/Login Details ***/
create table Login_Details(
user_id bigint(15),
password varchar(255),
last_login_time_date datetime,
foreign key(user_id) references user_details(user_id)
);

***/Accounts Details ***/
create table Accounts_Details(
account_number bigint(20) Primary Key,
user_id bigint(15),
account_balance bigint(20),
foreign key(user_id) references user_details(user_id)
);

***/Accounts Deposits ***/
create table Accounts_Deposits(
transaction_ref_id bigint(20) Primary Key,
user_id bigint(15),
account_balance bigint(20),
amount bigint(20),
date_time datetime,
foreign key(user_id) references user_details(user_id)
);

***/Accounts Withdrawals ***/
create table Accounts_Withdrawals(
transaction_ref_id bigint(20) Primary Key,
user_id bigint(15),
account_balance bigint(20),
amount bigint(20),
date_time datetime,
foreign key(user_id) references user_details(user_id)
);

***/Transfer Details ***/
create table Transfer_Details(
transaction_ref_id bigint(20) Primary Key,
router_number bigint(10),
from_account bigint(20),
to_account bigint(20),
amount bigint(20),
transfer_type varchar(255),
date_time datetime,
foreign key(router_number) references Bank(router_number),
foreign key(from_account) references Accounts_Details(account_number),
foreign key(to_account) references Accounts_Details(account_number)
);

