package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class DetallePresActualizarActivity extends Activity {
	
	ControlBDPrestamoLib helper;
	EditText editCodDocDetalle;
	EditText editCodPresDetalle;
	EditText editPrestamoDetalle;
	EditText editMaximoDetalle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_pres_actualizar);
		
		helper=new ControlBDPrestamoLib(this);
		editCodDocDetalle=(EditText)findViewById(R.id.editCodDocDetalle);
		editCodPresDetalle=(EditText)findViewById(R.id.editCodPresDetalle);
		editPrestamoDetalle=(EditText)findViewById(R.id.editPrestamoDetalle);
		editMaximoDetalle=(EditText)findViewById(R.id.editMaximoDetalle);
	}
	
	public void actualizar(View v){
		DetallePres detalle = new DetallePres();
		detalle.setCodDoc(editCodDocDetalle.getText().toString());
		detalle.setCodPrestamo(editCodPresDetalle.getText().toString());
		detalle.setNumPrestamo(Integer.valueOf(editPrestamoDetalle.getText().toString()));
		detalle.setMaxPrest(Integer.valueOf(editMaximoDetalle.getText().toString()));
		
		helper.abrir();
		String estado = helper.actualizar(detalle);
		helper.cerrar();
		
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
	}

	public void limpiarTexto(View v){
		editCodDocDetalle.setText("");
		editCodPresDetalle.setText("");
		editPrestamoDetalle.setText("");
		editMaximoDetalle.setText("");
	}
	

}
