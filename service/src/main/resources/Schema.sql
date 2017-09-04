
    alter table TELEFONO 
        drop 
        foreign key FK2rlspqt0957wwoj9t89potkul;

    drop table if exists TELEFONO;

    drop table if exists USUARIO;

    create table TELEFONO (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        NUMERO varchar(30) not null,
        SALDO double precision not null,
        USUARIO_ID bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table USUARIO (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        APELLIDO varchar(300) not null,
        DOCUMENTO varchar(12) not null,
        EMAIL varchar(500) not null,
        NOMBRE varchar(300) not null,
        TIPO_DOCUMENTO integer not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table TELEFONO 
        add constraint FK2rlspqt0957wwoj9t89potkul 
        foreign key (USUARIO_ID) 
        references USUARIO (ID);
