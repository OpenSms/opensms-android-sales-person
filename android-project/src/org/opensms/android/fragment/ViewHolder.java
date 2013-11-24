package org.opensms.android.fragment;

public class ViewHolder {
	
	private static final ViewHolder viewHolder=new ViewHolder();
	private FragmentAccess access;
	
	private ViewHolder(){
		
	}
	
	public static ViewHolder getViewHolder(){
		return viewHolder;
	}

	public FragmentAccess getAccess() {
		return access;
	}

	public void setAccess(FragmentAccess access) {
		this.access = access;
	}

}
