package sv.ues.fia.sistemaprestamolibro;

public class Prestamo {


	private char codPrestamo;
	private char carneAlum;
	private String facultad;
	private char fechaPrest;
	private char fechaDevol;
	private Integer cantPrest;
	private char estado;
	
	public Prestamo(){
		
	}
	
	public Prestamo(char codPrestamo, char carneAlum, String facultad, char fechaPrest, char fechaDevol, 
			Integer cantPrest, char estado){
		
    	this.codPrestamo = codPrestamo;
    	this.carneAlum = carneAlum;
    	this.facultad = facultad;
    	this.fechaPrest = fechaPrest;
    	this.fechaDevol = fechaDevol;
    	this.cantPrest = cantPrest;
    	this.estado = estado;
		
    }

    public char getCodPrestamo() {
		return codPrestamo;
	}

	public void setCodPrestamo(char codPrestamo ) {
		this.codPrestamo = codPrestamo;
	}

	public char getCarneAlum() {
		return carneAlum;
	}
    
	public void setCarnetAlum(char carneAlum){
		this.carneAlum = carneAlum;
	}
	
	public String getFacultad(){
		return facultad;
	}
	
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public char getFechaPrest() {
		return fechaPrest;
	}

	public void setFechaPrest(char fechaPrest) {
		this.fechaPrest = fechaPrest;
	}
	
	public char getFechaDevol() {
		return fechaDevol;
	}

	public void setFechaDevol(char fechaDevol) {
		this.fechaDevol = fechaDevol;
	}

	public Integer getCantPrest() {
		return cantPrest;
	}

	public void setCantPrest(Integer cantPrest) {
		this.cantPrest = cantPrest;
	}
	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
}
