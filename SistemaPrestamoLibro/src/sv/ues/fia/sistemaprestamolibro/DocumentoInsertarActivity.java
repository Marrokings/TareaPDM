package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;


public class DocumentoInsertarActivity extends Activity {
	
	EditText editIdarea;
	EditText editIdlibro;
	EditText editTitulo;
	EditText editEditorial;
	EditText editTipod;
	
	ControlBDPrestamoLib helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_documento_insertar);
		helper= new ControlBDPrestamoLib(this);
		editIdarea= (EditText) findViewById(R.id.editIdarea); 
		editIdlibro= (EditText) findViewById(R.id.editIdlibro); 
		editTitulo= (EditText) findViewById(R.id.editTitulo); 
		editEditorial= (EditText) findViewById(R.id.editEditorial);
		editTipod= (EditText) findViewById(R.id.editTipod); 
	}

	public void insertarDoc(View v) { 
		 String regInsertados; 
		 Documento documento=new Documento(); 
		 documento.setCoddocument(editIdlibro.getText().toString());
		 documento.setIdtipo(editTipod.getText().toString());
		 documento.setIdarea(editIdarea.getText().toString());
		 documento.setNomdocument(editTitulo.getText().toString());
		 documento.setEditorial(editEditorial.getText().toString());
		 
		
		 
		 helper.abrir(); 
		 regInsertados=helper.insertar(documento); 
		 helper.cerrar(); 
		 Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show(); 
		} 

		public void limpiarTexto(View v) { 

			 editIdarea.setText("");
			 editIdlibro.setText("");
			 editTitulo.setText("");
			 editEditorial.setText("");
			 editTipod.setText("");
		 
		}
	

}
