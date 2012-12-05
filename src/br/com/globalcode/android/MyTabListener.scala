package br.com.globalcode.android

import android.app.ActionBar.Tab
import android.app.Activity
import android.app.Fragment
import android.app.FragmentTransaction

class MyTabListener[_](activity: Activity, tag: String, clz: Class[_]) extends
		android.app.ActionBar.TabListener  {

	var mFragment: Fragment = new Fragment();
	
	override def onTabSelected(tab: Tab, ft: FragmentTransaction) : Unit = {

		mFragment = activity.getFragmentManager().findFragmentByTag(tag);

		if (mFragment == null) {
			
			mFragment = Fragment.instantiate(activity, clz.getName());
			ft.add(android.R.id.content, mFragment, tag);
		} else {
			
			ft.attach(mFragment);
		}
	}

	override def onTabReselected(tab: Tab, ft: FragmentTransaction) = println("onTabReselected event")
	
	override def onTabUnselected(tab: Tab, ft: FragmentTransaction) : Unit = {
		
		if (mFragment != null) {
			ft.detach(mFragment);
		}
	}
}
