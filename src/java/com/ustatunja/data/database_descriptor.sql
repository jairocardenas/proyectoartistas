/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     18/11/2019 11:57:51 p. m.                    */
/*==============================================================*/


drop table artist;

drop table art_order;

drop table client;

drop table coupon;

drop table coupon_type;

drop table invoice;

drop table payment_status;

drop table product;

drop table product_type;

drop table tracking_status;

drop table tracking_ticket;

/*==============================================================*/
/* Table: artist                                                */
/*==============================================================*/
create table artist (
   idartist             serial               not null,
   display_name         varchar(255)         not null,
   email                varchar(255)         not null,
   paypal_email         varchar(255)         not null,
   password             varchar(50)          not null,
   active               bool                 not null,
   constraint pk_artist primary key (idartist)
);

/*==============================================================*/
/* Table: art_order                                             */
/*==============================================================*/
create table art_order (
   idartorder           serial               not null,
   idartist             int4                 null,
   idclient             int4                 null,
   idproduct            int4                 null,
   active               bool                 not null,
   constraint pk_art_order primary key (idartorder)
);

/*==============================================================*/
/* Table: client                                                */
/*==============================================================*/
create table client (
   idclient             serial               not null,
   first_name           varchar(255)         not null,
   last_name            varchar(255)         not null,
   email                varchar(255)         not null,
   password             varchar(50)          not null,
   active               bool                 not null,
   constraint pk_client primary key (idclient)
);

/*==============================================================*/
/* Table: coupon                                                */
/*==============================================================*/
create table coupon (
   idcoupon             serial               not null,
   idcoupontype         int4                 null,
   coupon_number        varchar(255)         not null,
   expiration_date      date                 not null,
   amount               float8               not null,
   constraint pk_coupon primary key (idcoupon)
);

/*==============================================================*/
/* Table: coupon_type                                           */
/*==============================================================*/
create table coupon_type (
   idcoupontype         serial               not null,
   name                 varchar(255)         not null,
   constraint pk_coupon_type primary key (idcoupontype)
);

/*==============================================================*/
/* Table: invoice                                               */
/*==============================================================*/
create table invoice (
   idinvoice            serial               not null,
   idartorder           int4                 null,
   idcoupon             int4                 null,
   idpaymentstatus      int4                 null,
   date                 date                 not null,
   price                float8               not null,
   constraint pk_invoice primary key (idinvoice)
);

/*==============================================================*/
/* Table: payment_status                                        */
/*==============================================================*/
create table payment_status (
   idpaymentstatus      serial               not null,
   name                 varchar(255)         not null,
   constraint pk_payment_status primary key (idpaymentstatus)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product (
   idproduct            serial               not null,
   idproducttype        int4                 not null,
   title                varchar(255)         not null,
   description          varchar(1000)        not null,
   constraint pk_product primary key (idproduct)
);

/*==============================================================*/
/* Table: product_type                                          */
/*==============================================================*/
create table product_type (
   idproducttype        serial               not null,
   name                 varchar(255)         not null,
   constraint pk_product_type primary key (idproducttype)
);

/*==============================================================*/
/* Table: tracking_status                                       */
/*==============================================================*/
create table tracking_status (
   idtrackingstatus     serial               not null,
   name                 varchar(255)         not null,
   constraint pk_tracking_status primary key (idtrackingstatus)
);

/*==============================================================*/
/* Table: tracking_ticket                                       */
/*==============================================================*/
create table tracking_ticket (
   idtrackingticket     serial               not null,
   date                 date                 not null,
   idtrackingstatus     int4                 not null,
   idartorder           int4                 null,
   constraint pk_tracking_ticket primary key (idtrackingticket)
);

alter table art_order
   add constraint fk_art_orde_reference_artist foreign key (idartist)
      references artist (idartist)
      on delete restrict on update restrict;

alter table art_order
   add constraint fk_art_orde_reference_client foreign key (idclient)
      references client (idclient)
      on delete cascade on update restrict;

alter table art_order
   add constraint fk_art_orde_reference_product foreign key (idproduct)
      references product (idproduct)
      on delete cascade on update restrict;

alter table coupon
   add constraint fk_coupon_reference_coupon_t foreign key (idcoupontype)
      references coupon_type (idcoupontype)
      on delete cascade on update restrict;

alter table invoice
   add constraint fk_invoice_reference_art_orde foreign key (idartorder)
      references art_order (idartorder)
      on delete cascade on update restrict;

alter table invoice
   add constraint fk_invoice_reference_coupon foreign key (idcoupon)
      references coupon (idcoupon)
      on delete cascade on update restrict;

alter table invoice
   add constraint fk_invoice_reference_payment_ foreign key (idpaymentstatus)
      references payment_status (idpaymentstatus)
      on delete cascade on update restrict;

alter table product
   add constraint fk_product_reference_product_ foreign key (idproducttype)
      references product_type (idproducttype)
      on delete cascade on update restrict;

alter table tracking_ticket
   add constraint fk_tracking_reference_tracking foreign key (idtrackingstatus)
      references tracking_status (idtrackingstatus)
      on delete cascade on update restrict;

alter table tracking_ticket
   add constraint fk_tracking_reference_art_orde foreign key (idartorder)
      references art_order (idartorder)
      on delete cascade on update restrict;

