package sv.ues.fia.sistemaprestamolibro;

public class Documento {
	
	private String coddocument;
	private String idarea;
	private String idtipo;
	private String editorial;
	private String nomdocument;
	
	public Documento(){
		  
	  }
		
	public Documento(String coddocument, String idarea, String idtipo,
			String editorial, String nomdocument) {
		super();
		this.coddocument = coddocument;
		this.idarea = idarea;
		this.idtipo = idtipo;
		this.editorial = editorial;
		this.nomdocument = nomdocument;
	}


	public String getCoddocument() {
		return coddocument;
	}

	public void setCoddocument(String coddocument) {
		this.coddocument = coddocument;
	}

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNomdocument() {
		return nomdocument;
	}

	public void setNomdocument(String nomdocument) {
		this.nomdocument = nomdocument;
	}

	
	
}
