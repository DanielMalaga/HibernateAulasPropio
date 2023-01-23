package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenador")
public class Ordenador implements Serializable {

	// atributos
	@Id
	@Column(name = "ordenador_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String marca;
	private int anno;
	private String tipo;
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	// constructor
	public Ordenador() {
		super();
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
