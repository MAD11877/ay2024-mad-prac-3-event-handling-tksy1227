package sg.edu.np.mad.madpractical3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Group1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Group1Fragment extends Fragment {

    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ITEM1 = "param1";
    private static final String ARG_ITEM2 = "param2";

    // Rename and change types of parameters
    private String mItem1;
    private String mItem2;

    public Group1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Group1Fragment.
     */
    // Rename and change types and number of parameters
    public static Group1Fragment newInstance(String param1, String param2) {
        Group1Fragment fragment = new Group1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM1, param1);
        args.putString(ARG_ITEM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItem1 = getArguments().getString(ARG_ITEM1);
            mItem2 = getArguments().getString(ARG_ITEM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group1, container, false);
    }
}