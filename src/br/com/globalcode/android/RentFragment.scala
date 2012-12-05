package br.com.globalcode.android

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RentFragment extends Fragment {

	override def onCreateView(inflater: LayoutInflater, container: ViewGroup,
			savedInstanceState: Bundle) =
		inflater.inflate(R.layout.rent_fragment_layout, container, false)
}
