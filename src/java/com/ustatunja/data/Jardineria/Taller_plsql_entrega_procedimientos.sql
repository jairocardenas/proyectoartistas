/*==============================================================*/ 
/* NUMERO 1*/ 
/*==============================================================*/ 

DECLARE 
v_codigocliente clientes.codigocliente%TYPE := &cdo_cliente;
BEGIN
NOMBRECLIENTES (v_codigocliente);
END;
/


CREATE OR REPLACE PROCEDURE nombreclientes (
    v_codigocliente   clientes.codigocliente%TYPE ) is
    v_nombrecliente   clientes.nombrecliente%TYPE ;
BEGIN
    SELECT
        nombrecliente
    INTO v_nombrecliente
    FROM
        clientes
    WHERE
        codigocliente = v_codigocliente;

    dbms_output.put_line('El nombre del cliente es ' || v_nombrecliente);
END;
/
/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 2*/ 
/*==============================================================*/ 
DECLARE
 v_codigoproducto productos.descripcion%TYPE := '&cod_producto';
 BEGIN
 gamadeproductos(v_codigoproducto);
 END;
 /
 


CREATE OR REPLACE PROCEDURE gamadeproductos(
    v_codigoproducto   productos.codigoproducto%TYPE) IS
    v_nombreproducto   productos.nombre%TYPE;
    v_gamaproducto     productos.gama%TYPE;
BEGIN
    SELECT
        nombre,
        gama
    INTO
        v_nombreproducto,
        v_gamaproducto
    FROM
        productos
    WHERE
        codigoproducto = v_codigoproducto;
    dbms_output.put_line('El nombre del producto es '
                         || v_nombreproducto
                         || ' y su gama es '
                         || v_gamaproducto);
END;
/
/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 3*/ 
/*==============================================================*/ 
DECLARE
v_codigopedido pedidos.codigopedido%TYPE := '&cod_ped';
BEGIN
fechapedido(v_codigopedido);
END;
/
 
 
 
 
 
 SELECT
    e.nombre, e.apellido1
FROM empleados e INNER JOIN oficinas o ON e.codigooficina = o.codigooficina
WHERE o.ciudad = 'Barcelona'


CREATE OR REPLACE PROCEDURE FECHAPEDIDO (
    v_codigopedido   pedidos.codigopedido%TYPE) IS
    v_pedido         pedidos%rowtype;
BEGIN
    SELECT
        *
    INTO v_pedido
    FROM
        pedidos
    WHERE
        codigopedido = v_codigopedido;

    dbms_output.put_line('La fecha de pedido es '|| v_pedido.fechapedido
                         || ', la fecha esperada es '
                         || v_pedido.fechaesperada
                         || ', la fecha de entrega es '
                         || v_pedido.fechaentrega
                         || ', el estado es '
                         || v_pedido.estado
                         || ' y los comentarios son: '
                         || v_pedido.comentarios);

END;
/
/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 4/ 
/*==============================================================*/ 
DECLARE
v_codigocliente clientes.codigocliente%TYPE := '&cod_cliente';
BEGIN
nombrecliente (v_codigocliente);
END;
/

CREATE OR REPLACE PROCEDURE nombrecliente (
    v_codigocliente   clientes.codigocliente%TYPE) IS
    v_nombrecliente   clientes.nombrecliente%TYPE;
BEGIN
    SELECT
        nombrecliente
    INTO v_nombrecliente
    FROM
        clientes
    WHERE
        codigocliente = v_codigocliente;

    dbms_output.put_line('El nombre del cliente es ' || v_nombrecliente);
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('No existe el cliente');
END;
/
/*==============================================================*/ 


/*==============================================================*/ 
/* NUMERO 5/ 
/*==============================================================*/ 
DECLARE
BEGIN
nomcl;
END;
/

CREATE OR REPLACE PROCEDURE nomcl IS 
    CURSOR clientes_sin_pagos_cursor IS
    SELECT nombrecliente FROM clientes WHERE codigocliente NOT IN (SELECT codigocliente FROM pagos);

