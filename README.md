# Sistema Bancario - Arquitectura Limpia

## 1. Descripción del proyecto

Este proyecto consiste en la refactorización de un sistema bancario desarrollado inicialmente en Java, aplicando los principios de Arquitectura Limpia (Clean Architecture).

El objetivo es separar las responsabilidades del sistema en diferentes capas, evitando que las reglas del negocio dependan directamente de herramientas externas como la entrada por consola o el almacenamiento en archivos.

El sistema permite registrar una cuenta bancaria, realizar depósitos, efectuar retiros, consultar el saldo y almacenar los movimientos realizados.

## 2. Objetivos

- Separar las responsabilidades del sistema mediante capas.
- Aplicar el principio de inversión de dependencias.
- Mantener las reglas del negocio independientes de la infraestructura.
- Evitar el registro de múltiples cuentas cuando ya existe una cuenta activa.
- Utilizar `BigDecimal` para realizar operaciones monetarias.
- Facilitar el mantenimiento, las pruebas y futuras modificaciones del sistema.

## 3. Tecnologías utilizadas

- **Lenguaje:** Java.
- **Gestión del proyecto:** Maven.
- **Entorno de desarrollo:** IntelliJ IDEA.
- **Control de versiones:** Git.
- **Repositorio remoto:** GitHub.
- **Almacenamiento de movimientos:** Archivo de texto.

## 4. Arquitectura del proyecto

El sistema está organizado en las siguientes capas:

| Capa | Responsabilidad |
|---|---|
| Dominio | Contiene las reglas principales y la entidad CuentaBancaria. |
| Aplicación | Coordina las operaciones mediante CuentaService y define el contrato MovimientoRepository. |
| Infraestructura | Implementa el almacenamiento de movimientos en un archivo. |
| Presentación | Gestiona el menú, la entrada de datos y los mensajes al usuario. |

### Estructura de carpetas

```text
BancoInicial/
│
├── src/
│   └── main/
│       └── java/
│           └── pe/
│               └── edu/
│                   └── unsch/
│                       ├── Main.java
│                       │
│                       ├── aplicacion/
│                       │   ├── CuentaService.java
│                       │   └── MovimientoRepository.java
│                       │
│                       ├── dominio/
│                       │   └── CuentaBancaria.java
│                       │
│                       └── infraestructura/
│                           └── ArchivoMovimientoRepository.java
│
├── README.md
├── PRUEBAS.md
├── DIAGNOSTICO.md
├── pom.xml
└── .gitignore
```

## 5. Funcionamiento del sistema

El sistema presenta un menú con cinco opciones:

1. Registrar cuenta.
2. Depositar dinero.
3. Retirar dinero.
4. Consultar saldo.
5. Salir.

Se establece que solamente puede existir una cuenta activa durante la ejecución del programa. Si se intenta registrar otra cuenta, el sistema rechaza la operación.

Asimismo, se validan los montos ingresados para impedir depósitos o retiros con cantidades iguales o menores que cero, y se evita realizar retiros superiores al saldo disponible.

## 6. Persistencia de movimientos

Los movimientos realizados se almacenan en el archivo `movimientos.txt`.

Para ello, la aplicación utiliza el contrato `MovimientoRepository`, mientras que la clase `ArchivoMovimientoRepository` implementa el almacenamiento mediante archivos.

Esta separación permite cambiar posteriormente el mecanismo de almacenamiento sin modificar directamente las reglas del negocio.

**Importante:** el archivo de movimientos conserva un historial de operaciones, pero no recupera automáticamente la cuenta ni su saldo al iniciar nuevamente el programa.

## 7. Ejecución del proyecto

### Requisitos

- Tener instalado Java JDK.
- Tener instalado Maven.
- Contar con IntelliJ IDEA u otro entorno compatible con Java.

### Compilar el proyecto

Desde la carpeta raíz del proyecto, ejecutar:

```bash
mvn clean compile
```

Si la compilación termina correctamente, el proyecto no presenta errores de compilación.

### Ejecutar el sistema

Abrir el proyecto en IntelliJ IDEA y ejecutar la clase `Main.java` mediante el botón de ejecución.

## 8. Documentación complementaria

- **[PRUEBAS.md](PRUEBAS.md):** contiene los casos de prueba funcionales P01–P07 y sus resultados.
- **[DIAGNOSTICO.md](DIAGNOSTICO.md):** presenta el análisis del programa original y la justificación de la refactorización.

## 9. Resultados esperados

Con la aplicación de Arquitectura Limpia se busca conseguir:

- Una mejor organización del código.
- Menor acoplamiento entre las capas.
- Separación entre las reglas del negocio y las herramientas externas.
- Mayor facilidad para realizar modificaciones.
- Mejor capacidad para probar las funcionalidades del sistema.
