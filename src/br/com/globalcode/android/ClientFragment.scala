package br.com.globalcode.android

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ClientFragment extends Fragment {

	override def onCreateView(inflater: LayoutInflater, container: ViewGroup,
			savedInstanceState: Bundle) : View = {
		inflater.inflate(R.layout.client_fragment_layout, container, false);
	}
}