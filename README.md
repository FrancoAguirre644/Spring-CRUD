# Spring-CRUD
Especificaciones:<br/>
1-Contara con registros precargados en un archivo .sql <br/>

2-A simple vista parecera que no se puede editar/borrar los registros de la tabla "skill", pero no es asi,se podra hacerlo accediendo 
a las siguientes direcciones:<br/>
http://localhost:8080/skill/new (Para agregar una nueva skill) <br/>
http://localhost:8080/skill/ (Seguido del id de la skill a modificar) <br/>
http://localhost:8080/skill/delete/ (Seguido del id de la skill a eliminar) <br/>

Y en cuanto a Developer:<br/>
http://localhost:8080/crud/new (Para agregar un nuevo developer)  <br/>
http://localhost:8080/crud/ (Seguido del id del developer a modificar)<br/>
http://localhost:8080/crud/delete (Seguido del id del developer a eliminar)<br/>

3-Cabe destacar que no se podra eliminar una skill si la misma esta asociada a un developer.
