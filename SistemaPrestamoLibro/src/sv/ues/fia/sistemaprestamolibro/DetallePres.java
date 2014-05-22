package sv.ues.fia.sistemaprestamolibro;

public class DetallePres {
	
	private String codDoc;
	private String codPrestamo;
	private int numPrestamo;
	private int maxPrest;
	
public DetallePres(){
		
	}

public DetallePres(String codDoc, String codPrestamo, int numPrestamo, int maxPrest) {
	super();
	this.codDoc = codDoc;
	this.codPrestamo = codPrestamo;
	this.numPrestamo = numPrestamo;
	this.maxPrest = maxPrest;
}

public String getCodDoc() {
	return codDoc;
}

public void setCodDoc(String codDoc) {
	this.codDoc = codDoc;
}

public String getCodPrestamo() {
	return codPrestamo;
}

public void setCodPrestamo(String codPrestamo) {
	this.codPrestamo = codPrestamo;
}

public int getNumPrestamo() {
	return numPrestamo;
}

public void setNumPrestamo(int numPrestamo) {
	this.numPrestamo = numPrestamo;
}

public int getMaxPrest() {
	return maxPrest;
}

public void setMaxPrest(int maxPrest) {
	this.maxPrest = maxPrest;
}



}
