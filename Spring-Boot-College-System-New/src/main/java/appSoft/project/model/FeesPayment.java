package appSoft.project.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FeesPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	private int rollNo;
	private String fullName;
	private String feesType;
	private double amount;
	private String grade;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	private String time;
	private String paidWith;
	
}
