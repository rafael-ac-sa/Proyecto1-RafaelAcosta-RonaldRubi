CREATE TABLE IF NOT EXISTS `sucursal` (
  `codSucursal` varchar(20) PRIMARY KEY,
  `telefono` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `encargado` varchar(45) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `suscriptor` (
  `idSuscriptor` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `identificacion` varchar(10) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `region` (
  `codRegion` varchar(20) PRIMARY KEY,
  `encargado` varchar(45) DEFAULT NULL,
  `sucursal_codSucursal` varchar(20) NOT NULL,
  FOREIGN KEY (sucursal_codSucursal) REFERENCES sucursal(codSucursal)
);

CREATE TABLE IF NOT EXISTS `servicio` (
  `codServicio` varchar(20) PRIMARY KEY,
  `fechaInst` varchar(45) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `region_codRegion` varchar(20) NOT NULL,
  `suscriptor_idSuscriptor` varchar(20) NOT NULL,
  `nombre` varchar(64) DEFAULT NULL,
  FOREIGN KEY (region_codRegion) REFERENCES region(codRegion),
  FOREIGN KEY (suscriptor_idSuscriptor) REFERENCES suscriptor(idSuscriptor)
);

CREATE TABLE IF NOT EXISTS `cuadra` (
  `codCuadra` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `region_codRegion` varchar(20) NOT NULL,
  FOREIGN KEY (region_codRegion) REFERENCES region(codRegion)
);

CREATE TABLE IF NOT EXISTS `averia` (
  `codAveria` varchar(20) PRIMARY KEY,
  `descripcion` varchar(150) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `servicio_codServicio` varchar(20) NOT NULL,
  FOREIGN KEY (servicio_codServicio) REFERENCES servicio(codServicio)
);

CREATE TABLE IF NOT EXISTS `estadoaveria` (
  `idEstAveria` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `averia_codAveria` varchar(20) NOT NULL,
  FOREIGN KEY (averia_codAveria) REFERENCES averia(codAveria)
);

CREATE TABLE IF NOT EXISTS `estadoserv` (
  `codEstServ` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `servicio_codServicio` varchar(20) NOT NULL,
  FOREIGN KEY (servicio_codServicio) REFERENCES servicio(codServicio)
);

CREATE TABLE IF NOT EXISTS `instalacion` (
  `idInst` varchar(20) PRIMARY KEY,
  `numConcent` int(11) DEFAULT NULL,
  `cantMetCable` float DEFAULT NULL,
  `instPropia` tinyint(1) DEFAULT NULL,
  `cantTel` int(11) DEFAULT NULL,
  `servicio_codServicio` varchar(20) NOT NULL,
  FOREIGN KEY (servicio_codServicio) REFERENCES servicio(codServicio)
);

CREATE TABLE IF NOT EXISTS `servicioextra` (
  `codServExtra` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `servicio_codServicio` varchar(20) NOT NULL,
  FOREIGN KEY (servicio_codServicio) REFERENCES servicio(codServicio)
);

CREATE TABLE IF NOT EXISTS `tipoaveria` (
  `idTipoAveria` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `averia_codAveria` varchar(20) NOT NULL,
  FOREIGN KEY (averia_codAveria) REFERENCES averia(codAveria)
);

CREATE TABLE IF NOT EXISTS `tipovivienda` (
  `idTipVivienda` varchar(20) PRIMARY KEY,
  `nombre` varchar(45) DEFAULT NULL,
  `servicio_codServicio` varchar(20) NOT NULL,
  FOREIGN KEY (servicio_codServicio) REFERENCES servicio(codServicio)
);

INSERT INTO `averia` (`codAveria`, `descripcion`, `fecha`, `servicio_codServicio`) VALUES
('1', 'No tengo señal', '2012-09-12', '1'),
('2', 'No se ven los canales', '2012-09-13', '2'),
('3', 'La imagen esta borrosa', '2012-09-10', '3'),
('4', 'Error de configuracion', '2012-09-12', '4');

INSERT INTO `cuadra` (`codCuadra`, `nombre`, `region_codRegion`) VALUES
('1', 'Cuadra 1', '1'),
('2', 'Cuadra 1', '2'),
('3', 'Cuadra 1', '3'),
('4', 'Cuadra 1', '4');

INSERT INTO `estadoaveria` (`idEstAveria`, `nombre`, `averia_codAveria`) VALUES
('1', 'Pendiente', '1'),
('2', 'En revision', '2'),
('3', 'Resuelto', '3'),
('4', 'Resuelto', '4');

INSERT INTO `estadoserv` (`codEstServ`, `nombre`, `servicio_codServicio`) VALUES
('1', 'Pendiente', '1'),
('2', 'Activo', '2'),
('3', 'Suspendido', '3'),
('4', 'Activo', '4');

INSERT INTO `instalacion` (`idInst`, `numConcent`, `cantMetCable`, `instPropia`, `cantTel`, `servicio_codServicio`) VALUES
('1', 1, 6.5, 1, 1, '1'),
('2', 2, 8, 0, 2, '2'),
('3', 3, 8.6, 1, 3, '3'),
('4', 4, 10, 1, 1, '4'),
('5', 5, 3, 0, 1, '3'),
('6', 6, 18, 0, 5, '1');

INSERT INTO `region` (`codRegion`, `encargado`, `sucursal_codSucursal`) VALUES
('1', 'Heredia', '1'),
('2', 'Cartago', '1'),
('3', 'Limon', '2'),
('4', 'Alajuela', '2');

INSERT INTO `servicio` (`codServicio`, `fechaInst`, `direccion`, `region_codRegion`, `suscriptor_idSuscriptor`, `nombre`) VALUES
('1', '2012-09-10', 'Contiguo a deposito', '1', '1', 'Cable Digital'),
('2', '2012-09-02', 'Contiguo a pulperia', '2', '3', 'Internet'),
('3', '2012-09-13', 'Contiguo a deposito', '3', '3', 'Red Privada'),
('4', '2012-08-14', 'Contiguo a pulperia', '4', '4', 'Red Publica');

INSERT INTO `servicioextra` (`codServExtra`, `nombre`, `servicio_codServicio`) VALUES
('1', 'Cable Digital', '1'),
('2', 'Internet', '1'),
('3', 'Cable Digital', '2'),
('4', 'Red Privada', '2'),
('5', 'Cable Digital', '3'),
('6', 'Internet', '3'),
('7', 'Cable Digital', '4'),
('8', 'Internet', '4');

INSERT INTO `sucursal` (`codSucursal`, `telefono`, `ciudad`, `direccion`, `encargado`) VALUES
('1', '22602258', 'Heredia', '100m Norte del Estadio', 'Carlos Lopez'),
('2', '22659875', 'San Jose', 'Frente al BN', 'Maria Morales');

INSERT INTO `suscriptor` (`idSuscriptor`, `nombre`, `identificacion`, `telefono`, `direccion`) VALUES
('1', 'Mauren Salazar', '401225416', '86958745', 'Heredia'),
('2', 'Adrian Solano', '65241154', '89574545', 'San Jose'),
('3', 'Gimena Hernandez', '456982525', '26659875', 'San Jose'),
('4', 'Luis Acosta', '50626659', '88755742', 'Heredia, Belen');

INSERT INTO `tipoaveria` (`idTipoAveria`, `nombre`, `averia_codAveria`) VALUES
('1', 'Sin señal', '1'),
('2', 'Problema con canales', '2'),
('3', 'Imagen defectuosa', '3'),
('4', 'Configuracion', '4');

INSERT INTO `tipovivienda` (`idTipVivienda`, `nombre`, `servicio_codServicio`) VALUES
('1', 'Apartamento', '1'),
('2', 'Condominio', '2'),
('3', 'Casa Independiente', '3'),
('4', 'Casa en Grupo', '4');


