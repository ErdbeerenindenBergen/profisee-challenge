BEGIN TRANSACTION;

DROP TABLE IF EXISTS bespoked_user, quarterly_bonus, discount, sale, product, customer, employee;
DROP SEQUENCE IF EXISTS seq_user_id, seq_product_id, seq_discount_id, seq_customer_id, seq_employee_id, seq_sale_id, seq_quarterly_bonus_id;

CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;

CREATE TABLE bespoked_user(
    user_id int NOT NULL DEFAULT nextval('seq_user_id'::regclass),
    username VARCHAR(50) NOT NULL,
    password_hash VARCHAR(200) NOT NULL,
    user_role VARCHAR(20) NOT NULL,
    CONSTRAINT PK_bespoked_user PRIMARY KEY (user_id),
    CONSTRAINT UQ_username UNIQUE (username)
);

CREATE SEQUENCE seq_product_id
    INCREMENT BY 1
    START WITH 4001
    NO MAXVALUE;

CREATE TABLE product
(
    product_id int NOT NULL DEFAULT nextval('seq_product_id'::regclass),
    product_name character varying(100) NOT NULL,
    manufacturer character varying(100) NOT NULL,
    product_style character varying(50),
    purchase_price numeric NOT NULL,
    sale_price numeric,
    qty_on_hand integer NOT NULL,
    commission_percent numeric NOT NULL,
    upc_code bigint NOT NULL,
    CONSTRAINT "PK_product" PRIMARY KEY (product_id),
    CONSTRAINT "UQ_upc_code" UNIQUE (upc_code)
);

CREATE SEQUENCE seq_discount_id
    INCREMENT BY 1
    START WITH 5001
    NO MAXVALUE;

CREATE TABLE discount
(
    discount_id int NOT NULL DEFAULT nextval('seq_discount_id'::regclass),
    product_id integer NOT NULL,
    begin_date date NOT NULL,
    end_date date NOT NULL,
    discount_percentage numeric NOT NULL,
    CONSTRAINT "PK_discount" PRIMARY KEY (discount_id),
    CONSTRAINT "FK_discount_product" FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);

CREATE SEQUENCE seq_customer_id
    INCREMENT BY 1
    START WITH 6001
    NO MAXVALUE;

CREATE TABLE customer
(
    customer_id int NOT NULL DEFAULT nextval('seq_customer_id'::regclass),
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    street_address character varying(100) NOT NULL,
    town character varying(60) NOT NULL,
    customer_state character varying(2) NOT NULL,
    zip_code integer NOT NULL,
    phone bigint NOT NULL,
    email_address character varying(254) NOT NULL,
    start_date date NOT NULL,
    CONSTRAINT "PK_customer" PRIMARY KEY (customer_id),
    CHECK (zip_code BETWEEN 0 AND 99999)
);

CREATE SEQUENCE seq_employee_id
    INCREMENT BY 1
    START WITH 7001
    NO MAXVALUE;

CREATE TABLE employee
(
    employee_id int NOT NULL DEFAULT nextval('seq_employee_id'::regclass),
    id_of_manager integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    street_address character varying(100) NOT NULL,
    town character varying(60) NOT NULL,
    employee_state character varying(2) NOT NULL,
    zip_code integer NOT NULL,
    phone bigint NOT NULL,
    email_address character varying(254) NOT NULL,
    start_date date NOT NULL,
    termination_date date,
    CONSTRAINT "PK_employee" PRIMARY KEY (employee_id),
	CONSTRAINT "FK_employee_employee" FOREIGN KEY (id_of_manager)
		REFERENCES employee (employee_id)
);

CREATE SEQUENCE seq_sale_id
    INCREMENT BY 1
    START WITH 8001
    NO MAXVALUE;

CREATE TABLE sale
(
    sale_id int NOT NULL DEFAULT nextval('seq_sale_id'::regclass),
    product_id integer NOT NULL,
    salesperson_id integer NOT NULL,
    customer_id integer NOT NULL,
    sale_date date NOT NULL,
    CONSTRAINT "PK_sale" PRIMARY KEY (sale_id),
    CONSTRAINT "FK_sale_product" FOREIGN KEY (product_id)
        REFERENCES product (product_id),
    CONSTRAINT "FK_sale_employee" FOREIGN KEY (salesperson_id)
        REFERENCES employee (employee_id),
    CONSTRAINT "FK_sale_customer" FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);

CREATE SEQUENCE seq_quarterly_bonus_id
    INCREMENT BY 1
    START WITH 9001
    NO MAXVALUE;

CREATE TABLE quarterly_bonus
(
    quarterly_bonus_id int NOT NULL DEFAULT nextval('seq_quarterly_bonus_id'::regclass),
    salesperson_id integer NOT NULL,
    bonus_year integer NOT NULL,
    quarter integer NOT NULL,
    amount numeric NOT NULL,
    CONSTRAINT "PK_quarterly_bonus" PRIMARY KEY (quarterly_bonus_id),
    CONSTRAINT "FK_quarterly_bonus_employee" FOREIGN KEY (salesperson_id)
        REFERENCES employee (employee_id),
    CHECK (quarter BETWEEN 1 AND 4),
    CHECK (bonus_year BETWEEN 1800 AND 3000)
);

DROP USER IF EXISTS bespoked_owner;
DROP USER IF EXISTS bespoked_client;

CREATE USER bespoked_owner
WITH PASSWORD 'passwordJokesAboutBeSpokes';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO bespoked_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO bespoked_owner;

CREATE USER bespoked_client
WITH PASSWORD 'passwordToBeDetermined';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO bespoked_client;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO bespoked_client;

COMMIT;