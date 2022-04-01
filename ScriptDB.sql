-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MedioPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedioPago` (
  `idMedioPago` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMedioPago`),
  UNIQUE INDEX `idMedioPago_UNIQUE` (`idMedioPago` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Multiplex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Multiplex` (
  `idMultiplex` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMultiplex`),
  UNIQUE INDEX `idMultiplex_UNIQUE` (`idMultiplex` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  UNIQUE INDEX `Direccion_UNIQUE` (`Direccion` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE INDEX `idRol_UNIQUE` (`idRol` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AccionRol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AccionRol` (
  `idAccionRol` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Rol_idRol` INT NOT NULL,
  PRIMARY KEY (`idAccionRol`),
  UNIQUE INDEX `idAccionRol_UNIQUE` (`idAccionRol` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  INDEX `fk_AccionRol_Rol1_idx` (`Rol_idRol` ASC),
  CONSTRAINT `fk_AccionRol_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comida` (
  `idComida` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Stock` DOUBLE NOT NULL,
  `Multiplex_idMultiplex` INT NOT NULL,
  `UrlImagen` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idComida`),
  UNIQUE INDEX `idComida_UNIQUE` (`idComida` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  INDEX `fk_Comida_Multiplex_idx` (`Multiplex_idMultiplex` ASC),
  CONSTRAINT `fk_Comida_Multiplex`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`Multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `PuntosJungla` DOUBLE NOT NULL,
  `Correo` VARCHAR(60) NOT NULL,
  `HashPsw` VARCHAR(45) NOT NULL,
  `MedioPago_idMedioPago` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC),
  UNIQUE INDEX `Correo_UNIQUE` (`Correo` ASC),
  INDEX `fk_Cliente_MedioPago1_idx` (`MedioPago_idMedioPago` ASC),
  CONSTRAINT `fk_Cliente_MedioPago1`
    FOREIGN KEY (`MedioPago_idMedioPago`)
    REFERENCES `mydb`.`MedioPago` (`idMedioPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sala` (
  `idSala` INT NOT NULL AUTO_INCREMENT,
  `Numero` VARCHAR(45) NOT NULL,
  `Multiplex_idMultiplex` INT NOT NULL,
  PRIMARY KEY (`idSala`),
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC),
  INDEX `fk_Sala_Multiplex1_idx` (`Multiplex_idMultiplex` ASC),
  CONSTRAINT `fk_Sala_Multiplex1`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`Multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Silla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Silla` (
  `idSilla` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(45) NOT NULL,
  `Sala_idSala` INT NOT NULL,
  PRIMARY KEY (`idSilla`),
  UNIQUE INDEX `idSilla_UNIQUE` (`idSilla` ASC),
  INDEX `fk_Silla_Sala1_idx` (`Sala_idSala` ASC),
  CONSTRAINT `fk_Silla_Sala1`
    FOREIGN KEY (`Sala_idSala`)
    REFERENCES `mydb`.`Sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pelicula` (
  `idPelicula` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `ClasificacionEdad` VARCHAR(45) NOT NULL,
  `Duracion` INT NOT NULL,
  `Director` VARCHAR(70) NOT NULL,
  `Sinopsis` VARCHAR(450) NULL,
  `UrlPelicula` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPelicula`),
  UNIQUE INDEX `idPelicula_UNIQUE` (`idPelicula` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(90) NOT NULL,
  `Cedula` VARCHAR(45) NOT NULL,
  `NumTelefono` VARCHAR(45) NOT NULL,
  `Salario` DOUBLE NOT NULL,
  `FechaIngreso` DATE NOT NULL,
  `HashPsw` VARCHAR(100) NOT NULL,
  `Multiplex_idMultiplex` INT NOT NULL,
  `Rol_idRol` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC),
  UNIQUE INDEX `NumTelefono_UNIQUE` (`NumTelefono` ASC),
  INDEX `fk_Empleado_Multiplex1_idx` (`Multiplex_idMultiplex` ASC),
  INDEX `fk_Empleado_Rol1_idx` (`Rol_idRol` ASC),
  CONSTRAINT `fk_Empleado_Multiplex1`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`Multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcion` (
  `idFuncion` INT NOT NULL AUTO_INCREMENT,
  `Horario` DATETIME NOT NULL,
  `Sala_idSala` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  `Pelicula_idPelicula` INT NOT NULL,
  `Duracion` INT NOT NULL,
  PRIMARY KEY (`idFuncion`),
  UNIQUE INDEX `idFuncion_UNIQUE` (`idFuncion` ASC),
  INDEX `fk_Funcion_Sala1_idx` (`Sala_idSala` ASC),
  INDEX `fk_Funcion_Empleado1_idx` (`Empleado_idEmpleado` ASC),
  INDEX `fk_Funcion_Pelicula1_idx` (`Pelicula_idPelicula` ASC),
  CONSTRAINT `fk_Funcion_Sala1`
    FOREIGN KEY (`Sala_idSala`)
    REFERENCES `mydb`.`Sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `mydb`.`Pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SillaFuncion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SillaFuncion` (
  `idSillaFuncion` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(45) NOT NULL DEFAULT 'LIBRE',
  `Silla_idSilla` INT NOT NULL,
  `Funcion_idFuncion` INT NOT NULL,
  PRIMARY KEY (`idSillaFuncion`),
  UNIQUE INDEX `idSillaFuncion_UNIQUE` (`idSillaFuncion` ASC),
  INDEX `fk_SillaFuncion_Silla1_idx` (`Silla_idSilla` ASC),
  INDEX `fk_SillaFuncion_Funcion1_idx` (`Funcion_idFuncion` ASC),
  CONSTRAINT `fk_SillaFuncion_Silla1`
    FOREIGN KEY (`Silla_idSilla`)
    REFERENCES `mydb`.`Silla` (`idSilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SillaFuncion_Funcion1`
    FOREIGN KEY (`Funcion_idFuncion`)
    REFERENCES `mydb`.`Funcion` (`idFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FacturaRapida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FacturaRapida` (
  `idFacturaRapida` INT NOT NULL AUTO_INCREMENT,
  `Total` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idFacturaRapida`),
  UNIQUE INDEX `idFacturaRapida_UNIQUE` (`idFacturaRapida` ASC),
  INDEX `fk_FacturaRapida_Empleado1_idx` (`Empleado_idEmpleado` ASC),
  CONSTRAINT `fk_FacturaRapida_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FacturaCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FacturaCliente` (
  `idFacturaCliente` INT NOT NULL AUTO_INCREMENT,
  `Total` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idFacturaCliente`),
  UNIQUE INDEX `idFacturaCliente_UNIQUE` (`idFacturaCliente` ASC),
  INDEX `fk_FacturaCliente_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_FacturaCliente_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RegistroComida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RegistroComida` (
  `idRegistroComida` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Comida_idComida` INT NOT NULL,
  `FacturaRapida_idFacturaRapida` INT NULL,
  `FacturaCliente_idFacturaCliente` INT NULL,
  PRIMARY KEY (`idRegistroComida`),
  UNIQUE INDEX `idRegistroComida_UNIQUE` (`idRegistroComida` ASC),
  INDEX `fk_RegistroComida_Comida1_idx` (`Comida_idComida` ASC),
  INDEX `fk_RegistroComida_FacturaRapida1_idx` (`FacturaRapida_idFacturaRapida` ASC),
  INDEX `fk_RegistroComida_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_RegistroComida_Comida1`
    FOREIGN KEY (`Comida_idComida`)
    REFERENCES `mydb`.`Comida` (`idComida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroComida_FacturaRapida1`
    FOREIGN KEY (`FacturaRapida_idFacturaRapida`)
    REFERENCES `mydb`.`FacturaRapida` (`idFacturaRapida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroComida_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`FacturaCliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RegistroBoleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RegistroBoleta` (
  `idRegistroBoleta` INT NOT NULL AUTO_INCREMENT,
  `Precio` DOUBLE NOT NULL,
  `Cantidad` VARCHAR(45) NOT NULL,
  `SillaFuncion_idSillaFuncion` INT NOT NULL,
  `FacturaRapida_idFacturaRapida` INT NULL,
  `FacturaCliente_idFacturaCliente` INT NULL,
  PRIMARY KEY (`idRegistroBoleta`),
  UNIQUE INDEX `idRegistroBoleta_UNIQUE` (`idRegistroBoleta` ASC),
  INDEX `fk_RegistroBoleta_SillaFuncion1_idx` (`SillaFuncion_idSillaFuncion` ASC),
  INDEX `fk_RegistroBoleta_FacturaRapida1_idx` (`FacturaRapida_idFacturaRapida` ASC),
  INDEX `fk_RegistroBoleta_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_RegistroBoleta_SillaFuncion1`
    FOREIGN KEY (`SillaFuncion_idSillaFuncion`)
    REFERENCES `mydb`.`SillaFuncion` (`idSillaFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroBoleta_FacturaRapida1`
    FOREIGN KEY (`FacturaRapida_idFacturaRapida`)
    REFERENCES `mydb`.`FacturaRapida` (`idFacturaRapida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroBoleta_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`FacturaCliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CalificacionPelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CalificacionPelicula` (
  `idCalificacionPelicula` INT NOT NULL AUTO_INCREMENT,
  `Calificacion` DOUBLE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Pelicula_idPelicula` INT NOT NULL,
  PRIMARY KEY (`idCalificacionPelicula`),
  UNIQUE INDEX `idCalificacionPelicula_UNIQUE` (`idCalificacionPelicula` ASC),
  INDEX `fk_CalificacionPelicula_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_CalificacionPelicula_Pelicula1_idx` (`Pelicula_idPelicula` ASC),
  CONSTRAINT `fk_CalificacionPelicula_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CalificacionPelicula_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `mydb`.`Pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CalificacionServicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CalificacionServicio` (
  `idCalificacionServicio` INT NOT NULL AUTO_INCREMENT,
  `Calificacion` DOUBLE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `FacturaCliente_idFacturaCliente` INT NOT NULL,
  PRIMARY KEY (`idCalificacionServicio`),
  UNIQUE INDEX `idCalificacionServicio_UNIQUE` (`idCalificacionServicio` ASC),
  INDEX `fk_CalificacionServicio_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_CalificacionServicio_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_CalificacionServicio_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CalificacionServicio_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`FacturaCliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rol` (
  `idRol` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE INDEX `idRol_UNIQUE` (`idRol` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`accionrol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`accionrol` (
  `idAccionRol` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Rol_idRol` INT(11) NOT NULL,
  PRIMARY KEY (`idAccionRol`),
  UNIQUE INDEX `idAccionRol_UNIQUE` (`idAccionRol` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  INDEX `fk_AccionRol_Rol1_idx` (`Rol_idRol` ASC),
  CONSTRAINT `fk_AccionRol_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`mediopago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mediopago` (
  `idMedioPago` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMedioPago`),
  UNIQUE INDEX `idMedioPago_UNIQUE` (`idMedioPago` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `PuntosJungla` DOUBLE NOT NULL,
  `Correo` VARCHAR(60) NOT NULL,
  `HashPsw` VARCHAR(45) NOT NULL,
  `MedioPago_idMedioPago` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC),
  UNIQUE INDEX `Correo_UNIQUE` (`Correo` ASC),
  INDEX `fk_Cliente_MedioPago1_idx` (`MedioPago_idMedioPago` ASC),
  CONSTRAINT `fk_Cliente_MedioPago1`
    FOREIGN KEY (`MedioPago_idMedioPago`)
    REFERENCES `mydb`.`mediopago` (`idMedioPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pelicula` (
  `idPelicula` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `ClasificacionEdad` VARCHAR(45) NOT NULL,
  `Duracion` INT(11) NOT NULL,
  `Director` VARCHAR(70) NOT NULL,
  `Sinopsis` VARCHAR(450) NULL DEFAULT NULL,
  `UrlPelicula` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPelicula`),
  UNIQUE INDEX `idPelicula_UNIQUE` (`idPelicula` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`calificacionpelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`calificacionpelicula` (
  `idCalificacionPelicula` INT(11) NOT NULL AUTO_INCREMENT,
  `Calificacion` DOUBLE NOT NULL,
  `Cliente_idCliente` INT(11) NOT NULL,
  `Pelicula_idPelicula` INT(11) NOT NULL,
  PRIMARY KEY (`idCalificacionPelicula`),
  UNIQUE INDEX `idCalificacionPelicula_UNIQUE` (`idCalificacionPelicula` ASC),
  INDEX `fk_CalificacionPelicula_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_CalificacionPelicula_Pelicula1_idx` (`Pelicula_idPelicula` ASC),
  CONSTRAINT `fk_CalificacionPelicula_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CalificacionPelicula_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `mydb`.`pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`facturacliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`facturacliente` (
  `idFacturaCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `Total` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Cliente_idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idFacturaCliente`),
  UNIQUE INDEX `idFacturaCliente_UNIQUE` (`idFacturaCliente` ASC),
  INDEX `fk_FacturaCliente_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_FacturaCliente_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`calificacionservicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`calificacionservicio` (
  `idCalificacionServicio` INT(11) NOT NULL AUTO_INCREMENT,
  `Calificacion` DOUBLE NOT NULL,
  `Cliente_idCliente` INT(11) NOT NULL,
  `FacturaCliente_idFacturaCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idCalificacionServicio`),
  UNIQUE INDEX `idCalificacionServicio_UNIQUE` (`idCalificacionServicio` ASC),
  INDEX `fk_CalificacionServicio_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_CalificacionServicio_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_CalificacionServicio_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CalificacionServicio_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`facturacliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`multiplex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`multiplex` (
  `idMultiplex` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMultiplex`),
  UNIQUE INDEX `idMultiplex_UNIQUE` (`idMultiplex` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  UNIQUE INDEX `Direccion_UNIQUE` (`Direccion` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`comida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comida` (
  `idComida` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Stock` DOUBLE NOT NULL,
  `Multiplex_idMultiplex` INT(11) NOT NULL,
  `UrlImagen` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idComida`),
  UNIQUE INDEX `idComida_UNIQUE` (`idComida` ASC),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC),
  INDEX `fk_Comida_Multiplex_idx` (`Multiplex_idMultiplex` ASC),
  CONSTRAINT `fk_Comida_Multiplex`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`empleado` (
  `idEmpleado` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(90) NOT NULL,
  `Cedula` VARCHAR(45) NOT NULL,
  `NumTelefono` VARCHAR(45) NOT NULL,
  `Salario` DOUBLE NOT NULL,
  `FechaIngreso` DATE NOT NULL,
  `HashPsw` VARCHAR(100) NOT NULL,
  `Multiplex_idMultiplex` INT(11) NOT NULL,
  `Rol_idRol` INT(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC),
  UNIQUE INDEX `NumTelefono_UNIQUE` (`NumTelefono` ASC),
  INDEX `fk_Empleado_Multiplex1_idx` (`Multiplex_idMultiplex` ASC),
  INDEX `fk_Empleado_Rol1_idx` (`Rol_idRol` ASC),
  CONSTRAINT `fk_Empleado_Multiplex1`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`facturarapida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`facturarapida` (
  `idFacturaRapida` INT(11) NOT NULL AUTO_INCREMENT,
  `Total` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Empleado_idEmpleado` INT(11) NOT NULL,
  PRIMARY KEY (`idFacturaRapida`),
  UNIQUE INDEX `idFacturaRapida_UNIQUE` (`idFacturaRapida` ASC),
  INDEX `fk_FacturaRapida_Empleado1_idx` (`Empleado_idEmpleado` ASC),
  CONSTRAINT `fk_FacturaRapida_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sala` (
  `idSala` INT(11) NOT NULL AUTO_INCREMENT,
  `Numero` VARCHAR(45) NOT NULL,
  `Multiplex_idMultiplex` INT(11) NOT NULL,
  PRIMARY KEY (`idSala`),
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC),
  INDEX `fk_Sala_Multiplex1_idx` (`Multiplex_idMultiplex` ASC),
  CONSTRAINT `fk_Sala_Multiplex1`
    FOREIGN KEY (`Multiplex_idMultiplex`)
    REFERENCES `mydb`.`multiplex` (`idMultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`funcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcion` (
  `idFuncion` INT(11) NOT NULL AUTO_INCREMENT,
  `Horario` DATETIME NOT NULL,
  `Sala_idSala` INT(11) NOT NULL,
  `Empleado_idEmpleado` INT(11) NOT NULL,
  `Pelicula_idPelicula` INT(11) NOT NULL,
  `Duracion` INT(11) NOT NULL,
  PRIMARY KEY (`idFuncion`),
  UNIQUE INDEX `idFuncion_UNIQUE` (`idFuncion` ASC),
  INDEX `fk_Funcion_Sala1_idx` (`Sala_idSala` ASC),
  INDEX `fk_Funcion_Empleado1_idx` (`Empleado_idEmpleado` ASC),
  INDEX `fk_Funcion_Pelicula1_idx` (`Pelicula_idPelicula` ASC),
  CONSTRAINT `fk_Funcion_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `mydb`.`pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Sala1`
    FOREIGN KEY (`Sala_idSala`)
    REFERENCES `mydb`.`sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`silla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`silla` (
  `idSilla` INT(11) NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(45) NOT NULL,
  `Sala_idSala` INT(11) NOT NULL,
  PRIMARY KEY (`idSilla`),
  UNIQUE INDEX `idSilla_UNIQUE` (`idSilla` ASC),
  INDEX `fk_Silla_Sala1_idx` (`Sala_idSala` ASC),
  CONSTRAINT `fk_Silla_Sala1`
    FOREIGN KEY (`Sala_idSala`)
    REFERENCES `mydb`.`sala` (`idSala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`sillafuncion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sillafuncion` (
  `idSillaFuncion` INT(11) NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(45) NOT NULL DEFAULT 'LIBRE',
  `Silla_idSilla` INT(11) NOT NULL,
  `Funcion_idFuncion` INT(11) NOT NULL,
  PRIMARY KEY (`idSillaFuncion`),
  UNIQUE INDEX `idSillaFuncion_UNIQUE` (`idSillaFuncion` ASC),
  INDEX `fk_SillaFuncion_Silla1_idx` (`Silla_idSilla` ASC),
  INDEX `fk_SillaFuncion_Funcion1_idx` (`Funcion_idFuncion` ASC),
  CONSTRAINT `fk_SillaFuncion_Funcion1`
    FOREIGN KEY (`Funcion_idFuncion`)
    REFERENCES `mydb`.`funcion` (`idFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SillaFuncion_Silla1`
    FOREIGN KEY (`Silla_idSilla`)
    REFERENCES `mydb`.`silla` (`idSilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`registroboleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`registroboleta` (
  `idRegistroBoleta` INT(11) NOT NULL AUTO_INCREMENT,
  `Precio` DOUBLE NOT NULL,
  `Cantidad` VARCHAR(45) NOT NULL,
  `SillaFuncion_idSillaFuncion` INT(11) NOT NULL,
  `FacturaRapida_idFacturaRapida` INT(11) NULL DEFAULT NULL,
  `FacturaCliente_idFacturaCliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegistroBoleta`),
  UNIQUE INDEX `idRegistroBoleta_UNIQUE` (`idRegistroBoleta` ASC),
  INDEX `fk_RegistroBoleta_SillaFuncion1_idx` (`SillaFuncion_idSillaFuncion` ASC),
  INDEX `fk_RegistroBoleta_FacturaRapida1_idx` (`FacturaRapida_idFacturaRapida` ASC),
  INDEX `fk_RegistroBoleta_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_RegistroBoleta_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`facturacliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroBoleta_FacturaRapida1`
    FOREIGN KEY (`FacturaRapida_idFacturaRapida`)
    REFERENCES `mydb`.`facturarapida` (`idFacturaRapida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroBoleta_SillaFuncion1`
    FOREIGN KEY (`SillaFuncion_idSillaFuncion`)
    REFERENCES `mydb`.`sillafuncion` (`idSillaFuncion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`registrocomida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`registrocomida` (
  `idRegistroComida` INT(11) NOT NULL AUTO_INCREMENT,
  `Cantidad` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Comida_idComida` INT(11) NOT NULL,
  `FacturaRapida_idFacturaRapida` INT(11) NULL DEFAULT NULL,
  `FacturaCliente_idFacturaCliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegistroComida`),
  UNIQUE INDEX `idRegistroComida_UNIQUE` (`idRegistroComida` ASC),
  INDEX `fk_RegistroComida_Comida1_idx` (`Comida_idComida` ASC),
  INDEX `fk_RegistroComida_FacturaRapida1_idx` (`FacturaRapida_idFacturaRapida` ASC),
  INDEX `fk_RegistroComida_FacturaCliente1_idx` (`FacturaCliente_idFacturaCliente` ASC),
  CONSTRAINT `fk_RegistroComida_Comida1`
    FOREIGN KEY (`Comida_idComida`)
    REFERENCES `mydb`.`comida` (`idComida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroComida_FacturaCliente1`
    FOREIGN KEY (`FacturaCliente_idFacturaCliente`)
    REFERENCES `mydb`.`facturacliente` (`idFacturaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RegistroComida_FacturaRapida1`
    FOREIGN KEY (`FacturaRapida_idFacturaRapida`)
    REFERENCES `mydb`.`facturarapida` (`idFacturaRapida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
