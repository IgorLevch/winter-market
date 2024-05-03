create table products (id bigserial primary key, title varchar(255), price int);
insert into products (title, price) values
('Milk', 80), ('Bread',25), ('Cheese', 300);


create table users
(
    id  bigserial primary key,
    username varchar(36) not null,
    password varchar(80) not null

);

create table roles
(
    id      bigserial primary key,
    name    varchar(50)  not null

);


create table users_roles

(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)

);

insert into roles (name)
values ('ROLE_USER'),
        ('ROLE_ADMIN');


 insert into users (username, password)
 values('bob', 'ad57366865126e55649ecb23ae1d48887544976efea46a48eb5d85a6eeb4d306'),
        ('john', 'ad57366865126e55649ecb23ae1d48887544976efea46a48eb5d85a6eeb4d306');


  insert into users_roles (user_id, role_id)
  values (1, 1),
          (2, 2);               



