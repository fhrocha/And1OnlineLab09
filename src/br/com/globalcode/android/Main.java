package br.com.globalcode.android;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main extends Activity {
	
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab().setText("Venda").setTabListener(new MyTabListener<VendaFragment>(this, "venda", VendaFragment.class));
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Locação").setTabListener(new MyTabListener<LocacaoFragment>(this, "locacao", LocacaoFragment.class));
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Clientes").setTabListener(new MyTabListener<ClienteFragment>(this, "cliente", ClienteFragment.class));
		actionBar.addTab(tab);
		
		if(savedInstanceState != null) {
			actionBar.setSelectedNavigationItem(savedInstanceState.getInt("selected"));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putInt("selected", actionBar.getSelectedNavigationIndex());
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

}
