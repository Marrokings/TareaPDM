package sv.ues.fia.sistemaprestamolibro;

public class Area {

	private String idarea;
	private String nombrearea;
	
	
	public Area(){
		
	}
	
	public Area(String idarea,String nombrearea ){
    	this.idarea=idarea;
    	this.nombrearea=nombrearea;
    }

    public String getNombrearea() {
		return nombrearea;
	}

	public void setNombrearea(String nombrearea) {
		this.nombrearea = nombrearea;
	}

	public String getIdarea() {
		return idarea;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	
}

