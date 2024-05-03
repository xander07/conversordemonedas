# API de Conversión de Monedas

Esta es una API simple en Java que te permite convertir entre diferentes monedas utilizando tipos de cambio en tiempo real. La API utiliza datos actualizados para proporcionar resultados precisos y fiables.

## Características

- Conversión precisa entre diversas monedas.
- Datos de tipos de cambio actualizados en tiempo real.
- Fácil de integrar en aplicaciones existentes.
- API con interacción por consola.

## Requisitos

- Para utilizar esta API, necesitarás tener instalado Java 17 en tu sistema.
- Se requiere conexión a internet.

## Uso

Ejecute el archivo Principal.java

### Obtener monedas disponibles y escoger moneda origen.

Una vez ejecutado el archivo Principal.java, el sistema te mostrará un mensaje de bienvenida y desplegará una lista de 10 monedas disponibles para utilizar como moneda de origen.
Posterior a la muestra de las 10 primeras opciones, el sistema preguntará si desea ver más opciones, si desea ir atrás (regresar a las opciones anteriores) o si no desea ver más opciones.
Si se escoge la opción ver más monedas el sistema desplegará otras 10 opciones de monedas y realizará la pregunta anterior, esto hasta que se muestren todas las opciones disponibles o el usuario decida no ver más opciones.
Si el usuario decide no ver más opciones, el sistema le preguntará cuál es la moneda a elegir, en este punto puede ingresar la opción 0 para salir del sistema.

### Obtener monedas disponibles y escoger moneda destino.

Una vez escogida la moneda de origen, el sistema mostrará las 10 primeras opciones disponibles, el sistema preguntará si desea ver más opciones, si desea ir atrás (regresar a las opciones anteriores) o si no desea ver más opciones.
Si se escoge la opción ver más monedas el sistema desplegará otras 10 opciones de monedas y realizará la pregunta anterior, esto hasta que se muestren todas las opciones disponibles o el usuario decida no ver más opciones.
Si el usuario decide no ver más opciones, el sistema le preguntará cuál es la moneda a elegir, en este punto puede ingresar la opción 0 para salir del sistema.

## Ingresar cantidad a convertir.

Una vez seleccionada la moneda destino, el sistema preguntará la cantidad de divisas que desea convertir de la moneda origen a la moneda destino.

## Ver resultado de la conversión.

Una vez ingresada la cantidad de divisas a convertir, el sistema mostrará un mensaje con el resultado, mostrará la cantidad de divisas y su moneda origen y su respectivo valor en la moneda destino.

## Ver historial.

Una vez el sistema muestra el resultado de la conversión, el sistema preguntará al usuario si desea realizar otra conversión, en este caso el sistema repetirá la ejecución desde el inicio y conservará el historial de conversiones hechas. Adicionalmente, el sistema preguntará al usuario si desea ver el historial de conversiones hechas, en este caso el sistema mostrará la fecha, hora, moneda origen, cantidad, moneda destino y resultado de las conversiones realizadas por el usuario durante la ejecución del programa y preguntará nuevamente al usuario si desea realizar otra conversión o si desea ver el historial de conversiones. En el caso de que el usuario escoja no realizar más conversiones, el sistema mostrará un mensaje de agradecimiento y dentendrá su ejecución.
