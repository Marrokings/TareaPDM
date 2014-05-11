package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;


public class AreaActualizarActivity extends Activity {

	ControlBDPrestamoLib controlhelper;
	EditText editIdcategoria; 
	EditText editNomcategory;
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		     setContentView(R.layout.activity_area_actualizar);
		
		     controlhelper = new ControlBDPrestamoLib(this);
		     editIdcategoria= (EditText) findViewById(R.id.editIdarea); 
		     editNomcategory= (EditText) findViewById(R.id.editNomarea); 
				
	       }
      public void actualizarArea(View v){
    	
    	Area area=new Area();
    	area.setIdarea(editIdcategoria.getText().toString());
    	area.setNombrearea(editNomcategory.getText().toString());
    	 controlhelper.abrir(); 
    	 String estado = controlhelper.actualizar(area); 
    	 controlhelper.cerrar(); 
    	 
    	 Toast.makeText(this, estado, Toast.LENGTH_SHORT).show(); 
      }
      
      public void limpiarTexto(View V){
    	  
    	  editNomcategory.setText("");
    	  editIdcategoria.setText("");
      }
	
	

}
