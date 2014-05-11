package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocumentoActualizarActivity extends Activity {
	EditText editIdarea;
	EditText editIdlibro;
	EditText editTitulo;
	EditText editEditorial;
	EditText editTipod;
	
	ControlBDPrestamoLib helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_documento_actualizar);
		
		helper= new ControlBDPrestamoLib(this);
		editIdarea= (EditText) findViewById(R.id.editIdarea); 
		editIdlibro= (EditText) findViewById(R.id.editIdlibro); 
		editTitulo= (EditText) findViewById(R.id.editTitulo); 
		editEditorial= (EditText) findViewById(R.id.editEditorial);
		editTipod= (EditText) findViewById(R.id.editTipod); 
	}

	public void actualizarDoc(View v){
		 String estado; 
		 Documento documento=new Documento(); 
		 documento.setCoddocument(editIdlibro.getText().toString());
		 documento.setIdtipo(editTipod.getText().toString());
		 documento.setIdarea(editIdarea.getText().toString());
		 documento.setNomdocument(editTitulo.getText().toString());
		 documento.setEditorial(editEditorial.getText().toString());
		 
		 
		 helper.abrir(); 
		 estado=helper.actualizar(documento); 
		 helper.cerrar(); 
		 Toast.makeText(this, estado, Toast.LENGTH_SHORT).show(); 
	}

}
