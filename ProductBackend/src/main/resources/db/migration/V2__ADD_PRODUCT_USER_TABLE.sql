CREATE TABLE product_user
(
    id  bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id int NOT NULL,
    product_id bigint NOT NULL,
    FOREIGN KEY(product_id) REFERENCES product(id)
 );