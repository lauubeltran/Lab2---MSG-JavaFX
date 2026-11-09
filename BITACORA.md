# Bitácora — Laboratorio 2

## Equipo
| Rol | Nombre | Usuario de GitHub |
|---|---|---|
| Integrador | Laura Beltran | lauubeltran |
| Controlador | Ximena Lozano | chimena777 |
| Formato y estilo | Juan Papa | Papitas-Chipzhp |
| Vista | Youbry Camilo Mendoza | camilomendoza527-sketch |

## Contrato

| Elemento | Valor acordado | Lo usan |
|---|---|---|
| Archivo de la vista | `infrastructure/ui/funds-view.fxml`, en `src/main/resources/co/edu/unillanos/msg` | Vista, Integrador |
| Controlador declarado en la vista | `fx:controller="co.edu.unillanos.msg.infrastructure.ui.FundsController"` | Vista, Controlador |
| Etiqueta del total | Un `Label` con `fx:id="totalLabel"` | Vista, Controlador |
| Acción del botón | `onAction="#onEstimate"` | Vista, Controlador |
| Constructor del controlador | `FundsController(EstimateFundsForWeek estimateFunds)` | Controlador, Integrador |
| Formato del dinero | `MoneyFormat.format(double)` devuelve, por ejemplo, `"$ 1160.00"` | Formato y estilo, Controlador |
| Hoja de estilos | `funds-view.css`, con las clases `title` y `total` | Vista, Formato y estilo |

## Parte C — Guion de aceptación

| Paso | Acción | Resultado esperado | Resultado obtenido |
|---|---|---|---|
| 1 | `mvn javafx:run` | Abre la ventana con el título, el botón y la etiqueta vacía | Cumple: abre la ventana con título, botón «Calcular fondos» y etiqueta vacía |
| 2 | Ejecutar `Launcher` desde el IDE | Abre la misma ventana | Cumple: abre la misma ventana sin errores de runtime |
| 3 | Pulsar **Calcular fondos** | La etiqueta muestra `$ 1160.00` | Cumple: la etiqueta muestra `$ 1160.00` |
| 4 | Ejecutar `Main` desde el IDE | La consola sigue imprimiendo `1160.00` | Cumple: la consola imprime `1160.00` |
| 5 | `git diff --stat base main -- src/main/java/co/edu/unillanos/msg/domain src/main/java/co/edu/unillanos/msg/application` | No imprime nada: el núcleo no cambió | Cumple: salida vacía (el núcleo `domain` y `application` no cambió respecto a la solución base de Lab 1) |
| 6 | Abrir `FundsController` | No hay `new` de casos de uso ni de repositorios, ni `52`, ni `0.28` | Cumple: recibe `EstimateFundsForWeek` por constructor y delega el formato a `MoneyFormat` |

## Lo que realmente cambió

Respecto a la solución base del Laboratorio 1, **ningún archivo de `domain` ni de `application` tuvo que modificarse** para agregar la interfaz gráfica JavaFX, coincidiendo exactamente con la predicción **D6** (lista vacía). Únicamente se agregaron piezas en la capa externa (`infrastructure.ui`, `App`, `Launcher` y configuración en `pom.xml`).
