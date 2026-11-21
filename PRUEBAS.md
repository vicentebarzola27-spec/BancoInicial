PRUEBAS FUNCIONALES

## Casos de prueba

### P01. Registrar a Ana con S/ 1000

**Objetivo:** verificar que el sistema permita registrar una cuenta bancaria correctamente.
![img_8.png](img_8.png)


### P02. Depositar S/ 200

**Objetivo:** comprobar que el sistema no permita reemplazar una cuenta que ya se encuentra registrada.
![img_9.png](img_9.png)

### P03. Retirar S/ 150

**Objetivo:** verificar que se pueda incrementar el saldo de la cuenta mediante un depósito válido.
![img_10.png](img_10.png)
### P04. Retirar S/ 2000

**Objetivo:** comprobar que el sistema no permita realizar depósitos con cantidades negativas.
![img_11.png](img_11.png)

### P05. Depositar S/ -10

**Objetivo:** comprobar que el sistema permita retirar dinero cuando existe saldo suficiente.
![img_12.png](img_12.png)

### P06. Registrar nueva cuenta sin reiniciar

**Objetivo:** comprobar que el sistema impida retirar una cantidad superior al saldo de la cuenta.
![img_7.png](img_7.png)


### P07. Salir y abrir nuevamente

**Objetivo:** verificar que el sistema muestre correctamente el saldo actualizado de la cuenta.

|![img_6.png](img_6.png)

##  Conclusión

Las pruebas funcionales permiten comprobar que las operaciones principales del sistema se ejecutan de acuerdo con las reglas establecidas.

Se verificó el registro de una cuenta, la restricción de una segunda cuenta, los depósitos válidos y el rechazo de cantidades negativas.

También se contemplaron las pruebas de retiro, saldo insuficiente y consulta de saldo, con el propósito de comprobar que las operaciones no afecten incorrectamente el dinero disponible.

Las pruebas constituyen una evidencia del funcionamiento del sistema y permiten identificar posibles errores antes de considerar finalizada la implementación.