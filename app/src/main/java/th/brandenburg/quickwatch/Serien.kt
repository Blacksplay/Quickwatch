package th.brandenburg.quickwatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Serien.newInstance] factory method to
 * create an instance of this fragment.
 */
class Serien : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filme, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.backButton?.visibility = View.GONE

        val recyclerView: RecyclerView = view.findViewById(R.id.film_recycler_view)

        val items: MutableList<Item> = ArrayList()
        items.add(Item("Arcane", "1. Staffel", R.drawable.title_2))
        items.add(Item("Haus des Geldes", "5. Staffeln", R.drawable.titel_6))
        items.add(Item("Umbrella Academy", "4. Staffeln", R.drawable.titel_7))
        items.add(Item("The Last of Us", "1. Staffel", R.drawable.titel_8))

        //recyclerview mit Inhalten füllen
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(requireContext(), items)

    }

}