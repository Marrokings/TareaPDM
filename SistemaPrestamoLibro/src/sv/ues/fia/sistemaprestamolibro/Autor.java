package sv.ues.fia.sistemaprestamolibro;

public class Autor {

	private String codautor;
	private String nombreautor;
	private String apellidoautor;
	private String paisautor;
	
	
	
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Autor(String codautor, String nombreautor, String apellidoautor,
			String paisautor) {
		super();
		this.codautor = codautor;
		this.nombreautor = nombreautor;
		this.apellidoautor = apellidoautor;
		this.paisautor = paisautor;
	}



	public String getCodautor() {
		return codautor;
	}



	public void setCodautor(String codautor) {
		this.codautor = codautor;
	}



	public String getNombreautor() {
		return nombreautor;
	}



	public void setNombreautor(String nombreautor) {
		this.nombreautor = nombreautor;
	}



	public String getApellidoautor() {
		return apellidoautor;
	}



	public void setApellidoautor(String apellidoautor) {
		this.apellidoautor = apellidoautor;
	}



	public String getPaisautor() {
		return paisautor;
	}



	public void setPaisautor(String paisautor) {
		this.paisautor = paisautor;
	}
	
	
	
}
