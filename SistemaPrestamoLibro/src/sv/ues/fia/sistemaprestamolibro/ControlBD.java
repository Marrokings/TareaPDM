package sv.ues.fia.sistemaprestamolibro;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ControlBD {
	private static final String[]camposDetalleAutor = new String []
			{"codautor","coddocument","especializacion"};
	
	/*		private static final String[]camposNota = new String []
			{"carnet","codmateria","ciclo","notafinal"};
			private static final String[] camposMateria = new String []
			{"codmateria","nommateria","unidadesval"};
			*/
			
			private final Context context;			
			private DatabaseHelper DBHelper;
			private SQLiteDatabase db;
			
			public ControlBD(Context ctx) {
			this.context = ctx;
			DBHelper = new DatabaseHelper(context);
			}
			private static class DatabaseHelper extends SQLiteOpenHelper {
			private static final String BASE_DATOS = "sistemabibliotecario.s3db";
			private static final int VERSION = 1;
			public DatabaseHelper(Context context) {
			super(context, BASE_DATOS, null, VERSION);
			}
			@Override
			public void onCreate(SQLiteDatabase db) {
			try{
			db.execSQL("CREATE TABLE DetalleAutor(CODDOC VARCHAR(4) NOT NULL PRIMARY KEY,CODAUTOR VARCHAR(4) NOT NULL, ESPECIALIZACION VARCHAR2(25));");
			
		/*	db.execSQL("CREATE TABLE materia(codmateria VARCHAR(6) NOT NULL	PRIMARY KEY,nommateria VARCHAR(30),unidadesval VARCHAR(1));");
			db.execSQL("CREATE TABLE nota(carnet VARCHAR(7) NOT NULL ,codmateria VARCHAR(6) NOT NULL ,ciclo VARCHAR(5) ,notafinal REAL ,PRIMARY" +
			"KEY(carnet,codmateria,ciclo));");
			*/
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
			public String insertar(DetalleAutor detalleAutor){
				String regInsertados="Registro Insertado Nº= ";
				long contador=0;
				ContentValues detAutor = new ContentValues();
				detAutor.put("codautor", (detalleAutor.getCodautor()));
				detAutor.put("coddocument", detalleAutor.getCoddocument());
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
			
	/*		public String insertar(Nota nota){
				String regInsertados="Registro Insertado Nº= ";
				long contador=0;
				if(verificarIntegridad(nota,1))
				{
				ContentValues notas = new ContentValues();
				notas.put("carnet", nota.getCarnet());
				notas.put("codmateria", nota.getCodmateria());
				notas.put("ciclo", nota.getCiclo());
				notas.put("notafinal", nota.getNotafinal());
				contador=db.insert("nota", null, notas);
				}
				if(contador==-1 || contador==0)
				{
				regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
				}
				else {
				regInsertados=regInsertados+contador;
				}
				return regInsertados;
				}
			
			public String insertar(Materia materia){
			return null;
			}
			public String actualizar(DetalleAutor DetalleAutor){
				if(verificarIntegridad(DetalleAutor, 5)){
					String[] id = {DetalleAutor.getCarnet()};
					ContentValues cv = new ContentValues();
					cv.put("nombre", DetalleAutor.getNombre());
					cv.put("apellido", DetalleAutor.getApellido());
					cv.put("sexo", DetalleAutor.getSexo());
					db.update("DetalleAutor", cv, "carnet = ?", id);
					return "Registro Actualizado Correctamente";
					}else{
					return "Registro con carnet " + DetalleAutor.getCarnet() + " no existe";
					}
					}
			
			public String actualizar(Materia materia){
			return null;
			}
			public String actualizar(Nota nota){
				if(verificarIntegridad(nota, 2)){
					String[] id = {nota.getCodmateria(), nota.getCarnet(),
					nota.getCiclo()};
					ContentValues cv = new ContentValues();
					cv.put("notafinal", nota.getNotafinal());
					db.update("nota", cv, "codmateria = ? AND carnet = ? AND ciclo = ?", id);
					return "Registro Actualizado Correctamente";
					}else{
					return "Registro no Existe";
					}
					}

			
			public String eliminar(DetalleAutor DetalleAutor){
				String regAfectados="filas afectadas= ";
				int contador=0;
				if (verificarIntegridad(DetalleAutor,3)) {
				regAfectados="0";
				//aplica para cascada
				//borrar registros de notas
				//contador+=db.delete("nota", carnet='"+DetalleAutor.getCarnet()+"'", null); ¨
				}
				else
				{
				//borrar los registros de DetalleAutor
				contador+=db.delete("DetalleAutor", "carnet='"+DetalleAutor.getCodautor()+"'",
				null);
				regAfectados+=contador;
				}
				return regAfectados;
				}
			
			public String eliminar(Nota nota){
				String regAfectados="filas afectadas= ";
				int contador=0;
				String where="carnet='"+nota.getCarnet()+"'";
				where=where+" AND codmateria='"+nota.getCodmateria()+"'";
				where=where+" AND ciclo="+nota.getCiclo();
				contador+=db.delete("nota", where, null);
				regAfectados+=contador;
				return regAfectados;
				}
			*/
			
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

				
	/*		public Materia consultarMateria(String codmateria){
			return null;
			}
			public Nota consultarNota(String carnet, String codmateria, String ciclo){
				String[] id = {carnet, codmateria, ciclo};
				Cursor cursor = db.query("nota", camposNota, "carnet = ? AND codmateria = ? AND ciclo = ?", id, null, null, null);
				if(cursor.moveToFirst()){
				Nota nota = new Nota();
				nota.setCarnet(cursor.getString(0));
				nota.setCodmateria(cursor.getString(1));
				nota.setCiclo(cursor.getString(2));
				nota.setNotafinal(cursor.getFloat(3));
				return nota;
				}else{
				return null;
				}
				}

			private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
			switch(relacion){
			case 1:
			{
			//verificar que al insertar nota exista carnet del DetalleAutor y el
			//codigo de materia
			Nota nota = (Nota)dato;
			String[] id1 = {nota.getCarnet()};
			String[] id2 = {nota.getCodmateria()};
			//abrir();
			Cursor cursor1 = db.query("DetalleAutor", null, "carnet = ?", id1, null,
			null, null);
			Cursor cursor2 = db.query("materia", null, "codmateria = ?", id2,
			null, null, null);
			if(cursor1.moveToFirst() && cursor2.moveToFirst()){
			//Se encontraron datos
			return true;
			}
			return false;
			}
			case 2:
			{
			//verificar que al modificar nota exista carnet del DetalleAutor, el
			//codigo de materia y el ciclo
			Nota nota1 = (Nota)dato;
			String[] ids = {nota1.getCarnet(), nota1.getCodmateria(),
			nota1.getCiclo()};
			abrir();
			Cursor c = db.query("nota", null, "carnet = ? AND codmateria = ? AND ciclo = ?", ids, null, null, null);
			if(c.moveToFirst()){
			//Se encontraron datos
			return true;
			}
			return false;
			}
			case 3:
			{
			DetalleAutor DetalleAutor = (DetalleAutor)dato;
			Cursor c=db.query(true, "nota", new String[] {
			"carnet" }, "carnet='"+DetalleAutor.getCarnet()+"'",null,
			null, null, null, null);
			if(c.moveToFirst())
			return true;
			else
			return false;
			}
			case 4:
			{
			Materia materia = (Materia)dato;
			Cursor cmat=db.query(true, "nota", new String[] {
			"codmateria" },
			"codmateria='"+materia.getCodmateria()+"'",null, null, null, null, null);
			if(cmat.moveToFirst())
				return true;
			else
			return false;
			}
			case 5:
			{
			//verificar que exista DetalleAutor
			DetalleAutor DetalleAutor2 = (DetalleAutor)dato;
			String[] id = {DetalleAutor2.getCarnet()};
			abrir();
			Cursor c2 = db.query("DetalleAutor", null, "carnet = ?", id, null, null,
			null);
			if(c2.moveToFirst()){
			//Se encontro DetalleAutor
			return true;
			}
			return false;
			}
			case 6:
			{
			//verificar que exista Materia
			Materia materia2 = (Materia)dato;
			String[] idm = {materia2.getCodmateria()};
			abrir();
			Cursor cm = db.query("materia", null, "codmateria = ?", idm, null,
			null, null);
			if(cm.moveToFirst()){
			//Se encontro Materia
			return true;
			}
			return false;
			}
			default:
			return false;
			}
			} */
			public String llenarBDCarnet(){
			final String[] VDAcodautor = {"OO12035","OF12044","GG11098","CC12021"};
			final String[] VDAcoddocument = {"Carlos","Pedro","Sara","Gabriela"};
			final String[] VDAespecializacion = {"Orantes","Ortiz","Gonzales","Coto"};
			
			final String[] VAsexo = {"M","M","F","F"};
			final String[] VMcodmateria = {"MAT115","PRN115","IEC115","TSI115"};
			final String[] VMnommateria = {"Matematica I","Programacion I","Ingenieria Economica","Teoria de Sistemas"};
			final String[] VMunidadesval = {"4","4","4","4"};
			final String[] VNcarnet =
				{"OO12035","OF12044","GG11098","CC12021","OO12035","GG11098","OF12044"};
				final String[] VNcodmateria =
				{"MAT115","PRN115","IEC115","TSI115","IC115","MAT115","PRN115"};
				final String[] VNciclo = {"1","1","2","2","2","1","2"};
				final float[] VNnotafinal = {7,5,8,7,6,10,7};
				abrir();
				db.execSQL("DELETE FROM DetalleAutor");
				db.execSQL("DELETE FROM materia");
				db.execSQL("DELETE FROM nota");
				
				DetalleAutor DetalleAutor = new DetalleAutor();
				for(int i=0;i<4;i++){
				DetalleAutor.setCodautor(VDAcodautor[i]);
				DetalleAutor.setCoddocument(VDAcoddocument[i]);
				DetalleAutor.setEspecializacion(VDAespecializacion[i]);				
				insertar(DetalleAutor);
				}
	/*			Materia materia = new Materia();
				for(int i=0;i<4;i++){
				materia.setCodmateria(VMcodmateria[i]);
				materia.setNommateria(VMnommateria[i]);
				materia.setUnidadesval(VMunidadesval[i]);
				insertar(materia);
				}
				Nota nota = new Nota();
				for(int i=0;i<7;i++){
				nota.setCarnet(VNcarnet[i]);
				nota.setCodmateria(VNcodmateria[i]);
				nota.setCiclo(VNciclo[i]);
				nota.setNotafinal(VNnotafinal[i]);
				insertar(nota);
				}
				*/
				cerrar();
				return "Guardo Correctamente";  
				}
		
}
