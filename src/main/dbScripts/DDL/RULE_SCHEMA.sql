-- Database: ruleengine

-- DROP DATABASE ruleengine;

CREATE DATABASE ruleengine
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    

-- CREATE RULES TABLE

-- DROP TABLE RULES;

CREATE TABLE public.rules (
id serial,
lower_boundry timestamp without time zone,
upper_boundry timestamp without time zone,
string_value_type text,
lower_boundry_int numeric,
upper_boundry_int numeric,
CONSTRAINT rules_pkey PRIMARY KEY (id)
) 
 

    