# WholeWorthsGrocery

## Project Description
This application was created as a part of my Certificate IV in Information Technology (Programming) at South Metropolitan TAFE in 2022. This project implements JavaFX using a [Model-view-controller architecture](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller). The GUI elements were created using [SceneBuilder](https://gluonhq.com/products/scene-builder/). The application is run using an optimized Java Runtime Environment with the necessary Java and JavaFX modules.

## Installation
Before running this program, you must have JavaFX-SDK and JavaFX-JMODS installed on your system. The latest version of JavaFX is available here on the official website at [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/).

Your environment variables must be set up for your user profile (not your system).
| Environment variable | Location | Example |
| ---------- | ---------- | ---------- |
| PATH_TO_FX | your JavaFX-SDK lib directory | C:\Users\\[your username]\Documents\javafx-sdk-18.0.2\lib |
| PATH_TO_FX_JMOD | your JavaFX-JMODS root directory | C:\Users\\[your username]\Documents\javafx-jmods-18.0.2 |

You need to run the Compile.bat file to compile the source code, the CreateJRE.bat file to create an optimized version of the Java-JDK and JavaFX-SDK, and the Launch.bat file to launch the generated app\WholeWorthsGrocery.jar file using the custom JRE.

Once CreateJRE.bat is run, this program is able to run independently on any Windows system
as long as you copy the directories "app" and "jre", and Launch.bat
