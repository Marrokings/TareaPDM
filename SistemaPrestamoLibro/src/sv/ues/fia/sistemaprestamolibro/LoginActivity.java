package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		addListenerOnButton();
	}

	public void addListenerOnButton() {
		 
		button = (Button) findViewById(R.id.imageButton1);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				Class<?> clase;
				try {
					clase = Class.forName("sv.ues.fia.sistemaprestamolibro.PrestamoLibroActivity");
					Intent intent = new Intent(LoginActivity.this,clase);
			    	startActivity(intent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
 
			}
 
		});
 
	}

}
