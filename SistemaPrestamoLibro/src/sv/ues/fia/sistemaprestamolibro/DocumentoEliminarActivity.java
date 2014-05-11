package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoEliminarActivity extends Activity {
	
	ControlBDPrestamoLib controlhelper; 
	EditText editIdlibro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_documento_eliminar);
		
		controlhelper= new ControlBDPrestamoLib(this);
		editIdlibro=(EditText) findViewById(R.id.editIdlibro);
	}

	
	public  void eliminarDoc(View v){
		
		 String regEliminados; 
		 Documento docm = new Documento();
		 docm.setCoddocument(editIdlibro.getText().toString());
		 controlhelper.abrir(); 
		 regEliminados=controlhelper.eliminar(docm); 
		 controlhelper.cerrar(); 
		 Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show(); 
		
	}

}
