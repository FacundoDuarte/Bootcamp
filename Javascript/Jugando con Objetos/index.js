var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];
// ¿Cómo harías print/log de la edad de John?
console.log("La edad de John es: "+ users[1].age);
// ¿Cómo harías print/log del nombre del primer objeto?
console.log("El nombre del primer objeto es: "+ users[0].name);
// ¿Cómo harías print/log del nombre y la edad de cada usuario utilizando un for loop? Tu output debería verse algo como esto
/*
Michael - 37
John - 30
David - 27 
*/
users.forEach(user => {
    console.log(user.name + " - " + user.age) ;
})
// ¿Cómo harías para imprimir el nombre de los mayores de edad?
users.forEach(user => {
    if(user.age > 18){
        console.log(user.name);
    }
})