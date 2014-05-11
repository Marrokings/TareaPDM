package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class DocumentoConsultarActivity extends Activity {
	ControlBDPrestamoLib controlhelper;
	EditText editIdarea;
	EditText editIdlibro;
	EditText editTitulo;
	EditText editEditorial;
	EditText editTipod;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_documento_consultar);
		
		controlhelper= new ControlBDPrestamoLib(this);
		editIdlibro= (EditText) findViewById(R.id.editIdlibro); 
		editIdarea= (EditText) findViewById(R.id.editIdarea); 
		editTipod= (EditText) findViewById(R.id.editIdtipod);
		editTitulo= (EditText) findViewById(R.id.editTitulo); 
		editEditorial= (EditText) findViewById(R.id.editEditorial);
		
	}
    
	 public void consultarDocumento(View v){
		 
		 controlhelper.abrir();
	    	Documento doc=controlhelper.consultarDocumento(editIdlibro.getText().toString());
	      controlhelper.cerrar();	
	      if(doc == null) 
	    	  Toast.makeText(this, "Documento con idLibro " + editIdlibro.getText().toString() + " no se encontro", Toast.LENGTH_LONG).show(); 
	    	  else{ 
	    		 editIdlibro.setText(doc.getCoddocument());
                 editIdarea.setText(doc.getIdarea());
	 			 editTipod.setText(doc.getIdtipo());
	 			 editTitulo.setText(doc.getNomdocument());
	 			 editEditorial.setText(doc.getEditorial());
	 			 
		 
	        }
	 }
	 public void limpiarTexto(View V){
	   	  
		 editIdlibro.setText("");
		 editIdarea.setText("");
		 editTipod.setText("");
		 editTitulo.setText("");
		 editEditorial.setText("");
		 
		 
		 
		 
	     }

}
