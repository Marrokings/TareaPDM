package sv.ues.fia.sistemaprestamolibro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	Button button;
	EditText user;
	String name;
	final static String ACT_INFO = "sv.ues.fia.sistemaprestamolibro.PrestamoLibroActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		addListenerOnButton();
	}

	public void addListenerOnButton() {
		 
		button = (Button) findViewById(R.id.imageButton1);
		user= (EditText) findViewById(R.id.editText1);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
                name=user.getText().toString(); 
				Class<?> clase;
				try {
					clase = Class.forName("sv.ues.fia.sistemaprestamolibro.PrestamoLibroActivity");
					Intent intent = new Intent(LoginActivity.this,clase);
					intent.putExtra(ACT_INFO,name);
			    	startActivity(intent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
 
			}
 
		});
 
	}

}
