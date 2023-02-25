-- Test Data

BEGIN TRANSACTION;

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