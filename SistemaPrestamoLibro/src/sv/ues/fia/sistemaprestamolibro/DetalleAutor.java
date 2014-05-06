package sv.ues.fia.sistemaprestamolibro;

public class DetalleAutor {
	
	private String codautor;
	private String coddocument;
	private String especializacion;
	
		
	public DetalleAutor() {	}

	public DetalleAutor(String codautor, String coddocument) {
		super();
		this.codautor = codautor;
		this.coddocument = coddocument;
	}
	
	public String getCodautor() {
		return codautor;
	}
	public void setCodautor(String codautor) {
		this.codautor = codautor;
	}
	public String getCoddocument() {
		return coddocument;
	}
	public void setCoddocument(String coddocument) {
		this.coddocument = coddocument;
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
	
}