BEGIN
    FOR registro IN clientes_sin_pagos_cursor LOOP
        dbms_output.put_line(registro.nombrecliente);
    END LOOP;
END;
/
/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 6/ 
/*==============================================================*/ 
DECLARE
BEGIN
clientessinpago;
END;
/

CREATE OR REPLACE PROCEDURE clientessinpago IS
    v_nombrecliente clientes.nombrecliente%TYPE;
    CURSOR clientes_sin_pagos_cursor IS
    SELECT nombrecliente FROM clientes WHERE codigocliente NOT IN (SELECT codigocliente FROM pagos);

BEGIN
    OPEN clientes_sin_pagos_cursor;
    LOOP
        FETCH clientes_sin_pagos_cursor INTO v_nombrecliente;
        EXIT WHEN clientes_sin_pagos_cursor%notfound;
        dbms_output.put_line(v_nombrecliente);
    END LOOP;

    CLOSE clientes_sin_pagos_cursor;
END;
/

/*==============================================================*/ 

/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 7/ 
/*==============================================================*/ 
DECLARE
BEGIN
pediditos;
END;
/

CREATE OR REPLACE PROCEDURE pediditos IS
    v_nombreproducto productos.nombre%TYPE;
    CURSOR productos_sin_pedido_cursor IS
    SELECT DISTINCT nombre INTO v_nombreproducto FROM productos WHERE codigoproducto NOT IN (SELECT codigoproducto FROM detallepedidos);
BEGIN
    OPEN productos_sin_pedido_cursor;
    LOOP
        FETCH productos_sin_pedido_cursor INTO v_nombreproducto;
        EXIT WHEN productos_sin_pedido_cursor%notfound;
        dbms_output.put_line(v_nombreproducto);
    END LOOP;
    CLOSE productos_sin_pedido_cursor;
    EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('No hay productos sin pedidos');
END;
/


/*==============================================================*/ 

/*==============================================================*/ 
/* NUMERO 8/ 
/*==============================================================*/ 
DECLARE
v_gama_producto gamasproductos.gama%TYPE := '&nom_gama';
BEGIN
gamaproducto(v_gama_producto);
END;
/

CREATE OR REPLACE PROCEDURE gamaproducto(
    v_gama_producto gamasproductos.gama%TYPE) IS
    v_producto productos.nombre%TYPE;
    CURSOR productos_gama_cursor IS
    SELECT nombre INTO v_producto FROM productos WHERE UPPER(gama) = UPPER(v_gama_producto);
BEGIN
    OPEN productos_gama_cursor;
    LOOP
        FETCH productos_gama_cursor INTO v_producto;
        EXIT WHEN productos_gama_cursor%notfound;
        dbms_output.put_line(v_producto);
    END LOOP;
    CLOSE productos_gama_cursor;
    EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Esta gama no tiene productos');
END;
/
/*==============================================================*/ 


/*==============================================================*/ 
/* Ejercicio 2: Crear procedimientos almacenados usando 
cursores donde sea necesario que muestren la siguiente información:
/ 
/*==============================================================*/ 

/*1. Muestra la ciudad y el código postal de las oficinas de España.*/
DECLARE BEGIN
    oficinasespaña;
END;
/

CREATE OR REPLACE PROCEDURE oficinasespaña IS
    CURSOR oficina_españa IS
    SELECT
        o.ciudad,
        o.codigopostal
    FROM
        oficinas o
    WHERE
        o.pais = 'España';
BEGIN
    FOR registro IN oficina_españa LOOP
        dbms_output.put_line('Ciudad es: '
                             || registro.ciudad
                             || ' Codigo Postal: '
                             || registro.codigopostal);
    END LOOP;
END;
/
/*==============================================================*/ 

/*2. Mostrar el nombre y cargo de los empleados que no sean directores de oficina.*/
DECLARE BEGIN
    nombrepuestooficina;
END;
/

CREATE OR REPLACE PROCEDURE nombrepuestooficina IS
    CURSOR lista_empleado IS
    SELECT
        e.nombre,
        e.puesto
    FROM
        empleados e
    WHERE
        NOT e.puesto = 'Director Oficina';

