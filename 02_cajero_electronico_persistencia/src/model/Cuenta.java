package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	@Column(name="numeroCuenta")
	private int idCuenta;
	private double saldo;
	private String tipoCuenta;
	
} 
