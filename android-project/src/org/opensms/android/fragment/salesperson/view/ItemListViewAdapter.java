package org.opensms.android.fragment.salesperson.view;

import java.util.ArrayList;
import java.util.List;

import org.opensms.android.R;
import org.opensms.db.entity.Item;
import org.opensms.db.entity.OrderItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemListViewAdapter extends BaseAdapter{
	
	private List<OrderItem> items=new ArrayList<OrderItem>();
	private Context context;
	private TextView tvItemId;
	private TextView tvItemName;
	private TextView tvItemQty;
	
	

	public ItemListViewAdapter(Context context) {
		this.context = context;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		 View vi = convertView;
        
         if(convertView==null){
        	 LayoutInflater LayoutInflater=
			( LayoutInflater )context.
             getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
             vi = LayoutInflater.inflate(R.layout.salesperson_gsr_order_itemlist_item_view, null);
              
            
         }
         
         
         tvItemId=(TextView)vi.findViewById(R.id.tvsalesperson_gsr_order_itemlist_item_id);
         tvItemName=(TextView)vi.findViewById(R.id.tvSalesperson_gsr_order_itemlist_item_name);
         tvItemQty=(TextView)vi.findViewById(R.id.tvSalesperson_gsr_order_itemlist_item_qty);
         
         
         OrderItem item = (OrderItem) getItem(arg0);
         tvItemId.setText(item.getItemId());
         tvItemName.setText(item.getItemName());
         tvItemQty.setText(item.getQty()+"");
       
         return vi;
	}

	

}
