package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class TipoInsertarActivity extends Activity {
	
	ControlBDPrestamoLib helper;
	EditText editIdTipo;
	EditText editNomTipo;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_insertar);
		helper = new ControlBDPrestamoLib(this);
		editIdTipo=(EditText)findViewById(R.id.editIdTipo);
		editNomTipo=(EditText)findViewById(R.id.editNomTipo);
	}

	
	public void insertarTipo(View v){
		
		String idTipo=editIdTipo.getText().toString();
		String nomTipo=editNomTipo.getText().toString();
		String regInsertados;
		
		TipoDoc tipo = new TipoDoc();
		tipo.setIdtipo(idTipo);
		tipo.setNombretipo(nomTipo);
		
		helper.abrir();
		regInsertados=helper.insertar(tipo);
		helper.cerrar();
		
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
		
	}
	
	public void limpiarTexto(View v){
		editIdTipo.setText("");
		editNomTipo.setText("");
	}

}
