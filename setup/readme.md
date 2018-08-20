# How to setup Mora Group Buying

## Prerequisites

MySQL database, this project is developed with MySQL 8.0, other version may work but not tested. 

## Application configuration

First thing you need to get done with is to create an application config `application.yaml`,
its template [application.template](../config/application.yaml.template) is inside the `config` directory, make a copy of it with the suffix `template` removed,
modify datasource settings with your actual MySQL setttings such as username, password, etc.


## Database creation

SQL scripts to create database, tables, test data are placed in the directory `setup/database`.

1. [mgb_create_database_with_root.sql.template](database/mgb_create_database_with_root.sql.template): This is the script to create mgb database and
develop user and grant permissions, just like the `application.template` change the `the_user_name` and `the_password`
to what you like before you use it.
*Some test table and data also included, which should be removed soon.*

1. [mgb_create_table.sql](database/mgb_create_table.sql): Create mgb tables which are required to run mgb.

1. [mgb_test_data.sql](database/mgb_test_data.sql): Insert a few test data for you.

Execute the scripts in the order above is recommended.