BEGIN
    FOR listaempleado IN lista_empleado LOOP
        dbms_output.put_line('Nombre empleado: '
                             || listaempleado.nombre
                             || '==> Cargo empleado:'
                             || listaempleado.puesto);
    END LOOP;
END;
/
/*==============================================================*/ 

/*3. Muestra el nombre del cliente y el nombre de su representante de ventas (si lo tiene).*/
DECLARE BEGIN
    clienteprovedor;
END;
/

CREATE OR REPLACE PROCEDURE clienteprovedor IS
    CURSOR limite_cliente IS
    SELECT
        c.nombrecliente,
        c.nombrecontacto
    FROM
        clientes c;

BEGIN
    FOR listacliente IN limite_cliente LOOP
           dbms_output.put_line('Nombre del cliente : '
                             || listacliente.nombrecliente
                             || '  ==> Nombre del provedor: '
                             || listacliente.nombrecontacto);
    END LOOP;
END;
/
/*==============================================================*/ 



/*4. Nombre de los clientes que hayan hecho un pago en el año dado.*/

CREATE VIEW pagoanio as
SELECT
  p.fechapago, c.nombrecliente, EXTRACT(YEAR FROM p.fechapago) as anio
FROM pagos p INNER JOIN  clientes c ON p.codigocliente = c.codigocliente
ORDER BY p.fechapago ASC;


DECLARE 
v_codigocliente pagoanio.anio%TYPE := '&anio';
BEGIN
clientepago (v_codigocliente);
END;
/

CREATE OR REPLACE PROCEDURE clientepago (
    v_anio pagoanio.anio%TYPE) IS
    CURSOR limite_clientes IS
    SELECT
        p.fechapago,
        p.nombrecliente
    FROM
        pagoanio p
    WHERE
        anio = v_anio;

BEGIN
    FOR listacliente IN limite_clientes LOOP 
	dbms_output.put_line('El nombre del cliente es: '
                                                                  || listacliente.nombrecliente
                                                                  || '   ===> La Fecha de pago es: '
                                                                  || listacliente.fechapago);
    END LOOP;
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Invalid Column');
END;
/
/*==============================================================*/ 


/*5. Los posibles estados de un pedido.*/

DECLARE BEGIN
posibles_estados;
END;
/

CREATE OR REPLACE PROCEDURE posibles_estados IS
    CURSOR limite_estado IS
    SELECT DISTINCT
       p.estado
    FROM
        pedidos p;
        BEGIN
    FOR lista_estado IN limite_estado LOOP
        dbms_output.put_line(lista_estado.estado);
    END LOOP;
END;
/

SELECT
   COUNT( p.estado)
FROM pedidos p
WHERE p.estado = 'Pediente';

UPDATE pedidos 
  SET estado = 'Rechazado'
  WHERE estado ='rechazado';

/*==============================================================*/ 

/*6. Muestra el número de pedido, el nombre del cliente, la fecha de entrega y la fecha requerida
  de los pedidos que no han sido entregados a tiempo.*/

DECLARE 
  BEGIN
    lista_no_entragados_tiempo;
END;
/

CREATE OR REPLACE PROCEDURE lista_no_entragados_tiempo IS
    CURSOR limite_pedidos IS
    SELECT
        p.codigopedido,
        c.nombrecliente,
        p.fechaentrega,
        p.fechaesperada
    FROM
        pedidos    p
        INNER JOIN clientes   c ON p.codigocliente = c.codigocliente
    WHERE
        p.estado = 'Pendiente';

BEGIN
    FOR lista_pedido IN limite_pedidos LOOP
        dbms_output.put_line('Número de pedido: '
                             || lista_pedido.codigopedido
                             || ' Nombre cliente: '
                             || lista_pedido.nombrecliente
                             || ' Fecha de entrega: '||lista_pedido.fechaentrega
                             ||' Fecha esperada: '||lista_pedido.fechaesperada);
    END LOOP;
END;
/

