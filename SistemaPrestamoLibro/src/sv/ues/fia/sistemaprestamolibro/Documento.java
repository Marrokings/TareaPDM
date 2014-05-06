package sv.ues.fia.sistemaprestamolibro;

public class Documento {
	
	private char coddocument;
	private char idarea;
	private String nomdocument;
	private String editorial;
	
	 public Documento(){
		  
	  }
	
	public Documento(char coddocument, char idarea, String nomdocument,
			String editorial) {
		super();
		this.coddocument = coddocument;
		this.idarea = idarea;
		this.nomdocument = nomdocument;
		this.editorial = editorial;
	}


	public char getCoddocument() {
		return coddocument;
	}



	public void setCoddocument(char coddocument) {
		this.coddocument = coddocument;
	}



	public char getIdarea() {
		return idarea;
	}



	public void setIdarea(char idarea) {
		this.idarea = idarea;
	}



	public String getNomdocument() {
		return nomdocument;
	}



	public void setNomdocument(String nomdocument) {
		this.nomdocument = nomdocument;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	

  
}
