package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AreaEliminarActivity extends Activity {

	ControlBDPrestamoLib controlhelper; 
	EditText editIdcategoria;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area_eliminar);
		controlhelper = new ControlBDPrestamoLib(this);
		editIdcategoria= (EditText) findViewById(R.id.editIdarea); 
		 
	}
	public void eliminarArea(View v) { 
		 String idarea=editIdcategoria.getText().toString(); 
		 String regEliminados; 
		 Area area=new Area(); 
		 area.setIdarea(idarea); 
		 controlhelper.abrir(); 
		 regEliminados=controlhelper.eliminar(area); 
		 controlhelper.cerrar(); 
		 Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show(); 
		} 

}
