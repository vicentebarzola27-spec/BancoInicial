# DIAGNÓSTICO DE LA ARQUITECTURA ORIGINAL

## Situación inicial

El sistema bancario original estaba desarrollado en una sola clase denominada `SistemaBancario`.

Esta clase concentraba prácticamente todas las responsabilidades del programa: captura de datos, validación de operaciones, actualización de saldos, almacenamiento de movimientos, presentación de resultados y coordinación del menú.

Aunque el programa podía realizar las operaciones bancarias principales, su organización dificultaba el mantenimiento y la incorporación de nuevas funcionalidades.



## Problemas encontrados

A partir del análisis de la arquitectura original se identificaron los siguientes problemas:

1. **Concentración de responsabilidades:** una sola clase realiza demasiadas tareas, dificultando su comprensión y mantenimiento.

2. **Acoplamiento:** las reglas del negocio dependen directamente de herramientas externas como Scanner y FileWriter.

3. **Dificultad para modificar el almacenamiento:** cambiar el mecanismo de persistencia requiere modificar el código que contiene otras responsabilidades.

4. **Registro de cuentas:** al no existir una separación adecuada de las reglas de negocio, el registro de una nueva cuenta podía reemplazar los datos de la cuenta anterior.

5. **Precisión monetaria:** el uso de double para representar cantidades monetarias puede producir imprecisiones en los cálculos.

## Propuesta de solución

Para solucionar los problemas identificados se realizó una refactorización aplicando Arquitectura Limpia.

La propuesta consiste en dividir el sistema en componentes con responsabilidades específicas, procurando que las reglas del negocio no dependan directamente de las tecnologías externas.

### Capa de dominio

Contiene la clase `CuentaBancaria`, responsable de representar la cuenta y aplicar las reglas relacionadas con su saldo.

Entre sus responsabilidades se encuentran:

- Mantener los datos de la cuenta.
- Validar los montos de las operaciones.
- Realizar depósitos.
- Realizar retiros.
- Evitar retiros superiores al saldo disponible.

Se utiliza `BigDecimal` para representar las cantidades monetarias.

### Capa de aplicación

Contiene las clases:

- `CuentaService`: coordina las operaciones bancarias y administra la cuenta activa.
- `MovimientoRepository`: define el contrato para guardar los movimientos.

La clase `CuentaService` recibe el repositorio mediante su constructor, evitando depender directamente de una implementación concreta de almacenamiento.

### Capa de infraestructura

Contiene la clase `ArchivoMovimientoRepository`, encargada de implementar el contrato `MovimientoRepository`.

Su función es almacenar los movimientos en el archivo `movimientos.txt`.

De esta manera, la aplicación no necesita conocer los detalles internos de cómo se guardan los movimientos.

### Capa de presentación

Contiene la clase `Main`, responsable de interactuar con el usuario mediante la consola.

Sus responsabilidades son:

- Mostrar el menú principal.
- Capturar las opciones del usuario.
- Solicitar los datos necesarios.
- Invocar los métodos de la aplicación.
- Mostrar los resultados y mensajes de error.

## 5. Comparación entre la arquitectura original y la refactorizada

| Aspecto | Arquitectura original | Arquitectura refactorizada |
|---|---|---|
| Organización | Una clase concentra las responsabilidades. | Responsabilidades separadas por capas. |
| Reglas del negocio | Mezcladas con la interacción. | Ubicadas en el dominio. |
| Coordinación | Realizada por la clase principal. | Realizada por CuentaService. |
| Persistencia | Dependencia directa de FileWriter. | Implementación mediante un contrato. |
| Presentación | Mezclada con la lógica bancaria. | Separada en Main. |
| Mantenimiento | Más difícil de modificar. | Más sencillo de mantener y ampliar. |
| Operaciones monetarias | Uso de double en el programa original. | Uso de BigDecimal. |


## 7. Conclusión

Logramos identificar que el principal problema era la concentración de responsabilidades en una sola clase.

Al aplicar Arquitectura Limpia, el sistema pasó a organizarse en componentes independientes, donde cada uno cumple una función específica.

Esta refactorización no solamente mejora la estructura del código, sino que también facilita comprender cómo funciona el sistema, realizar modificaciones y agregar nuevas funcionalidades sin afectar directamente las reglas principales del negocio.