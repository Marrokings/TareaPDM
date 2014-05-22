package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoActualizarActivity extends Activity {

	ControlBDPrestamoLib helper;
	EditText editIdTipo;
	EditText editNomTipo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_actualizar);
		
		helper = new ControlBDPrestamoLib(this);
		editIdTipo=(EditText)findViewById(R.id.editIdTipo);
		editNomTipo=(EditText)findViewById(R.id.editNomTipo);
	}
	
	public void actualizarTipo(View v){
		TipoDoc tipo = new TipoDoc();
		tipo.setIdtipo(editIdTipo.getText().toString());
		tipo.setNombretipo(editNomTipo.getText().toString());
		
		helper.abrir();
		String estado=helper.actualizar(tipo);
		helper.cerrar();
		
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
	}
	
	public void limpiarTexto(View v){
		editIdTipo.setText("");
		editNomTipo.setText("");
	}

}
