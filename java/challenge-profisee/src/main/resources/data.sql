BEGIN TRANSACTION;

DROP TABLE IF EXISTS bespoked_user, discount, sale, product, customer, employee;
DROP SEQUENCE IF EXISTS seq_user_id, seq_product_id, seq_discount_id, seq_customer_id, seq_employee_id, seq_sale_id;

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
    CONSTRAINT UQ_email_address UNIQUE (email_address),
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

-- Test Data

INSERT INTO customer (first_name, last_name, street_address, town, customer_state, zip_code, phone, email_address, start_date)
VALUES ('Brittany', 'Weavey', '583 South Street', 'Wilmington', 'KY', 30524, 4475532564, 'brittWeavey@gmail.com', '07/01/2022');
INSERT INTO customer (first_name, last_name, street_address, town, customer_state, zip_code, phone, email_address, start_date)
VALUES ('Mikey', 'Nguyen', '45 Jinkies St.', 'Columbus', 'OH', 43230, 6475836475, 'mikeyknowsbest@gmail.com', '06/30/2022');
INSERT INTO customer (first_name, last_name, street_address, town, customer_state, zip_code, phone, email_address, start_date)
VALUES ('Patty', 'Bentley', '544 Sugar Ln.', 'Clairsey', 'PA', 42203, 2755867965, 'pattybaseball@gmail.com', '06/29/2022');
INSERT INTO customer (first_name, last_name, street_address, town, customer_state, zip_code, phone, email_address, start_date)
VALUES ('Kevin', 'Circey', '700 Hollywood Blvd.', 'Los Angeles', 'CA', 10728, 2933945967, 'kevins2coolforschool@gmail.com', '05/27/2022');
INSERT INTO customer (first_name, last_name, street_address, town, customer_state, zip_code, phone, email_address, start_date)
VALUES ('Jameson', 'Cole', '780 Circle Dr.', 'Fennyville', 'WA', 20778, 1022935647, 'jcolebikes@gmail.com', '04/23/2022');

INSERT INTO product (product_name, manufacturer, product_style, purchase_price, sale_price, qty_on_hand, commission_percent, upc_code)
VALUES ('Hover-1 Instinct Electric Bicycle', 'Hover-1', 'Commuting', 599.99, 999.99, 10, 0.05, 059485637284);
INSERT INTO product (product_name, manufacturer, product_style, purchase_price, sale_price, qty_on_hand, commission_percent, upc_code)
VALUES ('Scooway Electric Bike', 'Scooway', 'Mountain', 799.99, 1099.99, 9, 0.05, 475869122499);
INSERT INTO product (product_name, manufacturer, product_style, purchase_price, sale_price, qty_on_hand, commission_percent, upc_code)
VALUES ('Totgard Electric Bike', 'Totgard', 'Mountain', 319.50, 750.99, 15, 0.10, 773842257322);
INSERT INTO product (product_name, manufacturer, product_style, purchase_price, sale_price, qty_on_hand, commission_percent, upc_code)
VALUES ('Waterproof Folding Mini Bike', 'Sailnovo', 'Portable', 259.99, 489.99, 12, 0.10, 911209634658);

INSERT INTO discount (product_id, begin_date, end_date, discount_percentage)
VALUES (4001, '01/15/2023', '01/15/2023', 0.2);
INSERT INTO discount (product_id, begin_date, end_date, discount_percentage)
VALUES (4002, '01/30/2023', '02/14/2023', 0.15);
INSERT INTO discount (product_id, begin_date, end_date, discount_percentage)
VALUES (4003, '02/07/2023', '02/14/2023', 0.3);

INSERT INTO employee (id_of_manager, first_name, last_name, street_address, town, employee_state, zip_code, phone, email_address, start_date, termination_date)
VALUES (7001, 'Mariano', 'Trejo', '71 Rockwell Dr.', 'Atwater', 'CA', 95301, 1253459999, 'mtrejo@bespokedbikes.com', '04/01/2022', NULL);
INSERT INTO employee (id_of_manager, first_name, last_name, street_address, town, employee_state, zip_code, phone, email_address, start_date, termination_date)
VALUES (7001, 'Asher', 'Christian', '5 Rockaway Ave.', 'Livonia', 'MI', 48150, 7408675309, 'achristian@bespokedbikes.com', '03/01/2022', NULL);
INSERT INTO employee (id_of_manager, first_name, last_name, street_address, town, employee_state, zip_code, phone, email_address, start_date, termination_date)
VALUES (7001, 'Iyla', 'Yu', '750 Country Club Lane', 'Wasilla', 'AK', 99654, 2844855855, 'iyu@bespokedbikes.com', '02/02/2022', '02/20/2023');
INSERT INTO employee (id_of_manager, first_name, last_name, street_address, town, employee_state, zip_code, phone, email_address, start_date, termination_date)
VALUES (7002, 'Karsyn', 'Simmons', 'Edgewater Ave.', 'Hampton', 'VA', 23664, 1095573644, 'ksimmons@bespokedbikes.com', '01/02/2022', NULL);

INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4001, 7001, 6005, '01/02/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4002, 7001, 6004, '01/02/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4003, 7002, 6003, '02/14/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4004, 7002, 6002, '02/13/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4004, 7002, 6001, '11/12/2022');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4003, 7002, 6003, '12/23/2022');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4002, 7002, 6002, '12/24/2022');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4001, 7002, 6001, '12/24/2022');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4001, 7003, 6002, '01/04/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4003, 7003, 6004, '01/05/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4001, 7003, 6001, '01/26/2023');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4002, 7003, 6002, '07/01/2022');
INSERT INTO sale (product_id, salesperson_id, customer_id, sale_date)
VALUES (4004, 7003, 6005, '07/04/2022');

COMMIT;