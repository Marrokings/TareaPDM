package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class TipoConsultarActivity extends Activity {

	ControlBDPrestamoLib helper;
	EditText editIdTipo;
	EditText editNomTipo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_consultar);
		
		helper = new ControlBDPrestamoLib(this);
		editIdTipo=(EditText)findViewById(R.id.editIdTipo);
		editNomTipo=(EditText)findViewById(R.id.editNomTipo);
	}

	public void consultarTipo(View v){
		
		helper.abrir();
		TipoDoc tipo = helper.consultarTipo(editIdTipo.getText().toString());
		helper.cerrar();
		
		if(tipo==null)
			Toast.makeText(this, "Id Tipo de Documento "+ editIdTipo.getText().toString() + " no encontrado",Toast.LENGTH_LONG).show();
		else{
			editNomTipo.setText(tipo.getNombretipo());
		}
	}
	
	public void limpiarTexto(View v){
		editIdTipo.setText("");
		editNomTipo.setText("");
	}

}
