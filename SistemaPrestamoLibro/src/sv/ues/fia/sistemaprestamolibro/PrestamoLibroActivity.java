package sv.ues.fia.sistemaprestamolibro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PrestamoLibroActivity extends Activity {
 
 // references to our images
 private Integer[] mThumbIds = {
   R.drawable.area,
   R.drawable.docum,
   R.drawable.documentos,
   R.drawable.autor2,
   R.drawable.autorinfo,
   R.drawable.prestamo,
   R.drawable.detalle,
   R.drawable.usuarios,
   R.drawable.sancion,
   R.drawable.nada,
   R.drawable.secretaria,
   R.drawable.nada
   };
 private String[] texto = {
	        "Area",
	        "Documento",
	        "Tipo Documento",
	        "Autor",
	        "Detalle Autor",
	        "Prestamo",
	        "Detalle Prestamo",
	        "Usuario",
	        "Penalización",
	        "",
	        "Secretaria",
	        ""
	    };
 String[]activities={"AreaMenuActivity","DocumentoMenuActivity","LoginActivity","DocumentoActivity",
		 "DocumentoActivity","DocumentoActivity","DocumentoActivity","DocumentoActivity","DocumentoActivity",
		 "DocumentoActivity"};
 
    public class MyAdapter extends BaseAdapter {
     
     private Context mContext;

  public MyAdapter(Context c) {
   // TODO Auto-generated constructor stub
   mContext = c;
  }

  @Override
  public int getCount() {
   // TODO Auto-generated method stub
   return mThumbIds.length;
  }

  @Override
  public Object getItem(int arg0) {
   // TODO Auto-generated method stub
   return mThumbIds[arg0];
  }

  @Override
  public long getItemId(int arg0) {
   // TODO Auto-generated method stub
   return arg0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
   // TODO Auto-generated method stub
   
   View grid;
    
   if(convertView==null){
    grid = new View(mContext);
    LayoutInflater inflater=getLayoutInflater();
    grid=inflater.inflate(R.layout.grid_item, parent, false);
   }else{
    grid = (View)convertView;
   }
   
   ImageView imageView = (ImageView)grid.findViewById(R.id.imagepart);
   TextView textView = (TextView)grid.findViewById(R.id.textpart);
   imageView.setImageResource(mThumbIds[position]);
   textView.setText(texto[position]);

   return grid;
  }

 }

 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gw = (GridView) findViewById(R.id.gridview);
        gw.setAdapter(new MyAdapter(this));

   gw.setOnItemClickListener(new OnItemClickListener(){
    public void onItemClick(AdapterView<?> parent,View v,int position,long id){ 
    	String nombreValue=activities[position];
    	if (position !=10 ){
    	Class<?> clase;
		try {
			clase = Class.forName("sv.ues.fia.sistemaprestamolibro."+nombreValue);
			Intent intent = new Intent(PrestamoLibroActivity.this,clase);
	    	startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	
   	}
    	else{
    		
    		 Toast.makeText(getApplication(), "Seleccione un Item ",  Toast.LENGTH_SHORT).show();
    		 
    	}
    		
    }}); 
  
    }
   
}