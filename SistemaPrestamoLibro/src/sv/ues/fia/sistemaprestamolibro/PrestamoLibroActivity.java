package sv.ues.fia.sistemaprestamolibro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
 
	final static String ACT_INFO = "sv.ues.fia.sistemaprestamolibro.MenuCRUDActivity"; 
	 // references to our images
	 private Integer[] imagenesIds = {
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
		        "Secretaria"
		        };
	 String[]activities={"AreaMenuActivity","DocumentoMenuActivity","LoginActivity","DocumentoActivity",
			 "DocumentoActivity","DocumentoActivity","DocumentoActivity","DocumentoActivity","DocumentoActivity",
			 "DocumentoActivity"};
	 ControlBDPrestamoLib BDhelper; 
	 
	    public class MyAdapter extends BaseAdapter {
	     
	     private Context mContext;

	  public MyAdapter(Context c) {
	   // TODO Auto-generated constructor stub
	   mContext = c;
	  }

	  @Override
	  public int getCount() {
	   // TODO Auto-generated method stub
	   return imagenesIds.length;
	  }

	  @Override
	  public Object getItem(int arg0) {
	   // TODO Auto-generated method stub
	   return imagenesIds[arg0];
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
	   imageView.setImageResource(imagenesIds[position]);
	   textView.setText(texto[position]);

	   return grid;
	  }

	 }

	 /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        BDhelper=new ControlBDPrestamoLib(this);
	        
	        GridView gw = (GridView) findViewById(R.id.gridview);
	        gw.setAdapter(new MyAdapter(this));

	   gw.setOnItemClickListener(new OnItemClickListener(){
	    public void onItemClick(AdapterView<?> parent,View v,int position,long id){
	    	
	    	String nombreValue="MenuCRUDActivity";
	    	String pos=Integer.toString(position);
	    	if (position==9){
	    		Toast.makeText(PrestamoLibroActivity.this, "seleccione un Item", Toast.LENGTH_SHORT).show();
	    	
	   	}
	    	else{
	    		Class<?> clase;
	    		try {
	    			clase = Class.forName("sv.ues.fia.sistemaprestamolibro."+nombreValue);
	    			Intent intent = new Intent(PrestamoLibroActivity.this,clase);
	    			intent.putExtra(ACT_INFO,pos);
	    	    	startActivity(intent);
	    		} catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} 
	    		
	    		 
	    	}
	    		
	    }}); 
	  
	    }
	    /**Opciones  de Menu*/
	 // Initiating Menu XML file (menu_inout.xml)
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu)
	    {
	        MenuInflater menuInflater = getMenuInflater();
	        menuInflater.inflate(R.menu.menu_iconos, menu);
	        return true;
	    }
	     
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	        case R.id.menu_salir:
	            // Single menu item is selected do something
	            // launching nuevo activity/screen o show alert message
	            Toast.makeText(PrestamoLibroActivity.this, "Cerrando Aplicacion en 3,2,1 ...", Toast.LENGTH_SHORT).show();
	            new Intent(Intent.ACTION_MAIN); finish();
	            
	            
	            return true;
	 
	        case R.id.menu_BD:
	        	BDhelper.abrir(); 
	       	 String tost=BDhelper.llenarBDPrestamoLib(); 
	       	 BDhelper.cerrar(); 
	       	 Toast.makeText(this, tost, Toast.LENGTH_SHORT).show(); 
	            return true;
	 
	         
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }    
	   
	}