package sv.ues.fia.sistemaprestamolibro;

public class TipoDoc {
	
	private String idtipo;
	private String nombretipo;
	
	public TipoDoc(){
		
	}
	
	public TipoDoc(String idtipo, String nombretipo) {
		super();
		this.idtipo = idtipo;
		this.nombretipo = nombretipo;
	}

	public String getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}

	public String getNombretipo() {
		return nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}

}
