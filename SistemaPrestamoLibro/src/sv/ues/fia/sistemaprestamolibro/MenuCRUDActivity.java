package sv.ues.fia.sistemaprestamolibro;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MenuCRUDActivity extends Activity {
	
	private Integer[] icon_menu = {
			   R.drawable.add_fondo,
			   R.drawable.delete_fondo,
			   R.drawable.buscar_fondo,
			   R.drawable.update,
			   };
			 private String[] texto = {
					    "Insertar",
				        "Eliminar",
				        "Consultar",
				        "Actualizar",
				        };
			 String[]activities={"AreaInsertarActivity","AreaEliminarActivity","AreaConsultarActivity","AreaActualizarActivity",
					             "DocumentoInsertarActivity","DocumentoEliminarActivity","DocumentoConsultarActivity","DocumentoActualizarActivity",
					             "","","","",//activitys tipodoc
			                     "AutorInsertarActivity","AutorEliminarActivity","AutorConsultarActivity","AutorActualizarActivity",
			                     "DetalleAutorInsertarActivity","DetalleAutorEliminarActivity","DetalleAutorConsultarActivity","DetalleAutorActualizarActivity",
			                     "PrestamoInsertarActivity","PrestamoEliminarActivity","PrestamoConsultarActivity","PrestamoActualizarActivity",
			                     "DetallePrestamoInsertarActivity","DetallePrestamoEliminarActivity","DetallePrestamoConsultarActivity","DetallePrestamoActualizarActivity",
			                     "UsuarioInsertarActivity","UsuarioEliminarActivity","UsuarioConsultarActivity","UsuarioActualizarActivity",
			                     "","","","",//activitys sancion o penalizacion
			                     "","","","",//activitys secretaria
			                     };
			 
	 public class MyAdapter extends BaseAdapter {
	    
	    private Context mContext;

			  public MyAdapter(Context c) {
			   // TODO Auto-generated constructor stub
			   mContext = c;
			  }

			  @Override
			  public int getCount() {
			   // TODO Auto-generated method stub
			   return icon_menu.length;
			  }

			  @Override
			  public Object getItem(int arg0) {
			   // TODO Auto-generated method stub
			   return icon_menu[arg0];
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
	    imageView.setImageResource(icon_menu[position]);
	    textView.setText(texto[position]);

	   return grid;
	  }

	 }

			 /** Called when the activity is first created. */
	

	@Override
   protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_crud);
		GridView gw = (GridView) findViewById(R.id.gridview);
        gw.setAdapter(new MyAdapter(this));

       gw.setOnItemClickListener(new OnItemClickListener(){
          public void onItemClick(AdapterView<?> parent,View v,int position,long id){ 
    	     int info;
    	     Intent men = getIntent();
    	     String inf = men.getStringExtra(PrestamoLibroActivity.ACT_INFO);
    	     info=Integer.parseInt(inf);
    	     int num=DondeIr(position,info);
    	     String  nombreValue=activities[num];
    	     Class<?> clase;
 		     try {
 			    clase = Class.forName("sv.ues.fia.sistemaprestamolibro."+nombreValue);
 			    Intent intent = new Intent(MenuCRUDActivity.this,clase);
 			    startActivity(intent);
 		        }
 		     catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		  } 
   	    }  
      }); 
  
    }

    public int DondeIr(int pos,int infoant){
    	int n=0;	
    	     switch(infoant){
    	
    	        case 0:  {   //si lo invoca area 		
    		              if (pos==0)
    			             return n=0;
    		              else if (pos==1)
    			             return n=1;
    		              else if (pos==2)
    			             return n=2;
    		              else
    			             return n=3;
        	            }
    	        case 1:  {   //si lo invoca documento 		
		              if (pos==0)
			             return n=4;
		              else if (pos==1)
			             return n=5;
		              else if (pos==2)
			             return n=6;
		              else
			             return n=7;
  	                } 
    	        case 2:  {   //si lo invoca tipodoc  		
		              if (pos==0)
			             return n=8;
		              else if (pos==1)
			             return n=9;
		              else if (pos==2)
			             return n=10;
		              else
			             return n=11;
  	            }
    	        case 3:  {    //si lo invoca autor 		
		              if (pos==0)
			             return n=12;
		              else if (pos==1)
			             return n=13;
		              else if (pos==2)
			             return n=14;
		              else
			             return n=15;
  	            }
    	        case 4:  {  //si lo invoca detalleautor		
		              if (pos==0)
			             return n=16;
		              else if (pos==1)
			             return n=17;
		              else if (pos==2)
			             return n=18;
		              else
			             return n=19;
  	            }
    	        case 5:  {  //si lo invoca prestamo		
		              if (pos==0)
			             return n=20;
		              else if (pos==1)
			             return n=21;
		              else if (pos==2)
			             return n=22;
		              else
			             return n=23;
	            }
    	        case 6:  {  //si lo invoca detalleprestamo	
		              if (pos==0)
			             return n=24;
		              else if (pos==1)
			             return n=25;
		              else if (pos==2)
			             return n=26;
		              else
			             return n=27;
	            }
    	        case 7:  {  //si lo invoca usuario	
		              if (pos==0)
			             return n=28;
		              else if (pos==1)
			             return n=29;
		              else if (pos==2)
			             return n=30;
		              else
			             return n=31;
	            }
    	        case 8:  {  //si lo invoca penalizacion	
		              if (pos==0)
			             return n=32;
		              else if (pos==1)
			             return n=33;
		              else if (pos==2)
			             return n=34;
		              else
			             return n=35;
	            }
    	        case 10:  {  //si lo invoca secretaria	
		              if (pos==0)
			             return n=36;
		              else if (pos==1)
			             return n=37;
		              else if (pos==2)
			             return n=38;
		              else
			             return n=39;
	            }
    }
		return n;	
  }
}
