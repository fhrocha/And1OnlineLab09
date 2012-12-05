package br.com.globalcode.android

import android.app.ActionBar
import android.app.ActionBar.Tab
import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class Main extends Activity {
	
	val actionBar: ActionBar = getActionBar();

	override def onCreate(savedInstanceState: Bundle) : Unit = {
		super.onCreate(savedInstanceState);

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		var tab: Tab = actionBar.newTab().setText("Venda").setTabListener(new MyTabListener[SaleFragment](this, "venda", classOf[SaleFragment]));
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Locação").setTabListener(new MyTabListener[RentFragment](this, "locacao", classOf[RentFragment]));
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Clientes").setTabListener(new MyTabListener[ClientFragment](this, "cliente", classOf[ClientFragment]));
		actionBar.addTab(tab);
		
		if(savedInstanceState != null) {
			actionBar.setSelectedNavigationItem(savedInstanceState.getInt("selected"));
		}
	}

	override def onCreateOptionsMenu(menu: Menu) : Boolean = {

		val menuInflater: MenuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	override def onSaveInstanceState(outState: Bundle) : Unit = {
		super.onSaveInstanceState(outState);
		outState.putInt("selected", actionBar.getSelectedNavigationIndex());
	}
	
	override def onOptionsItemSelected(item: MenuItem) : Boolean = 	super.onOptionsItemSelected(item)
}
