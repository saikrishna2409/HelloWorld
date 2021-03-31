create database tweet_App_DB;
use tweet_App_DB;
create table user_details(
first_name varchar(60) not null, 
last_name varchar(60), 
gender varchar(12) not null,  
email_id varchar(50) not null unique, 
dob date,
user_password varchar(100) not null
);
create table tweet_details(
user_name varchar(60) not null,
tweet varchar(60) not null
);