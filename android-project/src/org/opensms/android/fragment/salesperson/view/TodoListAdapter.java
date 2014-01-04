package org.opensms.android.fragment.salesperson.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.opensms.android.R;
import org.opensms.db.entity.Customer;
import org.opensms.db.entity.PreOrder;

import com.activeandroid.util.Log;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TodoListAdapter extends BaseExpandableListAdapter {
	
	
	private static final String TAG = TodoListAdapter.class.getName();
	private Activity context;
    private Map<String, List<PreOrder>> preOrderCollections;
    private List<PreOrder> preOrders;
    private Map<Integer, Customer> customers;
 
    public TodoListAdapter(Activity context, List<PreOrder> preOrders,Map<Integer,Customer> customers) {
        this.context = context;
        this.preOrders = preOrders;
        this.customers=customers;
        
        this.preOrderCollections = new HashMap<String, List<PreOrder>>();
        
        
        // PreOrder categories by location
        for (PreOrder preOrder : preOrders) {
			String location = customers.get(preOrder.getCustomer_id()).getLocation().getCity();			
			List<PreOrder> preList = preOrderCollections.get(location);			
			if(preList==null){
				preList=new ArrayList<PreOrder>();
			}
			
			preList.add(preOrder);			
			preOrderCollections.put(location, preList);		
        	
		}
       
    }
    @Override
	 public View getGroupView(int groupPosition, boolean isExpanded,
	            View convertView, ViewGroup parent) {
	        String  preOrderName = (String) getGroup(groupPosition);
	        if (convertView == null) {
	            LayoutInflater infalInflater = (LayoutInflater) context
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = infalInflater.inflate(R.layout.salesperson_todolist_todolist_group_item,
	                    null);
	        }
	        TextView item = (TextView) convertView.findViewById(R.id.laptop);
	        item.setTypeface(null, Typeface.BOLD);
	        item.setText(preOrderName);
	        return convertView;
	    }
    
    
    @Override
    public View getChildView(final int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        final PreOrder preOrder = (PreOrder) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater(); 
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.salesperson_todolist_todolist_child_item, null);
        } 
        TextView item = (TextView) convertView.findViewById(R.id.laptop); 
        ImageView delete = (ImageView) convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to remove?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                List<PreOrder> child =
                                    preOrderCollections.get(preOrders.get(groupPosition));
                                child.remove(childPosition);
                                notifyDataSetChanged();
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });        
        Log.i(TAG,preOrder+""); 
        item.setText(preOrder.getCustomer_id()+"");
        return convertView;
    }

	

	@Override
	public Object getChild(int groupPos, int childPos) {
		return preOrderCollections.get(customers.get(preOrders.get(groupPos).getCustomer_id()).getLocation().getCity()).get(childPos);
	}

	@Override
	public long getChildId(int groupPos, int childPos) {
		return childPos;
	}

	
	@Override
	public int getChildrenCount(int arg0) {
		return preOrderCollections.get(customers.get(preOrders.get(arg0).getCustomer_id()).getLocation().getCity()).size();
	}

	@Override
	public Object getGroup(int arg0) {
		return customers.get(preOrders.get(arg0).getCustomer_id()).getLocation().getCity();
	}

	@Override
	public int getGroupCount() {
		return preOrderCollections.keySet().size();
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	
	 

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}

}
