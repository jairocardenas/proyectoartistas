/*1. Pedir el código de un cliente y retornar el valor total que ha pagado.*/
DECLARE
    v_codigo_cliente   clientes.codigocliente%TYPE := '&cod_cliente';
    v_total            pagos.cantidad%TYPE := 0;
BEGIN
    v_total := total_pago_cliente(v_codigo_cliente);
    dbms_output.put_line('El total del pago es: ' || v_total);
END;
/

CREATE OR REPLACE FUNCTION total_pago_cliente (
    v_codigo_cliente clientes.codigocliente%TYPE
) RETURN NUMBER IS
    v_total pagos.cantidad%TYPE := 0;
BEGIN
    SELECT
        SUM(p.cantidad)
    INTO v_total
    FROM
        clientes   c
        INNER JOIN pagos      p ON c.codigocliente = p.codigocliente
    WHERE
        c.codigocliente = v_codigo_cliente
    GROUP BY
        p.cantidad;

    RETURN v_total;
END;
/
/*==============================================================*/ 

/*2. Pedir el código de un pedido y retornar el número de ítems del detalle del pedido */
DECLARE
    v_codpedido   pedidos.codigopedido%TYPE := '&cod_pedido';
    v_total       pedidos.codigopedido%TYPE := 0;
    
BEGIN
    v_total := item_pedido(v_codpedido);
    dbms_output.put_line('El total de item es: ' || v_total);
END;
/

CREATE OR REPLACE FUNCTION item_pedido (
    v_codpedido pedidos.codigopedido%TYPE
) RETURN NUMBER IS
    v_total pedidos.codigopedido%TYPE := 0;
BEGIN
SELECT
        COUNT(d.codigoproducto)
    INTO v_total
    FROM
        pedidos          p
        INNER JOIN detallepedidos   d ON p.codigopedido = d.codigopedido
    WHERE
        p.codigopedido = v_codpedido;

    RETURN v_total;
END;
/
/*==============================================================*/ 

/*3. Pedir la gama de producto y retornar cuantos productos tiene*/
DECLARE
    v_gama    productos.gama%TYPE := '&nom_gama';
    v_total   productos.gama%TYPE := 0;
BEGIN
    v_total := cuanto_gama(v_gama);
    dbms_output.put_line('El total de productos de la gama'
                         || :v_gama
                         || ' es :'
                         || v_total);
END;
/

CREATE OR REPLACE FUNCTION cuanto_gama (
    v_gama productos.gama%TYPE
) RETURN NUMBER IS
    v_total NUMBER := 0;
BEGIN
    SELECT
        COUNT(p.nombre)
    INTO v_total
    FROM
        gamasproductos   g
        INNER JOIN productos        p ON g.gama = p.gama
    WHERE
        p.gama = 'Herramientas'
    GROUP BY
        p.gama;

    RETURN v_total;
END;
/
/*==============================================================*/ 

/*4. Pedir el código de una oficina y retornar el número de empleados que tiene */
DECLARE
    v_nom_oficina   oficinas.codigooficina%TYPE := '&cod_oficina';
    v_total         NUMBER := 0;
BEGIN
    v_total := num_empleados(v_nom_oficina);
    dbms_output.put_line('El total de empleados es: ' || v_total);
END;
/

CREATE OR REPLACE FUNCTION num_empleados (
    v_nom_oficina oficinas.codigooficina%TYPE
) RETURN NUMBER IS
    v_total NUMBER :=0;
BEGIN
    SELECT
        COUNT(e.codigoempleado)
        INTO v_total
    FROM
        oficinas    o
        INNER JOIN empleados   e ON o.codigooficina = e.codigooficina
    WHERE
        o.codigooficina = v_nom_oficina;

    RETURN v_total;
END;
/
/*==============================================================*/ 

/* */