/*==============================================================*/ 

/*7. Muestra el código, nombre y gama de los productos que nunca
 se han pedido (detalle pedidos).*/
 DECLARE BEGIN
    lista_pedido_nunca_vendido;
END;
/
 
CREATE OR REPLACE PROCEDURE lista_pedido_nunca_vendido IS
    CURSOR limite_producto IS
    SELECT
        p.codigoproducto,
        p.nombre,
        g.gama
    FROM
        productos        p
        INNER JOIN gamasproductos   g ON p.gama = g.gama
                                       AND NOT EXISTS (
            SELECT
                d.codigoproducto
            FROM
                detallepedidos d
            WHERE
                d.codigoproducto = p.codigoproducto
        );

BEGIN
    FOR lista_pedido IN limite_producto LOOP
        dbms_output.put_line('Codigo de producto: '
                             || lista_pedido.codigoproducto
                             || ' Nombre Producto'
                             || lista_pedido.nombre
                             ||' Gama producto'
                             || lista_pedido.gama);
    END LOOP;
END;
/
/*==============================================================*/ 

/*8. Muestra el nombre y apellidos de los empleados que trabajan en la ciudad dada*/

DECLARE
    v_nom_ciudad oficinas.ciudad%TYPE := '&nom_ciudad';
BEGIN
    nombre_empleado_ciudad(v_nom_ciudad);
END;
/


CREATE OR REPLACE PROCEDURE nombre_empleado_ciudad (
    v_nom_ciudad oficinas.ciudad%TYPE) IS
    CURSOR limite_ciudad IS
    SELECT
        e.nombre,
        e.apellido1
    FROM
        empleados   e
        INNER JOIN oficinas    o ON e.codigooficina = o.codigooficina
    WHERE
        upper(o.ciudad) = upper('barcelona');

BEGIN
    FOR lista_ciudades IN limite_ciudad LOOP
        dbms_output.put_line('los nombres y apellidos de la ciudad: '
                             || v_nom_ciudad
                             || ' son: '
                             || lista_ciudades.nombre
                             || ' '
                             || lista_ciudades.apellido1);
    END LOOP;
END;
/
/*==============================================================*/ 

SELECT
c.nombrecliente,SUM(p.cantidad)
FROM clientes c INNER JOIN pagos p ON c.codigocliente = p.codigocliente
GROUP BY c.nombrecliente;

SELECT SUM(pg.cantidad)
FROM pagos pg
WHERE pg.codigocliente = '5'
/*==============================================================*/ 

/*9. Mostrar lo que ha pagado cada cliente.*/
DECLARE
    v_codcliente pagos.codigocliente%TYPE := '&codcliente';
BEGIN
    pago_cliente(v_codcliente);
END;
/

CREATE OR REPLACE PROCEDURE pago_cliente (
    v_codcliente pagos.codigocliente%TYPE) IS
    v_cantidad_pago pagos.cantidad%TYPE;
BEGIN
    SELECT
        SUM(pg.cantidad)
    INTO v_cantidad_pago
    FROM
        pagos pg
    WHERE
        pg.codigocliente = v_codcliente;

    dbms_output.put_line('El pago del clienete'
                         || v_codcliente
                         || ' es '
                         || v_cantidad_pago);
END;
/
/*==============================================================*/ 

/*10. Mostrar el código de los pedidos donde se hayan vendido mas de 6 productos.*/

DECLARE BEGIN
    lista_pedido_mayor_seis();
END;
/

CREATE OR REPLACE PROCEDURE lista_pedido_mayor_seis IS
    CURSOR limite_pedido IS
    SELECT
        p.codigopedido
    FROM
        pedidos          p
        INNER JOIN detallepedidos   dp ON p.codigopedido = dp.codigopedido
    GROUP BY
        p.codigopedido
    HAVING
        COUNT(dp.cantidad) >= 6;

BEGIN
    FOR lista_pedido IN limite_pedido LOOP
        dbms_output.put_line('Codigo de pedido: ' || lista_pedido.codigopedido);
    END LOOP;
END;
/
