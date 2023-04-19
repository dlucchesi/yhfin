-- Database: db_yhfin

-- DROP DATABASE IF EXISTS db_yhfin;

CREATE DATABASE db_yhfin
    WITH
    OWNER = usr_yhfin
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



-- Database: db_yhfin_test

-- DROP DATABASE IF EXISTS db_yhfin_test;

CREATE DATABASE db_yhfin_test
    WITH
    OWNER = usr_yhfin
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;