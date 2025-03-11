# BlogWithAuth

## 📌 Descripción
Realicé una API de autenticación con **JWT**, donde solo los usuarios autenticados pueden subir un blog con **título** y **descripción**.  
Para manejar los blogs desde la terminal, creé un **CLI en Node.js**, disponible en el siguiente repositorio:  
[CLI_BlogWithAuth](https://github.com/mallquidev/CLI_BlogWithAuth)

##Configuración previa
Antes de usar la API, recuerda insertar los roles en la base de datos manualmente:  

SQL
INSERT INTO role(role) VALUES("ROLE_USER");
INSERT INTO role(role) VALUES("ROLE_ADMIN");

##comandos para usar con el cli
onecli set-token 123tokenaqui
onecli listar
onecli crear
onecli eliminar

aun me falta poner editar pero ya estare actualizando
