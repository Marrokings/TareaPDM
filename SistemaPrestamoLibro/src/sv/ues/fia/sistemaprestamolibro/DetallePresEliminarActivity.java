package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class DetallePresEliminarActivity extends Activity {
	
	EditText editCodDocDetalle,editCodPresDetalle;
	ControlBDPrestamoLib controlhelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_pres_eliminar);
		
		editCodDocDetalle=(EditText)findViewById(R.id.editCodDocDetalle);
		editCodPresDetalle=(EditText)findViewById(R.id.editCodPresDetalle);
	}

	public void eliminarDetalle(View v){
		String regEliminadas;
		DetallePres detalle = new DetallePres();
		detalle.setCodDoc(editCodDocDetalle.getText().toString());
		detalle.setCodPrestamo(editCodPresDetalle.getText().toString());
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(detalle);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();		
	}
	
	public void limpiarTexto(View v){
		editCodDocDetalle.setText("");
		editCodPresDetalle.setText("");
	}

}
