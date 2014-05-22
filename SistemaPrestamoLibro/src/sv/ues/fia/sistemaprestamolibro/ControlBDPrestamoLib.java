package sv.ues.fia.sistemaprestamolibro;



import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDPrestamoLib {
	
	private static final String[]camposArea = new String [] 
			{"idarea","nombrearea"}; 
	private static final String[]camposDocum=new String[]
			{"coddoc","idtipo","idarea","nombredoc","editorial"};
	private static final String[]camposDetalleAutor = new String []
			{"coddoc","codautor","especializacion"};
	private static final String[]camposTipoDoc=new String[]
			{"idtipo","nombretipo"};
	private static final String[]camposDetalle = new String[]
			{"coddoc","codprestamo","numprestamo","maxprest"};
	
	 private final Context context; 
	 private DatabaseHelper DBHelper; 
	 private SQLiteDatabase db;
	 
	 public ControlBDPrestamoLib(Context ctx) { 
		 this.context = ctx; 
		 DBHelper = new DatabaseHelper(context);
	}
	 
	 private static class DatabaseHelper extends SQLiteOpenHelper { 
		 
		 private static final String BASE_DATOS = "libroprestamo.s3db"; 
		 private static final int VERSION = 1; 
		 
		 public DatabaseHelper(Context context) { 
		 super(context, BASE_DATOS, null, VERSION); 
		 }
		 
		 @Override 
		 public void onCreate(SQLiteDatabase db) { 
		 try{ 
		 db.execSQL("CREATE TABLE Secretaria (carnetsec VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),direccion VARCHAR(100),telefono VARCHAR(8));");	 
		 db.execSQL("CREATE TABLE Alumno (carnetalum VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),direccion VARCHAR(100),telefono VARCHAR(8));"); 
		 db.execSQL("CREATE TABLE Area (idarea VARCHAR(3) NOT NULL PRIMARY KEY,nombrearea VARCHAR(20));"); 
		 db.execSQL("CREATE TABLE Tipodoc(idtipo VARCHAR(2) NOT NULL PRIMARY KEY,nombretipo VARCHAR(10));"); 
		 db.execSQL("CREATE TABLE Autor  (codautor VARCHAR(4) NOT NULL PRIMARY KEY,nombreautor VARCHAR(25),apellidoautor VARCHAR(25),paisautor VARCHAR(10) );");
		 db.execSQL("CREATE TABLE Penalizacion  (idpenalizacion VARCHAR(4) NOT NULL PRIMARY KEY,tiempoatraso INTEGER,tiempopenalizacion INTEGER,fechafinal DATE);");
		 db.execSQL("CREATE TABLE Prestamo  (codprestamo VARCHAR(6) NOT NULL PRIMARY KEY,idpenalizacion VARCHAR(4) NOT NULL,carnetsec VARCHAR(7) NOT NULL,carnetalum VARCHAR(7) NOT NULL,facultad VARCHAR(50),fechaprest DATE,fechadev DATE,cantidadprest INTEGER,estado VARCHAR(15));");
		 db.execSQL("CREATE TABLE Detalle (coddoc VARCHAR(4) NOT NULL,codprestamo VARCHAR(6) NOT NULL,numprestamo INTEGER,maxprest INTEGER, PRIMARY KEY(coddoc,codprestamo));");
		 db.execSQL("CREATE TABLE Detalleautor (coddoc VARCHAR(4) NOT NULL,codautor VARCHAR(4) NOT NULL,especializacion VARCHAR(25), PRIMARY KEY (coddoc, codautor));");
		 db.execSQL("CREATE TABLE Documento (coddoc VARCHAR(4) NOT NULL PRIMARY KEY,idtipo VARCHAR(2) NOT NULL,idarea VARCHAR(3) NOT NULL,nombredoc VARCHAR(30),editorial VARCHAR(10));");
		 }catch(SQLException e){ 
			 
			 e.printStackTrace(); 
			 } 
			 } 
			 
			 @Override 
			 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
			 // TODO Auto-generated method stub 
			 
			 } 
			 
			 
			 }	
	 public void abrir() throws SQLException{ 
		 db = DBHelper.getWritableDatabase(); 
		 return; 
		 } 
		 
		 public void cerrar(){ 
		 DBHelper.close(); 
		 } 
		/** Metodos de Ingresar,Eliminar,Actualizar,Consultar
		 *  para cada tabla de la BaseDato prestamolibro***************************/
		 
		 public String insertar(Area area){
			 String regInsertados="Registro Insertado Nº= "; 
			 long contador=0; 
			 
			 ContentValues are_a = new ContentValues(); 
			 are_a.put("idarea", area.getIdarea()); 
			 are_a.put("nombrearea", area.getNombrearea()); 
			 contador=db.insert("Area", null, are_a); 
			 
			 if(contador==-1 || contador==0) 
			 { 
			 regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción"; 
			 } 
			 else { 
			 regInsertados=regInsertados+contador; 
			 } 
			 return regInsertados; 
		 }
		 
		 public Area consultarArea(String idarea){
			 String[] id = {idarea}; 
			 Cursor cursor = db.query("Area", camposArea, "idarea = ?", id,	null, null, null); 
			 if(cursor.moveToFirst()){ 
			 Area ar_ea = new Area(); 
			 ar_ea.setIdarea(cursor.getString(0)); 
			 ar_ea.setNombrearea(cursor.getString(1)); 
			 return ar_ea; 
			 }else{ 
			 return null; 
			 }
		 }
		 
		 public String eliminar(Area area){
			 String regAfectados="filas afectadas= "; 
			 int contador=0; 
			 //if (verificarIntegridad(alumno,3)) { 
			// contador+=db.delete("nota", "idarea='"+area.getIdarea()+"'", null); 
			// } 
			 contador+=db.delete("Area", "idarea='"+area.getIdarea()+"'", null); 
			 regAfectados+=contador; 
			 return regAfectados; 
		 }
		 
		 public String actualizar(Area area){
			 
			// if(verificarIntegridad(alumno, 5)){ 
				 String[] id = {area.getIdarea()}; 
				 ContentValues cv = new ContentValues(); 
				 cv.put("idarea", area.getIdarea()); 
				 cv.put("nombrearea", area.getNombrearea()); 
				 db.update("Area", cv, "idarea = ?", id); 
				 return "Actualización Realizada Correctamente"; 
				// }else{ 
				// return "EL codigo de area  " + area.getIdarea() + " no existe"; 
				// }
		 }
		 
		 public String insertar(Documento documento){
			 String regInsertados="Registro Insertado Nº= "; 
			 long contador=0; 
			 
			 ContentValues do_cum = new ContentValues(); 
			 do_cum.put("coddoc",documento.getCoddocument()); 
			 do_cum.put("idtipo", documento.getIdtipo());
			 do_cum.put("idarea", documento.getIdarea());
			 do_cum.put("nombredoc", documento.getNomdocument());
			 do_cum.put("editorial", documento.getEditorial());
			 contador=db.insert("Documento", null, do_cum); 
			 
			 if(contador==-1 || contador==0) 
			 { 
			 regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción"; 
			 } 
			 else { 
			 regInsertados=regInsertados+contador; 
			 } 
			 return regInsertados; 
		 }
		 
		 public Documento consultarDocumento(String coddoc){
			 String[] id = {coddoc}; 
			 Cursor cursor = db.query("Documento", camposDocum, "coddoc = ?", id, null, null, null); 
			 if(cursor.moveToFirst()){ 
			 Documento ar_ea = new Documento(); 
			 ar_ea.setCoddocument(cursor.getString(0));
			 ar_ea.setIdarea(cursor.getString(2));
			 ar_ea.setIdtipo(cursor.getString(1));
			 ar_ea.setNomdocument(cursor.getString(3));
			 ar_ea.setEditorial(cursor.getString(4));
			 return ar_ea; 
			 }else{ 
			 return null; 
			 }
		 }
		 
		 public String eliminar(Documento docum){
			 String regAfectados="filas afectadas= "; 
			 int contador=0; 
			 //if (verificarIntegridad(alumno,3)) { 
			// contador+=db.delete("nota", "idarea='"+area.getIdarea()+"'", null); 
			// } 
			 contador+=db.delete("Documento", "coddoc='"+docum.getCoddocument()+"'", null); 
			 regAfectados+=contador; 
			 return regAfectados; 
		 }
		 
		 public String actualizar(Documento docum){
			 
			// if(verificarIntegridad(alumno, 5)){ 
				 String[] id = {docum.getCoddocument()}; 
				 ContentValues cv = new ContentValues(); 
				 
				 cv.put("coddoc",docum.getCoddocument()); 
				 cv.put("idtipo", docum.getIdtipo());
				 cv.put("idarea", docum.getIdarea());
				 cv.put("nombredoc", docum.getNomdocument());
				 cv.put("editorial", docum.getEditorial());
				  
				 db.update("Documento", cv, "coddoc = ?", id); 
				 return "Actualización Realizada Correctamente"; 
				// }else{ 
				// return "EL codigo de area  " + area.getIdarea() + " no existe"; 
				// }
		 }
		 //parte de Detalle Autor
		 
		 public String insertar(DetalleAutor detalleAutor){
				String regInsertados="Registro Insertado Nº= ";
				long contador=0;
				ContentValues detAutor = new ContentValues();
				detAutor.put("coddoc", detalleAutor.getCoddocument());
				detAutor.put("codautor", (detalleAutor.getCodautor()));
				detAutor.put("especializacion", detalleAutor.getEspecializacion());				
				contador=db.insert("DetalleAutor", null, detAutor);
				if(contador==-1 || contador==0)
				{
				regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
				}
				else {
				regInsertados=regInsertados+contador;
				}
				return regInsertados;
				}
		 
		 public DetalleAutor consultarDetalleAutor(String codautor){
				String[] id = {codautor};
				Cursor cursor = db.query("DetalleAutor", camposDetalleAutor, "codautor = ?", id,
				null, null, null);
				if(cursor.moveToFirst()){
				DetalleAutor DetalleAutor = new DetalleAutor();
				DetalleAutor.setCodautor(cursor.getString(0));
				DetalleAutor.setCoddocument(cursor.getString(1));
				DetalleAutor.setEspecializacion(cursor.getString(2));
				return DetalleAutor;
				}else{
				return null;
				}
				}
		 
		 /****************** parte de TipoDoc *****************/
		 public String insertar(TipoDoc tipodoc){
			 
			 String regInsertados = "Registro N°= ";
			 long contador=0;
			 
			 ContentValues tipo = new ContentValues();
			 tipo.put("idtipo", tipodoc.getIdtipo());
			 tipo.put("nombretipo", tipodoc.getNombretipo());
			 
			 contador=db.insert("Tipodoc", null, tipo);
			 
			 if(contador==-1 || contador==0)
			 {
				 regInsertados="Error al Insertar el Registro, Registro Duplicado. Verificar Inserción";
			 }else{
				 regInsertados=regInsertados+contador;
			 }
			 return regInsertados;
		 }//fin insertar(TipoDoc)
		 
		 public TipoDoc consultarTipo(String idTipo){
			 
			 String[] id={idTipo};
			 Cursor cursor = db.query("Tipodoc",camposTipoDoc,"idtipo=?",id,null,null,null);
			 
			 if(cursor.moveToFirst()){
				 TipoDoc tipo = new TipoDoc();
				 tipo.setIdtipo(cursor.getString(0));
				 tipo.setNombretipo(cursor.getString(1));
				 return tipo;
			 }else{
				 return null;
			 }
		 }//fin consultarTipo
		 
		 public String actualizar(TipoDoc tipo){
			 
			// if(VerificarIntegridad(tipo,5)){
				 String[] id={tipo.getIdtipo()};
				 ContentValues cv=new ContentValues();
				 cv.put("IdTipo", tipo.getIdtipo());
				 cv.put("Nombre Tipo", tipo.getNombretipo());
				 db.update("Tipodoc", cv, "idtipo=?", id);
				 return "Registro Actualizado correctamente";
			/* }else{
				 return "Registro con Id " + tipo.getIdtipo()+" no existe";
			 } */
		 }//fin actualizar(tipoDoc)
		 
		 public String eliminar(TipoDoc tipo){
			 
			 String regAfectados="filas afectadas= ";
			 int contador=0;
			 
			 //if(verificarIntegridad(tipo,3)){
				 //regAfectados="0";
				 //contador+=db.delete("Tipodoc", "idtipo='"+tipo.getIdtipo()+"'", null);
			 //}else{
				 //borrar los registros
				 contador+=db.delete("Tipodoc", "idtipo='"+tipo.getIdtipo()+"'", null);
				 regAfectados+=contador;
			 //}
			 return regAfectados;
		 }
		 
		 
		 /***********************************************************************/
		 /********************** Parte de DetallePrestamo *******************/
		 
		 public String insertar(DetallePres detalle){
			 
			 String regInsertados = "Registro N°= ";
			 long contador=0;
			 
			 ContentValues det = new ContentValues();
			 det.put("coddoc", detalle.getCodDoc());
			 det.put("codprestamo", detalle.getCodPrestamo());
			 det.put("numprestamo", detalle.getNumPrestamo());
			 det.put("maxprest", detalle.getMaxPrest());
			 
			 contador=db.insert("Detalle", null, det);
			 
			 if(contador==-1 || contador==0)
			 {
				 regInsertados="Error al Insertar el Registro, Registro Duplicado. Verificar Inserción";
			 }else{
				 regInsertados=regInsertados+contador;
			 }
			 return regInsertados;
		 }//fin insertar(TipoDoc)
		 
		 public DetallePres consultarDetalle(String codDoc, String codPrestamo){
			 
			 String[] id={codDoc,codPrestamo};
			 Cursor cursor=db.query("Detalle",camposDetalle,"coddoc=? AND codprestamo=?",id,null,null,null);
			 
			 if(cursor.moveToFirst()){
				 DetallePres detalle = new DetallePres();
				 detalle.setCodDoc(cursor.getString(0));
				 detalle.setCodPrestamo(cursor.getString(1));
				 detalle.setNumPrestamo(cursor.getInt(2));
				 detalle.setMaxPrest(cursor.getInt(3));
			 }
			 return null;
		 }
		 
		 public String actualizar(DetallePres detalle){
			 //if(verificarIntegridad(detalle,2)){
				 String[] id={detalle.getCodDoc(),detalle.getCodPrestamo()};
				 ContentValues cv= new ContentValues();
				 cv.put("numprestamo", detalle.getNumPrestamo());
				 cv.put("maxprest", detalle.getMaxPrest());
				 
				 db.update("Detalle", cv, "coddoc=? AND codprestamo=? ", id);
				 return "Registro Actualizado Correctamente";
			/* }else{
				 return "Registro no Existe";
			 }*/
		 }
		 
		 public String eliminar(DetallePres detalle){
			 String regAfectados="filas afectadas= ";
			 int contador=0;
			 String where="coddoc='"+detalle.getCodDoc()+"'";
			 where=where+"AND codprestamo='"+detalle.getCodPrestamo()+"'";
			 contador+=db.delete("Detalle", where, null);
			 regAfectados+=contador;
			 return regAfectados;
		 }
		 /**************************************************************************************/
		 
		    /**Llenando  la base de  **************
		     ************* datos     **************/
		 public String llenarBDPrestamoLib(){ 
			 
			 final String[] VAidarea = {"0BD","PJ1","CM5"}; 
			 final String[] VAnombrearea = {"Base de Datos","Programacion Java","Comunicaciones"}; 
			 //
			 final String[] VDcoddoc = {"0046","0621","0047"}; 
			 final String[] VDidtipo = {"00","00","01"}; 
			 final String[] VDidarea = {"0BD","PJ1","CM5"}; 
			 final String[] VDnombredoc = {"UML","Estructura Dato","Progamacion 2"}; 
			 final String[] VDeditorial = {"Santillana","Barral","Ceiba"}; 
			 
			final String[] VDAcodautor = {"2035","2044","1098"};
			final String[] VDAcoddocument = {"0046","0621","0047"};
			final String[] VDAespecializacion = {"Analisis y Diseño","programacion","redes"};
			
			final String[] VTnombretipo={"libro","revista","cd"};
			final String[] VDcodprestamo={"000001","000002","000451"};
			
				  abrir(); 
				  db.execSQL("DELETE FROM area"); 
				  db.execSQL("DELETE FROM documento"); 
				  db.execSQL("DELETE FROM detalleautor");
				  db.execSQL("DELETE FROM Tipodoc");
				  db.execSQL("DELETE FROM Detalle");
				  
				  Area n_area = new Area(); 
				  for(int i=0;i<3;i++){ 
				  n_area.setIdarea(VAidarea[i]); 
				  n_area.setNombrearea(VAnombrearea[i]); 
				  
				  insertar(n_area); 
				  } 
				  
				  Documento doc_mnto = new Documento(); 
				  for(int i=0;i<3;i++){ 
					  doc_mnto.setCoddocument(VDcoddoc[i]);
					  doc_mnto.setIdtipo(VDidtipo[i]);
					  doc_mnto.setIdarea(VDidarea[i]);
					  doc_mnto.setNomdocument(VDnombredoc[i]);
					  doc_mnto.setEditorial(VDeditorial[i]); 
				  
				  insertar(doc_mnto); 
				  }
				  
				  DetalleAutor DetalleAutor = new DetalleAutor();
					for(int i=0;i<3;i++){
					DetalleAutor.setCodautor(VDAcodautor[i]);
					DetalleAutor.setCoddocument(VDAcoddocument[i]);
					DetalleAutor.setEspecializacion(VDAespecializacion[i]);				
					insertar(DetalleAutor);
					}
					
					TipoDoc tipo = new TipoDoc();
					for(int i=0;i<3;i++){
						tipo.setIdtipo(VDidtipo[i]);
						tipo.setNombretipo(VTnombretipo[i]);
						insertar(tipo);
					}
					
					DetallePres detalle = new DetallePres();
					for(int i=0;i<3;i++){
						detalle.setCodDoc(VDcoddoc[i]);
						detalle.setCodPrestamo(VDcodprestamo[i]);
						detalle.setNumPrestamo(1);
						detalle.setMaxPrest(2);
						insertar(detalle);
					}
				  
				  cerrar(); 
				 return "Base Creada Correctamente"; 
				  
		 }
}
