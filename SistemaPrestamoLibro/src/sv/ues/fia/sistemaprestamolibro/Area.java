package sv.ues.fia.sistemaprestamolibro;

public class Area {

	private String nombrearea;
	private char idarea;
	
	public Area(){
		
	}
	
	public Area(String nombrearea,char idarea ){
    	this.nombrearea=nombrearea;
    	this.idarea=idarea;
    }

    public String getNombrearea() {
		return nombrearea;
	}

	public void setNombrearea(String nombrearea) {
		this.nombrearea = nombrearea;
	}

	public int getIdarea() {
		return idarea;
	}

	public void setIdarea(char idarea) {
		this.idarea = idarea;
	}

	
}

