package sv.ues.fia.sistemaprestamolibro;



import android.app.Activity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.Toast; 

public class AreaInsertarActivity extends Activity {
	
	ControlBDPrestamoLib helper; 
	EditText editIdcategoria; 
	EditText editNomcategory; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area_insertar);
		helper = new ControlBDPrestamoLib(this);
		editIdcategoria= (EditText) findViewById(R.id.editIdarea); 
		editNomcategory= (EditText) findViewById(R.id.editNomarea); 
	}
 
	public void insertarArea(View v) { 
		 String idarea=editIdcategoria.getText().toString(); 
		 String nombrearea=editNomcategory.getText().toString(); 
		 String regInsertados; 
		 Area area=new Area(); 
		 area.setIdarea(idarea); 
		 area.setNombrearea(nombrearea);
		 helper.abrir(); 
		 regInsertados=helper.insertar(area); 
		 helper.cerrar(); 
		 Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show(); 
		} 

		public void limpiarTexto(View v) { 

		editIdcategoria.setText(""); 
		editNomcategory.setText(""); 
		 
		} 
	

}
