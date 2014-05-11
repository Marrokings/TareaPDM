package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;


public class AreaConsultarActivity extends Activity {

	ControlBDPrestamoLib controlhelper;
	EditText editIdcategoria; 
	EditText editNomcategory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area_consultar);
		controlhelper= new ControlBDPrestamoLib(this);
		editIdcategoria= (EditText) findViewById(R.id.editIdarea); 
	    editNomcategory= (EditText) findViewById(R.id.editNomarea);
	}
    
	 public void consultarArea(View v){
		  controlhelper.abrir();
	    	Area area=controlhelper.consultarArea(editIdcategoria.getText().toString());
	      controlhelper.cerrar();	
	      if(area == null) 
	    	  Toast.makeText(this, "Area con idarea " + editIdcategoria.getText().toString() + " no se encontro", Toast.LENGTH_LONG).show(); 
	    	  else{ 
	    	  editNomcategory.setText(area.getNombrearea()); 
	    	  
	    	  } 
	    	
	    	 
	    	 
	      }
	
	
	 public void limpiarTexto(View V){
   	  
   	  editNomcategory.setText("");
   	  editIdcategoria.setText("");
     }
	

}
