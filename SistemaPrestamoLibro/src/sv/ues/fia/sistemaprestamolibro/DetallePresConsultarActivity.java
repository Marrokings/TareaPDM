package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class DetallePresConsultarActivity extends Activity {
	
	ControlBDPrestamoLib helper;
	EditText editCodDocDetalle;
	EditText editCodPresDetalle;
	EditText editPrestamoDetalle;
	EditText editMaximoDetalle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_pres_consultar);
		
		editCodDocDetalle = (EditText)findViewById(R.id.editCodDocDetalle);
		editCodPresDetalle = (EditText)findViewById(R.id.editCodPresDetalle);
		editPrestamoDetalle = (EditText)findViewById(R.id.editPrestamoDetalle);
		editMaximoDetalle = (EditText)findViewById(R.id.editMaximoDetalle);
	}

	public void consultarDetalle(View v){
		helper.abrir();		
		DetallePres detalle = helper.consultarDetalle(editCodDocDetalle.getText().toString(), editCodPresDetalle.getText().toString());
		helper.cerrar();
		
		if(detalle == null)
			Toast.makeText(this, "Detalle no encontrado", Toast.LENGTH_LONG).show();
		else{
			editPrestamoDetalle.setText(String.valueOf(detalle.getNumPrestamo()));
			editMaximoDetalle.setText(String.valueOf(detalle.getMaxPrest()));
		}
	}
	
	public void limpiarTexto(View v){
		editCodDocDetalle.setText("");
		editCodPresDetalle.setText("");
		editPrestamoDetalle.setText("");
		editMaximoDetalle.setText("");
	}

}
