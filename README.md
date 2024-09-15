# Pasos para que todo vaya bien:
1)Extraer los datos del gitHub o del archivo .zip
2)Tener el tomcat bien configurado.
3) En phpmyadmin en mysql se debe crear una base de datos con el nombre de coworking.
4) Realizar la conexion con el driver mysqlconnector 8.0.17 en java netbeans 
5) Despues de hacer la clase de las reservas, en este caso la llame ClassUser, se debe crear la persistencia llamada 
"CoworkingPU" si no esta creada, con sus respectivos drivers.
6) Enlazar el Jpa controller a la ClassUser(Omita este paso si ya esta esta enlazado).
7) Corra el programa y disfrute :)
