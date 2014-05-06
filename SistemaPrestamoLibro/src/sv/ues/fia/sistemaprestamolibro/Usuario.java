package sv.ues.fia.sistemaprestamolibro;

public class Usuario {

	private char carnet;
	private String nombAlum;
	private String apelAlum;
	private String direccion;
	private String telefono;
	public Usuario(){
		
	}
	
	public Usuario(char carnet, String nombAlum, String apelAlum, String direccion, String telefono ){
    	this.carnet = carnet;
		this.nombAlum=nombAlum;
    	this.apelAlum = apelAlum;
    	this.direccion = direccion;
    	this.telefono = telefono;
    }

    public char getCarnet() {
		return carnet;
	}

	public void setCarnet(char carnet ) {
		this.carnet = carnet;
	}

	public String getNombAlum() {
		return nombAlum;
	}

	public void setNombAlum(String nombAlum) {
		this.nombAlum = nombAlum;
	}
	
	public String getApelAlum() {
		return apelAlum;
	}

	public void setApelAlum(String apelAlum) {
		this.apelAlum = apelAlum;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
