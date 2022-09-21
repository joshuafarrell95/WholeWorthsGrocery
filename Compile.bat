@echo off
javac --module-path %PATH_TO_FX% --add-modules=javafx.base,javafx.controls,javafx.fxml src\wholeworthsgrocery\*.java -d classes
copy src\wholeworthsgrocery\*.fxml classes\wholeworthsgrocery\*.fxml
pause
