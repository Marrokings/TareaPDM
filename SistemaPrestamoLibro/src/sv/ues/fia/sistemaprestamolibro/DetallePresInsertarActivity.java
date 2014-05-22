package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class DetallePresInsertarActivity extends Activity {
	
	ControlBDPrestamoLib helper;
	EditText editCodDetalle;
	EditText editCodPresDetalle;
	EditText editNumPrestDetalle;
	EditText editMaxDetalle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_pres_insertar);
		
		helper = new ControlBDPrestamoLib(this);
		editCodDetalle=(EditText)findViewById(R.id.editCodDetalle);
		editCodPresDetalle=(EditText)findViewById(R.id.editCodPresDetalle);
		editNumPrestDetalle=(EditText)findViewById(R.id.editNumPrestDetalle);
		editMaxDetalle=(EditText)findViewById(R.id.editMaxDetalle);
	}
	
	public void insertarDetalle(View v){
		String cod=editCodDetalle.getText().toString();
		String codPres=editCodPresDetalle.getText().toString();
		Integer NumPres=Integer.valueOf(editNumPrestDetalle.getText().toString());
		Integer MaxPres=Integer.valueOf(editMaxDetalle.getText().toString());
		String regInsertados;
		
		DetallePres detalle=new DetallePres();
		
		detalle.setCodDoc(cod);
		detalle.setCodPrestamo(codPres);
		detalle.setNumPrestamo(NumPres);
		detalle.setMaxPrest(MaxPres);
		
		helper.abrir();
		regInsertados=helper.insertar(detalle);
		helper.cerrar();
		
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	
	public void limpiarTexto(View v){
		editCodDetalle.setText("");
		editCodPresDetalle.setText("");
		editNumPrestDetalle.setText("");
		editMaxDetalle.setText("");
	}

	

}
