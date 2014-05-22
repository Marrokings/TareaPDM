package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class TipoEliminarActivity extends Activity {

	EditText editIdTipo;
	ControlBDPrestamoLib controlhelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_eliminar);
		controlhelper=new ControlBDPrestamoLib(this);
		editIdTipo=(EditText)findViewById(R.id.editIdTipo);
	}
	
	public void eliminarTipo(View v){
		String regEliminadas;
		TipoDoc tipo = new TipoDoc();
		tipo.setIdtipo(editIdTipo.getText().toString());
		
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(tipo);
		controlhelper.cerrar();
		
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}
	
	public void limpiarTexto(View v){
		editIdTipo.setText("");
	}

}
