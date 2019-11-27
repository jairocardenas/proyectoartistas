/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     3/10/2019 5:46:44 p. m.                      */
/*==============================================================*/


alter table clientes
   drop constraint fk_clientes_reference_empleado;

alter table detallepedidos
   drop constraint fk_detallep_reference_pedidos;

alter table detallepedidos
   drop constraint fk_detallep_reference_producto;

alter table empleados
   drop constraint fk_empleado_reference_oficinas;

alter table empleados
   drop constraint fk_empleado_reference_empleado;

alter table pagos
   drop constraint fk_pagos_reference_clientes;

alter table pedidos
   drop constraint fk_pedidos_reference_clientes;

alter table productos
   drop constraint fk_producto_reference_gamaspro;

drop table clientes cascade constraints;

drop table detallepedidos cascade constraints;

drop table empleados cascade constraints;

drop table gamasproductos cascade constraints;

drop table oficinas cascade constraints;

drop table pagos cascade constraints;

drop table pedidos cascade constraints;

drop table productos cascade constraints;

/*==============================================================*/
/* Table: clientes                                              */
/*==============================================================*/
create table clientes (
   codigocliente        number(*,0)           not null,
   nombrecliente        varchar(50),
   nombrecontacto       varchar(30),
   apellidocontacto     varchar(30),
   telefono             varchar(15),
   fax                  varchar(15),
   lineadireccion1      varchar(50),
   lineadireccion2      varchar(50),
   ciudad               varchar(50),
   region               varchar(50),
   pais                 varchar(50),
   codigopostal         varchar(10),
   codigoempleadorepventas     number(*,2),
   limitecredito        number(15,2),
   constraint pk_clientes primary key (codigocliente)
);

/*==============================================================*/
/* Table: detallepedidos                                        */
/*==============================================================*/
create table detallepedidos (
   codigopedido         number(*,0)           not null,
   codigoproducto       varchar(15)          not null,
   cantidad             number(*,0)           not null,
   preciounidad         number(15,2)          not null,
   numerolinea          number(*,0)           not null,
   constraint pk_detallepedidos primary key (codigopedido, codigoproducto)
);

/*==============================================================*/
/* Table: empleados                                             */
/*==============================================================*/
create table empleados (
   codigoempleado       number(*,2)           not null,
   nombre               varchar(50)          not null,
   apellido1            varchar(50)          not null,
   apellido2            varchar(10),
   extension            varchar(100)         not null,
   email                varchar(100)          not null,
   codigooficina        varchar(10),
   codigojefe           number(*,2),
   puesto               varchar(50),
   constraint pk_empleados primary key (codigoempleado)
);

/*==============================================================*/
/* Table: gamasproductos                                        */
/*==============================================================*/
create table gamasproductos (
   gama                 varchar(50)          not null,
   descripciontexto     clob,
   descripcionhtml      clob,
   imagen               blob,
   constraint pk_gamasproductos primary key (gama)
);

/*==============================================================*/
/* Table: oficinas                                              */
/*==============================================================*/
create table oficinas (
   codigooficina        varchar(10)          not null,
   ciudad               varchar(30)          not null,
   pais                 varchar(50)          not null,
   region               varchar(50)          not null,
   codigopostal         varchar(10)          not null,
   telefono             varchar(20)          not null,
   lineadireccion1      varchar(50)          not null,
   lineadireccion2      varchar(50),
   constraint pk_oficinas primary key (codigooficina)
);

/*==============================================================*/
/* Table: pagos                                                 */
/*==============================================================*/
create table pagos (
   codigocliente        number(*,0),
   formapago            varchar(40)          not null,
   idtransaccion        varchar(50)          not null,
   fechapago            date                  not null,
   cantidad             number(15,2)          not null,
   constraint pk_pagos primary key (idtransaccion)
);

/*==============================================================*/
/* Table: pedidos                                               */
/*==============================================================*/
create table pedidos (
   codigopedido         number(*,0)           not null,
   fechapedido          date                  not null,
   fechaesperada        date                  not null,
   fechaentrega         date             default  null,
   estado               varchar(15)          not null,
   comentarios          clob,
   codigocliente        number(*,0),
   constraint pk_pedidos primary key (codigopedido)
);

/*==============================================================*/
/* Table: productos                                             */
/*==============================================================*/
create table productos (
   codigoproducto       varchar(15)          not null,
   nombre               varchar(70)          not null,
   gama                 varchar(50),
   dimensiones          varchar(25),
   proveedor            varchar(50),
   descripcion          clob,
   cantidadenstock      number(*,0)           not null,
   precioventa          number(15,2)          not null,
   precioproveedor      number(15,2)          not null,
   constraint pk_productos primary key (codigoproducto)
);

alter table clientes
   add constraint fk_clientes_reference_empleado foreign key (codigoempleadorepventas)
      references empleados (codigoempleado)
      on delete cascade;

alter table detallepedidos
   add constraint fk_detallep_reference_pedidos foreign key (codigopedido)
      references pedidos (codigopedido)
      on delete cascade;

alter table detallepedidos
   add constraint fk_detallep_reference_producto foreign key (codigoproducto)
      references productos (codigoproducto)
      on delete cascade;

alter table empleados
   add constraint fk_empleado_reference_oficinas foreign key (codigooficina)
      references oficinas (codigooficina)
      on delete cascade;

alter table empleados
   add constraint fk_empleado_reference_empleado foreign key (codigojefe)
      references empleados (codigoempleado)
      on delete cascade;

alter table pagos
   add constraint fk_pagos_reference_clientes foreign key (codigocliente)
      references clientes (codigocliente)
      on delete cascade;

alter table pedidos
   add constraint fk_pedidos_reference_clientes foreign key (codigocliente)
      references clientes (codigocliente)
      on delete cascade;

alter table productos
   add constraint fk_producto_reference_gamaspro foreign key (gama)
      references gamasproductos (gama)
      on delete cascade;

