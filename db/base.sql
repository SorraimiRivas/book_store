create database bookstore;

create table customer(
 id_customer int(11) auto_increment primary key not null,
 customer_name varchar(50),
 lastname varchar(50),
 email varchar(50),
 pass varchar (20),
 is_admin int(15)
);

create table shopping_cart (
    id_shopping_cart int(11) auto_increment primary key not null,
    total float,
    id_customer int(11),
    foreign key (id_customer) references customer(id_customer)
);

create table book(
    id_book int(11) auto_increment primary key  not null,
    title varchar(50),
    price_book float,
    img longblob,
    category varchar(10),
    author varchar(50),
    editorial varchar(20)
);

create table item_cart(
    id_item_cart int(11) auto_increment primary key not null,
    quantity int(11),
    subtotal float,
    id_book int(11),
    id_shopping_cart int(11),
    foreign key (id_book) references book(id_book),
    foreign key (id_shopping_cart) references shopping_cart( id_shopping_cart)
);





































