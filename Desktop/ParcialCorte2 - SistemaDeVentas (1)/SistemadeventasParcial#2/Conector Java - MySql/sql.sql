CREATE DATABASE Ventas;

USE Ventas;

/*----------------CREACIÓN DE TABLAS----------------*/

CREATE TABLE Cliente(
  IdCliente int AUTO_INCREMENT NOT NULL,
  Dni varchar(8) NOT NULL,
  Nombres varchar(30) NOT NULL,
  Direccion varchar(30) NOT NULL,
  Estado varchar(1) NOT NULL,

  PRIMARY KEY (IdCliente) 
);

CREATE TABLE Empleado(
  IdEmpleado int AUTO_INCREMENT NOT NULL,
  Dni varchar(8) NOT NULL,
  Nombres varchar(30) NOT NULL,
  Telefono varchar(20) NOT NULL,
  Estado varchar(1) NOT NULL,
  User varchar(8) NOT NULL,
  Clave varchar(200) NOT NULL,

  PRIMARY KEY (IdEmpleado) 
);

CREATE TABLE Producto(
  IdProducto int AUTO_INCREMENT NOT NULL,
  Nombres varchar(30) NOT NULL,
  Precio double NOT NULL,
  Stock int NOT NULL,
  Estado varchar(1) NOT NULL,

  PRIMARY KEY (IdProducto) 
);

CREATE TABLE Ventas(
  IdVentas int AUTO_INCREMENT NOT NULL,
  IdCliente int NOT NULL,
  IdEmpleado int NOT NULL,
  NumeroSerie varchar(20) NOT NULL,
  FechaVentas date NOT NULL,
  Monto double NOT NULL,
  Estado varchar(1) NOT NULL,

  PRIMARY KEY (IdVentas),
  FOREIGN KEY (IdCliente) REFERENCES Cliente (IdCliente),
  FOREIGN KEY (IdEmpleado) REFERENCES Empleado (IdEmpleado)
);

CREATE TABLE Detalle_Ventas(
  IdDetalleVentas int AUTO_INCREMENT NOT NULL,
  IdVentas int NOT NULL,
  IdProducto int NOT NULL,
  Cantidad int NOT NULL,
  PrecioVenta double NOT NULL,

  PRIMARY KEY (IdDetalleVentas,IdVentas,IdProducto),
  FOREIGN KEY (IdVentas) REFERENCES Ventas (IdVentas),
  FOREIGN KEY (IdProducto) REFERENCES Producto (IdProducto)
);


/*----------------INSERCIÓN DE DATOS----------------*/

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
(17, '2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
(20, '4', 'Andres Mendoza', 'Chosica, Lurigancho', '1');

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`,`Clave`) VALUES
(1, '123', 'Pedro Hernandez', '988252459', '1', 'emp01','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM='),
(2, '123', 'Roman Riquelme', '988252459', '1', 'Jo46','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM='),
(3, '123', 'Palermo Suarez', '453536458', '1', 'Em22','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Teclado Logitech 345 Editado', 150, 99, '1'),
(2, 'Mouse Logitech 567', 20, 98, '1'),
(3, 'Laptop Lenovo Ideapad 520', 800, 100, '1'),
(4, 'HeadPhones Sony M333', 500, 98, '1'),
(5, 'Producto Nuevo w', 22, 35, '1');










