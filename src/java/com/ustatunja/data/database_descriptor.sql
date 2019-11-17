
CREATE TABLE client
(

    id         SERIAL       NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(500) NOT NULL,
    active     BOOLEAN      NOT NULL,

    CONSTRAINT client_pk PRIMARY KEY (id)

);

CREATE TABLE artist
(

    id           SERIAL       NOT NULL,
    display_name VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    paypal_email VARCHAR(255) NOT NULL,
    password     VARCHAR(500),
    active       BOOLEAN      NOT NULL,

    CONSTRAINT artist_pk PRIMARY KEY (id)

);

CREATE TABLE product_type
(

    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT product_type_pk PRIMARY KEY (id)

);

CREATE TABLE product
(

    id          SERIAL        NOT NULL,
    title       VARCHAR(255)  NOT NULL,
    description varchar(1000) NULL,
    type        INT           NOT NULL,

    CONSTRAINT product_pk PRIMARY KEY (id),
    CONSTRAINT product_product_type_fk FOREIGN KEY (type) REFERENCES product_type (id)

);

CREATE TABLE coupon_type
(

    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT coupon_type_pk PRIMARY KEY (id)

);

CREATE TABLE coupon
(

    id              SERIAL       NOT NULL,
    coupon_number   VARCHAR(255) NOT NULL,
    expiration_date DATE         NOT NULL,
    amount          DECIMAL      NOT NULL,
    type            INT          NOT NULL,

    CONSTRAINT coupon_pk PRIMARY KEY (id),
    CONSTRAINT coupon_coupon_type_fk FOREIGN KEY (type) REFERENCES coupon_type (id)

);

CREATE TABLE art_order
(

    id      SERIAL  NOT NULL,
    artist  INT     NOT NULL,
    client  INT     NOT NULL,
    product INT     NOT NULL,
    active  BOOLEAN NOT NULL,

    CONSTRAINT art_order_pk PRIMARY KEY (id),
    CONSTRAINT art_order_artist FOREIGN KEY (artist) REFERENCES artist (id),
    CONSTRAINT art_order_client FOREIGN KEY (client) REFERENCES client (id),
    CONSTRAINT art_order_product FOREIGN KEY (product) REFERENCES product (id)

);

CREATE TABLE payment_status
(

    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT payment_status_pk PRIMARY KEY (id)

);

CREATE TABLE invoice
(

    id             SERIAL  NOT NULL,
    date           DATE    NOT NULL,
    payment_status INT     NOT NULL,
    price          DECIMAL NOT NULL,
    art_order      INT     NOT NULL,
    coupon         INT     NULL,

    CONSTRAINT invoice_pk PRIMARY KEY (id),
    CONSTRAINT invoice_payment_status_fk FOREIGN KEY (payment_status) REFERENCES payment_status (id),
    CONSTRAINT invoice_art_order_fk FOREIGN KEY (art_order) REFERENCES art_order (id),
    CONSTRAINT invoice_coupon FOREIGN KEY (coupon) REFERENCES coupon (id)

);

CREATE TABLE tracking_status
(

    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT tracking_status_pk PRIMARY KEY (id)

);

CREATE TABLE tracking_ticket
(

    id        SERIAL NOT NULL,
    date      DATE   NOT NULL,
    status    INT    NOT NULL,
    art_order INT    NOT NULL,

    CONSTRAINT tracking_ticket_pk PRIMARY KEY (id),
    CONSTRAINT tracking_ticket_tracking_status_fk FOREIGN KEY (status) REFERENCES tracking_status (id),
    CONSTRAINT tracking_ticket_art_order FOREIGN KEY (art_order) REFERENCES art_order (id)

);