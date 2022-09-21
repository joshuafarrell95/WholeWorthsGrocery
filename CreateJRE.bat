@echo off
echo "Creating custom JRE"
jlink --module-path ../jmods;%PATH_TO_FX_JMOD% --add-modules java.base,javafx.base,javafx.controls,javafx.fxml,javafx.graphics --output jre
echo "Creating JAR file"
mkdir app
jar --create --file=app/WholeWorthsGrocery.jar --main-class=wholeworthsgrocery.WholeWorthsGrocery -C classes .
pause
